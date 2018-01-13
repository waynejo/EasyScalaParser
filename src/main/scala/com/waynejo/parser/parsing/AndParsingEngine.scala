package com.waynejo.parser.parsing

import com.waynejo.parser.{ParsingContext, ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}
import com.waynejo.parser.element._

object AndParsingEngine {
    def parse[A](parsingContext: ParsingContext, parserStack: List[ParsingElement[_]]): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case AndParsingElement1(pe0, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
            } yield ParsingSuccessInfo(r0.nextContext, reducer((r0.result)))
        case AndParsingElement2(pe0, pe1, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
            } yield ParsingSuccessInfo(r1.nextContext, reducer((r0.result, r1.result)))
        case AndParsingElement3(pe0, pe1, pe2, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
            } yield ParsingSuccessInfo(r2.nextContext, reducer((r0.result, r1.result, r2.result)))
        case AndParsingElement4(pe0, pe1, pe2, pe3, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
                r3 <- ParsingEngine._parse(pe3, r2.nextContext, parserStack)
            } yield ParsingSuccessInfo(r3.nextContext, reducer((r0.result, r1.result, r2.result, r3.result)))
        case AndParsingElement5(pe0, pe1, pe2, pe3, pe4, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
                r3 <- ParsingEngine._parse(pe3, r2.nextContext, parserStack)
                r4 <- ParsingEngine._parse(pe4, r3.nextContext, parserStack)
            } yield ParsingSuccessInfo(r4.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result)))
        case AndParsingElement6(pe0, pe1, pe2, pe3, pe4, pe5, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
                r3 <- ParsingEngine._parse(pe3, r2.nextContext, parserStack)
                r4 <- ParsingEngine._parse(pe4, r3.nextContext, parserStack)
                r5 <- ParsingEngine._parse(pe5, r4.nextContext, parserStack)
            } yield ParsingSuccessInfo(r5.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result)))
        case AndParsingElement7(pe0, pe1, pe2, pe3, pe4, pe5, pe6, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
                r3 <- ParsingEngine._parse(pe3, r2.nextContext, parserStack)
                r4 <- ParsingEngine._parse(pe4, r3.nextContext, parserStack)
                r5 <- ParsingEngine._parse(pe5, r4.nextContext, parserStack)
                r6 <- ParsingEngine._parse(pe6, r5.nextContext, parserStack)
            } yield ParsingSuccessInfo(r6.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result)))
        case AndParsingElement8(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
                r3 <- ParsingEngine._parse(pe3, r2.nextContext, parserStack)
                r4 <- ParsingEngine._parse(pe4, r3.nextContext, parserStack)
                r5 <- ParsingEngine._parse(pe5, r4.nextContext, parserStack)
                r6 <- ParsingEngine._parse(pe6, r5.nextContext, parserStack)
                r7 <- ParsingEngine._parse(pe7, r6.nextContext, parserStack)
            } yield ParsingSuccessInfo(r7.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result)))
        case AndParsingElement9(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
                r3 <- ParsingEngine._parse(pe3, r2.nextContext, parserStack)
                r4 <- ParsingEngine._parse(pe4, r3.nextContext, parserStack)
                r5 <- ParsingEngine._parse(pe5, r4.nextContext, parserStack)
                r6 <- ParsingEngine._parse(pe6, r5.nextContext, parserStack)
                r7 <- ParsingEngine._parse(pe7, r6.nextContext, parserStack)
                r8 <- ParsingEngine._parse(pe8, r7.nextContext, parserStack)
            } yield ParsingSuccessInfo(r8.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result)))
        case AndParsingElement10(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext, parserStack)
                r1 <- ParsingEngine._parse(pe1, r0.nextContext, parserStack)
                r2 <- ParsingEngine._parse(pe2, r1.nextContext, parserStack)
                r3 <- ParsingEngine._parse(pe3, r2.nextContext, parserStack)
                r4 <- ParsingEngine._parse(pe4, r3.nextContext, parserStack)
                r5 <- ParsingEngine._parse(pe5, r4.nextContext, parserStack)
                r6 <- ParsingEngine._parse(pe6, r5.nextContext, parserStack)
                r7 <- ParsingEngine._parse(pe7, r6.nextContext, parserStack)
                r8 <- ParsingEngine._parse(pe8, r7.nextContext, parserStack)
                r9 <- ParsingEngine._parse(pe9, r8.nextContext, parserStack)
            } yield ParsingSuccessInfo(r9.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result)))

    }
}
