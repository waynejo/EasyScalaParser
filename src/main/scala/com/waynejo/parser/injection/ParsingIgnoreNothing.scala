package com.waynejo.parser.injection

object ParsingIgnoreNothing extends ParsingIgnore {
    def ignore(s: String, index: Int): Int = {
        index
    }
}
