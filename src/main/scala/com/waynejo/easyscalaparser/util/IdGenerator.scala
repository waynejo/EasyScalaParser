package com.waynejo.easyscalaparser.util

import com.waynejo.easyscalaparser.element.ParsingElement

class IdGenerator {
  private var id = 0
  private var idCache: Map[ParsingElement[_], Int] = Map[ParsingElement[_], Int]()

  def nextId[A](element: ParsingElement[A]): Int = {
    val cachedId = idCache.get(element)
    if (cachedId.isDefined) {
      cachedId.get
    } else {
      id = id + 1
      idCache = idCache.updated(element, id)
      id
    }
  }

  def last(): Int = {
    id
  }
}
