package com.waynejo.easyscalaparser.util

class IdGenerator {
  private var id = 0

  def next(): Int = {
    id = id + 1
    id
  }

  def last(): Int = {
    id
  }
}
