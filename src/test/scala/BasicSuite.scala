import com.waynejo.parser.Parser
import com.waynejo.parser.ImplicitConversions._
import com.waynejo.parser.element.CustomParsingElement
import com.waynejo.parser.types.{Type0, Type1}
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
        assert(parser.parse("abc").isEmpty)
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

        assert(parser2.parse("abcddfgh").isEmpty)
    }

    test("simple 'or'") {
        case class ParsingResult(v0: String)

        val parser = Parser.or("ab", "cd") {
            case Type0(v) =>
                ParsingResult(v)
            case Type1(v) =>
                ParsingResult(v)
        }

        assert(parser.parse("ab").contains(ParsingResult("ab")))
        assert(parser.parse("cd").contains(ParsingResult("cd")))
        assert(parser.parse("ef").isEmpty)
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
        assert(parser.parse("ab").isEmpty)
    }

    test("simple 'repeat'") {
        case class ParsingResult(v0: String)

        val parser = Parser.and(Parser.and("ab", "cd") {
            case (v0, v1) =>
                ParsingResult(v0 + v1)
        }.repeat {
            case (v0, v1) =>
                ParsingResult(v0.v0 + v1.v0)
        }, "ef") {
            case (v0, v1) =>
                ParsingResult(v0.v0 + v1)
        }

        assert(parser.parse("ef").isEmpty)
        assert(parser.parse("abcdef").contains(ParsingResult("abcdef")))
        assert(parser.parse("abcdabcdef").contains(ParsingResult("abcdabcdef")))
        assert(parser.parse("abcdabcdabcdef").contains(ParsingResult("abcdabcdabcdef")))
        assert(parser.parse("abcdabef").isEmpty)
    }

    test("simple regex") {
        case class ParsingResult(v0: String, v1: String)

        val parser = Parser.and("[0-9]+".r, "cd") { case (v0, v1) =>
            ParsingResult(v0, v1)
        }
        assert(parser.parse("0123cd").contains(ParsingResult("0123", "cd")))
        assert(parser.parse("012cd").contains(ParsingResult("012", "cd")))
        assert(parser.parse("0cd").contains(ParsingResult("0", "cd")))
        assert(parser.parse("abcd").isEmpty)
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
        assert(parser.parse("abcd").isEmpty)
    }
}
