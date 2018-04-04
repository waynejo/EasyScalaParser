package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.ParsingElement

case class ParsingFailInfo(failReasons: Array[ParsingFailReason] = Array())

object ParsingFailInfo {
    private val parsingFailReasonNum = 10

    def apply[A](parsingContext: ParsingContext, parsingState: ParsingState, parsingElement: ParsingElement[A]): ParsingFailInfo = {
        val failReason = ParsingFailReason(parsingContext.textIndex, parsingElement.name, parsingState.parsingStack)
        val newInfo = parsingContext.parsingFailInfo.failReasons :+ failReason
        val orderedInfo = newInfo.sortBy(-_.index).take(parsingFailReasonNum)
        ParsingFailInfo(orderedInfo)
    }
}