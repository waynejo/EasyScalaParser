package com.waynejo.parser.parsing

import com.waynejo.parser._
import com.waynejo.parser.element._

import scala.annotation.tailrec

object BaseParsingEngine {

    @tailrec
    private def repeat[A](parsingElement: ParsingElement[A], parsingContext: ParsingContext, reducer: (A, A) => A, acc: A): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        ParsingEngine._parse(parsingElement, parsingContext.copy(terminals = Nil)) match {
            case Right(parsingSuccessInfo) =>
                val nextAcc = reducer(acc, parsingSuccessInfo.result)
                repeat(parsingElement, parsingSuccessInfo.nextContext, reducer, nextAcc)
            case Left(_) =>
                Right(ParsingSuccessInfo[A](parsingContext, acc))
        }
    }

    def parse[A](parsingContext: ParsingContext): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case parsingElement@SimpleParsingElement(token) =>
            if (parsingContext.text.substring(parsingContext.textIndex).startsWith(token)) {
                Right(ParsingSuccessInfo(parsingContext.onSuccess(parsingContext.textIndex + token.length), token))
            } else {
                Left(ParsingFailInfo(parsingContext, parsingElement))
            }
        case parsingElement@RegexParsingElement(regex) =>
            val text = parsingContext.text.substring(parsingContext.textIndex)
            val matchResult = regex.findPrefixMatchOf(text)
            matchResult match {
                case Some(result) =>
                    val token = text.substring(0, result.end)
                    Right(ParsingSuccessInfo(parsingContext.onSuccess(parsingContext.textIndex + token.length), token))
                case None =>
                    Left(ParsingFailInfo(parsingContext, parsingElement))
            }
        case parsingElement@CustomParsingElement(parser, _) =>
            val text = parsingContext.text.substring(parsingContext.textIndex)
            val matchResult = parser(text)
            matchResult match {
                case Some(token) =>
                    Right(ParsingSuccessInfo(parsingContext.onSuccess(parsingContext.textIndex + token.length), token))
                case None =>
                    Left(ParsingFailInfo(parsingContext, parsingElement))
            }
        case ReferenceParsingElement(reference) =>
            ParsingEngine._parse(reference(), parsingContext)
        case OptionParsingElement(reference) =>
            ParsingEngine._parse(reference, parsingContext) match {
                case Right(parsingSuccessInfo) =>
                    Right(ParsingSuccessInfo[A](parsingSuccessInfo.nextContext, Some(parsingSuccessInfo.result)))
                case Left(_) =>
                    Right(ParsingSuccessInfo[A](parsingContext, None))
            }
        case RepeatParsingElement(pe0, reducer) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- repeat(pe0, r0.nextContext, reducer, r0.result)
            } yield ParsingSuccessInfo(r1.nextContext, r1.result)
    }
}
