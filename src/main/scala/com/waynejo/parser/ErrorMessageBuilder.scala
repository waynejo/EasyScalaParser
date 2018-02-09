package com.waynejo.parser

object ErrorMessageBuilder {
    val MAX_ACTUAL_TEXT_LENGTH = 20

    def build(text: String)(parsingFailInfo: ParsingFailInfo): String = {
        parsingFailInfo.failReasons.map(x => {
            val line = lineNumber(text, x.index)
            val column = columnNumber(text, x.index)
            val expected = (x.expected :: x.parserStack.map(_.name).filter(_.nonEmpty)).reverse.mkString(" > ")
            val actual = actualText(text, x.index)

            s"[$line:$column] expected: $expected but $actual"
        }).mkString("\n")
    }

    def lineNumber(text: String, index: Int): Int = {
        text.substring(0, index).count(_ == '\n') + 1
    }

    def columnNumber(text: String, index: Int): Int = {
        text.substring(0, index).split('\n').last.length + 1
    }

    def actualText(text: String, index: Int): String = {
        val result = if (text.length > index + MAX_ACTUAL_TEXT_LENGTH) {
            text.substring(index, index + MAX_ACTUAL_TEXT_LENGTH) + "..."
        } else {
            text.substring(index)
        }
        result.replace("\n", "\\n")
    }
}
