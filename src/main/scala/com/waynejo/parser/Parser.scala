package com.waynejo.parser

import com.waynejo.parser.types._
import com.waynejo.parser.element._

class Parser {

}

object Parser {
    def and[A, B](v0: ParsingElement[A])(reducer: ((A)) => B): ParsingElement[B] = {
        AndParsingElement1[A, B](v0, reducer)
    }

    def and[A, B, C](v0: ParsingElement[A], v1: ParsingElement[B])(reducer: ((A, B)) => C): ParsingElement[C] = {
        AndParsingElement2[A, B, C](v0, v1, reducer)
    }

    def and[A, B, C, D](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C])(reducer: ((A, B, C)) => D): ParsingElement[D] = {
        AndParsingElement3[A, B, C, D](v0, v1, v2, reducer)
    }

    def and[A, B, C, D, E](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D])(reducer: ((A, B, C, D)) => E): ParsingElement[E] = {
        AndParsingElement4[A, B, C, D, E](v0, v1, v2, v3, reducer)
    }

    def and[A, B, C, D, E, F](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E])(reducer: ((A, B, C, D, E)) => F): ParsingElement[F] = {
        AndParsingElement5[A, B, C, D, E, F](v0, v1, v2, v3, v4, reducer)
    }

    def and[A, B, C, D, E, F, G](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F])(reducer: ((A, B, C, D, E, F)) => G): ParsingElement[G] = {
        AndParsingElement6[A, B, C, D, E, F, G](v0, v1, v2, v3, v4, v5, reducer)
    }

    def and[A, B, C, D, E, F, G, H](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G])(reducer: ((A, B, C, D, E, F, G)) => H): ParsingElement[H] = {
        AndParsingElement7[A, B, C, D, E, F, G, H](v0, v1, v2, v3, v4, v5, v6, reducer)
    }

    def and[A, B, C, D, E, F, G, H, I](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H])(reducer: ((A, B, C, D, E, F, G, H)) => I): ParsingElement[I] = {
        AndParsingElement8[A, B, C, D, E, F, G, H, I](v0, v1, v2, v3, v4, v5, v6, v7, reducer)
    }

    def and[A, B, C, D, E, F, G, H, I, J](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I])(reducer: ((A, B, C, D, E, F, G, H, I)) => J): ParsingElement[J] = {
        AndParsingElement9[A, B, C, D, E, F, G, H, I, J](v0, v1, v2, v3, v4, v5, v6, v7, v8, reducer)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J])(reducer: ((A, B, C, D, E, F, G, H, I, J)) => K): ParsingElement[K] = {
        AndParsingElement10[A, B, C, D, E, F, G, H, I, J, K](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, reducer)
    }

    def or[A, B](v0: ParsingElement[A])(reducer: MultipleType1[A] => B): ParsingElement[B] = {
        OrParsingElement1[A, B](v0, reducer)
    }

    def or[A, B, C](v0: ParsingElement[A], v1: ParsingElement[B])(reducer: MultipleType2[A, B] => C): ParsingElement[C] = {
        OrParsingElement2[A, B, C](v0, v1, reducer)
    }

    def or[A, B, C, D](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C])(reducer: MultipleType3[A, B, C] => D): ParsingElement[D] = {
        OrParsingElement3[A, B, C, D](v0, v1, v2, reducer)
    }

    def or[A, B, C, D, E](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D])(reducer: MultipleType4[A, B, C, D] => E): ParsingElement[E] = {
        OrParsingElement4[A, B, C, D, E](v0, v1, v2, v3, reducer)
    }

    def or[A, B, C, D, E, F](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E])(reducer: MultipleType5[A, B, C, D, E] => F): ParsingElement[F] = {
        OrParsingElement5[A, B, C, D, E, F](v0, v1, v2, v3, v4, reducer)
    }

    def or[A, B, C, D, E, F, G](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F])(reducer: MultipleType6[A, B, C, D, E, F] => G): ParsingElement[G] = {
        OrParsingElement6[A, B, C, D, E, F, G](v0, v1, v2, v3, v4, v5, reducer)
    }

    def or[A, B, C, D, E, F, G, H](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G])(reducer: MultipleType7[A, B, C, D, E, F, G] => H): ParsingElement[H] = {
        OrParsingElement7[A, B, C, D, E, F, G, H](v0, v1, v2, v3, v4, v5, v6, reducer)
    }

    def or[A, B, C, D, E, F, G, H, I](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H])(reducer: MultipleType8[A, B, C, D, E, F, G, H] => I): ParsingElement[I] = {
        OrParsingElement8[A, B, C, D, E, F, G, H, I](v0, v1, v2, v3, v4, v5, v6, v7, reducer)
    }

    def or[A, B, C, D, E, F, G, H, I, J](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I])(reducer: MultipleType9[A, B, C, D, E, F, G, H, I] => J): ParsingElement[J] = {
        OrParsingElement9[A, B, C, D, E, F, G, H, I, J](v0, v1, v2, v3, v4, v5, v6, v7, v8, reducer)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J])(reducer: MultipleType10[A, B, C, D, E, F, G, H, I, J] => K): ParsingElement[K] = {
        OrParsingElement10[A, B, C, D, E, F, G, H, I, J, K](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, reducer)
    }

    def refer[A](v: () => ParsingElement[A]) : ParsingElement[A] = {
        ReferenceParsingElement[A](v)
    }
}
