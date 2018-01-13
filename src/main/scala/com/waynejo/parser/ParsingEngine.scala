package com.waynejo.parser

import com.waynejo.parser.element._
import com.waynejo.parser.injection.ParsingIgnore
import com.waynejo.parser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}

object ParsingEngine {

    def _parse[A](parsingElement: ParsingElement[A], parsingContext: ParsingContext, parserStack: List[ParsingElement[_]]): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        val ignoredIndex = parsingContext.parsingInjection.ignore(parsingContext.text, parsingContext.textIndex)
        val nextContext = parsingContext.copy(textIndex = ignoredIndex)
        val nextParsingStack = parsingElement :: parserStack

        val parser = BaseParsingEngine.parse[A](nextContext, nextParsingStack)
            .orElse(AndParsingEngine.parse[A](nextContext, nextParsingStack))
            .orElse(OrParsingEngine.parse[A](nextContext, nextParsingStack))

        parser(parsingElement)
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Either[String, A] = {
        val parsingContext = ParsingContext(text, 0, Nil, parsingInjection, ParsingFailInfo())
        val parseResult = _parse(parsingElement, parsingContext, Nil)
        parseResult.left.map(ErrorMessageBuilder.build(text)).right.map(_.result)
    }
}
