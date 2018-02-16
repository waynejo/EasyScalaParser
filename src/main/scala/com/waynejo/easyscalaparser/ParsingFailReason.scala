package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.ParsingElement

case class ParsingFailReason(index: Int, expected: String, parserStack: List[ParsingElement[_]])
