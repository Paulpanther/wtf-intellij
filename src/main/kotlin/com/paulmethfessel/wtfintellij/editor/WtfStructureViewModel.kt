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
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumName
import com.paulmethfessel.wtfintellij.lang.psi.WtfEnumValue
import com.paulmethfessel.wtfintellij.lang.psi.WtfFile
import com.paulmethfessel.wtfintellij.lang.psi.WtfFuncDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfFunctionName
import com.paulmethfessel.wtfintellij.lang.psi.WtfNamedElementImpl
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordField
import com.paulmethfessel.wtfintellij.lang.psi.WtfRecordName
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceField
import com.paulmethfessel.wtfintellij.lang.psi.WtfResourceName
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantDeclaration
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantName
import com.paulmethfessel.wtfintellij.lang.psi.WtfVariantValue

class WtfStructureViewModel(editor: Editor?, psiFile: PsiFile) :
  StructureViewModelBase(psiFile, editor, WtfStructureViewElement(psiFile)),
  StructureViewModel.ElementInfoProvider {

  override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
    return element?.value is WtfRecordName
        || element?.value is WtfResourceName
        || element?.value is WtfEnumName
        || element?.value is WtfVariantName
  }

  override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
    return element?.value is WtfFunctionName
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
      WtfFunctionName::class.java,
      WtfRecordName::class.java,
      WtfEnumName::class.java,
      WtfResourceName::class.java,
      WtfVariantName::class.java,
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
    if (element is WtfFile) {
      val records = element.childrenOfType<WtfRecordDeclaration>().map { it.recordName }
      val resources = element.childrenOfType<WtfResourceDeclaration>().map { it.resourceName }
      val functions = element.childrenOfType<WtfFuncDeclaration>().map { it.functionName }
      val enums = element.childrenOfType<WtfEnumDeclaration>().map { it.enumName }
      val variants = element.childrenOfType<WtfVariantDeclaration>().map { it.variantName }
      val psiElements = records + resources + functions + enums + variants
      return psiElements.map { WtfStructureViewElement(it as WtfNamedElementImpl) }.toTypedArray()
    } else if (element is WtfRecordName) {
      val fields =
        ((element as WtfRecordName).parent as WtfRecordDeclaration).recordFieldList.map { it.typedIdentifier.namedIdentifier }
      return fields.map { WtfStructureViewElement(it as WtfNamedElementImpl) }.toTypedArray()
    } else if (element is WtfEnumName) {
      val fields =
        ((element as WtfEnumName).parent as WtfEnumDeclaration).enumValueList.map { it.namedIdentifier }
      return fields.map { WtfStructureViewElement(it as WtfNamedElementImpl) }.toTypedArray()
    } else if (element is WtfVariantName) {
      val fields =
        ((element as WtfVariantName).parent as WtfVariantDeclaration).variantValueList.map { it.namedIdentifier }
      return fields.map { WtfStructureViewElement(it as WtfNamedElementImpl) }.toTypedArray()
    } else if (element is WtfResourceName) {
      val fields =
        ((element as WtfResourceName).parent as WtfResourceDeclaration).resourceFieldList.map { it.typedIdentifier.namedIdentifier }
      val methods =
        ((element as WtfResourceName).parent as WtfResourceDeclaration).resourceMethodList.map { it.functionName.namedIdentifier }
      return (methods + fields).map { WtfStructureViewElement(it as WtfNamedElementImpl) }.toTypedArray()
    }
    return arrayOf()
  }
}