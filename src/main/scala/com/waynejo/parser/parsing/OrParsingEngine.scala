package com.waynejo.parser.parsing

import com.waynejo.parser.element._
import com.waynejo.parser.{ParsingContext, ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}
import com.waynejo.parser.types._

object OrParsingEngine {
    def parse[A](parsingContext: ParsingContext, parserStack: List[ParsingElement[_]]): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case OrParsingElement1(pe0, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))

        case OrParsingElement2(pe0, pe1, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }
        case OrParsingElement3(pe0, pe1, pe2, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }
        case OrParsingElement4(pe0, pe1, pe2, pe3, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type3(x.result))))
            }
        case OrParsingElement5(pe0, pe1, pe2, pe3, pe4, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type4(x.result))))
            }
        case OrParsingElement6(pe0, pe1, pe2, pe3, pe4, pe5, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type5(x.result))))
            }
        case OrParsingElement7(pe0, pe1, pe2, pe3, pe4, pe5, pe6, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type6(x.result))))
            }
        case OrParsingElement8(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type7(x.result))))
            }
        case OrParsingElement9(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type7(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe8, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type8(x.result))))
            }
        case OrParsingElement10(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext, parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type7(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe8, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type8(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe9, parsingContext.onFail(failInfo), parserStack).map(x => ParsingSuccessInfo(x.nextContext, reducer(Type9(x.result))))
            }
    }
}
