package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement}

case class ParsingState(parsingStack: List[ParsingElement[_]], textIndex: Int) {
  def apply[A](parsingElement: ParsingElement[A]): ParsingState = {
    ParsingState(parsingElement :: parsingStack, textIndex)
  }

  def tail[A](): ParsingState = {
    ParsingState(parsingStack.tail, textIndex)
  }
}

object ParsingState {
  def apply[A](parsingState: ParsingState, textIndex: Int, value: A): ParsingState = {
    ParsingState(ResultParsingElement(value) :: parsingState.parsingStack, textIndex)
  }
}
