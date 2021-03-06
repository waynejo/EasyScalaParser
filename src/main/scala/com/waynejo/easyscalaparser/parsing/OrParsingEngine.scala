package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser._
import com.waynejo.easyscalaparser.element.{OrParsingElement, _}

object OrParsingEngine {
  def reduce[A, B](reducer: ParsingElement[A], element: B): ResultParsingElement[A] = {
    reducer match {
      case OrParsingElement(_, reduce, _, _, _, _) =>
        ResultParsingElement(reduce(element))
    }
  }

  def parse[A](parsingContext: ParsingContext, parsingState: ParsingState, parsingElement: ParsingElement[A]): ParsingContext = parsingElement match {
    case parsingElement@OrParsingElement(pe0, _, next, _, _, _) =>
      next match {
        case Some(nextOrParsingElement) =>
          val nextContext = parse(parsingContext, parsingState, nextOrParsingElement)
          nextContext.onSuccess(parsingState(parsingElement).markSplitIndex()(pe0))
        case None =>
          parsingContext.onSuccess(parsingState(parsingElement)(pe0))
      }
  }
}
