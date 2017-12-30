package com.waynejo.parser.element

case class SimpleParsingElement(token: String) extends ParsingElement[String] with TerminalParsingElement {
    def debugString: String = {
        token
    }
}
