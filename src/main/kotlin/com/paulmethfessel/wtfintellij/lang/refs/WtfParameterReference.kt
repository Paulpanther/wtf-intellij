package com.paulmethfessel.wtfintellij.lang.refs

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.parentOfType
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariable

class WtfParameterReference(variable: WtfVariable) : PsiReferenceBase<PsiElement>(variable, variable.textRange) {
  override fun resolve(): PsiElement? {
    val func = element.parentOfType<WtfFuncDeclaration>() ?: return null
    return func
      .funcArgumentList
      .find { it.typedIdentifier.namedIdentifier.text == element.text }
      ?.typedIdentifier?.namedIdentifier
  }

  override fun getRangeInElement() = TextRange(0, myElement.textLength)
}