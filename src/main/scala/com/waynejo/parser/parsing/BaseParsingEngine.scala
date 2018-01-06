package com.waynejo.parser.parsing

import com.waynejo.parser.{ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}
import com.waynejo.parser.element._
import com.waynejo.parser.injection.ParsingInjection

import scala.annotation.tailrec

object BaseParsingEngine {

    @tailrec
    private def repeat[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingInjection, reducer: (A, A) => A, acc: A): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        ParsingEngine._parse(parsingElement, text, Nil, parsingInjection) match {
            case Right(parsingSuccessInfo) =>
                val nextAcc = reducer(acc, parsingSuccessInfo.result)
                repeat(parsingElement, parsingSuccessInfo.remain, parsingInjection, reducer, nextAcc)
            case Left(_) =>
                Right(ParsingSuccessInfo[A](text, acc))
        }
    }

    def parse[A](text: String, terminals: List[TerminalParsingElement], parsingInjection: ParsingInjection): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case SimpleParsingElement(token) =>
            if (text.startsWith(token)) {
                Right(ParsingSuccessInfo(text.substring(token.length), token))
            } else {
                Left(ParsingFailInfo())
            }
        case RegexParsingElement(regex) =>
            val matchResult = regex.findPrefixMatchOf(text)
            matchResult match {
                case Some(result) =>
                    val token = text.substring(0, result.end)
                    Right(ParsingSuccessInfo(text.substring(token.length), token))
                case None =>
                    Left(ParsingFailInfo())
            }
        case CustomParsingElement(parser, _) =>
            val matchResult = parser(text)
            matchResult match {
                case Some(token) =>
                    Right(ParsingSuccessInfo(text.substring(token.length), token))
                case None =>
                    Left(ParsingFailInfo())
            }
        case ReferenceParsingElement(reference) =>
            ParsingEngine._parse(reference(), text, terminals, parsingInjection)
        case OptionParsingElement(reference) =>
            ParsingEngine._parse(reference, text, terminals, parsingInjection) match {
                case Right(parsingSuccessInfo) =>
                    Right(ParsingSuccessInfo[A](parsingSuccessInfo.remain, Some(parsingSuccessInfo.result)))
                case Left(_) =>
                    Right(ParsingSuccessInfo[A](text, None))
            }
        case RepeatParsingElement(pe0, reducer) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- repeat(pe0, r0.remain, parsingInjection, reducer, r0.result)
            } yield ParsingSuccessInfo(r1.remain, r1.result)
    }
}
