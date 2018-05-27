package com.waynejo.easyscalaparser.element

import com.waynejo.easyscalaparser.util.IdGenerator

trait AndParsingElement[A] extends ParsingElement[A] {
}

case class AndParsingElement1[A, B](pe0: ParsingElement[A], reducer: (A) => B, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[B] {

  def clone(idGenerator: IdGenerator): ParsingElement[B] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement2[A, B, C](pe0: ParsingElement[A], pe1: ParsingElement[B], reducer: (A, B) => C, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[C] {
  type typeB = B

  def clone(idGenerator: IdGenerator): ParsingElement[C] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement3[A, B, C, D](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], reducer: (A, B, C) => D, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[D] {
  type typeB = B
  type typeC = C

  def clone(idGenerator: IdGenerator): ParsingElement[D] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement4[A, B, C, D, E](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], reducer: (A, B, C, D) => E, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[E] {
  type typeB = B
  type typeC = C
  type typeD = D

  def clone(idGenerator: IdGenerator): ParsingElement[E] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement5[A, B, C, D, E, F](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], reducer: (A, B, C, D, E) => F, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[F] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E

  def clone(idGenerator: IdGenerator): ParsingElement[F] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement6[A, B, C, D, E, F, G](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], reducer: (A, B, C, D, E, F) => G, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[G] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F

  def clone(idGenerator: IdGenerator): ParsingElement[G] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement7[A, B, C, D, E, F, G, H](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], reducer: (A, B, C, D, E, F, G) => H, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[H] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G

  def clone(idGenerator: IdGenerator): ParsingElement[H] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement8[A, B, C, D, E, F, G, H, I](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], reducer: (A, B, C, D, E, F, G, H) => I, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[I] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H

  def clone(idGenerator: IdGenerator): ParsingElement[I] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement9[A, B, C, D, E, F, G, H, I, J](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], reducer: (A, B, C, D, E, F, G, H, I) => J, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[J] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I

  def clone(idGenerator: IdGenerator): ParsingElement[J] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement10[A, B, C, D, E, F, G, H, I, J, K](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], reducer: (A, B, C, D, E, F, G, H, I, J) => K, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[K] {
  type typeB = B
  type typeC = C
  type typeD = D
  type typeE = E
  type typeF = F
  type typeG = G
  type typeH = H
  type typeI = I
  type typeJ = J

  def clone(idGenerator: IdGenerator): ParsingElement[K] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement11[A, B, C, D, E, F, G, H, I, J, K, L](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], reducer: (A, B, C, D, E, F, G, H, I, J, K) => L, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[L] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[L] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement12[A, B, C, D, E, F, G, H, I, J, K, L, M](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], reducer: (A, B, C, D, E, F, G, H, I, J, K, L) => M, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[M] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[M] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement13[A, B, C, D, E, F, G, H, I, J, K, L, M, N](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M) => N, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[N] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[N] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => O, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[O] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[O] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => P, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[P] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[P] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Q, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[Q] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[Q] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), pe15 = pe15.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => R, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[R] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[R] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), pe15 = pe15.clone(idGenerator), pe16 = pe16.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => S, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[S] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[S] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), pe15 = pe15.clone(idGenerator), pe16 = pe16.clone(idGenerator), pe17 = pe17.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => T, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[T] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[T] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), pe15 = pe15.clone(idGenerator), pe16 = pe16.clone(idGenerator), pe17 = pe17.clone(idGenerator), pe18 = pe18.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => U, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[U] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[U] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), pe15 = pe15.clone(idGenerator), pe16 = pe16.clone(idGenerator), pe17 = pe17.clone(idGenerator), pe18 = pe18.clone(idGenerator), pe19 = pe19.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], pe20: ParsingElement[U], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => V, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[V] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[V] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), pe15 = pe15.clone(idGenerator), pe16 = pe16.clone(idGenerator), pe17 = pe17.clone(idGenerator), pe18 = pe18.clone(idGenerator), pe19 = pe19.clone(idGenerator), pe20 = pe20.clone(idGenerator), id = nextId, srcId = nextId)
  }
}

case class AndParsingElement22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W](pe0: ParsingElement[A], pe1: ParsingElement[B], pe2: ParsingElement[C], pe3: ParsingElement[D], pe4: ParsingElement[E], pe5: ParsingElement[F], pe6: ParsingElement[G], pe7: ParsingElement[H], pe8: ParsingElement[I], pe9: ParsingElement[J], pe10: ParsingElement[K], pe11: ParsingElement[L], pe12: ParsingElement[M], pe13: ParsingElement[N], pe14: ParsingElement[O], pe15: ParsingElement[P], pe16: ParsingElement[Q], pe17: ParsingElement[R], pe18: ParsingElement[S], pe19: ParsingElement[T], pe20: ParsingElement[U], pe21: ParsingElement[V], reducer: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => W, name: String = "", override val id: Int = 0, override val srcId: Int = 0) extends AndParsingElement[W] {
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

  def clone(idGenerator: IdGenerator): ParsingElement[W] = {
    val nextId = idGenerator.next()
    copy(pe0 = pe0.clone(idGenerator), pe1 = pe1.clone(idGenerator), pe2 = pe2.clone(idGenerator), pe3 = pe3.clone(idGenerator), pe4 = pe4.clone(idGenerator), pe5 = pe5.clone(idGenerator), pe6 = pe6.clone(idGenerator), pe7 = pe7.clone(idGenerator), pe8 = pe8.clone(idGenerator), pe9 = pe9.clone(idGenerator), pe10 = pe10.clone(idGenerator), pe11 = pe11.clone(idGenerator), pe12 = pe12.clone(idGenerator), pe13 = pe13.clone(idGenerator), pe14 = pe14.clone(idGenerator), pe15 = pe15.clone(idGenerator), pe16 = pe16.clone(idGenerator), pe17 = pe17.clone(idGenerator), pe18 = pe18.clone(idGenerator), pe19 = pe19.clone(idGenerator), pe20 = pe20.clone(idGenerator), pe21 = pe21.clone(idGenerator), id = nextId, srcId = nextId)
  }
}
