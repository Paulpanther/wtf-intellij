// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfFuncDeclaration extends PsiElement {

  @NotNull
  List<WtfFuncArgument> getFuncArgumentList();

  @NotNull
  WtfFuncBody getFuncBody();

  @NotNull
  WtfFunctionName getFunctionName();

  @NotNull
  List<WtfNl> getNlList();

  @Nullable
  WtfTypeIdentifier getTypeIdentifier();

}
