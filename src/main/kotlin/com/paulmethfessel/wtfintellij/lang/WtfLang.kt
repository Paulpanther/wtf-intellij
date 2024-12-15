package com.paulmethfessel.wtfintellij.lang

import com.intellij.lang.Language

class WtfLang private constructor() : Language("WTF") {
  companion object {
    val instance = WtfLang()
  }
}