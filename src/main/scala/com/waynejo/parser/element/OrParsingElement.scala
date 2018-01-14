package com.waynejo.parser.element

case class OrParsingElement[A, B](pe: ParsingElement[A], reducer: A => B, next: Option[OrParsingElement[_, B]], name: String = "") extends ParsingElement[B]
