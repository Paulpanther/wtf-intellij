package com.paulmethfessel.wtfintellij.editor

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.Editor
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.childrenOfType
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumValue
import com.paulmethfessel.wtfintellij.lang.psi.WtfFile
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfNamedElementImpl
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordField
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceField
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantValue

class WtfStructureViewModel(editor: Editor?, psiFile: PsiFile) :
  StructureViewModelBase(psiFile, editor, WtfStructureViewElement(psiFile)),
  StructureViewModel.ElementInfoProvider {

  override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
    return element?.value is WtfRecordDeclaration
        || element?.value is WtfResourceDeclaration
        || element?.value is WtfEnumDeclaration
        || element?.value is WtfVariantDeclaration
  }

  override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
    return element?.value is WtfFuncDeclaration
        || element?.value is WtfRecordField
        || element?.value is WtfEnumValue
        || element?.value is WtfVariantValue
        || element?.value is WtfResourceField
  }

  override fun getSorters(): Array<Sorter> {
    return arrayOf(Sorter.ALPHA_SORTER)
  }

  override fun getSuitableClasses(): Array<Class<out PsiElement>> {
    return arrayOf(
      WtfFuncDeclaration::class.java,
      WtfRecordDeclaration::class.java,
      WtfEnumDeclaration::class.java,
      WtfResourceDeclaration::class.java,
      WtfVariantDeclaration::class.java,
      WtfRecordField::class.java,
      WtfEnumValue::class.java,
      WtfVariantValue::class.java,
      WtfResourceField::class.java,
    )
  }
}

class WtfStructureViewElement(
  private val element: NavigatablePsiElement
) : StructureViewTreeElement, SortableTreeElement {
  override fun getPresentation(): ItemPresentation {
    return element.presentation ?: PresentationData()
  }

  override fun getValue() = element

  override fun getAlphaSortKey(): String {
    return element.name ?: ""
  }

  override fun navigate(requestFocus: Boolean) {
    element.navigate(requestFocus)
  }

  override fun canNavigate(): Boolean {
    return element.canNavigate()
  }

  override fun canNavigateToSource(): Boolean {
    return element.canNavigateToSource()
  }

  override fun getChildren(): Array<TreeElement> {
    val elements = if (element is WtfFile) {
      val records = element.childrenOfType<WtfRecordDeclaration>()
      val resources = element.childrenOfType<WtfResourceDeclaration>()
      val functions = element.childrenOfType<WtfFuncDeclaration>()
      val enums = element.childrenOfType<WtfEnumDeclaration>()
      val variants = element.childrenOfType<WtfVariantDeclaration>()
      records + resources + functions + enums + variants
    } else if (element is WtfRecordDeclaration) {
      element.recordFieldList.map { it.typedIdentifier }
    } else if (element is WtfEnumDeclaration) {
      element.enumValueList
    } else if (element is WtfVariantDeclaration) {
      element.variantValueList
    } else if (element is WtfResourceDeclaration) {
      val fields =
        element.resourceFieldList.map { it.typedIdentifier }
      val methods =
        element.resourceMethodList
      fields + methods
    } else {
      listOf()
    }
    return elements.map { WtfStructureViewElement(it as WtfNamedElementImpl) }.toTypedArray()
  }
}