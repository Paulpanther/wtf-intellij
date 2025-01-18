package com.paulmethfessel.wtfintellij.ui

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantDeclaration
import javax.swing.Icon

class WtfIconProvider : IconProvider() {
  override fun getIcon(element: PsiElement, flags: Int): Icon? {
    return when (element.parent) {
      is WtfRecordDeclaration -> MyIcons.lang
      is WtfFuncDeclaration -> MyIcons.lang
      is WtfEnumDeclaration -> MyIcons.lang
      is WtfResourceDeclaration -> MyIcons.lang
      is WtfVariantDeclaration -> MyIcons.lang
      else -> null
    }
  }
}