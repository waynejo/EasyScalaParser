package com.waynejo.easyscalaparser.parsing.stack

import com.waynejo.easyscalaparser.element._

case class ParsingStackIterator(stack: Vector[ParsingElement[_]]) {

  def next(): Map[TerminalParsingElement, Vector[Vector[ParsingElement[_]]]] = {
    def _next(elements: Vector[ParsingElement[_]]): Map[TerminalParsingElement, Vector[Vector[ParsingElement[_]]]] = {
      elements.head match {
        case terminalElement: TerminalParsingElement =>
          Map(terminalElement -> Vector(elements))
        case OrParsingElement(element, _, next, _, _, _) =>
          if (next.isDefined) {
            _next(element +: elements.tail) ++ _next(next.get +: elements.tail)
          } else {
            _next(element +: elements.tail)
          }
        case ReferenceParsingElement(reference, _, _) =>
          _next(reference() +: elements.tail)
        case OptionParsingElement(parsingElement, _) =>
          _next(parsingElement +: elements.tail) ++ _next(elements.tail)
        case RepeatParsingElement(parsingElement, reducer, _, srcId) =>
          _next(parsingElement +: OptionalRepeatParsingElement(parsingElement, reducer, 0, srcId) +: elements.tail)
        case OptionalRepeatParsingElement(parsingElement, _, _, _) =>
          _next(parsingElement +: elements) ++ _next(elements.tail)
      }
    }

    _next(stack)
  }
}
