package com.waynejo.easyscalaparser.element

case class ResultParsingElement[A](value: A) extends ParsingElement[A] with TerminalParsingElement {
    def name: String = {
        ""
    }
}
