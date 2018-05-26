package com.waynejo.easyscalaparser.element

import java.util.concurrent.atomic.AtomicInteger

import com.waynejo.easyscalaparser.ParsingEngine
import com.waynejo.easyscalaparser.injection.{ParsingIgnore, ParsingIgnoreNothing}
import com.waynejo.easyscalaparser.util.IdGenerator

abstract class ParsingElement[A] {

  val id: Int = ParsingElement.nextId.incrementAndGet()
  def srcId: Int = id

  def name: String

  def parse(text: String, parsingInjection: ParsingIgnore = ParsingIgnoreNothing): Either[String, A] = {
    ParsingEngine.parse(this, text, parsingInjection)
  }

  def option: ParsingElement[Option[A]] = {
    OptionParsingElement[A](this)
  }

  def repeat(implicit evidence: cats.Semigroup[A]): ParsingElement[A] = {
    RepeatParsingElement[A](this, evidence.combine)
  }

  def times(n: Int)(implicit evidence: cats.Semigroup[A]): ParsingElement[A] = {
    TimesParsingElement[A](this, n, n, evidence.combine)
  }

  def times(lower: Int, upper: Int)(implicit evidence: cats.Semigroup[A]): ParsingElement[A] = {
    TimesParsingElement[A](this, lower, upper, evidence.combine)
  }

  def clone(idGenerator: IdGenerator): ParsingElement[A]
}

object ParsingElement {
  val nextId = new AtomicInteger(0)
}
