package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class ResultParsingElement[A](value: A) extends ParsingElement[A] with TerminalParsingElement {
  override val id: Int = -1

  def name: String = {
    ""
  }

  def clone(idGenerator: IdGenerator): ParsingElement[A] = {
    copy()
  }
}