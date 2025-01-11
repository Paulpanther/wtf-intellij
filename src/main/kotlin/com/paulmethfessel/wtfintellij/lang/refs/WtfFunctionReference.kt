package com.paulmethfessel.wtfintellij.lang.refs

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.childrenOfType
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfFunctionCallName

class WtfFunctionReference(element: WtfFunctionCallName) : PsiReferenceBase<PsiElement>(element, element.textRange) {
  override fun resolve(): PsiElement? {
    val func = element.containingFile
      .childrenOfType<WtfFuncDeclaration>()
      .find { it.functionName.text == element.text }
    return func?.functionName
  }

  override fun getRangeInElement() = TextRange(0, myElement.textLength)
}