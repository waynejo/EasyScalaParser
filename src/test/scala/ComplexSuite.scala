import com.waynejo.easyscalaparser.ImplicitConversions._
import com.waynejo.easyscalaparser.Parser
import com.waynejo.easyscalaparser.element.ParsingElement
import org.scalatest.FunSuite

class ComplexSuite extends FunSuite {
  test("Matching pairs") {
    case class ParsingResult(v: String)

    val rule0 = Parser("group1").and("a", "b") { case (v0, v1) =>
      ParsingResult(v0 + v1)
    }

    lazy val rule1: ParsingElement[ParsingResult] = Parser("group2").and("a", Parser.refer(() => parser), "b") { case (v0, v1, v2) =>
      ParsingResult(v0 + v1.v + v2)
    }

    lazy val parser: ParsingElement[ParsingResult] = Parser("group3")
      .or(rule0)(v => ParsingResult(v.v))
      .or(rule1)(v => ParsingResult(v.v))

    assert(parser.parse("ab").contains(ParsingResult("ab")))
    assert(parser.parse("aabb").contains(ParsingResult("aabb")))
    assert(parser.parse("aaabbb").contains(ParsingResult("aaabbb")))
    assert(parser.parse("aacbb").left.map(x => x.replace("\r", "")) == Left(
      """[1:3] expected: group3 > group2 > group3 > group1 > b but cbb
        |[1:3] expected: group3 > group2 > group3 > group2 > group3 > group1 > a but cbb
        |[1:3] expected: group3 > group2 > group3 > group2 > group3 > group2 > a but cbb
        |[1:2] expected: group3 > group1 > b but acbb""".stripMargin.replace("\r", "")))
  }

  test("If there is a value that succeeds too early.") {
    case class ParsingResult(v: String)

    val rule1 = Parser("group1").and("a") { case (v0) =>
      ParsingResult(v0)
    }

    val rule2 = Parser("group2").and("a", "b") { case (v0, v1) =>
      ParsingResult(v0 + v1)
    }

    val rule3 = Parser("group3").or(rule1)(x => x).or(rule2)(x => x)

    val rule4 = Parser("group4").and(rule3, "c") { case (v0, v1) =>
      ParsingResult(v0.v + v1)
    }

    assert(rule4.parse("abc").contains(ParsingResult("abc")))
  }
}
