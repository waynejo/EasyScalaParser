package com.waynejo.parser

import com.waynejo.parser.element._

object ParsingEngine {

    private def _parse[A](parsingElement: ParsingElement[A], text: String, terminals: List[TerminalParsingElement]): Option[(String, A)] = {
        parsingElement match {
            case SimpleParsingElement(token) =>
                if (text.startsWith(token)) {
                    Some((text.substring(token.length), token))
                } else {
                    None
                }
            case AndParsingElement2(pe0, pe1, reducer, _) =>
                for {
                    (remain0, v0) <- _parse(pe0, text, terminals)
                    (remain1, v1) <- _parse(pe1, remain0, Nil)
                } yield (remain1, reducer((v0, v1)))
            case AndParsingElement3(pe0, pe1, pe2, reducer, _) =>
                for {
                    (remain0, v0) <- _parse(pe0, text, terminals)
                    (remain1, v1) <- _parse(pe1, remain0, Nil)
                    (remain2, v2) <- _parse(pe2, remain1, Nil)
                } yield (remain2, reducer((v0, v1, v2)))
        }
    }

    def parse[A](parsingElement: ParsingElement[A], text: String): Option[A] = {
        _parse(parsingElement, text, Nil).map(_._2)
    }
}
