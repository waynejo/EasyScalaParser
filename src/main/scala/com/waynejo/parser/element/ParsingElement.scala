package com.waynejo.parser.element

import com.waynejo.parser.ParsingEngine

trait ParsingElement[A] {
    def debugString: String

    def parse(text: String): Option[A] = {
        ParsingEngine.parse(this, text)
    }

    def option: ParsingElement[Option[A]] = {
        OptionParsingElement[A](this)
    }

    def repeat(reducer: (A, A) => A): ParsingElement[A] = {
        RepeatParsingElement[A](this, reducer)
    }
}
