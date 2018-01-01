package com.waynejo.parser.element

case class OptionParsingElement[A](parsingElement: ParsingElement[A]) extends ParsingElement[Option[A]] {
    def debugString: String = {
        ""
    }
}