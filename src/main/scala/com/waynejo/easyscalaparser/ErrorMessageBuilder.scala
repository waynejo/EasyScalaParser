package com.waynejo.easyscalaparser

case class ErrorMessageBuilder(maxErrorTextNum: Int) {

  def build(text: String)(parsingFailInfo: ParsingFailInfo): String = {
    parsingFailInfo.failReasons.map(x => {
      val line = lineNumber(text, x.index)
      val column = columnNumber(text, x.index)
      val expected = (x.expected :: x.parserStack.map(_._2.name).filter(_.nonEmpty)).reverse.mkString(" > ")
      val actual = actualText(text, x.index)

      s"[$line:$column] expected: $expected but $actual"
    }).mkString("\n")
  }

  def lineNumber(text: String, index: Int): Int = {
    text.substring(0, index).count(_ == '\n') + 1
  }

  def columnNumber(text: String, index: Int): Int = {
    val splitText = text.substring(0, index).split('\n')
    if (splitText.isEmpty) {
      0
    } else {
      splitText.last.length + 1
    }
  }

  def actualText(text: String, index: Int): String = {
    val result = if (text.length > index + maxErrorTextNum) {
      text.substring(index, index + maxErrorTextNum) + "..."
    } else {
      text.substring(index)
    }
    result.replace("\n", "\\n")
  }
}
