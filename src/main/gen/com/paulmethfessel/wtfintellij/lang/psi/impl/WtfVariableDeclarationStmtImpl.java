// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.paulmethfessel.wtfintellij.lang.psi.WtfTypes.*;
import com.paulmethfessel.wtfintellij.lang.psi.*;
import com.paulmethfessel.wtfintellij.lang.WtfPsiImplUtil;

public class WtfVariableDeclarationStmtImpl extends WtfStmtImpl implements WtfVariableDeclarationStmt {

  public WtfVariableDeclarationStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull WtfVisitor visitor) {
    visitor.visitVariableDeclarationStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WtfVisitor) accept((WtfVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WtfExpr getExpr() {
    return findNotNullChildByClass(WtfExpr.class);
  }

  @Override
  @NotNull
  public WtfNamedIdentifier getNamedIdentifier() {
    return findNotNullChildByClass(WtfNamedIdentifier.class);
  }

  @Override
  @NotNull
  public List<WtfNl> getNlList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WtfNl.class);
  }

}
