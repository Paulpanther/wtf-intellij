// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfUseDeclaration extends PsiElement {

  @NotNull
  List<WtfNl> getNlList();

  @NotNull
  WtfUseInterface getUseInterface();

  @NotNull
  List<WtfUseItem> getUseItemList();

  @NotNull
  WtfUseNamespace getUseNamespace();

  @NotNull
  WtfUsePackage getUsePackage();

}
