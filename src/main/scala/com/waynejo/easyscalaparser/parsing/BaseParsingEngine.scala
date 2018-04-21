package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser.{ParsingState, _}
import com.waynejo.easyscalaparser.element._

object BaseParsingEngine {

    def parse[A](parsingContext: ParsingContext, parsingState: ParsingState): PartialFunction[ParsingElement[A], ParsingContext] = {
        case parsingElement@EndOfStringElement() =>
            if (parsingContext.parsingInjection.ignore(parsingContext.text, parsingState.textIndex) == parsingContext.text.length) {
                parsingContext.onSuccess(parsingState(parsingState.textIndex, ResultParsingElement[Unit](Unit)))
            } else {
                parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case parsingElement@SimpleParsingElement(token) =>
            if (parsingContext.text.substring(parsingState.textIndex).startsWith(token)) {
                val nextIndex = parsingState.textIndex + token.length
                parsingContext.onSuccess(parsingState(nextIndex, ResultParsingElement(token)))
                  .onCacheResult((parsingState.textIndex, parsingElement.srcId()), nextIndex, ResultParsingElement(token))
            } else {
                parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case parsingElement@RegexParsingElement(regex) =>
            val text = parsingContext.text.substring(parsingState.textIndex)
            val matchResult = regex.findPrefixMatchOf(text)
            matchResult match {
                case Some(result) =>
                    val token = text.substring(0, result.end)
                    val nextIndex = parsingState.textIndex + token.length
                    parsingContext.onSuccess(parsingState(nextIndex, ResultParsingElement(token)))
                      .onCacheResult((parsingState.textIndex, parsingElement.srcId()), nextIndex, ResultParsingElement(token))
                case None =>
                    parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case parsingElement@CustomParsingElement(parser, _) =>
            val text = parsingContext.text.substring(parsingState.textIndex)
            val matchResult = parser(text)
            matchResult match {
                case Some(token) =>
                    val nextIndex = parsingState.textIndex + token.length
                    parsingContext.onSuccess(parsingState(nextIndex, ResultParsingElement(token)))
                      .onCacheResult((parsingState.textIndex, parsingElement.srcId()), nextIndex, ResultParsingElement(token))
                case None =>
                    parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
            }

        case parsingElement@OptionParsingElement(reference) =>
            val resultElement = ResultParsingElement(None)
            parsingContext.onSuccess(parsingState(resultElement))
              .onCacheResult((parsingState.textIndex, parsingElement.srcId()), parsingState.textIndex, resultElement)
              .onSuccess(parsingState(parsingElement)(reference).markSplitIndex())

        case parsingElement@RepeatParsingElement(pe0, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case parsingElement@TimesParsingElement(pe0, _, _, _) =>
            parsingContext.onSuccess(parsingState(parsingElement)(pe0))

        case ReferenceParsingElement(reference, _) =>
            parsingContext.onSuccess(parsingState(reference()))

        case resultElement@ResultParsingElement(value) =>
            reduceResultElement(parsingContext, parsingState, resultElement, value)
    }

    private def reduceResultElement[A](parsingContext: ParsingContext, parsingState: ParsingState, resultElement: ResultParsingElement[A], value: A) = {
        val (headIndex, headElement) = parsingState.parsingStack.head
        val remainState = parsingState.tail()
        headElement match {
            case parsingElement: RepeatParsingElement[_] =>
                val element = parsingElement.asInstanceOf[RepeatParsingElement[A]]
                parsingContext.onSuccess(remainState(resultElement).markSplitIndex())
                  .onSuccess(remainState(RepeatContinueParsingElement[A](element.parsingElement, element.reducer, 0, Integer.MAX_VALUE, value)).markSplitIndex()(element.parsingElement))

            case parsingElement: TimesParsingElement[_] =>
                val element = parsingElement.asInstanceOf[TimesParsingElement[A]]
                if (element.lower == 1 && element.upper > 0) {
                    parsingContext.onSuccess(remainState(resultElement))
                      .onSuccess(remainState(RepeatContinueParsingElement[A](element.parsingElement, element.reducer, element.lower - 1, element.upper - 1, value))(element.parsingElement).markSplitIndex())
                } else if (element.lower > 0 && element.upper > 0) {
                    parsingContext.onSuccess(remainState(RepeatContinueParsingElement[A](element.parsingElement, element.reducer, element.lower - 1, element.upper - 1, value))(element.parsingElement))
                } else {
                    parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
                }

            case parsingElement: RepeatContinueParsingElement[_] =>
                val element = parsingElement.asInstanceOf[RepeatContinueParsingElement[A]]
                val nextValue = element.reducer(element.lastElement, value)
                val nextElement = element.copy(lower = element.lower - 1, upper = element.upper - 1)
                if (0 >= nextElement.lower && 0 <= nextElement.upper) {
                    parsingContext.onSuccess(remainState(ResultParsingElement(nextValue)))
                      .onSuccess(remainState(nextElement.copy(lastElement = nextValue)).markSplitIndex()(nextElement.parsingElement))
                } else if (0 < nextElement.lower && 0 <= nextElement.upper) {
                    parsingContext.onSuccess(remainState(nextElement.copy(lastElement = nextValue))(nextElement.parsingElement))
                } else {
                    parsingContext
                }

            case _: OptionParsingElement[_] =>
                val parsingResultElement: ResultParsingElement[_] = ResultParsingElement(Some(value))
                parsingContext.onSuccess(remainState(parsingResultElement))
                  .onCacheResult((headIndex, headElement.srcId()), remainState.textIndex, parsingResultElement)

            case _: OrParsingElement[_, _] =>
                val resultState = OrParsingEngine.reduce(headElement, value)
                parsingContext.onSuccess(remainState(resultState))
                  .onCacheResult((headIndex, headElement.srcId()), remainState.textIndex, resultState)

            case _ =>
                val nextResult = AndParsingEngine.reduce(headElement, value)
                nextResult match {
                case resultParsingElement: ResultParsingElement[_] =>
                    parsingContext.onSuccess(remainState((headIndex, nextResult)))
                      .onCacheResult((headIndex, headElement.srcId()), remainState.textIndex, resultParsingElement)
                case _ =>
                    parsingContext.onSuccess(remainState((headIndex, nextResult)))
                }
        }
    }
}
