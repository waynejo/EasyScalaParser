package com.waynejo.easyscalaparser.parsing.stack

import com.waynejo.easyscalaparser.element.ParsingElement

object ParsingStackKey {
  def from(stack: Vector[ParsingElement[_]]): Vector[Int] = {
    stack.map(_.id)
  }
}
