package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.{ParsingElement, SimpleParsingElement}

case class ParsingFailInfo(failReasons: Array[ParsingFailReason] = Array(), lastFailParsingState: ParsingState = ParsingState(), lastParsingElement: ParsingElement[_] = SimpleParsingElement(""))

object ParsingFailInfo {
    private val parsingFailReasonNum = 100

    def apply[A](parsingContext: ParsingContext, parsingState: ParsingState, parsingElement: ParsingElement[A]): ParsingFailInfo = {
        val failReason = ParsingFailReason(parsingState.textIndex, parsingElement.name, parsingState.parsingStack)
        val newInfo = parsingContext.parsingFailInfo.failReasons :+ failReason
        val orderedInfo = newInfo.sortBy(-_.index).take(parsingFailReasonNum)
        ParsingFailInfo(orderedInfo, parsingState, parsingElement)
    }
}