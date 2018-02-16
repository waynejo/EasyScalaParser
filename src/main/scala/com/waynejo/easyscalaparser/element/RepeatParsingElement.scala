package com.waynejo.easyscalaparser.element

case class RepeatParsingElement[A](parsingElement: ParsingElement[A], reducer: (A, A) => A) extends ParsingElement[A] {
    def name: String = {
        ""
    }
}