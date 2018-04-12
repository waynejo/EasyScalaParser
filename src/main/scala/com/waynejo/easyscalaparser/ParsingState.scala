package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement}

case class ParsingState(parsingStack: List[ParsingElement[_]] = Nil, parsingHistory: List[(Int, Int)] = Nil, textIndex: Int = 0, splitIndex: Int = 0) {
  def apply[A](parsingElement: ParsingElement[A]): ParsingState = {
    ParsingState(parsingElement :: parsingStack, parsingHistory, textIndex, splitIndex)
  }

  def apply[A](textIndex: Int, value: A): ParsingState = {
    ParsingState(ResultParsingElement(value) :: parsingStack, parsingHistory, textIndex, splitIndex)
  }

  def tail[A](): ParsingState = {
    ParsingState(parsingStack.tail, parsingHistory, textIndex, splitIndex)
  }

  def markSplitIndex(): ParsingState = {
    copy(splitIndex = parsingHistory.size)
  }
}