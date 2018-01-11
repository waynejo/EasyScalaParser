package com.waynejo.parser.element

case class TimesParsingElement[A](parsingElement: ParsingElement[A], n: Int, reducer: (A, A) => A) extends ParsingElement[A] {
    def name: String = {
        ""
    }
}