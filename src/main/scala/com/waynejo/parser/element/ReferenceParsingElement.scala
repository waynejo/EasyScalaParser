package com.waynejo.parser.element

case class ReferenceParsingElement[A](reference: () => ParsingElement[A], name: String = "") extends ParsingElement[A] {
}
