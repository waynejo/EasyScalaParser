package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{TerminalParsingElement, _}
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}

object ParsingEngine {

    def _parse[A](parsingElement: ParsingElement[A], parsingContext: ParsingContext): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        val ignoredIndex = parsingContext.parsingInjection.ignore(parsingContext.text, parsingContext.textIndex)
        val nextContext = parsingContext.onNext(ignoredIndex, parsingElement)

        val parser = BaseParsingEngine.parse[A](nextContext)
            .orElse(AndParsingEngine.parse[A](nextContext))
            .orElse(OrParsingEngine.parse[A](nextContext))

        parser(parsingElement)
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Either[String, A] = {
        val parsingContext = ParsingContext(text, 0, Nil, parsingInjection, ParsingFailInfo(), Nil)
        val parseResult = _parse(parsingElement, parsingContext)
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
