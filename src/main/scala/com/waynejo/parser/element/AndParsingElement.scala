package com.waynejo.parser.element

case class AndParsingElement1[A, B](pe0: ParsingElement[A], reducer: A => B, debugString: String = "") extends ParsingElement[B]
case class AndParsingElement2[A, B, C](pe0: ParsingElement[A], pe1: ParsingElement[B], reducer: ((A, B)) => C, debugString: String = "") extends ParsingElement[C]
case class AndParsingElement3[A, B, C, D](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], reducer: ((A, B, C)) => D, debugString: String = "") extends ParsingElement[D]
