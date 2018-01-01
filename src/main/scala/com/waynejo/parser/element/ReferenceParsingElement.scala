package com.waynejo.parser.element

case class ReferenceParsingElement[A](reference: () => ParsingElement[A]) extends ParsingElement[A] {
    def debugString: String = {
        ""
    }
}
