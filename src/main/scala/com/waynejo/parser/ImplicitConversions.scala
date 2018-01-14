package com.waynejo.parser

import com.waynejo.parser.element.builder.OrParsingElementBuilder
import com.waynejo.parser.element.{ParsingElement, RegexParsingElement, SimpleParsingElement}

import scala.util.matching.Regex

object ImplicitConversions {
    implicit def string2SimpleParsingElement(text: String): SimpleParsingElement = {
        SimpleParsingElement(text)
    }

    implicit def regex2SimpleParsingElement(regex: Regex): RegexParsingElement = {
        RegexParsingElement(regex)
    }

    implicit def OrParsingElementBuilder2OrParsingElement[_, B](builder: OrParsingElementBuilder[_, B]): ParsingElement[B] = {
        builder.build()
    }
}
