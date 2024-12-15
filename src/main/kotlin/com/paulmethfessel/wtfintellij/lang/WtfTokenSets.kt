package com.paulmethfessel.wtfintellij.lang

import com.intellij.psi.tree.TokenSet
import com.paulmethfessel.wtfintellij.lang.psi.WtfTypes

object WtfTokenSets {
  val identifiers = TokenSet.create(WtfTypes.IDENTIFIER)
  val comments = TokenSet.create(WtfTypes.COMMENT)
}