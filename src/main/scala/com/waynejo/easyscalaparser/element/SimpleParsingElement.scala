package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class SimpleParsingElement(token: String, override val id: Int = 0, override val srcId: Int = 0) extends ParsingElement[String] with TerminalParsingElement {
  def name: String = {
    token
  }

  def clone(idGenerator: IdGenerator): ParsingElement[String] = {
    val nextId = idGenerator.next()
    copy(id = nextId, srcId = nextId)
  }
}
