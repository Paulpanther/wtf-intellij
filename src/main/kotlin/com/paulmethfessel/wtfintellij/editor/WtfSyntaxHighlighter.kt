package com.paulmethfessel.wtfintellij.editor

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
import com.paulmethfessel.wtfintellij.lang.psi.WtfTypes.*

class WtfSyntaxHighlighter : SyntaxHighlighterBase() {
  companion object {
    val comment = createTextAttributesKey("WTF_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val keyword = createTextAttributesKey("WTF_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val number = createTextAttributesKey("WTF_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val string = createTextAttributesKey("WTF_STRING", DefaultLanguageHighlighterColors.STRING)
    val keywords = listOf(
      USE,
      PACKAGE,
      LET,
      VAR,
      RECORD,
      RESOURCE,
      FUNC,
      ENUM,
      VARIANT,
      IF,
      ELSE,
      WHILE,
      FOR,
      IN,
      RETURN,
      MATCH,
      BREAK,
      CONTINUE,
      EXPORT
    )
    val dot = createTextAttributesKey("WTF_DOT", DefaultLanguageHighlighterColors.DOT)
    val comma = createTextAttributesKey("WTF_COMMA", DefaultLanguageHighlighterColors.COMMA)
    val parenthesis = createTextAttributesKey("WTF_PARENTHESIS", DefaultLanguageHighlighterColors.PARENTHESES)
    val braces = createTextAttributesKey("WTF_BRACES", DefaultLanguageHighlighterColors.BRACES)
    val operatorSign = createTextAttributesKey("WTF_OPERATOR_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN)
    val arrow = createTextAttributesKey("WTF_ARROW", operatorSign)
    val colon = createTextAttributesKey("WTF_COLON", operatorSign)
    val versionSign = createTextAttributesKey("WTF_VERSION_SIGN", operatorSign)
    val stringTemplateParenthesis =
      createTextAttributesKey("WTF_STRING_TEMPLATE_PARENTHESIS", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)

    val funcDeclarationAttrib =
      createTextAttributesKey("WTF_FUNC_DECLARATION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
    val enumAttrib =
      createTextAttributesKey("WTF_ENUM", DefaultLanguageHighlighterColors.CLASS_NAME)
    val resourceAttrib =
      createTextAttributesKey("WTF_RESOURCE", DefaultLanguageHighlighterColors.CLASS_NAME)
    val recordAttrib =
      createTextAttributesKey("WTF_RECORD", DefaultLanguageHighlighterColors.CLASS_NAME)
    val variantAttrib =
      createTextAttributesKey("WTF_VARIANT", DefaultLanguageHighlighterColors.CLASS_NAME)
  }

  override fun getHighlightingLexer() = WtfLexerAdapter()

  override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
    return when (tokenType) {
      in keywords -> arrayOf(keyword)
      COMMENT -> arrayOf(comment)
      INTEGER, FLOAT -> arrayOf(number)
      STRING_CONTENT, QUOTE -> arrayOf(string)
      DOT -> arrayOf(dot)
      COMMA -> arrayOf(comma)
      LEFT_PAREN, RIGHT_PAREN -> arrayOf(parenthesis)
      LEFT_BRACE, RIGHT_BRACE -> arrayOf(braces)
      RIGHT_ARROW -> arrayOf(arrow)
      COLON -> arrayOf(colon)
      AT -> arrayOf(versionSign)
      STRING_LEFT_PAREN, STRING_RIGHT_PAREN -> arrayOf(stringTemplateParenthesis)
      PLUS, MINUS, SLASH, STAR, AND, OR, LT, GT, LE, GE, ASSIGN, EQUAL, NOT_EQUAL, EXCLAMETION, QUESTION -> arrayOf(
        operatorSign
      )

      else -> emptyArray()
    }
  }
}

class WtfSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
  override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
    return WtfSyntaxHighlighter()
  }
}