package com.paulmethfessel.wtfintellij.editor

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement

class WtfDumbAnnotator : Annotator, DumbAware {
  override fun annotate(element: PsiElement, holder: AnnotationHolder) {
//    when (element) {
//      is WtfFunctionName -> holder.newTextAttribute(WtfSyntaxHighlighter.funcDeclarationAttrib)
//      is WtfRecordName -> holder.newTextAttribute(WtfSyntaxHighlighter.recordAttrib)
//      is WtfEnumName -> holder.newTextAttribute(WtfSyntaxHighlighter.enumAttrib)
//      is WtfVariantName -> holder.newTextAttribute(WtfSyntaxHighlighter.variantAttrib)
//      is WtfResourceName -> holder.newTextAttribute(WtfSyntaxHighlighter.resourceAttrib)
//    }
  }

  private fun AnnotationHolder.newTextAttribute(key: TextAttributesKey) {
    this
      .newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
      .textAttributes(key)
      .create()
  }
}