// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfEnumDeclaration extends PsiElement {

  @NotNull
  WtfEnumName getEnumName();

  @NotNull
  List<WtfEnumValue> getEnumValueList();

  @NotNull
  List<WtfNl> getNlList();

}
