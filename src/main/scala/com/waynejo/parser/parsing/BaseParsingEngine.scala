package com.waynejo.parser.parsing

import com.waynejo.parser._
import com.waynejo.parser.element._

import scala.annotation.tailrec

object BaseParsingEngine {

    @tailrec
    private def repeat[A](parsingElement: ParsingElement[A], parsingContext: ParsingContext, parserStack: List[ParsingElement[_]], reducer: (A, A) => A, n: Int, acc: A): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
        if (0 >= n) {
            Right(ParsingSuccessInfo[A](parsingContext, acc))
        } else {
            ParsingEngine._parse(parsingElement, parsingContext.copy(terminals = Nil), parserStack) match {
                case Right(parsingSuccessInfo) =>
                    val nextAcc = reducer(acc, parsingSuccessInfo.result)
                    repeat(parsingElement, parsingSuccessInfo.nextContext, parserStack, reducer, n - 1, nextAcc)
                case Left(_) =>
                    Right(ParsingSuccessInfo[A](parsingContext, acc))
            }
        }
    }

    def parse[A](parsingContext: ParsingContext, parserStack: List[ParsingElement[_]]): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case parsingElement@SimpleParsingElement(token) =>
            if (parsingContext.text.substring(parsingContext.textIndex).startsWith(token)) {
                Right(ParsingSuccessInfo(parsingContext.onSuccess(parsingContext.textIndex + token.length), token))
            } else {
                Left(ParsingFailInfo(parsingContext, parsingElement, parserStack))
            }
        case parsingElement@RegexParsingElement(regex) =>
            val text = parsingContext.text.substring(parsingContext.textIndex)
            val matchResult = regex.findPrefixMatchOf(text)
            matchResult match {
                case Some(result) =>
                    val token = text.substring(0, result.end)
                    Right(ParsingSuccessInfo(parsingContext.onSuccess(parsingContext.textIndex + token.length), token))
                case None =>
                    Left(ParsingFailInfo(parsingContext, parsingElement, parserStack))
            }
        case parsingElement@CustomParsingElement(parser, _) =>
            val text = parsingContext.text.substring(parsingContext.textIndex)
            val matchResult = parser(text)
            matchResult match {
                case Some(token) =>
                    Right(ParsingSuccessInfo(parsingContext.onSuccess(parsingContext.textIndex + token.length), token))
                case None =>
                    Left(ParsingFailInfo(parsingContext, parsingElement, parserStack))
            }
        case ReferenceParsingElement(reference, _) =>
            ParsingEngine._parse(reference(), parsingContext, parserStack)
        case OptionParsingElement(reference) =>
            ParsingEngine._parse(reference, parsingContext, parserStack) match {
                case Right(parsingSuccessInfo) =>
                    Right(ParsingSuccessInfo[A](parsingSuccessInfo.nextContext, Some(parsingSuccessInfo.result)))
                case Left(failInfo) =>
                    Right(ParsingSuccessInfo[A](parsingContext.onFail(failInfo), None))
            }
        case RepeatParsingElement(pe0, reducer: ((A, A) => A)) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- repeat[A](pe0, r0.nextContext, parserStack, reducer, Int.MaxValue, r0.result)
            } yield ParsingSuccessInfo(r1.nextContext, r1.result)

        case TimesParsingElement(pe0, n, reducer: ((A, A) => A)) =>
            if (n > 0) {
                for {
                    r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                    r1 <- repeat[A](pe0, r0.nextContext, parserStack, reducer, n - 1, r0.result)
                } yield ParsingSuccessInfo(r1.nextContext, r1.result)
            } else {
                Left(ParsingFailInfo(parsingContext, pe0, parserStack))
            }
    }
}
