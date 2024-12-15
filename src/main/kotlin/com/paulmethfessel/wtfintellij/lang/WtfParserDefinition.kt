package com.paulmethfessel.wtfintellij.lang

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.paulmethfessel.wtfintellij.lang.psi.WtfFile
import com.paulmethfessel.wtfintellij.lang.psi.WtfTypes

class WtfParserDefinition : ParserDefinition {
  companion object {
    val file = IFileElementType(WtfLang.instance)
  }

  override fun createLexer(p: Project?) = WtfLexerAdapter()
  override fun createParser(p: Project?) = WtfParser()
  override fun getFileNodeType() = file
  override fun getCommentTokens() = WtfTokenSets.comments
  override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY
  override fun createElement(node: ASTNode?): PsiElement = WtfTypes.Factory.createElement(node)
  override fun createFile(fileViewProvider: FileViewProvider) = WtfFile(fileViewProvider)
}