package com.waynejo.easyscalaparser.parsing.stack

import com.waynejo.easyscalaparser.element.{ParsingElement, TerminalParsingElement}

case class ParsingStackIterator(stack: Vector[ParsingElement[_]]) {
  def next(): Map[TerminalParsingElement, Vector[Vector[ParsingElement[_]]]] = {
    ???
  }
}
