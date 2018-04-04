package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, TerminalParsingElement}
import com.waynejo.easyscalaparser.injection.ParsingIgnore

case class ParsingContext(
                           text: String,
                           terminals: List[TerminalParsingElement],
                           parsingInjection: ParsingIgnore,
                           parsingFailInfo: ParsingFailInfo,
                           parsingState: List[ParsingState]
                         ) {

    def textIndex: Int = {
        parsingState.head.textIndex
    }

    def onFail(parsingFailInfo: ParsingFailInfo): ParsingContext = {
        copy(parsingFailInfo = parsingFailInfo)
    }

    def onSuccess[A](successState: ParsingState): ParsingContext = {
        copy(parsingState = successState :: parsingState)
    }

    def onNext[A](textIndex: Int, parsingElement: ParsingElement[A]): (ParsingState, ParsingContext) = {
        val state = parsingState.head
        val nextStack = if (parsingElement.isInstanceOf[TerminalParsingElement]) {
            state.parsingStack
        } else {
            parsingElement :: state.parsingStack
        }
        val nextState = state.copy(textIndex = textIndex, parsingStack = nextStack)
        (nextState, copy(parsingState = parsingState.tail))
    }
}