import com.waynejo.parser.ImplicitConversions._
import com.waynejo.parser.Parser
import com.waynejo.parser.element.ParsingElement
import com.waynejo.parser.types.{Type1, Type2}
import org.scalatest.FunSuite

class ComplexSuite extends FunSuite {
    test("Matching pairs") {
        case class ParsingResult(v: String)

        val rule0: ParsingElement[ParsingResult] = Parser.and("a", "b") { case (v0, v1) =>
            ParsingResult(v0 + v1)
        }

        lazy val rule1: ParsingElement[ParsingResult] = Parser.and("a", Parser.refer(() => parser), "b") { case (v0, v1, v2) =>
            ParsingResult(v0 + v1.v + v2)
        }

        lazy val parser = Parser.or(rule0, rule1) {
            case Type1(v) =>
                ParsingResult(v.v)
            case Type2(v) =>
                ParsingResult(v.v)
        }

        assert(parser.parse("ab").contains(ParsingResult("ab")))
        assert(parser.parse("aabb").contains(ParsingResult("aabb")))
        assert(parser.parse("aaabbb").contains(ParsingResult("aaabbb")))
        assert(parser.parse("aacbb").isEmpty)
    }
}
