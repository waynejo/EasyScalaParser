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
assert(parser.parse("abcd").contains(ParsingResult("ab", "cd", "ef")))
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
