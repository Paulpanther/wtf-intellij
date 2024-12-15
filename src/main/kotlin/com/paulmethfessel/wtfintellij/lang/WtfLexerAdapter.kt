package com.paulmethfessel.wtfintellij.lang

import com.intellij.lexer.FlexAdapter

class WtfLexerAdapter : FlexAdapter(_WtfLexer(null)) {
}