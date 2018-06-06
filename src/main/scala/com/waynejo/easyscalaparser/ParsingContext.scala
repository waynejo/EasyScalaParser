package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{DuplicatedElement, ParsingElement, ResultParsingElement, TerminalParsingElement}
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.util.ParsingKeyUtil

import scala.collection.immutable.HashMap

case class ParsingContext(
                           text: String,
                           terminals: List[TerminalParsingElement],
                           parsingInjection: ParsingIgnore,
                           parsingFailInfo: ParsingFailInfo,
                           parsingState: List[ParsingState],
                           parsingFailMap: HashMap[Long, Boolean] = HashMap[Long, Boolean](),
                           parsingSuccessMap: HashMap[Long, Vector[(Int, ResultParsingElement[_])]] = HashMap[Long, Vector[(Int, ResultParsingElement[_])]]()
                         ) {

  def onFail(parsingFailInfo: ParsingFailInfo): ParsingContext = {
    val lastFailedParsingState = parsingFailInfo.lastFailParsingState
    val takeNum = lastFailedParsingState.parsingStack.size - lastFailedParsingState.splitIndex
    val failedElement = (parsingFailInfo.lastFailParsingState.textIndex, parsingFailInfo.lastParsingElement)
    val failedElements = failedElement :: lastFailedParsingState.parsingStack.take(takeNum)
    val nextFailMap = (parsingFailMap /: failedElements) ((acc, x) => {
      if (-1 != x._2.srcId) {
        acc.updated(ParsingKeyUtil.asKey(x._1, x._2.srcId), true)
      } else {
        acc
      }
    })
    copy(
      parsingFailInfo = parsingFailInfo,
      parsingFailMap = nextFailMap,
      parsingState = parsingState.filter(state => {
        state.parsingStack.forall(x => !nextFailMap.contains(ParsingKeyUtil.asKey(x._1, x._2.id)))
      })
    )
  }

  def onSuccess[A](successState: ParsingState): ParsingContext = {
    copy(parsingState = successState :: parsingState)
  }

  def onCacheResult[A](key: Long, nextIndex: Int, element: ResultParsingElement[_]): ParsingContext = {
    val nextValue = parsingSuccessMap.get(key)
      .map(_ :+ (nextIndex, element))
      .getOrElse(Vector[(Int, ResultParsingElement[_])]((nextIndex, element)))

    copy(parsingSuccessMap = parsingSuccessMap.updated(key, nextValue))
  }

  def onNext[A](textIndex: Int): (ParsingState, ParsingContext) = {
    val state = parsingState.head
    val nextState = state.copy(
      textIndex = textIndex,
      parsingStack = state.parsingStack.tail
    )
    (nextState, copy(parsingState = parsingState.tail))
  }

  def onDuplicatedElement[A](duplicatedIdx: Int, parsingElementId: Int, textIdx: Int, element: DuplicatedElement[A]): ParsingContext = {
    val nextParsingState = parsingState.map(x => {
      val parsingStack = x.parsingStack
      val idx = parsingStack.size - duplicatedIdx
      if (0 <= idx && idx < parsingStack.size && parsingStack(idx)._2.id == parsingElementId) {
        x.copy(parsingStack = parsingStack.take(idx) ::: (textIdx, element) :: parsingStack.drop(idx))
      } else {
        x
      }
    })
    copy(parsingState = nextParsingState)
  }
}