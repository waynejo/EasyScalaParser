package com.waynejo.parser

case class ParsingSuccessInfo[A](nextIndex: Int, result: A)
