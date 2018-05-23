package com.waynejo.easyscalaparser.element

case class TimesParsingElement[A](parsingElement: ParsingElement[A], lower: Int, upper: Int, reducer: (A, A) => A) extends ParsingElement[A] {
  def name: String = {
    ""
  }
}