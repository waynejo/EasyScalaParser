package com.waynejo.easyscalaparser.element

case class RepeatContinueParsingElement[A](parsingElement: ParsingElement[A], reducer: (A, A) => A, lastElement: A) extends ParsingElement[A] {
    def name: String = {
        ""
    }
}