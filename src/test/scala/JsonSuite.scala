import com.waynejo.parser.ImplicitConversions._
import com.waynejo.parser.Parser
import com.waynejo.parser.element.ParsingElement
import org.scalatest.FunSuite
import cats.implicits._
import com.waynejo.parser.injection.ParsingIgnoreRemoveWhiteSpace

class JsonSuite extends FunSuite {

    trait JsonElement
    case class JsonObject(children: Map[String, JsonElement]) extends JsonElement
    case class JsonArray(values: Array[JsonElement]) extends JsonElement
    case class JsonString(value: String) extends JsonElement
    case class JsonNumber(value: Double) extends JsonElement
    case class JsonBoolean(value: Boolean) extends JsonElement

    def jsonKey = Parser("JsonKey").and("\"[^\"]*\"".r)(x => x)
    def jsonString = Parser("JsonString").and("\"[^\"]*\"".r)(x => JsonString(x))
    def jsonNumber = Parser("JsonNumber").and("([0-9]+\\.[0-9]*)|([0-9]*\\.[0-9]+)|([0-9]+)".r)(x => JsonNumber(x.toDouble))
    def jsonBoolean = Parser("JsonBoolean").or("true")(_ => JsonBoolean(true)).or("false")(_ => JsonBoolean(false))
    def jsonValue: ParsingElement[JsonElement] = Parser.or[JsonString, JsonElement](jsonString)(x => x)
        .or(jsonNumber)(x => x)
        .or(jsonBoolean)(x => x)
        .or(Parser.refer(() => jsonObject))(x => x)
        .or(Parser.refer(() => jsonArray))(x => x)

    def jsonObjectBody = Parser.and(jsonKey, ":", jsonValue)(x => (x._1, x._3))
    def jsonObjectBodyRecursive = Parser.and(jsonObjectBody, Parser.and(",", jsonObjectBody)(x => x._2 :: Nil).repeat.option)(x => x._1 :: x._2.getOrElse(Nil))
    def jsonObject = Parser("JsonObject").and("{", jsonObjectBodyRecursive.option, "}")(x => JsonObject(x._2.getOrElse(Nil).toMap))
    def jsonArrayBodyRecursive = Parser.and(jsonValue, Parser.and(",", jsonValue)(x => x._2 :: Nil).repeat.option)(x => x._1 :: x._2.getOrElse(Nil))
    def jsonArray = Parser("JsonArray").and("[", jsonArrayBodyRecursive.option, "]")(x => JsonArray(x._2.getOrElse(Nil).toArray))
    def jsonParser = Parser("Json").or[JsonObject, JsonElement](jsonObject)(x => x).or(jsonArray)(x => x)

    test("simple json parser") {
        val jsonText = """{
          |	"id": "0001",
          | "type": "donut",
          |	"name": "Cake",
          |	"ppu": 0.55,
          |	"batters":
          |		{
          |			"batter":
          |				[
          |					{ "id": 1001, "type": "Regular" },
          |					{ "id": 1002, "type": "Chocolate" },
          |					{ "id": 1003, "type": "Blueberry" },
          |					{ "id": 1004, "type": "Devil's Food" }
          |				]
          |		},
          |	"topping":
          |		[
          |			{ "id": 5001, "type": "None" },
          |			{ "id": 5002, "type": "Glazed" },
          |			{ "id": 5005, "type": "Sugar" },
          |			{ "id": 5007, "type": "Powdered Sugar" },
          |			{ "id": 5006, "type": "Chocolate with Sprinkles" },
          |			{ "id": 5003, "type": "Chocolate" },
          |			{ "id": 5004, "type": "Maple" }
          |		]
          |}
        """.stripMargin
        assert(
            jsonParser.parse(jsonText, ParsingIgnoreRemoveWhiteSpace) ==
                Right(
                    JsonObject(
                        Map("batters" -> JsonObject(
                            Map("batter" -> JsonArray(
                                Array(
                                    JsonObject(Map("id" -> JsonNumber(1001), "type" -> JsonString("Regular"))),
                                    JsonObject(Map("id" -> JsonNumber(1002), "type" -> JsonString("Chocolate"))),
                                    JsonObject(Map("id" -> JsonNumber(1003), "type" -> JsonString("Blueberry"))),
                                    JsonObject(Map("id" -> JsonNumber(1004), "type" -> JsonString("Devil's Food")))
                                )
                            ))), "type" -> JsonString("donut")
                            , "ppu" -> JsonNumber(0.55)
                            , "id" -> JsonString("0001")
                            , "name" -> JsonString("Cake")
                            , "topping" -> JsonArray(Array(
                                JsonObject(Map("id" -> JsonNumber(5001), "type" -> JsonString("None"))),
                                JsonObject(Map("id" -> JsonNumber(5002), "type" -> JsonString("Glazed"))),
                                JsonObject(Map("id" -> JsonNumber(5005), "type" -> JsonString("Sugar"))),
                                JsonObject(Map("id" -> JsonNumber(5007), "type" -> JsonString("Powdered Sugar"))),
                                JsonObject(Map("id" -> JsonNumber(5006), "type" -> JsonString("Chocolate with Sprinkles"))),
                                JsonObject(Map("id" -> JsonNumber(5003), "type" -> JsonString("Chocolate"))),
                                JsonObject(Map("id" -> JsonNumber(5004), "type" -> JsonString("Maple"))
                            )
                            )
                        )
                    )
                )
            )
        )
    }
}
