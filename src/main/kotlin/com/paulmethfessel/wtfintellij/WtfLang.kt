package com.paulmethfessel.wtfintellij

import com.intellij.lang.Language

class WtfLang private constructor() : Language("WTF") {
  companion object {
    val instance = WtfLang()
  }
}