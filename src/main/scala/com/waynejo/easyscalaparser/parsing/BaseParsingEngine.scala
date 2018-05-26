package com.waynejo.easyscalaparser.parsing

import com.waynejo.easyscalaparser.element.{ParsingElement, _}
import com.waynejo.easyscalaparser.util.ParsingKeyUtil
import com.waynejo.easyscalaparser.{ParsingState, _}

object BaseParsingEngine {

  def parse[A](parsingContext: ParsingContext, parsingState: ParsingState, parsingElement: ParsingElement[A]): ParsingContext = parsingElement match {
    case parsingElement@EndOfStringElement(_) =>
      if (parsingContext.parsingInjection.ignore(parsingContext.text, parsingState.textIndex) == parsingContext.text.length) {
        parsingContext.onSuccess(parsingState(parsingState.textIndex, ResultParsingElement[Unit](Unit)))
      } else {
        parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
      }

    case parsingElement@SimpleParsingElement(token, _, _) =>
      if (parsingContext.text.substring(parsingState.textIndex).startsWith(token)) {
        val nextIndex = parsingState.textIndex + token.length
        parsingContext.onSuccess(parsingState(nextIndex, ResultParsingElement(token)))
          .onCacheResult(ParsingKeyUtil.asKey(parsingState.textIndex, parsingElement.srcId), nextIndex, ResultParsingElement(token))
      } else {
        parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
      }

    case parsingElement@RegexParsingElement(regex, _) =>
      val text = parsingContext.text.substring(parsingState.textIndex)
      val matchResult = regex.findPrefixMatchOf(text)
      matchResult match {
        case Some(result) =>
          val token = text.substring(0, result.end)
          val nextIndex = parsingState.textIndex + token.length
          parsingContext.onSuccess(parsingState(nextIndex, ResultParsingElement(token)))
            .onCacheResult(ParsingKeyUtil.asKey(parsingState.textIndex, parsingElement.srcId), nextIndex, ResultParsingElement(token))
        case None =>
          parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
      }

    case parsingElement@CustomParsingElement(parser, _, _) =>
      val matchResult = parser(parsingContext.text, parsingState.textIndex)
      matchResult match {
        case Some(nextIndex) =>
          val token = parsingContext.text.substring(parsingState.textIndex, nextIndex)
          parsingContext.onSuccess(parsingState(nextIndex, ResultParsingElement(token)))
            .onCacheResult(ParsingKeyUtil.asKey(parsingState.textIndex, parsingElement.srcId), nextIndex, ResultParsingElement(token))
        case None =>
          parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
      }
    case TextIndexParsingElement(_, _) =>
      parsingContext.onSuccess(parsingState(parsingState.textIndex, ResultParsingElement(parsingState.textIndex)))

    case parsingElement@OptionParsingElement(reference, _) =>
      val resultElement = ResultParsingElement(None)
      parsingContext.onSuccess(parsingState(resultElement))
        .onCacheResult(ParsingKeyUtil.asKey(parsingState.textIndex, parsingElement.srcId), parsingState.textIndex, resultElement)
        .onSuccess(parsingState(parsingElement)(reference).markSplitIndex())

    case parsingElement@RepeatParsingElement(pe0, _, _, _) =>
      parsingContext.onSuccess(parsingState(parsingElement)(pe0))

    case parsingElement@TimesParsingElement(pe0, _, _, _, _, _) =>
      parsingContext.onSuccess(parsingState(parsingElement)(pe0))

    case ReferenceParsingElement(reference, _, _) =>
      parsingContext.onSuccess(parsingState(reference()))

    case resultElement@ResultParsingElement(value, _) =>
      reduceResultElement(parsingContext, parsingState, resultElement, value)
  }

  private def reduceResultElement[A](parsingContext: ParsingContext, parsingState: ParsingState, resultElement: ResultParsingElement[A], value: A) = {
    val (headIndex, headElement) = parsingState.parsingStack.head
    val remainState = parsingState.tail()
    val cacheKey = ParsingKeyUtil.asKey(headIndex, headElement.srcId)
    headElement match {
      case parsingElement: RepeatParsingElement[_] =>
        val element = parsingElement.asInstanceOf[RepeatParsingElement[A]]
        parsingContext.onSuccess(remainState(resultElement).markSplitIndex())
          .onCacheResult(cacheKey, remainState.textIndex, resultElement)
          .onSuccess(remainState(RepeatContinueParsingElement[A](element.parsingElement, element.reducer, 0, Integer.MAX_VALUE, value, element.srcId)).markSplitIndex()(element.parsingElement))

      case parsingElement: TimesParsingElement[_] =>
        val element = parsingElement.asInstanceOf[TimesParsingElement[A]]
        if (element.lower == 1 && element.upper > 0) {
          parsingContext.onSuccess(remainState(resultElement))
            .onCacheResult(cacheKey, remainState.textIndex, resultElement)
            .onSuccess(remainState(RepeatContinueParsingElement[A](element.parsingElement, element.reducer, element.lower - 1, element.upper - 1, value, element.srcId))(element.parsingElement).markSplitIndex())
        } else if (element.lower > 0 && element.upper > 0) {
          parsingContext.onSuccess(remainState(RepeatContinueParsingElement[A](element.parsingElement, element.reducer, element.lower - 1, element.upper - 1, value, element.srcId))(element.parsingElement))
        } else {
          parsingContext.onFail(ParsingFailInfo(parsingContext, parsingState, parsingElement))
        }

      case parsingElement: RepeatContinueParsingElement[_] =>
        val element = parsingElement.asInstanceOf[RepeatContinueParsingElement[A]]
        val nextValue = element.reducer(element.lastElement, value)
        val nextElement = element.copy(lower = element.lower - 1, upper = element.upper - 1)
        if (0 >= nextElement.lower && 0 <= nextElement.upper) {
          parsingContext.onSuccess(remainState(ResultParsingElement(nextValue)))
            .onCacheResult(cacheKey, remainState.textIndex, resultElement)
            .onSuccess(remainState(nextElement.copy(lastElement = nextValue)).markSplitIndex()(nextElement.parsingElement))
        } else if (0 < nextElement.lower && 0 <= nextElement.upper) {
          parsingContext.onSuccess(remainState(nextElement.copy(lastElement = nextValue))(nextElement.parsingElement))
        } else {
          parsingContext
        }

      case _: OptionParsingElement[_] =>
        val parsingResultElement: ResultParsingElement[_] = ResultParsingElement(Some(value))
        parsingContext.onSuccess(remainState(parsingResultElement))
          .onCacheResult(cacheKey, remainState.textIndex, parsingResultElement)

      case _: OrParsingElement[_, _] =>
        val resultState = OrParsingEngine.reduce(headElement, value)
        parsingContext.onSuccess(remainState(resultState))
          .onCacheResult(cacheKey, remainState.textIndex, resultState)

      case _ =>
        val nextResult = AndParsingEngine.reduce(headElement, value)
        nextResult match {
          case resultParsingElement: ResultParsingElement[_] =>
            parsingContext.onSuccess(remainState((headIndex, nextResult)))
              .onCacheResult(cacheKey, remainState.textIndex, resultParsingElement)
          case _ =>
            parsingContext.onSuccess(remainState((headIndex, nextResult)))
        }
    }
  }
}
