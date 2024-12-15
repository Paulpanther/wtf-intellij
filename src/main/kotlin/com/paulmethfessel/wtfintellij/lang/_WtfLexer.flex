package com.paulmethfessel.wtfintellij.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.paulmethfessel.wtfintellij.lang.psi.WtfTypes.*;

%%

%{
  public _WtfLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _WtfLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

WHITESPACE=[ \t\n\x0B\f\r]+
IDENTIFIER=[_a-z][_a-zA-Z0-9]*
VERSION=regexp:[a-z0-9][_a-zA-Z0-9-]*(\.[_a-zA-Z0-9-]+)*
COMMENT="//".*

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }

  "package"           { return PACKAGE; }
  "use"               { return USE; }
  "let"               { return LET; }
  "var"               { return VAR; }
  "record"            { return RECORD; }
  "resource"          { return RESOURCE; }
  "func"              { return FUNC; }
  "enum"              { return ENUM; }
  "variant"           { return VARIANT; }
  "if"                { return IF; }
  "else"              { return ELSE; }
  "while"             { return WHILE; }
  "for"               { return FOR; }
  "in"                { return IN; }
  "return"            { return RETURN; }
  "match"             { return MATCH; }
  "break"             { return BREAK; }
  "continue"          { return CONTINUE; }
  ":"                 { return COLON; }
  "@"                 { return AT; }
  "/"                 { return SLASH; }
  "."                 { return DOT; }
  "{"                 { return LEFT_BRACE; }
  "}"                 { return RIGHT_BRACE; }
  ","                 { return COMMA; }

  {WHITESPACE}        { return WHITESPACE; }
  {IDENTIFIER}        { return IDENTIFIER; }
  {VERSION}           { return VERSION; }
  {COMMENT}           { return COMMENT; }

}

[^] { return BAD_CHARACTER; }
