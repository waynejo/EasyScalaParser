package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, TerminalParsingElement}
import com.waynejo.easyscalaparser.injection.ParsingIgnore

case class ParsingContext(text: String, textIndex: Int, terminals: List[TerminalParsingElement], parsingInjection: ParsingIgnore, parsingFailInfo: ParsingFailInfo, parserStack: List[ParsingElement[_]]) {
    def onFail(parsingFailInfo: ParsingFailInfo): ParsingContext = {
        copy(parsingFailInfo = parsingFailInfo)
    }

    def onSuccess(nextIndex: Int): ParsingContext = {
        copy(textIndex = nextIndex, terminals = Nil)
    }

    def onNext[A](textIndex: Int, parsingElement: ParsingElement[A]): ParsingContext = {
        val nextStack = if (parsingElement.isInstanceOf[TerminalParsingElement]) {
            parserStack
        } else {
            parsingElement :: parserStack
        }
        copy(textIndex = textIndex, parserStack = nextStack)
    }
}