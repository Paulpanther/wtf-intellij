package com.paulmethfessel.wtfintellij.lang.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import javax.swing.Icon

abstract class WtfNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), WtfNamedElement {
  override fun getPresentation(): ItemPresentation {
    return object : ItemPresentation {
      override fun getLocationString(): String {
        return containingFile.name
      }

      override fun getPresentableText(): String? {
        return name
      }

      override fun getIcon(unused: Boolean): Icon? {
        return getIcon(0)
      }
    }
  }

  override fun getName(): String = nameIdentifier?.text ?: ""

  override fun setName(newName: String): PsiElement? {
    val node = nameIdentifier?.node as? LeafPsiElement ?: return null
    node.replaceWithText(newName)
    return nameIdentifier
  }

  override fun getNavigationElement(): PsiElement {
    return nameIdentifier ?: this
  }
}