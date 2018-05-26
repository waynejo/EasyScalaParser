package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class OrParsingElement[A, B](pe: ParsingElement[A], reducer: A => B, next: Option[OrParsingElement[_, B]], name: String = "", override val id: Int = 0) extends ParsingElement[B] {

  def clone(idGenerator: IdGenerator): ParsingElement[B] = {
    copy(id = idGenerator.next())
  }
}
