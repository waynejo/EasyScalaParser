package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class RepeatParsingElement[A](parsingElement: ParsingElement[A], reducer: (A, A) => A, override val id: Int = 0, override val srcId: Int = 0) extends ParsingElement[A] {
  def name: String = {
    ""
  }

  def clone(idGenerator: IdGenerator): ParsingElement[A] = {
    val nextId = idGenerator.next()
    copy(parsingElement = parsingElement.clone(idGenerator), id = nextId, srcId = nextId)
  }
}