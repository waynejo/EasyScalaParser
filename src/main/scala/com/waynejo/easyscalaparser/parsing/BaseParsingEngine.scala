package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser.{ParsingState, _}
import com.waynejo.easyscalaparser.element._

import scala.annotation.tailrec

object BaseParsingEngine {

//    @tailrec
//    private def repeat[A](parsingElement: ParsingElement[A], parsingContext: ParsingContext, reducer: (A, A) => A, lower: Int, upper: Int, acc: A): Either[ParsingFailInfo, ParsingSuccessInfo[A]] = {
//        if (0 >= upper) {
//            Right(ParsingSuccessInfo[A](parsingContext, acc))
//        } else {
//            ParsingEngine._parse(parsingElement, parsingContext.copy(terminals = Nil)) match {
//                case Right(parsingSuccessInfo) =>
//                    val nextAcc = reducer(acc, parsingSuccessInfo.result)
//                    repeat(parsingElement, parsingSuccessInfo.nextContext, reducer, lower - 1, upper - 1, nextAcc)
//                case Left(failInfo: ParsingFailInfo) =>
//                    if (lower > 0) {
//                        Left(failInfo)
//                    } else {
//                        Right(ParsingSuccessInfo[A](parsingContext.onFail(failInfo), acc))
//                    }
//            }
//        }
//    }

    def parse[A](parsingContext: ParsingContext, parsingState: ParsingState): PartialFunction[ParsingElement[A], ParsingContext] = {
        case parsingElement@EndOfStringElement() =>
            if (parsingContext.parsingInjection.ignore(parsingContext.text, parsingState.textIndex) == parsingContext.text.length) {
                parsingContext.onSuccess(parsingState(parsingState.textIndex, Unit))
            } else {
                parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case parsingElement@SimpleParsingElement(token) =>
            if (parsingContext.text.substring(parsingState.textIndex).startsWith(token)) {
                parsingContext.onSuccess(parsingState(parsingState.textIndex + token.length, token))
            } else {
                parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case parsingElement@RegexParsingElement(regex) =>
            val text = parsingContext.text.substring(parsingState.textIndex)
            val matchResult = regex.findPrefixMatchOf(text)
            matchResult match {
                case Some(result) =>
                    val token = text.substring(0, result.end)
                    parsingContext.onSuccess(parsingState(parsingState.textIndex + token.length, token))
                case None =>
                    parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case parsingElement@CustomParsingElement(parser, _) =>
            val text = parsingContext.text.substring(parsingState.textIndex)
            val matchResult = parser(text)
            matchResult match {
                case Some(token) =>
                    parsingContext.onSuccess(parsingState(parsingState.textIndex + token.length, token))
                case None =>
                    parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case ResultParsingElement(value) =>
            val headElement = parsingState.parsingStack.head
            val remainState = parsingState.tail()
            val nextState = if (headElement.isInstanceOf[OrParsingElement[_, _]]) {
                remainState(OrParsingEngine.reduce(headElement, value))
            } else {
                remainState(AndParsingEngine.reduce(headElement, value))
            }
            parsingContext.onSuccess(nextState)



//        case ReferenceParsingElement(reference, _) =>
//            ParsingEngine._parse(reference(), parsingContext)
//        case OptionParsingElement(reference) =>
//            ParsingEngine._parse(reference, parsingContext) match {
//                case Right(parsingSuccessInfo) =>
//                    Right(ParsingSuccessInfo[A](parsingSuccessInfo.nextContext, Some(parsingSuccessInfo.result)))
//                case Left(failInfo) =>
//                    Right(ParsingSuccessInfo[A](parsingContext.onFail(failInfo), None))
//            }
//        case RepeatParsingElement(pe0, reducer: ((A, A) => A)) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- repeat[A](pe0, r0.nextContext, reducer, 0, Int.MaxValue, r0.result)
//            } yield ParsingSuccessInfo(r1.nextContext, r1.result)
//
//        case TimesParsingElement(pe0, lower, upper, reducer: ((A, A) => A)) =>
//            if (lower > 0 && upper > 0) {
//                for {
//                    r0 <- ParsingEngine._parse(pe0, parsingContext)
//                    r1 <- repeat[A](pe0, r0.nextContext, reducer, lower - 1, upper - 1, r0.result)
//                } yield ParsingSuccessInfo(r1.nextContext, r1.result)
//            } else {
//                Left(ParsingFailInfo(parsingContext, pe0))
//            }
    }
}
