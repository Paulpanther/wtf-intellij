package com.paulmethfessel.wtfintellij.lang.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class WtfNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), WtfNamedElement