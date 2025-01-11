// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfReferenceExpr extends WtfExpr {

  @NotNull
  List<WtfExpr> getExprList();

  @NotNull
  List<WtfNl> getNlList();

  @Nullable
  WtfVariable getVariable();

}
