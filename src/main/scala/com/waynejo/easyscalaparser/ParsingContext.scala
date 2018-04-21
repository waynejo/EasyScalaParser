package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement, TerminalParsingElement}
import com.waynejo.easyscalaparser.injection.ParsingIgnore

import scala.collection.immutable.HashMap

case class ParsingContext(
                           text: String,
                           terminals: List[TerminalParsingElement],
                           parsingInjection: ParsingIgnore,
                           parsingFailInfo: ParsingFailInfo,
                           parsingState: List[ParsingState],
                           parsingFailMap: HashMap[(Int, Int), Boolean] = HashMap[(Int, Int), Boolean](),
                           parsingSuccessMap: HashMap[(Int, Int), Vector[(Int, ResultParsingElement[_])]] = HashMap[(Int, Int), Vector[(Int, ResultParsingElement[_])]]()
                         ) {

    def onFail(parsingFailInfo: ParsingFailInfo): ParsingContext = {
        val lastFailedParsingState = parsingFailInfo.lastFailParsingState
        val takeNum = lastFailedParsingState.parsingStack.size - lastFailedParsingState.splitIndex
        val failedElement = (parsingFailInfo.lastFailParsingState.textIndex, parsingFailInfo.lastParsingElement)
        val failedElements = failedElement :: lastFailedParsingState.parsingStack.take(takeNum)
        val nextFailMap = (parsingFailMap /: failedElements)((acc, x) => acc.updated((x._1, x._2.srcId()), true))
        copy(
            parsingFailInfo = parsingFailInfo,
            parsingFailMap = nextFailMap,
            parsingState = parsingState.filter(state => {
                state.parsingStack.forall(x => !nextFailMap.contains((x._1, x._2.id)))
            })
        )
    }

    def onSuccess[A](successState: ParsingState): ParsingContext = {
        copy(parsingState = successState :: parsingState)
    }

    def onCacheResult[A](position: (Int, Int), nextIndex: Int, element: ResultParsingElement[_]): ParsingContext = {
        val nextValue = if (parsingSuccessMap.contains(position)) {
            parsingSuccessMap(position) :+ (nextIndex, element)
        } else {
            Vector[(Int, ResultParsingElement[_])]((nextIndex, element))
        }
        copy(parsingSuccessMap = parsingSuccessMap.updated(position, nextValue))
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