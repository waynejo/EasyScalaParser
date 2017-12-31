package com.waynejo.parser

case class ParsingSuccessInfo[A](remain: String, result: A)
