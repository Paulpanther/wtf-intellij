// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.paulmethfessel.wtfintellij.lang.psi.WtfTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.paulmethfessel.wtfintellij.lang.psi.*;
import com.paulmethfessel.wtfintellij.lang.WtfPsiImplUtil;

public class WtfUseDeclarationImpl extends ASTWrapperPsiElement implements WtfUseDeclaration {

  public WtfUseDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WtfVisitor visitor) {
    visitor.visitUseDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WtfVisitor) accept((WtfVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WtfNl> getNlList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WtfNl.class);
  }

  @Override
  @NotNull
  public WtfUseInterface getUseInterface() {
    return findNotNullChildByClass(WtfUseInterface.class);
  }

  @Override
  @NotNull
  public List<WtfUseItem> getUseItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WtfUseItem.class);
  }

  @Override
  @NotNull
  public WtfUseNamespace getUseNamespace() {
    return findNotNullChildByClass(WtfUseNamespace.class);
  }

  @Override
  @NotNull
  public WtfUsePackage getUsePackage() {
    return findNotNullChildByClass(WtfUsePackage.class);
  }

}
