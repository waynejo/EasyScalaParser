package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}
import com.waynejo.easyscalaparser.util.{IdGenerator, ParsingKeyUtil}


object ParsingEngine {

  def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore, maxErrorTextNum: Int = 10): Either[String, A] = {
    val copiedElement = parsingElement.clone(new IdGenerator())
    val parsingElementWithEndOfString = AndParsingElement2(copiedElement, EndOfStringElement(), (x: A, _: Any) => x)
    val parsingState = ParsingState((0, parsingElementWithEndOfString) :: Nil)
    val parsingContext = ParsingContext(text, Nil, parsingInjection, ParsingFailInfo(), parsingState :: Nil)
    val injectionCache = Array.fill(text.length)(-1)
    val errorMessageBuilder = ErrorMessageBuilder(maxErrorTextNum = maxErrorTextNum)

    def _recursiveParse(context: ParsingContext): Either[String, A] = {
      context.parsingState match {
        case Nil =>
          Left(errorMessageBuilder.build(text)(context.parsingFailInfo))
        case ParsingState((_, ResultParsingElement(result)) :: Nil, _, _) :: _ =>
          Right(result.asInstanceOf[A])
        case x :: _ =>
          val nextContext = _parse(context, x.parsingStack.head._1, x.parsingStack.head._2, injectionCache)
          _recursiveParse(nextContext)
      }
    }

    _recursiveParse(parsingContext)
  }

  private def findDuplicatedParsingElement[A](parsingStack: List[(Int, ParsingElement[_])], textIndex: Int, parsingElement: ParsingElement[A]): Option[Int] = {
    if (-1 == parsingElement.id) {
      None
    } else {
      def _findDuplicatedParsingElement[A](parsingStack: List[(Int, ParsingElement[_])], textIndex: Int, parsingElement: ParsingElement[A], acc: Int = 0): Option[Int] = {
        parsingStack match {
          case (idx, element) :: xs =>
            if (idx == textIndex) {
              if (element.srcId == parsingElement.id) {
                Some(acc)
              } else {
                _findDuplicatedParsingElement(xs, textIndex, parsingElement, acc + 1)
              }
            } else {
              None
            }
          case Nil =>
            None
        }
      }
      _findDuplicatedParsingElement(parsingStack, textIndex, parsingElement)
    }
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

    val (nextState, nextContext) = parsingContext.onNext(ignoredIndex)

    val cacheKey = ParsingKeyUtil.asKey(nextState.textIndex, parsingElement.id)
    if (-1 != parsingElement.id && parsingContext.parsingFailMap.contains(cacheKey)) {
      nextContext
    } else if (-1 != parsingElement.id && parsingContext.parsingSuccessMap.contains(cacheKey)) {
      val nextResults = parsingContext.parsingSuccessMap(cacheKey)
      (nextContext /: nextResults) ((acc, x) => acc.onSuccess(nextState(x._1, x._2)))
    } else {
      val hasDuplicatedElement = findDuplicatedParsingElement(nextState.parsingStack, ignoredIndex, parsingElement)
      if (hasDuplicatedElement.isDefined) {
        val duplicatedIdx = nextState.parsingStack.size - hasDuplicatedElement.get
        val duplicatedElement = DuplicatedElement(nextState.parsingStack)
        nextContext.onDuplicatedElement(duplicatedIdx, parsingElement.id, ignoredIndex, duplicatedElement)
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
}
