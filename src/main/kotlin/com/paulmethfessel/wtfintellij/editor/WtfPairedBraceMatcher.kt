package com.paulmethfessel.wtfintellij.editor

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.paulmethfessel.wtfintellij.lang.psi.WtfTypes

class WtfPairedBraceMatcher : PairedBraceMatcher {
  override fun getPairs(): Array<BracePair> {
    return arrayOf(
      BracePair(WtfTypes.LEFT_BRACE, WtfTypes.RIGHT_BRACE, true),
      BracePair(WtfTypes.STRING_LEFT_PAREN, WtfTypes.STRING_RIGHT_PAREN, true),

      BracePair(WtfTypes.LEFT_PAREN, WtfTypes.RIGHT_PAREN, false),
    )
  }

  override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
    return true
  }

  override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
    // TODO implement
    return openingBraceOffset
  }
}