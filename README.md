EasyScalaParser
========

EasyScalaParser is a library for parsing grammar in the form of bnf notation.
It supports four operations(And, OR, Repeat, Times, Option).

Operations
========
 - And
   - You can parse continuous strings.
   - To parse the consecutive characters "ab", "cd", "ef", you can do the following:
```scala
import com.waynejo.parser.ImplicitConversions._
case class ParsingResult(v0: String, v1: String, v2: String)

val parser = Parser.and("ab", "cd", "ef") { case (v0, v1, v2) =>
    ParsingResult(v0, v1, v2)
}
assert(parser.parse("abcdef").contains(ParsingResult("ab", "cd", "ef")))
```

 - Or
   - You can parse in one of the some cases.
   - To parse the different characters "ab", and "cd", you can do the following:
   
```scala
import com.waynejo.parser.ImplicitConversions._
case class ParsingResult(v0: String)

val parser = Parser
    .or("ab")(ParsingResult)
    .or("cd")(ParsingResult)

assert(parser.parse("ab").contains(ParsingResult("ab")))
assert(parser.parse("cd").contains(ParsingResult("cd")))
assert(parser.parse("ef").isLeft)
```

 - Repeat
   - If you can get out more than once, you can handle it as follows.
   - If "ab" can continue to come out.
```scala
import com.waynejo.parser.ImplicitConversions._
case class ParsingResult(v0: String)

val parser = Parser.and(Parser.and("ab") {
    case (v0) => ParsingResult(v0)
}.repeat((v0, v1) => {
    ParsingResult(v0.v0 + "|" + v1.v0)
})

assert(parser.parse("ab").contains(ParsingResult("ab")))
assert(parser.parse("abab").contains(ParsingResult("ab|ab")))
assert(parser.parse("ababab").contains(ParsingResult("ab|ab|ab")))
```

 - Times
   - If you want to iterate over the minimum and maximum ranges greater than 1, you can use as follows.
   - If you want "abab", "ababab" or "abababab".
```scala
import com.waynejo.parser.ImplicitConversions._
case class ParsingResult(v0: String)

val parser = Parser.and(Parser.and("ab") {
    case (v0) => ParsingResult(v0)
}.times(2, 4)((v0, v1) => {
    ParsingResult(v0.v0 + "|" + v1.v0)
})

assert(parser.parse("ab").isLeft)
assert(parser.parse("abab").contains(ParsingResult("ab|ab")))
assert(parser.parse("ababab").contains(ParsingResult("ab|ab|ab")))
assert(parser.parse("abababab").contains(ParsingResult("ab|ab|ab|ab")))
assert(parser.parse("ababababab").isLeft)
```

 - Option
   - If you want the value to exist or not exist.
   - If you want "abef" or "abcdef".
```scala
import com.waynejo.parser.ImplicitConversions._
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
```

 - Regex
   - If you want to use regex, you can simply use the regex.
```scala
import com.waynejo.parser.ImplicitConversions._
case class ParsingResult(v0: String, v1: String)

val parser = Parser.and("[0-9]+".r, "cd") { case (v0, v1) =>
    ParsingResult(v0, v1)
}
assert(parser.parse("0123cd").contains(ParsingResult("0123", "cd")))
assert(parser.parse("012cd").contains(ParsingResult("012", "cd")))
assert(parser.parse("0cd").contains(ParsingResult("0", "cd")))
assert(parser.parse("abcd").isLeft)
```

 - Ignore some characters
   - If you simply want to ignore spaces or some strings between tokens and tokens, you can use:
```scala
import com.waynejo.parser.ImplicitConversions._
import com.waynejo.easyscalaparser.injection.ParsingIgnoreWhiteSpace
import com.waynejo.easyscalaparser.injection.ParsingIgnoreChars

val parser = ??? // making parser
parser.parse("text", ParsingIgnoreWhiteSpace) // to ignore white space
parser.parse("text", ParsingIgnoreChars("abc")) // to ignore 'a', 'b', or 'c'

```

 - Error handling
   - You can name it to keep track of the error situation.
   - In case of an error, you can check the error sentence by taking the value of Left.

```scala
import com.waynejo.parser.ImplicitConversions._
import com.waynejo.easyscalaparser.injection.ParsingIgnoreWhiteSpace
import com.waynejo.easyscalaparser.injection.ParsingIgnoreChars

case class ParsingResult(v: String)

val rule0 = Parser("group1").and("a", "b") { case (v0, v1) =>
    ParsingResult(v0 + v1)
}

lazy val rule1: ParsingElement[ParsingResult] = Parser("group2").and("a", Parser.refer(() => parser), "b") { case (v0, v1, v2) =>
    ParsingResult(v0 + v1.v + v2)
}

lazy val parser = Parser("group3")
    .or(rule0)(v => ParsingResult(v.v))
    .or(rule1)(v => ParsingResult(v.v))

assert(parser.parse("aacbb") == Left(
    """[1:3] expected: group3 > group2 > group3 > group1 > b but cbb
    |[1:3] expected: group3 > group2 > group3 > group2 > group3 > group1 > a but cbb
    |[1:3] expected: group3 > group2 > group3 > group2 > group3 > group2 > a but cbb
    |[1:2] expected: group3 > group1 > b but acbb""".stripMargin))

```
