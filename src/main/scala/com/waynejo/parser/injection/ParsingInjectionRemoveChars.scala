package com.waynejo.parser.injection

class ParsingInjectionRemoveChars(ignoreChars: String) extends ParsingInjection {
    def inject(s: String): String = {
        s.dropWhile(c => ignoreChars.exists(_ == c))
    }
}
