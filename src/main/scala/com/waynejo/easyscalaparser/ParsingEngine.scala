package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}


object ParsingEngine {

    def _parse[A](parsingContext: ParsingContext, parsingElement: ParsingElement[A]): ParsingContext = {
        val textIndex = parsingContext.parsingState.head.textIndex
        val ignoredIndex = parsingContext.parsingInjection.ignore(parsingContext.text, textIndex)
        val (nextState, nextContext) = parsingContext.onNext(ignoredIndex, parsingElement)

        if (parsingContext.parsingFailMap.contains((nextState.textIndex, parsingElement))) {
            nextContext
        } else {
            val parser = BaseParsingEngine.parse[A](nextContext, nextState)
              .orElse(AndParsingEngine.parse[A](nextContext, nextState))
              .orElse(OrParsingEngine.parse[A](nextContext, nextState))

            parser(parsingElement)
        }
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Either[String, A] = {
        val parsingElementWithEndOfString = AndParsingElement2(parsingElement, EndOfStringElement(), (x: A, _: Any) => x)
        val parsingState = ParsingState(parsingElementWithEndOfString :: Nil, 0)
        val parsingContext = ParsingContext(text, Nil, parsingInjection, ParsingFailInfo(), parsingState :: Nil)

        def _recursiveParse(context: ParsingContext): Either[String, A] = {
            context.parsingState match {
                case Nil =>
                    Left(ErrorMessageBuilder.build(text)(context.parsingFailInfo))
                case ParsingState(ResultParsingElement(result) :: Nil, _) :: _ =>
                    Right(result.asInstanceOf[A])
                case x :: xs =>
                    val nextContext = _parse(context, x.parsingStack.head)
                    _recursiveParse(nextContext)
            }
        }

        _recursiveParse(parsingContext)
    }
}
