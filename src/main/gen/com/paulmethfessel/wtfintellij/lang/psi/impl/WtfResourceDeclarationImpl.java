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

public class WtfResourceDeclarationImpl extends ASTWrapperPsiElement implements WtfResourceDeclaration {

  public WtfResourceDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WtfVisitor visitor) {
    visitor.visitResourceDeclaration(this);
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
  public List<WtfResourceConstructor> getResourceConstructorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WtfResourceConstructor.class);
  }

  @Override
  @NotNull
  public List<WtfResourceField> getResourceFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WtfResourceField.class);
  }

  @Override
  @NotNull
  public List<WtfResourceMethod> getResourceMethodList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WtfResourceMethod.class);
  }

  @Override
  @NotNull
  public WtfResourceName getResourceName() {
    return findNotNullChildByClass(WtfResourceName.class);
  }

}
