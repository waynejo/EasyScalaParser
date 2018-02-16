package com.waynejo.easyscalaparser.element

case class ReferenceParsingElement[A](reference: () => ParsingElement[A], name: String = "") extends ParsingElement[A] {
}
