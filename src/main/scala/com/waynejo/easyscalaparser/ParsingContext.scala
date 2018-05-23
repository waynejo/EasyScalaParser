package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement, TerminalParsingElement}
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
    val nextFailMap = (parsingFailMap /: failedElements) ((acc, x) => acc.updated(ParsingKeyUtil.asKey(x._1, x._2.srcId()), true))
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

  def onNext[A](textIndex: Int, parsingElement: ParsingElement[A]): (ParsingState, ParsingContext) = {
    val state = parsingState.head
    val nextState = state.copy(
      textIndex = textIndex,
      parsingStack = state.parsingStack.tail
    )
    (nextState, copy(parsingState = parsingState.tail))
  }
}