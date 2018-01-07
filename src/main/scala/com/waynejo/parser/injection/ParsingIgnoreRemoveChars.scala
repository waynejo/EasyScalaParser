package com.waynejo.parser.injection

import scala.annotation.tailrec

class ParsingIgnoreRemoveChars(ignoreChars: String) extends ParsingIgnore {

    @tailrec
    final def ignore(s: String, index: Int): Int = {
        if (index < s.length && ignoreChars.contains(s.charAt(index))) {
            ignore(s, index + 1)
        } else {
            index
        }
    }
}
