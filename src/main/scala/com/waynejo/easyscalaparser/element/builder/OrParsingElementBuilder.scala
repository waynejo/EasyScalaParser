package com.waynejo.easyscalaparser.element.builder

import com.waynejo.easyscalaparser.element.{OrParsingElement, ParsingElement}

case class OrParsingElementBuilderHead[A](name: String = "") {
    def apply[B](pe: ParsingElement[B])(reducer: B => A): OrParsingElementBuilder[A] = {
        OrParsingElementBuilder(x => OrParsingElement(pe, reducer, x, name), name)
    }
}

case class OrParsingElementBuilder[A](generator: Option[OrParsingElement[_, A]] => OrParsingElement[_, A], name: String = "") {
    def or[B, AA <: A](pe: ParsingElement[B])(reducer: B => AA): OrParsingElementBuilder[A] = {
        OrParsingElementBuilder(x => generator(Some(OrParsingElement(pe, reducer, x, name))), name)
    }

    def build(): OrParsingElement[_, A] = {
        generator(None)
    }
}

object OrParsingElementBuilder {
    def apply[A, B](pe: ParsingElement[A], reducer: A => B, next: Option[OrParsingElement[_, B]], name: String): OrParsingElementBuilder[B] = {
        OrParsingElementBuilder(x => OrParsingElement(pe, reducer, x, name), name)
    }
}