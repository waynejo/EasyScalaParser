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
                           parsingFailMap: HashMap[(Int, ParsingElement[_]), Boolean] = HashMap[(Int, ParsingElement[_]), Boolean]()
                         ) {

    def onFail(parsingFailInfo: ParsingFailInfo): ParsingContext = {
        copy(parsingFailInfo = parsingFailInfo, parsingFailMap = parsingFailMap.updated((parsingFailInfo.lastFailIndex, parsingFailInfo.lastParsingElement), true))
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