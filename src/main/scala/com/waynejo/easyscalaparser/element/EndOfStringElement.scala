package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class EndOfStringElement(override val id: Int = 0) extends ParsingElement[Unit] with TerminalParsingElement {

  def name: String = {
    "End Of String"
  }

  def clone(idGenerator: IdGenerator): ParsingElement[Unit] = {
    copy(id = idGenerator.next())
  }
}
