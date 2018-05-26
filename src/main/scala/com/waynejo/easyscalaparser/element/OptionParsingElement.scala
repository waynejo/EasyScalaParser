package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class OptionParsingElement[A](parsingElement: ParsingElement[A], override val id: Int = 0) extends ParsingElement[Option[A]] {
  def name: String = {
    ""
  }

  def clone(idGenerator: IdGenerator): ParsingElement[Option[A]] = {
    copy(parsingElement = parsingElement.clone(idGenerator), id = idGenerator.next())
  }
}