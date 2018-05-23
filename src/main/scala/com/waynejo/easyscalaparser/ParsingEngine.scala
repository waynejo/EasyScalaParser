package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}
import com.waynejo.easyscalaparser.util.ParsingKeyUtil


object ParsingEngine {

  def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Either[String, A] = {
    val parsingElementWithEndOfString = AndParsingElement2(parsingElement, EndOfStringElement(), (x: A, _: Any) => x)
    val parsingState = ParsingState((0, parsingElementWithEndOfString) :: Nil)
    val parsingContext = ParsingContext(text, Nil, parsingInjection, ParsingFailInfo(), parsingState :: Nil)
    val injectionCache = Array.fill(text.length)(-1)

    def _recursiveParse(context: ParsingContext): Either[String, A] = {
      context.parsingState match {
        case Nil =>
          Left(ErrorMessageBuilder.build(text)(context.parsingFailInfo))
        case ParsingState((_, ResultParsingElement(result)) :: Nil, _, _) :: _ =>
          Right(result.asInstanceOf[A])
        case x :: _ =>
          val nextContext = _parse(context, x.parsingStack.head._1, x.parsingStack.head._2, injectionCache)
          _recursiveParse(nextContext)
      }
    }

    _recursiveParse(parsingContext)
  }

  def _parse[A](parsingContext: ParsingContext, lastElementTextIndex: Int, parsingElement: ParsingElement[A], injectionCache: Array[Int]): ParsingContext = {
    val textIndex = parsingContext.parsingState.head.textIndex
    val ignoredIndex = if (textIndex >= injectionCache.length || -1 == injectionCache(textIndex)) {
      val nextIndex = parsingContext.parsingInjection.ignore(parsingContext.text, textIndex)
      if (textIndex < injectionCache.length) {
        injectionCache(textIndex) = nextIndex
      }
      nextIndex
    } else {
      injectionCache(textIndex)
    }

    val (nextState, nextContext) = parsingContext.onNext(ignoredIndex, parsingElement)

    val cacheKey = ParsingKeyUtil.asKey(nextState.textIndex, parsingElement.id)
    if (parsingContext.parsingFailMap.contains(cacheKey)) {
      nextContext
    } else if (parsingContext.parsingSuccessMap.contains(cacheKey)) {
      val nextResults = parsingContext.parsingSuccessMap(cacheKey)
      (nextContext /: nextResults) ((acc, x) => acc.onSuccess(nextState(x._1, x._2)))
    } else {
      parsingElement match {
        case _: OrParsingElement[_, A] =>
          OrParsingEngine.parse[A](nextContext, nextState, parsingElement)
        case _: AndParsingElement[A] =>
          AndParsingEngine.parse[A](nextContext, nextState, lastElementTextIndex, parsingElement)
        case _ =>
          BaseParsingEngine.parse[A](nextContext, nextState, parsingElement)
      }
    }
  }
}
