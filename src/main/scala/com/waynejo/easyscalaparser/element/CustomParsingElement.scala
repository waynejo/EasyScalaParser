package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

case class CustomParsingElement(parser: (String, Int) => Option[Int], name: String, override val id: Int) extends ParsingElement[String] with TerminalParsingElement {

  def clone(idGenerator: IdGenerator): ParsingElement[String] = {
    copy(id = idGenerator.nextId(this))
  }
}

object CustomParsingElement {
  def apply(parser: String => Option[String], name: String = ""): CustomParsingElement = {
    new CustomParsingElement((text: String, idx: Int) => {
      parser(text.substring(idx)).map(x => idx + x.length)
    }, name, 0)
  }

  def apply(parser: (String, Int) => Option[Int]): CustomParsingElement = {
    new CustomParsingElement(parser, "", 0)
  }
}