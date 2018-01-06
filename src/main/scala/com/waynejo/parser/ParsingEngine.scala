package com.waynejo.parser

import com.waynejo.parser.element._
import com.waynejo.parser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}

object ParsingEngine {

    def _parse[A](parsingElement: ParsingElement[A], text: String, terminals: List[TerminalParsingElement]): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        val parser = BaseParsingEngine.parse[A](text, terminals)
            .orElse(AndParsingEngine.parse[A](text, terminals))
            .orElse(OrParsingEngine.parse[A](text, terminals))

        parser(parsingElement)
    }

    def parse[A](parsingElement: ParsingElement[A], text: String): Option[A] = {
        _parse(parsingElement, text, Nil).toOption.map(_.result)
    }
}
