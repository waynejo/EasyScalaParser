package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class ResultParsingElement[A](value: A, override val id: Int = 0) extends ParsingElement[A] with TerminalParsingElement {
  def name: String = {
    ""
  }

  def clone(idGenerator: IdGenerator): ParsingElement[A] = {
    val nextId = idGenerator.next()
    copy(id = nextId)
  }
}