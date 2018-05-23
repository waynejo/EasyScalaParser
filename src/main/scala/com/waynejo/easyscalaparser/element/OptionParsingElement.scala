package com.waynejo.easyscalaparser.element

case class OptionParsingElement[A](parsingElement: ParsingElement[A]) extends ParsingElement[Option[A]] {
  def name: String = {
    ""
  }
}