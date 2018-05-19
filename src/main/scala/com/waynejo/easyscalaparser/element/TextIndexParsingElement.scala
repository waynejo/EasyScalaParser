package com.waynejo.easyscalaparser.element

case class TextIndexParsingElement() extends ParsingElement[Int] with TerminalParsingElement {
  override def name: String = ""
}
