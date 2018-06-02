package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

import scala.util.matching.Regex

case class RegexParsingElement(token: Regex, override val id: Int = 0) extends ParsingElement[String] with TerminalParsingElement {
  def name: String = {
    token.toString()
  }

  def clone(idGenerator: IdGenerator): ParsingElement[String] = {
    copy(id = idGenerator.nextId(this))
  }
}
