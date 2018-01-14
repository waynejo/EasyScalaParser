package com.waynejo.parser.element.builder

import com.waynejo.parser.element.{OrParsingElement, ParsingElement}

case class OrParsingElementBuilder[A, B](generator: Option[OrParsingElement[_, B]] => OrParsingElement[_, B], name: String = "") {
    def or[C](pe: ParsingElement[C])(reducer: C => B): OrParsingElementBuilder[A, B] = {
        OrParsingElementBuilder((x) => generator(Some(OrParsingElement(pe, reducer, x, name))), name)
    }

    def build(): OrParsingElement[_, B] = {
        generator(None)
    }
}

object OrParsingElementBuilder {
    def apply[A, B](pe: ParsingElement[A], reducer: A => B, next: Option[OrParsingElement[_, B]], name: String): OrParsingElementBuilder[A, B] = {
        OrParsingElementBuilder((x) => OrParsingElement(pe, reducer, x, name), name)
    }
}