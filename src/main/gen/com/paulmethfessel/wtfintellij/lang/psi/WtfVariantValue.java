// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WtfVariantValue extends PsiElement {

  @NotNull
  WtfNamedIdentifier getNamedIdentifier();

  @NotNull
  List<WtfNl> getNlList();

  @NotNull
  List<WtfTypedIdentifier> getTypedIdentifierList();

}
