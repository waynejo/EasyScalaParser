package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class TextIndexParsingElement(override val id: Int = 0, override val srcId: Int = 0) extends ParsingElement[Int] with TerminalParsingElement {
  override def name: String = ""
  
  def clone(idGenerator: IdGenerator): ParsingElement[Int] = {
    val nextId = idGenerator.next()
    copy(id = nextId, srcId = nextId)
  }
}
