package com.waynejo.easyscalaparser.parsing.stack

import com.waynejo.easyscalaparser.element.ResultParsingElement

trait ParsingStackElement[A]
case class ParsingStackElement1[A](reducer: (_) => A, values: Vector[ResultParsingElement[_]])
