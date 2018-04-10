package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement}

case class ParsingState(parsingStack: List[ParsingElement[_]] = Nil, textIndex: Int = 0, splitIndex: Int = 0) {
  def apply[A](parsingElement: ParsingElement[A]): ParsingState = {
    ParsingState(parsingElement :: parsingStack, textIndex, splitIndex)
  }

  def apply[A](textIndex: Int, value: A): ParsingState = {
    ParsingState(ResultParsingElement(value) :: parsingStack, textIndex, splitIndex)
  }

  def tail[A](): ParsingState = {
    ParsingState(parsingStack.tail, textIndex, splitIndex)
  }

  def markSplitIndex(): ParsingState = {
    copy(splitIndex = parsingStack.size - 1)
  }
}