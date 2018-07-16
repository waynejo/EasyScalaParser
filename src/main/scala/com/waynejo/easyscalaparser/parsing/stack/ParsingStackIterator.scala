package com.waynejo.easyscalaparser.parsing.stack

import com.waynejo.easyscalaparser.element._

case class ParsingStackIterator(referenceCache: Map[Int, ParsingElement[_]] = Map()) {
  def nextUp(elements: Vector[ParsingElement[_]]): (ParsingStackIterator, Map[TerminalParsingElement, Vector[Vector[ParsingElement[_]]]]) = {
    if (elements.isEmpty) {
      return (this, Map())
    }
    elements.head match {
      case terminalElement: TerminalParsingElement =>
        (this, Map(terminalElement -> Vector(elements)))
      case OrParsingElement(element, _, next, _, _, _) =>
        if (next.isDefined) {
          val (iterator0, result0) = nextUp(element +: elements.tail)
          val (iterator1, result1) = iterator0.nextUp(next.get +: elements.tail)
          (iterator1, result0 ++ result1)
        } else {
          nextUp(element +: elements.tail)
        }
      case referenceElement@ReferenceParsingElement(reference, _, _) =>
        if (referenceCache.contains(referenceElement.id)) {
          nextUp(referenceCache(referenceElement.id) +: elements.tail)
        } else {
          val referencedElement = reference()
          ParsingStackIterator(referenceCache.updated(referenceElement.id, referencedElement)).nextUp(referencedElement +: elements.tail)
        }
      case OptionParsingElement(parsingElement, _) =>
        val (iterator0, result0) = nextUp(parsingElement +: elements.tail)
        val (iterator1, result1) = iterator0.nextUp(elements.tail)
        (iterator1, result0 ++ result1)
      case RepeatParsingElement(parsingElement, reducer, _, srcId) =>
        nextUp(parsingElement +: elements)


      case AndParsingElement1(pe0, reducer, name, id, srcId) =>
        nextUp(pe0 +: elements)
      case AndParsingElement2(pe0, pe1, reducer, name, id, srcId) =>
        nextUp(pe0 +: elements)
      case AndParsingElement3(pe0, pe1, pe2, reducer, name, id, srcId) =>
        nextUp(pe0 +: elements)
    }
  }

  def nextDown(elements: Vector[ParsingElement[_]]): (ParsingStackIterator, Map[TerminalParsingElement, Vector[Vector[ParsingElement[_]]]]) = {
    if (elements.isEmpty) {
      return (this, Map())
    }
    elements.head match {
      case terminalElement: TerminalParsingElement =>
        nextDown(elements.tail)
      case RepeatParsingElement(parsingElement, reducer, _, srcId) =>
        val (iterator0, result0) = nextUp(elements)
        val (iterator1, result1) = iterator0.nextDown(elements.tail)
        (iterator1, result0 ++ result1)
      case AndParsingElement1(pe0, reducer, name, id, srcId) =>
        nextDown(elements.tail)
      case AndParsingElement2(pe0, pe1, reducer, name, id, srcId) =>
        nextUp(pe1 +: elements.tail)
      case AndParsingElement3(pe0, pe1, pe2, reducer, name, id, srcId) =>
        nextUp(pe1 +: elements.tail)
    }
  }
}
