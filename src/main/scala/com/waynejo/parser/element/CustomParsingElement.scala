package com.waynejo.parser.element

case class CustomParsingElement(parser: String => Option[String], debugString: String = "") extends ParsingElement[String] with TerminalParsingElement {
}
