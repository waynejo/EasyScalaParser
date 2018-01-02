package com.waynejo.parser.element

case class RepeatParsingElement[A](parsingElement: ParsingElement[A], reducer: (A, A) => A) extends ParsingElement[A] {
    def debugString: String = {
        ""
    }
}