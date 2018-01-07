package com.waynejo.parser

import com.waynejo.parser.element.TerminalParsingElement
import com.waynejo.parser.injection.ParsingIgnore

case class ParsingContext(text: String, textIndex: Int, terminals: List[TerminalParsingElement], parsingInjection: ParsingIgnore)