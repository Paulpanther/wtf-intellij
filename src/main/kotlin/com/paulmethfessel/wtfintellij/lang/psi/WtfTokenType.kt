package com.paulmethfessel.wtfintellij.lang.psi

import com.intellij.psi.tree.IElementType
import com.paulmethfessel.wtfintellij.lang.WtfLang

class WtfTokenType(debugName: String) : IElementType(debugName, WtfLang.instance) {
  override fun toString() = "WtfTokenType." + super.toString()
}