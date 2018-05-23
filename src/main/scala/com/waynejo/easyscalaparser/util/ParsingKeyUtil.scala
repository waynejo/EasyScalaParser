package com.waynejo.easyscalaparser.util

object ParsingKeyUtil {
  def asKey(index: Int, id: Int): Long = {
    (index.toLong << 32) | id.toLong
  }
}
