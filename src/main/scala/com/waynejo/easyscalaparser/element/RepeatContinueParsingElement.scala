package com.waynejo.easyscalaparser.element

case class RepeatContinueParsingElement[A](parsingElement: ParsingElement[A], reducer: (A, A) => A, lower: Int, upper: Int, lastElement: A) extends ParsingElement[A] {
    def name: String = {
        ""
    }
}