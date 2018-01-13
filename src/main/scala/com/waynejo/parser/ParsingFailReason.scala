package com.waynejo.parser

import com.waynejo.parser.element.ParsingElement

case class ParsingFailReason(index: Int, expected: String, parserStack: List[ParsingElement[_]])
