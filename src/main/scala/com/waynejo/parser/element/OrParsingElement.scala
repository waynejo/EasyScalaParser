package com.waynejo.parser.element

import com.waynejo.parser.types.MultipleType2

case class OrParsingElement2[A, B, C](pe0: ParsingElement[A], pe1: ParsingElement[B], reducer: (MultipleType2[A, B]) => C, debugString: String = "") extends ParsingElement[C]