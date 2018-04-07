package com.waynejo.easyscalaparser.element

case class AndParsingElement1[A, B](pe0: ParsingElement[A], reducer: (A) => B, name: String = "") extends ParsingElement[B]

case class AndParsingElement2[A, B, C](pe0: ParsingElement[A], pe1: ParsingElement[B], reducer: (A, B) => C, name: String = "") extends ParsingElement[C] {
  type typeB = B
}

case class AndParsingElement3[A, B, C, D](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], reducer: (A, B, C) => D, name: String = "") extends ParsingElement[D] {
  type typeB = B
  type typeC = C
}

case class AndParsingElement4[A, B, C, D, E](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], reducer: (A, B, C, D) => E, name: String = "") extends ParsingElement[E]

case class AndParsingElement5[A, B, C, D, E, F](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], reducer: (A, B, C, D, E) => F, name: String = "") extends ParsingElement[F]

case class AndParsingElement6[A, B, C, D, E, F, G](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], reducer: (A, B, C, D, E, F) => G, name: String = "") extends ParsingElement[G]

case class AndParsingElement7[A, B, C, D, E, F, G, H](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], reducer: (A, B, C, D, E, F, G) => H, name: String = "") extends ParsingElement[H]

case class AndParsingElement8[A, B, C, D, E, F, G, H, I](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], reducer: (A, B, C, D, E, F, G, H) => I, name: String = "") extends ParsingElement[I]

case class AndParsingElement9[A, B, C, D, E, F, G, H, I, J](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], reducer: (A, B, C, D, E, F, G, H, I) => J, name: String = "") extends ParsingElement[J]

case class AndParsingElement10[A, B, C, D, E, F, G, H, I, J, K](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], reducer: (A, B, C, D, E, F, G, H, I, J) => K, name: String = "") extends ParsingElement[K]

case class AndParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], reducer: (A, B, C, D, E, F, G, H, I, J, K) => L, name: String = "") extends ParsingElement[L]

case class AndParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], reducer: (A, B, C, D, E, F, G, H, I, J, K, L) => M, name: String = "") extends ParsingElement[M]

case class AndParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M) => N, name: String = "") extends ParsingElement[N]

case class AndParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => O, name: String = "") extends ParsingElement[O]

case class AndParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => P, name: String = "") extends ParsingElement[P]

case class AndParsingElement16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Q, name: String = "") extends ParsingElement[Q]

case class AndParsingElement17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => R, name: String = "") extends ParsingElement[R]

case class AndParsingElement18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => S, name: String = "") extends ParsingElement[S]

case class AndParsingElement19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => T, name: String = "") extends ParsingElement[T]

case class AndParsingElement20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => U, name: String = "") extends ParsingElement[U]

case class AndParsingElement21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], pe20: ParsingElement[U], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => V, name: String = "") extends ParsingElement[V]

case class AndParsingElement22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], pe20: ParsingElement[U], pe21: ParsingElement[V], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => W, name: String = "") extends ParsingElement[W]
