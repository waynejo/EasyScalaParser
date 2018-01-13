package com.waynejo.parser

import com.waynejo.parser.types._
import com.waynejo.parser.element._

case class Parser(name: String) {
    def and[A, B](v0: ParsingElement[A])(reducer: ((A)) => B): ParsingElement[B] = {
        AndParsingElement1[A, B](v0, reducer, name)
    }

    def and[A, B, C](v0: ParsingElement[A], v1: ParsingElement[B])(reducer: ((A, B)) => C): ParsingElement[C] = {
        AndParsingElement2[A, B, C](v0, v1, reducer, name)
    }

    def and[A, B, C, D](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C])(reducer: ((A, B, C)) => D): ParsingElement[D] = {
        AndParsingElement3[A, B, C, D](v0, v1, v2, reducer, name)
    }

    def and[A, B, C, D, E](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D])(reducer: ((A, B, C, D)) => E): ParsingElement[E] = {
        AndParsingElement4[A, B, C, D, E](v0, v1, v2, v3, reducer, name)
    }

    def and[A, B, C, D, E, F](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E])(reducer: ((A, B, C, D, E)) => F): ParsingElement[F] = {
        AndParsingElement5[A, B, C, D, E, F](v0, v1, v2, v3, v4, reducer, name)
    }

    def and[A, B, C, D, E, F, G](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F])(reducer: ((A, B, C, D, E, F)) => G): ParsingElement[G] = {
        AndParsingElement6[A, B, C, D, E, F, G](v0, v1, v2, v3, v4, v5, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G])(reducer: ((A, B, C, D, E, F, G)) => H): ParsingElement[H] = {
        AndParsingElement7[A, B, C, D, E, F, G, H](v0, v1, v2, v3, v4, v5, v6, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H])(reducer: ((A, B, C, D, E, F, G, H)) => I): ParsingElement[I] = {
        AndParsingElement8[A, B, C, D, E, F, G, H, I](v0, v1, v2, v3, v4, v5, v6, v7, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I, J](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I])(reducer: ((A, B, C, D, E, F, G, H, I)) => J): ParsingElement[J] = {
        AndParsingElement9[A, B, C, D, E, F, G, H, I, J](v0, v1, v2, v3, v4, v5, v6, v7, v8, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J])(reducer: ((A, B, C, D, E, F, G, H, I, J)) => K): ParsingElement[K] = {
        AndParsingElement10[A, B, C, D, E, F, G, H, I, J, K](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K])(reducer: ((A, B, C, D, E, F, G, H, I, J, K)) => L): ParsingElement[L] = {
        AndParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L)) => M): ParsingElement[M] = {
        AndParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M)) => N): ParsingElement[N] = {
        AndParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M, N)) => O): ParsingElement[O] = {
        AndParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, reducer, name)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N], v14: ParsingElement[O])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)) => P): ParsingElement[P] = {
        AndParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, reducer, name)
    }

    def or[A, B](v0: ParsingElement[A])(reducer: MultipleType1[A] => B): ParsingElement[B] = {
        OrParsingElement1[A, B](v0, reducer, name)
    }

    def or[A, B, C](v0: ParsingElement[A], v1: ParsingElement[B])(reducer: MultipleType2[A, B] => C): ParsingElement[C] = {
        OrParsingElement2[A, B, C](v0, v1, reducer, name)
    }

    def or[A, B, C, D](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C])(reducer: MultipleType3[A, B, C] => D): ParsingElement[D] = {
        OrParsingElement3[A, B, C, D](v0, v1, v2, reducer, name)
    }

    def or[A, B, C, D, E](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D])(reducer: MultipleType4[A, B, C, D] => E): ParsingElement[E] = {
        OrParsingElement4[A, B, C, D, E](v0, v1, v2, v3, reducer, name)
    }

    def or[A, B, C, D, E, F](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E])(reducer: MultipleType5[A, B, C, D, E] => F): ParsingElement[F] = {
        OrParsingElement5[A, B, C, D, E, F](v0, v1, v2, v3, v4, reducer, name)
    }

    def or[A, B, C, D, E, F, G](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F])(reducer: MultipleType6[A, B, C, D, E, F] => G): ParsingElement[G] = {
        OrParsingElement6[A, B, C, D, E, F, G](v0, v1, v2, v3, v4, v5, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G])(reducer: MultipleType7[A, B, C, D, E, F, G] => H): ParsingElement[H] = {
        OrParsingElement7[A, B, C, D, E, F, G, H](v0, v1, v2, v3, v4, v5, v6, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H])(reducer: MultipleType8[A, B, C, D, E, F, G, H] => I): ParsingElement[I] = {
        OrParsingElement8[A, B, C, D, E, F, G, H, I](v0, v1, v2, v3, v4, v5, v6, v7, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I, J](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I])(reducer: MultipleType9[A, B, C, D, E, F, G, H, I] => J): ParsingElement[J] = {
        OrParsingElement9[A, B, C, D, E, F, G, H, I, J](v0, v1, v2, v3, v4, v5, v6, v7, v8, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J])(reducer: MultipleType10[A, B, C, D, E, F, G, H, I, J] => K): ParsingElement[K] = {
        OrParsingElement10[A, B, C, D, E, F, G, H, I, J, K](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K])(reducer: MultipleType11[A, B, C, D, E, F, G, H, I, J, K] => L): ParsingElement[L] = {
        OrParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L])(reducer: MultipleType12[A, B, C, D, E, F, G, H, I, J, K, L] => M): ParsingElement[M] = {
        OrParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M])(reducer: MultipleType13[A, B, C, D, E, F, G, H, I, J, K, L, M] => N): ParsingElement[N] = {
        OrParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N])(reducer: MultipleType14[A, B, C, D, E, F, G, H, I, J, K, L, M, N] => O): ParsingElement[O] = {
        OrParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, reducer, name)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N], v14: ParsingElement[O])(reducer: MultipleType15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O] => P): ParsingElement[P] = {
        OrParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, reducer, name)
    }

    def refer[A](v: () => ParsingElement[A]) : ParsingElement[A] = {
        ReferenceParsingElement[A](v, name)
    }
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

    def and[A, B, C, D, E, F, G, H, I, J, K, L](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K])(reducer: ((A, B, C, D, E, F, G, H, I, J, K)) => L): ParsingElement[L] = {
        AndParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, reducer)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L)) => M): ParsingElement[M] = {
        AndParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, reducer)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M)) => N): ParsingElement[N] = {
        AndParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, reducer)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M, N)) => O): ParsingElement[O] = {
        AndParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, reducer)
    }

    def and[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N], v14: ParsingElement[O])(reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)) => P): ParsingElement[P] = {
        AndParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, reducer)
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

    def or[A, B, C, D, E, F, G, H, I, J, K, L](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K])(reducer: MultipleType11[A, B, C, D, E, F, G, H, I, J, K] => L): ParsingElement[L] = {
        OrParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, reducer)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L])(reducer: MultipleType12[A, B, C, D, E, F, G, H, I, J, K, L] => M): ParsingElement[M] = {
        OrParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, reducer)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M])(reducer: MultipleType13[A, B, C, D, E, F, G, H, I, J, K, L, M] => N): ParsingElement[N] = {
        OrParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, reducer)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N])(reducer: MultipleType14[A, B, C, D, E, F, G, H, I, J, K, L, M, N] => O): ParsingElement[O] = {
        OrParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, reducer)
    }

    def or[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0: ParsingElement[A], v1: ParsingElement[B], v2: ParsingElement[C], v3: ParsingElement[D], v4: ParsingElement[E], v5: ParsingElement[F], v6: ParsingElement[G], v7: ParsingElement[H], v8: ParsingElement[I], v9: ParsingElement[J], v10: ParsingElement[K], v11: ParsingElement[L], v12: ParsingElement[M], v13: ParsingElement[N], v14: ParsingElement[O])(reducer: MultipleType15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O] => P): ParsingElement[P] = {
        OrParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, reducer)
    }

    def refer[A](v: () => ParsingElement[A]) : ParsingElement[A] = {
        ReferenceParsingElement[A](v)
    }

    def apply(name: String): Parser = {
        new Parser(name)
    }
}
