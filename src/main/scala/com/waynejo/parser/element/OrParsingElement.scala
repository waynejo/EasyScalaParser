package com.waynejo.parser.element

import com.waynejo.parser.types._

case class OrParsingElement1[A, B](pe0: ParsingElement[A], reducer: MultipleType1[A] => B, name: String = "") extends ParsingElement[B]
case class OrParsingElement2[A, B, C](pe0: ParsingElement[A], pe1: ParsingElement[B], reducer: MultipleType2[A, B] => C, name: String = "") extends ParsingElement[C]
case class OrParsingElement3[A, B, C, D](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], reducer: MultipleType3[A, B, C] => D, name: String = "") extends ParsingElement[D]
case class OrParsingElement4[A, B, C, D, E](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], reducer: MultipleType4[A, B, C, D] => E, name: String = "") extends ParsingElement[E]
case class OrParsingElement5[A, B, C, D, E, F](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], reducer: MultipleType5[A, B, C, D, E] => F, name: String = "") extends ParsingElement[F]
case class OrParsingElement6[A, B, C, D, E, F, G](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], reducer: MultipleType6[A, B, C, D, E, F] => G, name: String = "") extends ParsingElement[G]
case class OrParsingElement7[A, B, C, D, E, F, G, H](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], reducer: MultipleType7[A, B, C, D, E, F, G] => H, name: String = "") extends ParsingElement[H]
case class OrParsingElement8[A, B, C, D, E, F, G, H, I](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], reducer: MultipleType8[A, B, C, D, E, F, G, H] => I, name: String = "") extends ParsingElement[I]
case class OrParsingElement9[A, B, C, D, E, F, G, H, I, J](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], reducer: MultipleType9[A, B, C, D, E, F, G, H, I] => J, name: String = "") extends ParsingElement[J]
case class OrParsingElement10[A, B, C, D, E, F, G, H, I, J, K](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], reducer: MultipleType10[A, B, C, D, E, F, G, H, I, J] => K, name: String = "") extends ParsingElement[K]
