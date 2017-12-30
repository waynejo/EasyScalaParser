package com.waynejo.parser

import com.waynejo.parser.element.{AndParsingElement2, AndParsingElement3, ParsingElement, SimpleParsingElement}

class Parser {

}

object Parser {
    def and[A, B, C](v0: ParsingElement[A], v1: ParsingElement[B])(reducer: ((A, B)) => C) : ParsingElement[C] = {
        AndParsingElement2[A, B, C](v0, v1, reducer)
    }

    def and[A, B, C, D](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C])(reducer: ((A, B, C)) => D) : ParsingElement[D] = {
        AndParsingElement3[A, B, C, D](v0, v1, v2, reducer)
    }
}
