// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfConstructorExpr extends WtfExpr {

  @NotNull
  List<WtfConstructorArgument> getConstructorArgumentList();

  @NotNull
  WtfNamedIdentifier getNamedIdentifier();

  @NotNull
  List<WtfNl> getNlList();

}
