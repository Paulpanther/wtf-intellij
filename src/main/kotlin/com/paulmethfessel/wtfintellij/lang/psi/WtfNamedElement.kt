package com.paulmethfessel.wtfintellij.lang.psi

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface WtfNamedElement : PsiNameIdentifierOwner {
  fun getPresentation(): ItemPresentation
  override fun getName(): String
  override fun setName(newName: String): PsiElement?
}
