package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element._
import com.waynejo.easyscalaparser.injection.ParsingIgnore
import com.waynejo.easyscalaparser.parsing.{AndParsingEngine, BaseParsingEngine, OrParsingEngine}


object ParsingEngine {

    def _parse[A](parsingContext: ParsingContext, parsingElement: ParsingElement[A]): ParsingContext = {
        val ignoredIndex = parsingContext.parsingInjection.ignore(parsingContext.text, parsingContext.textIndex)
        val (nextState, nextContext) = parsingContext.onNext(ignoredIndex, parsingElement)
        val parsingState = parsingContext.parsingState.head
//
        val parser = BaseParsingEngine.parse[A](nextContext, nextState)
//            .orElse(AndParsingEngine.parse[A](nextContext))
//            .orElse(OrParsingEngine.parse[A](nextContext))
//
        parser(parsingElement)
    }

    def parse[A](parsingElement: ParsingElement[A], text: String, parsingInjection: ParsingIgnore): Either[String, A] = {
        val parsingState = ParsingState(parsingElement :: Nil, 0)
        val parsingContext = ParsingContext(text, Nil, parsingInjection, ParsingFailInfo(), parsingState :: Nil)

        def _recursiveParse(context: ParsingContext): Either[String, A] = {
            context.parsingState match {
                case ParsingState(ResultParsingElement(result) :: Nil, _) :: Nil if context.parsingInjection.ignore(text, context.textIndex) == text.length =>
                    Right(result.asInstanceOf[A])
                case ParsingState(ResultParsingElement(_) :: Nil, _) :: Nil =>
                    Left(ErrorMessageBuilder.build(text)(context.parsingFailInfo))
                case x :: xs =>
                    val nextContext = _parse(context, x.parsingStack.head)
                    _recursiveParse(nextContext)
                case Nil =>
                    Left(ErrorMessageBuilder.build(text)(context.parsingFailInfo))
            }
        }

        _recursiveParse(parsingContext)
    }
}
