package com.paulmethfessel.wtfintellij.lang

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.paulmethfessel.wtfintellij.lang.psi.WtfNamedIdentifier
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariable
import com.paulmethfessel.wtfintellij.lang.refs.WtfParameterReference
import javax.swing.Icon


object WtfPsiImplUtil {
  @JvmStatic
  fun getName(identifier: WtfNamedIdentifier): String = identifier.identifier.text

  @JvmStatic
  fun setName(identifier: WtfNamedIdentifier, newName: String): PsiElement? {
    val node = identifier.identifier.node as? LeafPsiElement ?: return null
    node.replaceWithText(newName)
    return identifier
  }

  @JvmStatic
  fun getNameIdentifier(identifier: WtfNamedIdentifier): PsiElement? {
    return identifier.identifier
  }

  @JvmStatic
  fun getReferences(variable: PsiElement): Array<PsiReferenceBase<PsiElement>> {
    return when (variable) {
      is WtfVariable -> arrayOf(WtfParameterReference(variable))
      else -> arrayOf()
    }
  }

  @JvmStatic
  fun getPresentation(element: WtfNamedIdentifier): ItemPresentation {
    return object : ItemPresentation {
      override fun getLocationString(): String {
        return element.containingFile.name
      }

      override fun getPresentableText(): String? {
        return element.text
      }

      override fun getIcon(unused: Boolean): Icon {
        return element.getIcon(0)
      }
    }
  }
}