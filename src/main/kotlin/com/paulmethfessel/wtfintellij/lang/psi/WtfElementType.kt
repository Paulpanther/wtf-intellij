package com.paulmethfessel.wtfintellij.lang.psi

import com.intellij.psi.tree.IElementType
import com.paulmethfessel.wtfintellij.lang.WtfLang

class WtfElementType(debugName: String) : IElementType(debugName, WtfLang.instance)