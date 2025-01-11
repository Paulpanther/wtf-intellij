package com.paulmethfessel.wtfintellij.editor

import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider
import com.paulmethfessel.wtfintellij.lang.WtfLang
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceConstructor
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceMethod
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantDeclaration

class WtfBreadcrumbsProvider : BreadcrumbsProvider {
  override fun getLanguages(): Array<Language> {
    return arrayOf(WtfLang.instance)
  }

  override fun acceptElement(element: PsiElement): Boolean {
    return element is WtfRecordDeclaration
        || element is WtfResourceDeclaration
        || element is WtfFuncDeclaration
        || element is WtfVariantDeclaration
        || element is WtfEnumDeclaration
        || element is WtfResourceMethod
        || element is WtfResourceConstructor
  }

  override fun getElementInfo(element: PsiElement): String {
    return when (element) {
      is WtfResourceDeclaration -> element.resourceName.text
      is WtfRecordDeclaration -> element.recordName.text
      is WtfFuncDeclaration -> element.functionName.text
      is WtfVariantDeclaration -> element.variantName.text
      is WtfEnumDeclaration -> element.enumName.text
      is WtfResourceMethod -> element.functionName.text
      is WtfResourceConstructor -> "constructor"
      else -> throw RuntimeException("Unexpected element $element")
    }
  }
}