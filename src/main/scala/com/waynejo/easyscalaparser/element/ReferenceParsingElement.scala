package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class ReferenceParsingElement[A](reference: () => ParsingElement[A], name: String = "", override val id: Int = 0) extends ParsingElement[A] {

  def clone(idGenerator: IdGenerator): ParsingElement[A] = {
    copy(reference = () => reference().clone(idGenerator), id = idGenerator.next())
  }
}
