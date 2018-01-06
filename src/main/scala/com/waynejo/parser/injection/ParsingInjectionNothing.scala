package com.waynejo.parser.injection

object ParsingInjectionNothing extends ParsingInjection {
    def inject(s: String): String = {
        s
    }
}
