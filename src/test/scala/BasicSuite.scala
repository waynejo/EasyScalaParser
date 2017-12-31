import com.waynejo.parser.Parser
import com.waynejo.parser.ImplicitConversions._
import com.waynejo.parser.types.{Type1, Type2}
import org.scalatest.FunSuite

class BasicSuite extends FunSuite {
    test("simple 'and' success") {
        case class ParsingResult(v0: String, v1: String)

        val parser = Parser.and("ab", "cd")({ case (v0, v1) =>
            ParsingResult(v0, v1)
        })
        assert(parser.parse("abcd").contains(ParsingResult("ab", "cd")))
    }

    test("simple 'and' fail") {
        case class ParsingResult(v0: String, v1: String)

        val parser = Parser.and("ab", "cd")({ case (v0, v1) =>
            ParsingResult(v0, v1)
        })
        assert(parser.parse("abc").isEmpty)
    }

    test("stacked 'and' success") {
        case class ParsingResult(v0: String, v1: String, v2: String, v3: String)

        val parser1 = Parser.and("cd", "ef")({ case (v0, v1) =>
            ParsingResult("", v0, v1, "")
        })

        val parser2 = Parser.and("ab", parser1, "gh")({ case (v0, v1, v2) =>
            ParsingResult(v0, v1.v1, v1.v2, v2)
        })

        assert(parser2.parse("abcdefgh").contains(ParsingResult("ab", "cd", "ef", "gh")))
    }

    test("stacked 'and' fail") {
        case class ParsingResult(v0: String, v1: String, v2: String, v3: String)

        val parser1 = Parser.and("cd", "ef")({ case (v0, v1) =>
            ParsingResult("", v0, v1, "")
        })

        val parser2 = Parser.and("ab", parser1, "gh")({ case (v0, v1, v2) =>
            ParsingResult(v0, v1.v1, v1.v2, v2)
        })

        assert(parser2.parse("abcddfgh").isEmpty)
    }

    test("simple 'or'") {
        case class ParsingResult(v0: String)

        val parser = Parser.or("ab", "cd")({
            case Type1(v) =>
                ParsingResult(v)
            case Type2(v) =>
                ParsingResult(v)
        })

        assert(parser.parse("ab").contains(ParsingResult("ab")))
        assert(parser.parse("cd").contains(ParsingResult("cd")))
        assert(parser.parse("ef").isEmpty)
    }
}
