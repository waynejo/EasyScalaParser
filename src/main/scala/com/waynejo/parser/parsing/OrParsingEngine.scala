package com.waynejo.parser.parsing

import com.waynejo.parser.element._
import com.waynejo.parser.{ParsingContext, ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}
import com.waynejo.parser.types._

object OrParsingEngine {
    def parse[A](parsingContext: ParsingContext): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case OrParsingElement1(pe0, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))

        case OrParsingElement2(pe0, pe1, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }
        case OrParsingElement3(pe0, pe1, pe2, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }
        case OrParsingElement4(pe0, pe1, pe2, pe3, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type3(x.result))))
            }
        case OrParsingElement5(pe0, pe1, pe2, pe3, pe4, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type4(x.result))))
            }
        case OrParsingElement6(pe0, pe1, pe2, pe3, pe4, pe5, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type5(x.result))))
            }
        case OrParsingElement7(pe0, pe1, pe2, pe3, pe4, pe5, pe6, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type6(x.result))))
            }
        case OrParsingElement8(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type7(x.result))))
            }
        case OrParsingElement9(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type7(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe8, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type8(x.result))))
            }
        case OrParsingElement10(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reducer, _) =>
            ParsingEngine._parse(pe0, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type7(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe8, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type8(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe9, parsingContext).map(x => ParsingSuccessInfo(x.nextIndex, reducer(Type9(x.result))))
            }
    }
}
