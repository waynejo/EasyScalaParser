import com.waynejo.easyscalaparser.Parser
import com.waynejo.easyscalaparser.ImplicitConversions._
import com.waynejo.easyscalaparser.element.CustomParsingElement
import com.waynejo.easyscalaparser.injection.ParsingIgnoreWhiteSpace
import org.scalatest.FunSuite

class BasicSuite extends FunSuite {
    test("simple 'and' success") {
        case class ParsingResult(v0: String, v1: String)

        val parser = Parser.and("ab", "cd") { case (v0, v1) =>
            ParsingResult(v0, v1)
        }
        assert(parser.parse("abcd").contains(ParsingResult("ab", "cd")))
    }

    test("simple 'and' fail") {
        case class ParsingResult(v0: String, v1: String)

        val parser = Parser.and("ab", "cd") { case (v0, v1) =>
            ParsingResult(v0, v1)
        }
        assert(parser.parse("abc").isLeft)
    }

    test("stacked 'and' success") {
        case class ParsingResult(v0: String, v1: String, v2: String, v3: String)

        val parser1 = Parser.and("cd", "ef") { case (v0, v1) =>
            ParsingResult("", v0, v1, "")
        }

        val parser2 = Parser.and("ab", parser1, "gh") { case (v0, v1, v2) =>
            ParsingResult(v0, v1.v1, v1.v2, v2)
        }

        assert(parser2.parse("abcdefgh").contains(ParsingResult("ab", "cd", "ef", "gh")))
    }

    test("stacked 'and' fail") {
        case class ParsingResult(v0: String, v1: String, v2: String, v3: String)

        val parser1 = Parser.and("cd", "ef") { case (v0, v1) =>
            ParsingResult("", v0, v1, "")
        }

        val parser2 = Parser.and("ab", parser1, "gh") { case (v0, v1, v2) =>
            ParsingResult(v0, v1.v1, v1.v2, v2)
        }

        assert(parser2.parse("abcddfgh").isLeft)
    }

    test("simple 'or'") {
        case class ParsingResult(v0: String)

        val parser = Parser
            .or("ab")(ParsingResult)
            .or("cd")(ParsingResult)

        assert(parser.parse("ab").contains(ParsingResult("ab")))
        assert(parser.parse("cd").contains(ParsingResult("cd")))
        assert(parser.parse("ef").isLeft)
    }

    test("simple 'option'") {
        case class ParsingResult(v0: String)

        val parser = Parser.and("ab", "cd".option, "ef") {
            case (v0, Some(v1), v2) =>
                ParsingResult(v0 + v1 + v2)
            case (v0, None, v2) =>
                ParsingResult(v0 + v2)
        }

        assert(parser.parse("abcdef").contains(ParsingResult("abcdef")))
        assert(parser.parse("abef").contains(ParsingResult("abef")))
        assert(parser.parse("ab").isLeft)
    }

    test("simple 'repeat'") {
        case class ParsingResult(v0: String)

        val parser = Parser.and(Parser.and("ab", "cd") {
            case (v0, v1) =>
                ParsingResult(v0 + v1)
        }.repeat((v0, v1) => {
            ParsingResult(v0.v0 + v1.v0)
        }), "ef") {
            case (v0, v1) =>
                ParsingResult(v0.v0 + v1)
        }

        assert(parser.parse("ef").isLeft)
        assert(parser.parse("abcdef").contains(ParsingResult("abcdef")))
        assert(parser.parse("abcdabcdef").contains(ParsingResult("abcdabcdef")))
        assert(parser.parse("abcdabcdabcdef").contains(ParsingResult("abcdabcdabcdef")))
        assert(parser.parse("abcdabef").isLeft)
    }

    test("simple 'repeat' with semigroup") {
        case class ParsingResult(v0: String)

        implicit val evidence: cats.Semigroup[ParsingResult] = (v0, v1) => {
            ParsingResult(v0.v0 + v1.v0)
        }

        val parser = Parser.and(Parser.and("ab", "cd") {
            case (v0, v1) =>
                ParsingResult(v0 + v1)
        }.repeat, "ef") {
            case (v0, v1) =>
                ParsingResult(v0.v0 + v1)
        }

        assert(parser.parse("ef").isLeft)
        assert(parser.parse("abcdef").contains(ParsingResult("abcdef")))
        assert(parser.parse("abcdabcdef").contains(ParsingResult("abcdabcdef")))
        assert(parser.parse("abcdabcdabcdef").contains(ParsingResult("abcdabcdabcdef")))
        assert(parser.parse("abcdabef").isLeft)
    }

    test("simple 'times'") {
        case class ParsingResult(v0: String)

        val parser = Parser.and(Parser.and("ab", "cd") {
            case (v0, v1) =>
                ParsingResult(v0 + v1)
        }.times(2)((v0, v1) => {
            ParsingResult(v0.v0 + v1.v0)
        }), "ef") {
            case (v0, v1) =>
                ParsingResult(v0.v0 + v1)
        }

        assert(parser.parse("ef").isLeft)
        assert(parser.parse("abcdef").isLeft)
        assert(parser.parse("abcdabcdef").contains(ParsingResult("abcdabcdef")))
        assert(parser.parse("abcdabcdabcdef").isLeft)
        assert(parser.parse("abcdabef").isLeft)
    }

    test("simple 'times' with lower and upper limit") {
        case class ParsingResult(v0: String)

        val parser = Parser.and(Parser.and("ab", "cd") {
            case (v0, v1) =>
                ParsingResult(v0 + v1)
        }.times(2, 4)((v0, v1) => {
            ParsingResult(v0.v0 + v1.v0)
        }), "ef") {
            case (v0, v1) =>
                ParsingResult(v0.v0 + v1)
        }

        assert(parser.parse("ef").isLeft)
        assert(parser.parse("abcdef").isLeft)
        assert(parser.parse("abcdabcdef").contains(ParsingResult("abcdabcdef")))
        assert(parser.parse("abcdabcdabcdef").contains(ParsingResult("abcdabcdabcdef")))
        assert(parser.parse("abcdabcdabcdabcdef").contains(ParsingResult("abcdabcdabcdabcdef")))
        assert(parser.parse("abcdabcdabcdabcdabcdef").isLeft)
        assert(parser.parse("abcdabef").isLeft)
    }

    test("simple regex") {
        case class ParsingResult(v0: String, v1: String)

        val parser = Parser.and("[0-9]+".r, "cd") { case (v0, v1) =>
            ParsingResult(v0, v1)
        }
        assert(parser.parse("0123cd").contains(ParsingResult("0123", "cd")))
        assert(parser.parse("012cd").contains(ParsingResult("012", "cd")))
        assert(parser.parse("0cd").contains(ParsingResult("0", "cd")))
        assert(parser.parse("abcd").isLeft)
    }

    test("simple custom") {
        case class ParsingResult(v0: String, v1: String)

        val customParser = CustomParsingElement(s => {
            def _parse(text: String, acc: String = ""): Option[String] = {
                if (text.isEmpty || ('0' > text.head || '9' < text.head)) {
                    if (acc.isEmpty) {
                        None
                    } else {
                        Some(acc)
                    }
                } else {
                    _parse(text.tail, acc + text.head)
                }
            }
            _parse(s)
        })

        val parser = Parser.and(customParser, "cd") { case (v0, v1) =>
            ParsingResult(v0, v1)
        }
        assert(parser.parse("0123cd").contains(ParsingResult("0123", "cd")))
        assert(parser.parse("012cd").contains(ParsingResult("012", "cd")))
        assert(parser.parse("0cd").contains(ParsingResult("0", "cd")))
        assert(parser.parse("abcd").isLeft)
    }

    test("ignore whitespace") {
        case class ParsingResult(v0: String, v1: String)

        val parser = Parser.and("ab", "cd") { case (v0, v1) =>
            ParsingResult(v0, v1)
        }
        assert(parser.parse("ab \r\n\t cd", ParsingIgnoreWhiteSpace).contains(ParsingResult("ab", "cd")))
    }
}
