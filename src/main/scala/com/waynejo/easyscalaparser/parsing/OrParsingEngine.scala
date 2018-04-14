package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser.element.{OrParsingElement, _}
import com.waynejo.easyscalaparser._

object OrParsingEngine {
    def reduce[A, B](reducer: ParsingElement[A], element: B): ParsingElement[A] = {
        reducer match {
            case OrParsingElement(_, reduce, _, _) =>
                ResultParsingElement(reduce(element))
        }
    }

    def parse[A](parsingContext: ParsingContext, parsingState: ParsingState): PartialFunction[ParsingElement[A], ParsingContext] = {
        case parsingElement@OrParsingElement(pe0, _, next, _) =>
            next match {
                case Some(nextOrParsingElement) =>
                    val nextContext = parse(parsingContext, parsingState)(nextOrParsingElement)
                    nextContext.onSuccess(parsingState(parsingElement).markSplitIndex()(pe0))
                case None =>
                    parsingContext.onSuccess(parsingState(parsingElement)(pe0))
            }
    }
}
