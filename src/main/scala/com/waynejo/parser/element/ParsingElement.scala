package com.waynejo.parser.element

import com.waynejo.parser.ParsingEngine
import com.waynejo.parser.injection.{ParsingIgnore, ParsingIgnoreNothing}

trait ParsingElement[A] {
    def name: String

    def parse(text: String, parsingInjection: ParsingIgnore = ParsingIgnoreNothing): Either[String, A] = {
        ParsingEngine.parse(this, text, parsingInjection)
    }

    def option: ParsingElement[Option[A]] = {
        OptionParsingElement[A](this)
    }

    def repeat(implicit evidence: cats.Semigroup[A]): ParsingElement[A] = {
        RepeatParsingElement[A](this, evidence.combine)
    }

    def times(n: Int)(implicit evidence: cats.Semigroup[A]): ParsingElement[A] = {
        TimesParsingElement[A](this, n, evidence.combine)
    }
}
