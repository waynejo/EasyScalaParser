package com.waynejo.parser

import com.waynejo.parser.element.SimpleParsingElement

object ImplicitConversions {
    implicit def string2SimpleParsingElement(text: String): SimpleParsingElement =
        SimpleParsingElement(text)
}
