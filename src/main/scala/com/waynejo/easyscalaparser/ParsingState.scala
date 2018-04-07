package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement}

case class ParsingState(parsingStack: List[ParsingElement[_]], textIndex: Int) {
  def apply[A](parsingElement: ParsingElement[A]): ParsingState = {
    ParsingState(parsingElement :: parsingStack, textIndex)
  }

  def apply[A](textIndex: Int, value: A): ParsingState = {
    ParsingState(ResultParsingElement(value) :: parsingStack, textIndex)
  }

  def tail[A](): ParsingState = {
    ParsingState(parsingStack.tail, textIndex)
  }
}