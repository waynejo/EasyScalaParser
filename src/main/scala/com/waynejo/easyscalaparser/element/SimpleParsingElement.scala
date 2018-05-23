package com.waynejo.easyscalaparser.element

case class SimpleParsingElement(token: String) extends ParsingElement[String] with TerminalParsingElement {
  def name: String = {
    token
  }
}
