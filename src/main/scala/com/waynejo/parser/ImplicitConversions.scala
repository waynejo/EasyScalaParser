package com.waynejo.parser

import com.waynejo.parser.element.{RegexParsingElement, SimpleParsingElement}

import scala.util.matching.Regex

object ImplicitConversions {
    implicit def string2SimpleParsingElement(text: String): SimpleParsingElement = {
        SimpleParsingElement(text)
    }

    implicit def regex2SimpleParsingElement(regex: Regex): RegexParsingElement = {
        RegexParsingElement(regex)
    }
}
