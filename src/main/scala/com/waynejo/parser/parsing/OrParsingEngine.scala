package com.waynejo.parser.parsing

import com.waynejo.parser.element._
import com.waynejo.parser.{ParsingContext, ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}

object OrParsingEngine {
    def parse[A](parsingContext: ParsingContext, parserStack: List[ParsingElement[_]]): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case OrParsingElement(pe0, reducer, next, _) =>
            next match {
                case Some(nextOrParsingElement) =>
                    ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(x.result)))
                        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                        OrParsingEngine.parse(parsingContext.onFail(failInfo), parserStack)(nextOrParsingElement)
                            //.map(x => ParsingSuccessInfo(x.nextContext, nextOrParsingElement.reducer(x.result)))
                    }
                case None =>
                    ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(x.result)))
            }
    }
}
