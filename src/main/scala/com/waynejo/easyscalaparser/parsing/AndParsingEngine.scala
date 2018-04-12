package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser._

object AndParsingEngine {

    def reduce[A, B](reducer: ParsingElement[A], element: B): ParsingElement[A] = {
        reducer match {
            case AndParsingElement1(_, function, _, _) =>
                ResultParsingElement(function(element))

            case element2@AndParsingElement2(_, pe1, reduce, name, id) =>
                AndParsingElement1(pe1, reduce(element, _: element2.typeB), name, id)

            case element3@AndParsingElement3(_, pe1, pe2, reduce, name, id) =>
                AndParsingElement2(pe1, pe2, reduce(element, _: element3.typeB, _: element3.typeC), name, id)

            case element4@AndParsingElement4(_, pe1, pe2, pe3, reduce, name, id) =>
                AndParsingElement3(pe1, pe2, pe3, reduce(element, _: element4.typeB, _: element4.typeC, _: element4.typeD), name, id)

            case element5@AndParsingElement5(_, pe1, pe2, pe3, pe4, reduce, name, id) =>
                AndParsingElement4(pe1, pe2, pe3, pe4, reduce(element, _: element5.typeB, _: element5.typeC, _: element5.typeD, _: element5.typeE), name, id)

            case element6@AndParsingElement6(_, pe1, pe2, pe3, pe4, pe5, reduce, name, id) =>
                AndParsingElement5(pe1, pe2, pe3, pe4, pe5, reduce(element, _: element6.typeB, _: element6.typeC, _: element6.typeD, _: element6.typeE, _: element6.typeF), name, id)

            case element7@AndParsingElement7(_, pe1, pe2, pe3, pe4, pe5, pe6, reduce, name, id) =>
                AndParsingElement6(pe1, pe2, pe3, pe4, pe5, pe6, reduce(element, _: element7.typeB, _: element7.typeC, _: element7.typeD, _: element7.typeE, _: element7.typeF, _: element7.typeG), name, id)

            case element8@AndParsingElement8(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reduce, name, id) =>
                AndParsingElement7(pe1, pe2, pe3, pe4, pe5, pe6, pe7, reduce(element, _: element8.typeB, _: element8.typeC, _: element8.typeD, _: element8.typeE, _: element8.typeF, _: element8.typeG, _: element8.typeH), name, id)

            case element9@AndParsingElement9(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reduce, name, id) =>
                AndParsingElement8(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reduce(element, _: element9.typeB, _: element9.typeC, _: element9.typeD, _: element9.typeE, _: element9.typeF, _: element9.typeG, _: element9.typeH, _: element9.typeI), name, id)

            case element10@AndParsingElement10(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reduce, name, id) =>
                AndParsingElement9(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reduce(element, _: element10.typeB, _: element10.typeC, _: element10.typeD, _: element10.typeE, _: element10.typeF, _: element10.typeG, _: element10.typeH, _: element10.typeI, _: element10.typeJ), name, id)

            case element11@AndParsingElement11(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, reduce, name, id) =>
                AndParsingElement10(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, reduce(element, _: element11.typeB, _: element11.typeC, _: element11.typeD, _: element11.typeE, _: element11.typeF, _: element11.typeG, _: element11.typeH, _: element11.typeI, _: element11.typeJ, _: element11.typeK), name, id)

            case element12@AndParsingElement12(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, reduce, name, id) =>
                AndParsingElement11(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, reduce(element, _: element12.typeB, _: element12.typeC, _: element12.typeD, _: element12.typeE, _: element12.typeF, _: element12.typeG, _: element12.typeH, _: element12.typeI, _: element12.typeJ, _: element12.typeK, _: element12.typeL), name, id)

            case element13@AndParsingElement13(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, reduce, name, id) =>
                AndParsingElement12(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, reduce(element, _: element13.typeB, _: element13.typeC, _: element13.typeD, _: element13.typeE, _: element13.typeF, _: element13.typeG, _: element13.typeH, _: element13.typeI, _: element13.typeJ, _: element13.typeK, _: element13.typeL, _: element13.typeM), name, id)

            case element14@AndParsingElement14(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, reduce, name, id) =>
                AndParsingElement13(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, reduce(element, _: element14.typeB, _: element14.typeC, _: element14.typeD, _: element14.typeE, _: element14.typeF, _: element14.typeG, _: element14.typeH, _: element14.typeI, _: element14.typeJ, _: element14.typeK, _: element14.typeL, _: element14.typeM, _: element14.typeN), name, id)

            case element15@AndParsingElement15(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, reduce, name, id) =>
                AndParsingElement14(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, reduce(element, _: element15.typeB, _: element15.typeC, _: element15.typeD, _: element15.typeE, _: element15.typeF, _: element15.typeG, _: element15.typeH, _: element15.typeI, _: element15.typeJ, _: element15.typeK, _: element15.typeL, _: element15.typeM, _: element15.typeN, _: element15.typeO), name, id)

            case element16@AndParsingElement16(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, reduce, name, id) =>
                AndParsingElement15(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, reduce(element, _: element16.typeB, _: element16.typeC, _: element16.typeD, _: element16.typeE, _: element16.typeF, _: element16.typeG, _: element16.typeH, _: element16.typeI, _: element16.typeJ, _: element16.typeK, _: element16.typeL, _: element16.typeM, _: element16.typeN, _: element16.typeO, _: element16.typeP), name, id)

            case element17@AndParsingElement17(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, reduce, name, id) =>
                AndParsingElement16(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, reduce(element, _: element17.typeB, _: element17.typeC, _: element17.typeD, _: element17.typeE, _: element17.typeF, _: element17.typeG, _: element17.typeH, _: element17.typeI, _: element17.typeJ, _: element17.typeK, _: element17.typeL, _: element17.typeM, _: element17.typeN, _: element17.typeO, _: element17.typeP, _: element17.typeQ), name, id)

            case element18@AndParsingElement18(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, reduce, name, id) =>
                AndParsingElement17(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, reduce(element, _: element18.typeB, _: element18.typeC, _: element18.typeD, _: element18.typeE, _: element18.typeF, _: element18.typeG, _: element18.typeH, _: element18.typeI, _: element18.typeJ, _: element18.typeK, _: element18.typeL, _: element18.typeM, _: element18.typeN, _: element18.typeO, _: element18.typeP, _: element18.typeQ, _: element18.typeR), name, id)

            case element19@AndParsingElement19(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, reduce, name, id) =>
                AndParsingElement18(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, reduce(element, _: element19.typeB, _: element19.typeC, _: element19.typeD, _: element19.typeE, _: element19.typeF, _: element19.typeG, _: element19.typeH, _: element19.typeI, _: element19.typeJ, _: element19.typeK, _: element19.typeL, _: element19.typeM, _: element19.typeN, _: element19.typeO, _: element19.typeP, _: element19.typeQ, _: element19.typeR, _: element19.typeS), name, id)

            case element20@AndParsingElement20(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, reduce, name, id) =>
                AndParsingElement19(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, reduce(element, _: element20.typeB, _: element20.typeC, _: element20.typeD, _: element20.typeE, _: element20.typeF, _: element20.typeG, _: element20.typeH, _: element20.typeI, _: element20.typeJ, _: element20.typeK, _: element20.typeL, _: element20.typeM, _: element20.typeN, _: element20.typeO, _: element20.typeP, _: element20.typeQ, _: element20.typeR, _: element20.typeS, _: element20.typeT), name, id)

            case element21@AndParsingElement21(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, pe20, reduce, name, id) =>
                AndParsingElement20(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, pe20, reduce(element, _: element21.typeB, _: element21.typeC, _: element21.typeD, _: element21.typeE, _: element21.typeF, _: element21.typeG, _: element21.typeH, _: element21.typeI, _: element21.typeJ, _: element21.typeK, _: element21.typeL, _: element21.typeM, _: element21.typeN, _: element21.typeO, _: element21.typeP, _: element21.typeQ, _: element21.typeR, _: element21.typeS, _: element21.typeT, _: element21.typeU), name, id)

            case element22@AndParsingElement22(_, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, pe20, pe21, reduce, name, id) =>
                AndParsingElement21(pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10, pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, pe20, pe21, reduce(element, _: element22.typeB, _: element22.typeC, _: element22.typeD, _: element22.typeE, _: element22.typeF, _: element22.typeG, _: element22.typeH, _: element22.typeI, _: element22.typeJ, _: element22.typeK, _: element22.typeL, _: element22.typeM, _: element22.typeN, _: element22.typeO, _: element22.typeP, _: element22.typeQ, _: element22.typeR, _: element22.typeS, _: element22.typeT, _: element22.typeU, _: element22.typeV), name, id)
        }
    }

    def parse[A](parsingContext: ParsingContext, parsingState: ParsingState): PartialFunction[ParsingElement[A], ParsingContext] = {
        case parsingElement@AndParsingElement1(pe0, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement2(pe0, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement3(pe0, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement4(pe0, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement5(pe0, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement6(pe0, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement7(pe0, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement8(pe0, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement9(pe0, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement10(pe0, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement11(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement12(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement13(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement14(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement15(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement16(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement17(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement18(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement19(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement20(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement21(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@AndParsingElement22(pe0, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))
    }
}
