package com.waynejo.easyscalaparser.injection

object ParsingIgnoreNothing extends ParsingIgnore {
    def ignore(s: String, index: Int): Int = {
        index
    }
}
