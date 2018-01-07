package com.waynejo.parser

import com.waynejo.parser.element._
import com.waynejo.parser.injection.ParsingIgnore
import com.waynejo.parser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}

object ParsingEngine {

    def _parse[A](parsingElement: ParsingElement[A], parsingContext: ParsingContext): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        val ignoredIndex = parsingContext.parsingInjection.ignore(parsingContext.text, parsingContext.textIndex)
        val ignoredContext = parsingContext.copy(textIndex = ignoredIndex)

        val parser = BaseParsingEngine.parse[A](ignoredContext)
            .orElse(AndParsingEngine.parse[A](ignoredContext))
            .orElse(OrParsingEngine.parse[A](ignoredContext))

        parser(parsingElement)
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Option[A] = {
        val parsingContext = ParsingContext(text, 0, Nil, parsingInjection)
        _parse(parsingElement, parsingContext).toOption.map(_.result)
    }
}
