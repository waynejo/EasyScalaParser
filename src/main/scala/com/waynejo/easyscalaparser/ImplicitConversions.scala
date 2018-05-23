package com.waynejo.easyscalaparser

import com.waynejo.easyscalaparser.element.builder.OrParsingElementBuilder
import com.waynejo.easyscalaparser.element.{ParsingElement, RegexParsingElement, SimpleParsingElement}

import scala.util.matching.Regex

object ImplicitConversions {
  implicit def string2SimpleParsingElement(text: String): SimpleParsingElement = {
    SimpleParsingElement(text)
  }

  implicit def regex2SimpleParsingElement(regex: Regex): RegexParsingElement = {
    RegexParsingElement(regex)
  }

  implicit def OrParsingElementBuilder2OrParsingElement[A](builder: OrParsingElementBuilder[A]): ParsingElement[A] = {
    builder.build()
  }
}
