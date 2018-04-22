package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}
import com.waynejo.easyscalaparser.util.ParsingKeyUtil


object ParsingEngine {

    def _parse[A](parsingContext: ParsingContext, lastElementTextIndex: Int, parsingElement: ParsingElement[A]): ParsingContext = {
        val textIndex = parsingContext.parsingState.head.textIndex
        val ignoredIndex = parsingContext.parsingInjection.ignore(parsingContext.text, textIndex)
        val (nextState, nextContext) = parsingContext.onNext(ignoredIndex, parsingElement)

        val cacheKey = ParsingKeyUtil.asKey(nextState.textIndex, parsingElement.id)
        if (parsingContext.parsingFailMap.contains(cacheKey)) {
            nextContext
        } else if (parsingContext.parsingSuccessMap.contains(cacheKey)) {
            val nextResults = parsingContext.parsingSuccessMap(cacheKey)
            (nextContext /: nextResults)((acc, x) => acc.onSuccess(nextState(x._1, x._2)))
        } else {
            val parser = BaseParsingEngine.parse[A](nextContext, nextState)
              .orElse(AndParsingEngine.parse[A](nextContext, nextState, lastElementTextIndex))
              .orElse(OrParsingEngine.parse[A](nextContext, nextState))

            parser(parsingElement)
        }
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Either[String, A] = {
        val parsingElementWithEndOfString = AndParsingElement2(parsingElement, EndOfStringElement(), (x: A, _: Any) => x)
        val parsingState = ParsingState((0, parsingElementWithEndOfString) :: Nil)
        val parsingContext = ParsingContext(text, Nil, parsingInjection, ParsingFailInfo(), parsingState :: Nil)

        def _recursiveParse(context: ParsingContext): Either[String, A] = {
            context.parsingState match {
                case Nil =>
                    Left(ErrorMessageBuilder.build(text)(context.parsingFailInfo))
                case ParsingState((_, ResultParsingElement(result)) :: Nil, _, _) :: _ =>
                    Right(result.asInstanceOf[A])
                case x :: _ =>
                    val nextContext = _parse(context, x.parsingStack.head._1, x.parsingStack.head._2)
                    _recursiveParse(nextContext)
            }
        }

        _recursiveParse(parsingContext)
    }
}
