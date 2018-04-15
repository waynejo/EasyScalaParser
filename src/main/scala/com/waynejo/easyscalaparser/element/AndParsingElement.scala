package com.waynejo.easyscalaparser.element

trait AndParsingElement[A] extends ParsingElement[A] {
  def srcAndElementId: Int

  override def srcId(): Int = srcAndElementId
}


case class AndParsingElement1[A, B](pe0: ParsingElement[A], reducer: (A) => B, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[B] {
}

case class AndParsingElement2[A, B, C](pe0: ParsingElement[A], pe1: ParsingElement[B], reducer: (A, B) => C, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[C] {
  type typeB = B
}

case class AndParsingElement3[A, B, C, D](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], reducer: (A, B, C) => D, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[D] {
  type typeB = B
  type typeC = C
}

case class AndParsingElement4[A, B, C, D, E](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], reducer: (A, B, C, D) => E, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[E] {
  type typeB = B
  type typeC = C
  type typeD = D
}

case class AndParsingElement5[A, B, C, D, E, F](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], reducer: (A, B, C, D, E) => F, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[F] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
}

case class AndParsingElement6[A, B, C, D, E, F, G](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], reducer: (A, B, C, D, E, F) => G, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[G] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
}

case class AndParsingElement7[A, B, C, D, E, F, G, H](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], reducer: (A, B, C, D, E, F, G) => H, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[H] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
}

case class AndParsingElement8[A, B, C, D, E, F, G, H, I](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], reducer: (A, B, C, D, E, F, G, H) => I, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[I] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
}

case class AndParsingElement9[A, B, C, D, E, F, G, H, I, J](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], reducer: (A, B, C, D, E, F, G, H, I) => J, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[J] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
}

case class AndParsingElement10[A, B, C, D, E, F, G, H, I, J, K](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], reducer: (A, B, C, D, E, F, G, H, I, J) => K, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[K] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
}

case class AndParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], reducer: (A, B, C, D, E, F, G, H, I, J, K) => L, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[L] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
}

case class AndParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], reducer: (A, B, C, D, E, F, G, H, I, J, K, L) => M, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[M] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
}

case class AndParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M) => N, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[N] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
}

case class AndParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => O, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[O] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
}

case class AndParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => P, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[P] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
}

case class AndParsingElement16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Q, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[Q] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
  type typeP = P
}

case class AndParsingElement17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => R, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[R] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
  type typeP = P
  type typeQ = Q
}

case class AndParsingElement18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => S, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[S] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
  type typeP = P
  type typeQ = Q
  type typeR = R
}

case class AndParsingElement19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => T, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[T] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
  type typeP = P
  type typeQ = Q
  type typeR = R
  type typeS = S
}

case class AndParsingElement20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => U, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[U] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
  type typeP = P
  type typeQ = Q
  type typeR = R
  type typeS = S
  type typeT = T
}

case class AndParsingElement21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], pe20: ParsingElement[U], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => V, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[V] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
  type typeP = P
  type typeQ = Q
  type typeR = R
  type typeS = S
  type typeT = T
  type typeU = U
}

case class AndParsingElement22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], pe20: ParsingElement[U], pe21: ParsingElement[V], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => W, name: String = "", srcAndElementId: Int = ParsingElement.nextId.incrementAndGet()) extends AndParsingElement[W] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J
  type typeK = K
  type typeL = L
  type typeM = M
  type typeN = N
  type typeO = O
  type typeP = P
  type typeQ = Q
  type typeR = R
  type typeS = S
  type typeT = T
  type typeU = U
  type typeV = V
}
