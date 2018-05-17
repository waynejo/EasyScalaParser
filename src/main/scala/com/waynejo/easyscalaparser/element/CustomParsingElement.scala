package com.waynejo.easyscalaparser.element

case class CustomParsingElement(parser: (String, Int) => Option[Int], name: String) extends ParsingElement[String] with TerminalParsingElement {
}

object CustomParsingElement {
  def apply(parser: String => Option[String], name: String = ""): CustomParsingElement = {
    new CustomParsingElement((text: String, idx: Int) => {
      parser(text.substring(idx)).map(x => idx + x.length)
    }, name)
  }

  def apply(parser: (String, Int) => Option[Int]): CustomParsingElement = {
    new CustomParsingElement(parser, "")
  }
}