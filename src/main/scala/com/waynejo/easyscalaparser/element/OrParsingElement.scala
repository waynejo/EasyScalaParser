package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class OrParsingElement[A, B](pe: ParsingElement[A], reducer: A => B, next: Option[OrParsingElement[_, B]], name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends ParsingElement[B] {

  def clone(idGenerator: IdGenerator): OrParsingElement[A, B] = {
    val id = idGenerator.nextId(this)
    copy(pe = pe.clone(idGenerator), next = next.map(_.cloneWithSrcId(idGenerator, id)), id = id, srcId = id)
  }

  def cloneWithSrcId(idGenerator: IdGenerator, srcId: Int): OrParsingElement[A, B] = {
    copy(pe = pe.clone(idGenerator), next = next.map(_.cloneWithSrcId(idGenerator, srcId)), id = -1, srcId = srcId)
  }
}
