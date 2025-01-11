// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfResourceDeclaration extends PsiElement {

  @NotNull
  List<WtfNl> getNlList();

  @NotNull
  List<WtfResourceConstructor> getResourceConstructorList();

  @NotNull
  List<WtfResourceField> getResourceFieldList();

  @NotNull
  List<WtfResourceMethod> getResourceMethodList();

  @NotNull
  WtfResourceName getResourceName();

}
