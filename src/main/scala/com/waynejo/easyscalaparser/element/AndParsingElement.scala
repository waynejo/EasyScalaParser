package com.waynejo.easyscalaparser.element

case class AndParsingElement1[A, B](pe0: ParsingElement[A], reducer: ((A)) => B, name: String = "") extends ParsingElement[B]

case class AndParsingElement2[A, B, C](pe0: ParsingElement[A], pe1: ParsingElement[B], reducer: ((A, B)) => C, name: String = "") extends ParsingElement[C]

case class AndParsingElement3[A, B, C, D](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], reducer: ((A, B, C)) => D, name: String = "") extends ParsingElement[D]

case class AndParsingElement4[A, B, C, D, E](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], reducer: ((A, B, C, D)) => E, name: String = "") extends ParsingElement[E]

case class AndParsingElement5[A, B, C, D, E, F](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], reducer: ((A, B, C, D, E)) => F, name: String = "") extends ParsingElement[F]

case class AndParsingElement6[A, B, C, D, E, F, G](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], reducer: ((A, B, C, D, E, F)) => G, name: String = "") extends ParsingElement[G]

case class AndParsingElement7[A, B, C, D, E, F, G, H](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], reducer: ((A, B, C, D, E, F, G)) => H, name: String = "") extends ParsingElement[H]

case class AndParsingElement8[A, B, C, D, E, F, G, H, I](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], reducer: ((A, B, C, D, E, F, G, H)) => I, name: String = "") extends ParsingElement[I]

case class AndParsingElement9[A, B, C, D, E, F, G, H, I, J](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], reducer: ((A, B, C, D, E, F, G, H, I)) => J, name: String = "") extends ParsingElement[J]

case class AndParsingElement10[A, B, C, D, E, F, G, H, I, J, K](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], reducer: ((A, B, C, D, E, F, G, H, I, J)) => K, name: String = "") extends ParsingElement[K]

case class AndParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], reducer: ((A, B, C, D, E, F, G, H, I, J, K)) => L, name: String = "") extends ParsingElement[L]

case class AndParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], reducer: ((A, B, C, D, E, F, G, H, I, J, K, L)) => M, name: String = "") extends ParsingElement[M]

case class AndParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M)) => N, name: String = "") extends ParsingElement[N]

case class AndParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M, N)) => O, name: String = "") extends ParsingElement[O]

case class AndParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], reducer: ((A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)) => P, name: String = "") extends ParsingElement[P]
