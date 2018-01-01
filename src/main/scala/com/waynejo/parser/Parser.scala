package com.waynejo.parser

import com.waynejo.parser.types.MultipleType2
import com.waynejo.parser.element._

class Parser {

}

object Parser {
    def and[A, B, C](v0: ParsingElement[A], v1: ParsingElement[B])(reducer: ((A, B)) => C) : ParsingElement[C] = {
        AndParsingElement2[A, B, C](v0, v1, reducer)
    }

    def and[A, B, C, D](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C])(reducer: ((A, B, C)) => D) : ParsingElement[D] = {
        AndParsingElement3[A, B, C, D](v0, v1, v2, reducer)
    }

    def or[A, B, C](v0: ParsingElement[A], v1: ParsingElement[B])(reducer: (MultipleType2[A, B]) => C) : ParsingElement[C] = {
        OrParsingElement2[A, B, C](v0, v1, reducer)
    }

    def refer[A](v: () => ParsingElement[A]) : ParsingElement[A] = {
        ReferenceParsingElement[A](v)
    }
}
