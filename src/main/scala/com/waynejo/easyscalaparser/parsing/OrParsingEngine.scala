package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser.{ParsingContext, ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}

object OrParsingEngine {
    def parse[A](parsingContext: ParsingContext): PartialFunction[ParsingElement[A], ParsingContext] = {
        ???
//        case OrParsingElement(pe0, reducer, next, _) =>
//            next match {
//                case Some(nextOrParsingElement) =>
//                    ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextContext, reducer(x.result)))
//                        .left.flatMap { case (failInfo: ParsingFailInfo) =>
//                        OrParsingEngine.parse(parsingContext.onFail(failInfo))(nextOrParsingElement)
//                    }
//                case None =>
//                    ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextContext, reducer(x.result)))
//            }
    }
}
