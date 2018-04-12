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
        val takeNum = lastFailedParsingState.parsingHistory.size - lastFailedParsingState.splitIndex
        val failedElements = lastFailedParsingState.parsingHistory.take(takeNum)
        val nextFailMap = (parsingFailMap /: failedElements)((acc, x) => acc.updated(x, true))
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
        val nextState = state.copy(textIndex = textIndex,
            parsingStack = state.parsingStack.tail,
            parsingHistory = (textIndex, parsingElement.id) :: state.parsingHistory
        )
        (nextState, copy(parsingState = parsingState.tail))
    }
}