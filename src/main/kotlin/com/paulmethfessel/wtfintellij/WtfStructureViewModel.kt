package com.paulmethfessel.wtfintellij

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
import com.paulmethfessel.wtfintellij.lang.psi.WtfFile
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfFunctionName
import com.paulmethfessel.wtfintellij.lang.psi.WtfNamedElementImpl
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordName
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantDeclaration

class WtfStructureViewModel(editor: Editor?, psiFile: PsiFile) :
  StructureViewModelBase(psiFile, editor, WtfStructureViewElement(psiFile)),
  StructureViewModel.ElementInfoProvider {
  override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
    return false
  }

  override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
    return element?.value is WtfFunctionName || element?.value is WtfRecordName
  }

  override fun getSorters(): Array<Sorter> {
    return arrayOf(Sorter.ALPHA_SORTER)
  }

  override fun getSuitableClasses(): Array<Class<out PsiElement>> {
    return arrayOf(
      WtfFunctionName::class.java,
      WtfRecordName::class.java
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
    if (element is WtfFile) {
      val records = element.childrenOfType<WtfRecordDeclaration>().map { it.recordName.namedIdentifier }
      val resources = element.childrenOfType<WtfResourceDeclaration>().map { it.resourceName.namedIdentifier }
      val functions = element.childrenOfType<WtfFuncDeclaration>().map { it.functionName.namedIdentifier }
      val enums = element.childrenOfType<WtfEnumDeclaration>().map { it.enumName.namedIdentifier }
      val variants = element.childrenOfType<WtfVariantDeclaration>().map { it.variantName.namedIdentifier }
      val psiElements = records + resources + functions + enums + variants
      return psiElements.map { WtfStructureViewElement(it as WtfNamedElementImpl) }.toTypedArray()
    }
    return arrayOf()
  }
}