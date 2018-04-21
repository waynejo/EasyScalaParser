package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, ResultParsingElement}

case class ParsingState(parsingStack: List[(Int, ParsingElement[_])] = Nil, textIndex: Int = 0, splitIndex: Int = 0) {

  def apply[A](parsingElementPair: (Int, ParsingElement[A])): ParsingState = {
    ParsingState(parsingElementPair :: parsingStack, textIndex, splitIndex)
  }

  def apply[A](parsingElement: ParsingElement[A]): ParsingState = {
    ParsingState((textIndex, parsingElement) :: parsingStack, textIndex, splitIndex)
  }

  def apply[A](textIndex: Int, resultElement: ResultParsingElement[A]): ParsingState = {
    ParsingState((textIndex, resultElement) :: parsingStack, textIndex, splitIndex)
  }

  def tail[A](): ParsingState = {
    ParsingState(parsingStack.tail, textIndex, splitIndex)
  }

  def markSplitIndex(): ParsingState = {
    copy(splitIndex = parsingStack.size)
  }
}