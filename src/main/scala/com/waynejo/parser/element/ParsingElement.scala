package com.waynejo.parser.element

import com.waynejo.parser.ParsingEngine
import com.waynejo.parser.injection.{ParsingInjection, ParsingInjectionNothing}

trait ParsingElement[A] {
    def name: String

    def parse(text: String, parsingInjection: ParsingInjection = ParsingInjectionNothing): Option[A] = {
        ParsingEngine.parse(this, text, parsingInjection)
    }

    def option: ParsingElement[Option[A]] = {
        OptionParsingElement[A](this)
    }

    def repeat(reducer: (A, A) => A): ParsingElement[A] = {
        RepeatParsingElement[A](this, reducer)
    }
}
