package com.waynejo.parser.parsing

import com.waynejo.parser.{ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}
import com.waynejo.parser.element._
import com.waynejo.parser.injection.ParsingInjection

object AndParsingEngine {
    def parse[A](text: String, terminals: List[TerminalParsingElement], parsingInjection: ParsingInjection): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case AndParsingElement1(pe0, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
            } yield ParsingSuccessInfo(r0.remain, reducer((r0.result)))
        case AndParsingElement2(pe0, pe1, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r1.remain, reducer((r0.result, r1.result)))
        case AndParsingElement3(pe0, pe1, pe2, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r2.remain, reducer((r0.result, r1.result, r2.result)))
        case AndParsingElement4(pe0, pe1, pe2, pe3, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
                r3 <- ParsingEngine._parse(pe3, r2.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r3.remain, reducer((r0.result, r1.result, r2.result, r3.result)))
        case AndParsingElement5(pe0, pe1, pe2, pe3, pe4, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
                r3 <- ParsingEngine._parse(pe3, r2.remain, Nil, parsingInjection)
                r4 <- ParsingEngine._parse(pe4, r3.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r4.remain, reducer((r0.result, r1.result, r2.result, r3.result, r4.result)))
        case AndParsingElement6(pe0, pe1, pe2, pe3, pe4, pe5, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
                r3 <- ParsingEngine._parse(pe3, r2.remain, Nil, parsingInjection)
                r4 <- ParsingEngine._parse(pe4, r3.remain, Nil, parsingInjection)
                r5 <- ParsingEngine._parse(pe5, r4.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r5.remain, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result)))
        case AndParsingElement7(pe0, pe1, pe2, pe3, pe4, pe5, pe6, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
                r3 <- ParsingEngine._parse(pe3, r2.remain, Nil, parsingInjection)
                r4 <- ParsingEngine._parse(pe4, r3.remain, Nil, parsingInjection)
                r5 <- ParsingEngine._parse(pe5, r4.remain, Nil, parsingInjection)
                r6 <- ParsingEngine._parse(pe6, r5.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r6.remain, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result)))
        case AndParsingElement8(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
                r3 <- ParsingEngine._parse(pe3, r2.remain, Nil, parsingInjection)
                r4 <- ParsingEngine._parse(pe4, r3.remain, Nil, parsingInjection)
                r5 <- ParsingEngine._parse(pe5, r4.remain, Nil, parsingInjection)
                r6 <- ParsingEngine._parse(pe6, r5.remain, Nil, parsingInjection)
                r7 <- ParsingEngine._parse(pe7, r6.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r7.remain, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result)))
        case AndParsingElement9(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
                r3 <- ParsingEngine._parse(pe3, r2.remain, Nil, parsingInjection)
                r4 <- ParsingEngine._parse(pe4, r3.remain, Nil, parsingInjection)
                r5 <- ParsingEngine._parse(pe5, r4.remain, Nil, parsingInjection)
                r6 <- ParsingEngine._parse(pe6, r5.remain, Nil, parsingInjection)
                r7 <- ParsingEngine._parse(pe7, r6.remain, Nil, parsingInjection)
                r8 <- ParsingEngine._parse(pe8, r7.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r8.remain, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result)))
        case AndParsingElement10(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reducer, _) =>
            for {
                r0 <- ParsingEngine._parse(pe0, text, terminals, parsingInjection)
                r1 <- ParsingEngine._parse(pe1, r0.remain, Nil, parsingInjection)
                r2 <- ParsingEngine._parse(pe2, r1.remain, Nil, parsingInjection)
                r3 <- ParsingEngine._parse(pe3, r2.remain, Nil, parsingInjection)
                r4 <- ParsingEngine._parse(pe4, r3.remain, Nil, parsingInjection)
                r5 <- ParsingEngine._parse(pe5, r4.remain, Nil, parsingInjection)
                r6 <- ParsingEngine._parse(pe6, r5.remain, Nil, parsingInjection)
                r7 <- ParsingEngine._parse(pe7, r6.remain, Nil, parsingInjection)
                r8 <- ParsingEngine._parse(pe8, r7.remain, Nil, parsingInjection)
                r9 <- ParsingEngine._parse(pe9, r8.remain, Nil, parsingInjection)
            } yield ParsingSuccessInfo(r9.remain, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result)))

    }
}
