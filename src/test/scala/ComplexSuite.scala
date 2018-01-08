import com.waynejo.parser.ImplicitConversions._
import com.waynejo.parser.Parser
import com.waynejo.parser.element.ParsingElement
import com.waynejo.parser.types.{Type0, Type1}
import org.scalatest.FunSuite

class ComplexSuite extends FunSuite {
    test("Matching pairs") {
        case class ParsingResult(v: String)

        val rule0 = Parser.and("a", "b") { case (v0, v1) =>
            ParsingResult(v0 + v1)
        }

        lazy val rule1: ParsingElement[ParsingResult] = Parser.and("a", Parser.refer(() => parser), "b") { case (v0, v1, v2) =>
            ParsingResult(v0 + v1.v + v2)
        }

        lazy val parser = Parser.or(rule0, rule1) {
            case Type0(v) =>
                ParsingResult(v.v)
            case Type1(v) =>
                ParsingResult(v.v)
        }

        assert(parser.parse("ab").contains(ParsingResult("ab")))
        assert(parser.parse("aabb").contains(ParsingResult("aabb")))
        assert(parser.parse("aaabbb").contains(ParsingResult("aaabbb")))
        assert(parser.parse("aacbb") == Left("[1:3] expected: b but cbb\n[1:3] expected: a but cbb\n[1:3] expected: a but cbb\n[1:2] expected: b but acbb"))
    }
}
