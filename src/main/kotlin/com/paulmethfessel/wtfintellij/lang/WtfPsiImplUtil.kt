package com.paulmethfessel.wtfintellij.lang

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.paulmethfessel.wtfintellij.lang.psi.WtfConstructorExpr
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumValue
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfFunctionCallName
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceMethod
import com.paulmethfessel.wtfintellij.lang.psi.WtfTypedIdentifier
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariable
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariableDeclarationStmt
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantValue
import com.paulmethfessel.wtfintellij.lang.refs.WtfFunctionReference
import com.paulmethfessel.wtfintellij.lang.refs.WtfParameterReference


object WtfPsiImplUtil {
  @JvmStatic
  fun getReferences(variable: PsiElement): Array<PsiReferenceBase<PsiElement>> {
    return when (variable) {
      is WtfVariable -> arrayOf(WtfParameterReference(variable))
      is WtfFunctionCallName -> arrayOf(WtfFunctionReference(variable))
      else -> arrayOf()
    }
  }

  @JvmStatic
  fun getNameIdentifier(element: WtfRecordDeclaration): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfResourceDeclaration): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfResourceMethod): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfEnumDeclaration): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfEnumValue): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfVariantDeclaration): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfVariantValue): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfFuncDeclaration): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfTypedIdentifier): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfConstructorExpr): PsiElement = element.identifier

  @JvmStatic
  fun getNameIdentifier(element: WtfVariableDeclarationStmt): PsiElement = element.identifier
}