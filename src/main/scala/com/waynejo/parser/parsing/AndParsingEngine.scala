package com.waynejo.parser.parsing

import com.waynejo.parser.{ParsingContext, ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}
import com.waynejo.parser.element._

object AndParsingEngine {
    def parse[A](parsingContext: ParsingContext): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case AndParsingElement1(pe0, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
            } yield ParsingSuccessInfo(r0.nextIndex, reducer((r0.result)))
        case AndParsingElement2(pe0, pe1, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r1.nextIndex, reducer((r0.result, r1.result)))
        case AndParsingElement3(pe0, pe1, pe2, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r2.nextIndex, reducer((r0.result, r1.result, r2.result)))
        case AndParsingElement4(pe0, pe1, pe2, pe3, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
                r3 <- ParsingEngine._parse(pe3, parsingContext.copy(textIndex = r2.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r3.nextIndex, reducer((r0.result, r1.result, r2.result, r3.result)))
        case AndParsingElement5(pe0, pe1, pe2, pe3, pe4, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
                r3 <- ParsingEngine._parse(pe3, parsingContext.copy(textIndex = r2.nextIndex, terminals = Nil))
                r4 <- ParsingEngine._parse(pe4, parsingContext.copy(textIndex = r3.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r4.nextIndex, reducer((r0.result, r1.result, r2.result, r3.result, r4.result)))
        case AndParsingElement6(pe0, pe1, pe2, pe3, pe4, pe5, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
                r3 <- ParsingEngine._parse(pe3, parsingContext.copy(textIndex = r2.nextIndex, terminals = Nil))
                r4 <- ParsingEngine._parse(pe4, parsingContext.copy(textIndex = r3.nextIndex, terminals = Nil))
                r5 <- ParsingEngine._parse(pe5, parsingContext.copy(textIndex = r4.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r5.nextIndex, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result)))
        case AndParsingElement7(pe0, pe1, pe2, pe3, pe4, pe5, pe6, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
                r3 <- ParsingEngine._parse(pe3, parsingContext.copy(textIndex = r2.nextIndex, terminals = Nil))
                r4 <- ParsingEngine._parse(pe4, parsingContext.copy(textIndex = r3.nextIndex, terminals = Nil))
                r5 <- ParsingEngine._parse(pe5, parsingContext.copy(textIndex = r4.nextIndex, terminals = Nil))
                r6 <- ParsingEngine._parse(pe6, parsingContext.copy(textIndex = r5.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r6.nextIndex, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result)))
        case AndParsingElement8(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
                r3 <- ParsingEngine._parse(pe3, parsingContext.copy(textIndex = r2.nextIndex, terminals = Nil))
                r4 <- ParsingEngine._parse(pe4, parsingContext.copy(textIndex = r3.nextIndex, terminals = Nil))
                r5 <- ParsingEngine._parse(pe5, parsingContext.copy(textIndex = r4.nextIndex, terminals = Nil))
                r6 <- ParsingEngine._parse(pe6, parsingContext.copy(textIndex = r5.nextIndex, terminals = Nil))
                r7 <- ParsingEngine._parse(pe7, parsingContext.copy(textIndex = r6.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r7.nextIndex, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result)))
        case AndParsingElement9(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
                r3 <- ParsingEngine._parse(pe3, parsingContext.copy(textIndex = r2.nextIndex, terminals = Nil))
                r4 <- ParsingEngine._parse(pe4, parsingContext.copy(textIndex = r3.nextIndex, terminals = Nil))
                r5 <- ParsingEngine._parse(pe5, parsingContext.copy(textIndex = r4.nextIndex, terminals = Nil))
                r6 <- ParsingEngine._parse(pe6, parsingContext.copy(textIndex = r5.nextIndex, terminals = Nil))
                r7 <- ParsingEngine._parse(pe7, parsingContext.copy(textIndex = r6.nextIndex, terminals = Nil))
                r8 <- ParsingEngine._parse(pe8, parsingContext.copy(textIndex = r7.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r8.nextIndex, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result)))
        case AndParsingElement10(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, parsingContext)
                r1 <- ParsingEngine._parse(pe1, parsingContext.copy(textIndex = r0.nextIndex, terminals = Nil))
                r2 <- ParsingEngine._parse(pe2, parsingContext.copy(textIndex = r1.nextIndex, terminals = Nil))
                r3 <- ParsingEngine._parse(pe3, parsingContext.copy(textIndex = r2.nextIndex, terminals = Nil))
                r4 <- ParsingEngine._parse(pe4, parsingContext.copy(textIndex = r3.nextIndex, terminals = Nil))
                r5 <- ParsingEngine._parse(pe5, parsingContext.copy(textIndex = r4.nextIndex, terminals = Nil))
                r6 <- ParsingEngine._parse(pe6, parsingContext.copy(textIndex = r5.nextIndex, terminals = Nil))
                r7 <- ParsingEngine._parse(pe7, parsingContext.copy(textIndex = r6.nextIndex, terminals = Nil))
                r8 <- ParsingEngine._parse(pe8, parsingContext.copy(textIndex = r7.nextIndex, terminals = Nil))
                r9 <- ParsingEngine._parse(pe9, parsingContext.copy(textIndex = r8.nextIndex, terminals = Nil))
            } yield ParsingSuccessInfo(r9.nextIndex, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result)))

    }
}
