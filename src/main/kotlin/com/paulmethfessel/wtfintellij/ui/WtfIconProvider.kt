package com.paulmethfessel.wtfintellij.ui

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumName
import com.paulmethfessel.wtfintellij.lang.psi.WtfFunctionName
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordName
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceName
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantName
import javax.swing.Icon

class WtfIconProvider : IconProvider() {
  override fun getIcon(element: PsiElement, flags: Int): Icon? {
    return when (element.parent) {
      is WtfRecordName -> MyIcons.lang
      is WtfFunctionName -> MyIcons.lang
      is WtfEnumName -> MyIcons.lang
      is WtfResourceName -> MyIcons.lang
      is WtfVariantName -> MyIcons.lang
      else -> null
    }
  }
}