package com.waynejo.easyscalaparser.element

case class EndOfStringElement() extends ParsingElement[Unit] with TerminalParsingElement {
  def name: String = {
    "End Of String"
  }
}

