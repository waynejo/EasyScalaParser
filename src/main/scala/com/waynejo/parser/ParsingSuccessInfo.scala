package com.waynejo.parser

case class ParsingSuccessInfo[A](nextContext: ParsingContext, result: A)
