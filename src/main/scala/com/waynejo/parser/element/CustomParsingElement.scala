package com.waynejo.parser.element

case class CustomParsingElement(parser: String => Option[String], name: String = "") extends ParsingElement[String] with TerminalParsingElement {
}
