package com.waynejo.parser

import com.waynejo.parser.element._
import com.waynejo.parser.injection.ParsingInjection
import com.waynejo.parser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}

object ParsingEngine {

    def _parse[A](parsingElement: ParsingElement[A], text: String, terminals: List[TerminalParsingElement], parsingInjection: ParsingInjection): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        val injectedText = parsingInjection.inject(text)

        val parser = BaseParsingEngine.parse[A](injectedText, terminals, parsingInjection)
            .orElse(AndParsingEngine.parse[A](injectedText, terminals, parsingInjection))
            .orElse(OrParsingEngine.parse[A](injectedText, terminals, parsingInjection))

        parser(parsingElement)
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingInjection): Option[A] = {
        _parse(parsingElement, text, Nil, parsingInjection).toOption.map(_.result)
    }
}
