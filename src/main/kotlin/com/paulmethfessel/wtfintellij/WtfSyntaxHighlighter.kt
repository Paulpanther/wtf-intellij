package com.paulmethfessel.wtfintellij

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import com.paulmethfessel.wtfintellij.lang.WtfLexerAdapter
import com.paulmethfessel.wtfintellij.lang.psi.WtfTypes

class WtfSyntaxHighlighter : SyntaxHighlighterBase() {
  companion object {
    val keywordAttrib = createTextAttributesKey("WTF_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val keywords = listOf(
      WtfTypes.USE,
      WtfTypes.PACKAGE,
      WtfTypes.LET,
      WtfTypes.VAR,
      WtfTypes.RECORD,
      WtfTypes.RESOURCE,
      WtfTypes.FUNC,
      WtfTypes.ENUM,
      WtfTypes.VARIANT,
      WtfTypes.IF,
      WtfTypes.ELSE,
      WtfTypes.WHILE,
      WtfTypes.FOR,
      WtfTypes.IN,
      WtfTypes.RETURN,
      WtfTypes.MATCH,
      WtfTypes.BREAK,
      WtfTypes.CONTINUE,
    )
  }

  override fun getHighlightingLexer() = WtfLexerAdapter()

  override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
    if (tokenType in keywords) {
      return arrayOf(keywordAttrib)
    }
    return emptyArray()
  }
}

class WtfSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
  override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
    return WtfSyntaxHighlighter()
  }
}