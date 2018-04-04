package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement}

case class ParsingState(parsingStack: List[ParsingElement[_]], textIndex: Int) {

}

object ParsingState {
  def apply[A](parsingState: ParsingState, textIndex: Int, value: A): ParsingState = {
    ParsingState(ResultParsingElement(value) :: parsingState.parsingStack, textIndex)
  }

  def apply[A](parsingState: ParsingState, parsingElement: ParsingElement[A]): ParsingState = {
    ParsingState(parsingElement :: parsingState.parsingStack.tail.tail, parsingState.textIndex)
  }
}
