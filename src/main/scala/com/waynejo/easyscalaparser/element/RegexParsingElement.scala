package com.waynejo.easyscalaparser.element

import scala.util.matching.Regex

case class RegexParsingElement(token: Regex) extends ParsingElement[String] with TerminalParsingElement {
    def name: String = {
        token.toString()
    }
}
