package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class DuplicatedElement[A](parsingStack: List[(Int, ParsingElement[_])]) extends ParsingElement[A] {
  def name: String = {
    ""
  }

  def clone(idGenerator: IdGenerator): ParsingElement[A] = {
    copy()
  }
}
