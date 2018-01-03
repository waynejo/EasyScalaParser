import com.waynejo.parser.Parser
import com.waynejo.parser.ImplicitConversions._
import com.waynejo.parser.types.{Type1, Type2}
import org.scalatest.FunSuite

import scala.util.matching.Regex

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
            case Type1(v) =>
                ParsingResult(v)
            case Type2(v) =>
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
}
