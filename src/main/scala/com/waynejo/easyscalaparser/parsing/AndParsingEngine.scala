package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser._

object AndParsingEngine {

    def reduce[A, B](reducer: ParsingElement[A], element: B): ParsingElement[A] = {
        reducer match {
            case AndParsingElement1(_, function, _) =>
                ResultParsingElement(function(element))

            case element2@AndParsingElement2(_, pe1, function, name) =>
                AndParsingElement1(pe1, function(element, _: element2.typeB), name)

            case element3@AndParsingElement3(_, pe1, pe2, function, name) =>
                AndParsingElement2(pe1, pe2, function(element, _: element3.typeB, _: element3.typeC), name)
        }
    }

    def parse[A](parsingContext: ParsingContext, parsingState: ParsingState): PartialFunction[ParsingElement[A], ParsingContext] = {
        case parsingElement@AndParsingElement1(pe0, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement2(pe0, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement3(pe0, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

//        case AndParsingElement1(pe0, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//            } yield ParsingSuccessInfo(r0.nextContext, reducer((r0.result)))
//        case AndParsingElement2(pe0, pe1, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//            } yield ParsingSuccessInfo(r1.nextContext, reducer((r0.result, r1.result)))
//        case AndParsingElement3(pe0, pe1, pe2, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//            } yield ParsingSuccessInfo(r2.nextContext, reducer((r0.result, r1.result, r2.result)))
//        case AndParsingElement4(pe0, pe1, pe2, pe3, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//            } yield ParsingSuccessInfo(r3.nextContext, reducer((r0.result, r1.result, r2.result, r3.result)))
//        case AndParsingElement5(pe0, pe1, pe2, pe3, pe4, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//            } yield ParsingSuccessInfo(r4.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result)))
//        case AndParsingElement6(pe0, pe1, pe2, pe3, pe4, pe5, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//            } yield ParsingSuccessInfo(r5.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result)))
//        case AndParsingElement7(pe0, pe1, pe2, pe3, pe4, pe5, pe6, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//            } yield ParsingSuccessInfo(r6.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result)))
//        case AndParsingElement8(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//            } yield ParsingSuccessInfo(r7.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result)))
//        case AndParsingElement9(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//            } yield ParsingSuccessInfo(r8.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result)))
//        case AndParsingElement10(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//            } yield ParsingSuccessInfo(r9.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result)))
//        case AndParsingElement11(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//            } yield ParsingSuccessInfo(r10.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result)))
//        case AndParsingElement12(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//            } yield ParsingSuccessInfo(r11.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result)))
//        case AndParsingElement13(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//            } yield ParsingSuccessInfo(r12.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result)))
//        case AndParsingElement14(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//            } yield ParsingSuccessInfo(r13.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result)))
//        case AndParsingElement15(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//            } yield ParsingSuccessInfo(r14.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result)))
//        case AndParsingElement16(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//                r15 <- ParsingEngine._parse(pe15, r14.nextContext)
//            } yield ParsingSuccessInfo(r15.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result, r15.result)))
//        case AndParsingElement17(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//                r15 <- ParsingEngine._parse(pe15, r14.nextContext)
//                r16 <- ParsingEngine._parse(pe16, r15.nextContext)
//            } yield ParsingSuccessInfo(r16.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result, r15.result, r16.result)))
//        case AndParsingElement18(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//                r15 <- ParsingEngine._parse(pe15, r14.nextContext)
//                r16 <- ParsingEngine._parse(pe16, r15.nextContext)
//                r17 <- ParsingEngine._parse(pe17, r16.nextContext)
//            } yield ParsingSuccessInfo(r17.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result, r15.result, r16.result, r17.result)))
//        case AndParsingElement19(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//                r15 <- ParsingEngine._parse(pe15, r14.nextContext)
//                r16 <- ParsingEngine._parse(pe16, r15.nextContext)
//                r17 <- ParsingEngine._parse(pe17, r16.nextContext)
//                r18 <- ParsingEngine._parse(pe18, r17.nextContext)
//            } yield ParsingSuccessInfo(r18.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result, r15.result, r16.result, r17.result, r18.result)))
//        case AndParsingElement20(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//                r15 <- ParsingEngine._parse(pe15, r14.nextContext)
//                r16 <- ParsingEngine._parse(pe16, r15.nextContext)
//                r17 <- ParsingEngine._parse(pe17, r16.nextContext)
//                r18 <- ParsingEngine._parse(pe18, r17.nextContext)
//                r19 <- ParsingEngine._parse(pe19, r18.nextContext)
//            } yield ParsingSuccessInfo(r19.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result, r15.result, r16.result, r17.result, r18.result, r19.result)))
//        case AndParsingElement21(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, pe20, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//                r15 <- ParsingEngine._parse(pe15, r14.nextContext)
//                r16 <- ParsingEngine._parse(pe16, r15.nextContext)
//                r17 <- ParsingEngine._parse(pe17, r16.nextContext)
//                r18 <- ParsingEngine._parse(pe18, r17.nextContext)
//                r19 <- ParsingEngine._parse(pe19, r18.nextContext)
//                r20 <- ParsingEngine._parse(pe20, r19.nextContext)
//            } yield ParsingSuccessInfo(r20.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result, r15.result, r16.result, r17.result, r18.result, r19.result, r20.result)))
//        case AndParsingElement22(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, pe20, pe21, reducer, _) =>
//            for {
//                r0 <- ParsingEngine._parse(pe0, parsingContext)
//                r1 <- ParsingEngine._parse(pe1, r0.nextContext)
//                r2 <- ParsingEngine._parse(pe2, r1.nextContext)
//                r3 <- ParsingEngine._parse(pe3, r2.nextContext)
//                r4 <- ParsingEngine._parse(pe4, r3.nextContext)
//                r5 <- ParsingEngine._parse(pe5, r4.nextContext)
//                r6 <- ParsingEngine._parse(pe6, r5.nextContext)
//                r7 <- ParsingEngine._parse(pe7, r6.nextContext)
//                r8 <- ParsingEngine._parse(pe8, r7.nextContext)
//                r9 <- ParsingEngine._parse(pe9, r8.nextContext)
//                r10 <- ParsingEngine._parse(pe10, r9.nextContext)
//                r11 <- ParsingEngine._parse(pe11, r10.nextContext)
//                r12 <- ParsingEngine._parse(pe12, r11.nextContext)
//                r13 <- ParsingEngine._parse(pe13, r12.nextContext)
//                r14 <- ParsingEngine._parse(pe14, r13.nextContext)
//                r15 <- ParsingEngine._parse(pe15, r14.nextContext)
//                r16 <- ParsingEngine._parse(pe16, r15.nextContext)
//                r17 <- ParsingEngine._parse(pe17, r16.nextContext)
//                r18 <- ParsingEngine._parse(pe18, r17.nextContext)
//                r19 <- ParsingEngine._parse(pe19, r18.nextContext)
//                r20 <- ParsingEngine._parse(pe20, r19.nextContext)
//                r21 <- ParsingEngine._parse(pe21, r20.nextContext)
//            } yield ParsingSuccessInfo(r21.nextContext, reducer((r0.result, r1.result, r2.result, r3.result, r4.result, r5.result, r6.result, r7.result, r8.result, r9.result, r10.result, r11.result, r12.result, r13.result, r14.result, r15.result, r16.result, r17.result, r18.result, r19.result, r20.result, r21.result)))
    }
}
