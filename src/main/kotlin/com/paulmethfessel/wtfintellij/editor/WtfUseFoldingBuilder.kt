package com.paulmethfessel.wtfintellij.editor

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.childrenOfType
import com.intellij.psi.util.elementType
import com.paulmethfessel.wtfintellij.lang.psi.WtfTypes
import com.paulmethfessel.wtfintellij.lang.psi.WtfUseDeclaration

class WtfUseFoldingBuilder : FoldingBuilderEx() {
  override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
    val useDeclarations = root.childrenOfType<WtfUseDeclaration>()
    val descriptors = mutableListOf<FoldingDescriptor>()
    val currentDeclarations = mutableSetOf<WtfUseDeclaration>()

    for (useDeclaration in useDeclarations) {
      if (currentDeclarations.isEmpty() || nextSiblingEqualsUseDeclaration(
          currentDeclarations.last(),
          useDeclaration
        )
      ) {
        currentDeclarations += useDeclaration
      } else {
        descriptors += toDescriptor(currentDeclarations)
        currentDeclarations.clear()
        currentDeclarations += useDeclaration
      }
    }
    if (currentDeclarations.isNotEmpty()) {
      descriptors += toDescriptor(currentDeclarations)
    }

    return descriptors.toTypedArray()
  }

  private fun toDescriptor(declarations: MutableSet<WtfUseDeclaration>): FoldingDescriptor {
    return FoldingDescriptor(
      declarations.first().node,
      // +4 to exclude first "use" word
      TextRange(declarations.first().textRange.startOffset + 4, declarations.last().textRange.endOffset),
    )
  }

  private fun nextSiblingEqualsUseDeclaration(prev: WtfUseDeclaration, current: WtfUseDeclaration): Boolean {
    var declaration: PsiElement = prev
    do {
      declaration = declaration.nextSibling
    } while (declaration.elementType == WtfTypes.NL)
    return declaration == current
  }

  override fun getPlaceholderText(node: ASTNode): String? {
    return "..."
  }

  override fun isCollapsedByDefault(node: ASTNode): Boolean {
    return false
  }
}