package com.waynejo.parser.parsing

import com.waynejo.parser.element._
import com.waynejo.parser.{ParsingEngine, ParsingFailInfo, ParsingSuccessInfo}
import com.waynejo.parser.types._

object OrParsingEngine {
    def parse[A](text: String, terminals: List[TerminalParsingElement]): PartialFunction[ParsingElement[A], Either[ParsingFailInfo, ParsingSuccessInfo[A]]] = {
        case OrParsingElement1(pe0, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))

        case OrParsingElement2(pe0, pe1, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }
        case OrParsingElement3(pe0, pe1, pe2, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }
        case OrParsingElement4(pe0, pe1, pe2, pe3, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type3(x.result))))
            }
        case OrParsingElement5(pe0, pe1, pe2, pe3, pe4, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type4(x.result))))
            }
        case OrParsingElement6(pe0, pe1, pe2, pe3, pe4, pe5, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type5(x.result))))
            }
        case OrParsingElement7(pe0, pe1, pe2, pe3, pe4, pe5, pe6, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type6(x.result))))
            }
        case OrParsingElement8(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type7(x.result))))
            }
        case OrParsingElement9(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type7(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe8, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type8(x.result))))
            }
        case OrParsingElement10(pe0, pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, reducer, _) =>
            ParsingEngine._parse(pe0, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type0(x.result))))
                .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe1, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type1(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe2, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type2(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe3, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type3(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe4, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type4(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe5, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type5(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe6, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type6(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe7, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type7(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe8, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type8(x.result))))
            }        .left.flatMap { case (failInfo: ParsingFailInfo) =>
                ParsingEngine._parse(pe9, text, terminals).map(x => ParsingSuccessInfo(x.remain, reducer(Type9(x.result))))
            }
    }
}
