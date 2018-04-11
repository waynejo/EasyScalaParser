package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, TerminalParsingElement}
import com.waynejo.easyscalaparser.injection.ParsingIgnore

import scala.collection.immutable.HashMap

case class ParsingContext(
                           text: String,
                           terminals: List[TerminalParsingElement],
                           parsingInjection: ParsingIgnore,
                           parsingFailInfo: ParsingFailInfo,
                           parsingState: List[ParsingState],
                           parsingFailMap: HashMap[(Int, Int), Boolean] = HashMap[(Int, Int), Boolean]()
                         ) {

    def onFail(parsingFailInfo: ParsingFailInfo): ParsingContext = {
        val lastFailedParsingState = parsingFailInfo.lastFailParsingState
        val failedIndex = lastFailedParsingState.textIndex
        val lastElementUpdatedMap = parsingFailMap.updated((failedIndex, parsingFailInfo.lastParsingElement.id), true)
        val failedElements = lastFailedParsingState.parsingStack.drop(lastFailedParsingState.splitIndex)
        val nextFailMap = (lastElementUpdatedMap /: failedElements)((acc, x) => acc.updated((failedIndex, x.id), true))
        copy(
            parsingFailInfo = parsingFailInfo,
            parsingFailMap = nextFailMap
        )
    }

    def onSuccess[A](successState: ParsingState): ParsingContext = {
        copy(parsingState = successState :: parsingState)
    }

    def onNext[A](textIndex: Int, parsingElement: ParsingElement[A]): (ParsingState, ParsingContext) = {
        val state = parsingState.head
        val nextState = state.copy(textIndex = textIndex, parsingStack = state.parsingStack.tail)
        (nextState, copy(parsingState = parsingState.tail))
    }
}