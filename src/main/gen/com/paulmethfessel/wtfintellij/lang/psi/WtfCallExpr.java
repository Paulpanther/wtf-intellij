// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfCallExpr extends WtfExpr {

  @NotNull
  List<WtfExpr> getExprList();

  @NotNull
  WtfFunctionCallName getFunctionCallName();

  @NotNull
  List<WtfNl> getNlList();

}
