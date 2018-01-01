package com.waynejo.parser

import com.waynejo.parser.element._
import com.waynejo.parser.types._

object ParsingEngine {

    private def _parse[A](parsingElement: ParsingElement[A], text: String, terminals: List[TerminalParsingElement]): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        parsingElement match {
            case SimpleParsingElement(token) =>
                if (text.startsWith(token)) {
                    Right(ParsingSuccessInfo(text.substring(token.length), token))
                } else {
                    Left(ParsingFailInfo())
                }
            case ReferenceParsingElement(reference) =>
                _parse(reference(), text, terminals)
            case OptionParsingElement(reference) =>
                _parse(reference, text, terminals) match {
                    case Right(parsingSuccessInfo) =>
                        Right(ParsingSuccessInfo[A](parsingSuccessInfo.remain, Some(parsingSuccessInfo.result)))
                    case Left(_) =>
                        Right(ParsingSuccessInfo[A](text, None))
                }
            case AndParsingElement2(pe0, pe1, reducer, _) =>
                for {
                    r0 <- _parse(pe0, text, terminals)
                    r1 <- _parse(pe1, r0.remain, Nil)
                } yield ParsingSuccessInfo(r1.remain, reducer((r0.result, r1.result)))
            case AndParsingElement3(pe0, pe1, pe2, reducer, _) =>
                for {
                    r0 <- _parse(pe0, text, terminals)
                    r1 <- _parse(pe1, r0.remain, Nil)
                    r2 <- _parse(pe2, r1.remain, Nil)
                } yield ParsingSuccessInfo(r2.remain, reducer((r0.result, r1.result, r2.result)))
            case OrParsingElement2(pe0, pe1, reducer, _) =>
                _parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
                    .left.flatMap { case (failInfo: ParsingFailInfo) =>
                        _parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
                    }
        }
    }

    def parse[A](parsingElement: ParsingElement[A], text: String): Option[A] = {
        _parse(parsingElement, text, Nil).toOption.map(_.result)
    }
}
