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

public class WtfPackageNamespaceImpl extends ASTWrapperPsiElement implements WtfPackageNamespace {

  public WtfPackageNamespaceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WtfVisitor visitor) {
    visitor.visitPackageNamespace(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WtfVisitor) accept((WtfVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}