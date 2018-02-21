package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{TerminalParsingElement, _}
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}

object ParsingEngine {

    def _parse[A](parsingElement: ParsingElement[A], parsingContext: ParsingContext, parserStack: List[ParsingElement[_]]): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        val ignoredIndex = parsingContext.parsingInjection.ignore(parsingContext.text, parsingContext.textIndex)
        val nextContext = parsingContext.copy(textIndex = ignoredIndex)

        val nextParsingStack = updateParsingStack(parsingElement, parserStack)

        val parser = BaseParsingEngine.parse[A](nextContext, nextParsingStack)
            .orElse(AndParsingEngine.parse[A](nextContext, nextParsingStack))
            .orElse(OrParsingEngine.parse[A](nextContext, nextParsingStack))

        parser(parsingElement)
    }

    private def updateParsingStack[A](parsingElement: ParsingElement[A], parserStack: List[ParsingElement[_]]) = {
        if (parsingElement.isInstanceOf[TerminalParsingElement]) {
            parserStack
        } else {
            parsingElement :: parserStack
        }
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Either[String, A] = {
        val parsingContext = ParsingContext(text, 0, Nil, parsingInjection, ParsingFailInfo())
        val parseResult = _parse(parsingElement, parsingContext, Nil)
        parseResult match {
            case Right(info) if parsingContext.parsingInjection.ignore(text, info.nextContext.textIndex) == text.length =>
                Right(info.result)
            case Right(info) =>
                Left(ErrorMessageBuilder.build(text)(info.nextContext.parsingFailInfo))
            case Left(info) =>
                Left(ErrorMessageBuilder.build(text)(info))
        }
    }
}
