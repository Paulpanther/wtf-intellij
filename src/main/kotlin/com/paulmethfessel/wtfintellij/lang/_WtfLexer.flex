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

NEW_LINE=\n
WHITESPACE=[ \t]+
IDENTIFIER=[_a-z][_a-zA-Z0-9]*
COMMENT="//".*
INTEGER=[0-9]+
FLOAT=([0-9]+\.[0-9]*)|([0-9]*\.[0-9]+)

%state STRING
%state STRING_EXPR

%%
<YYINITIAL> ")"        { return RIGHT_PAREN; }
<STRING_EXPR> ")"      { yybegin(STRING); return STRING_RIGHT_PAREN; }

<YYINITIAL, STRING_EXPR> {
  {NEW_LINE}          { return NEW_LINE; }
  {WHITESPACE}        { return WHITE_SPACE; }

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
  "constructor"       { return CONSTRUCTOR; }
  "true"              { return TRUE; }
  "false"             { return FALSE; }
  "+"                 { return PLUS; }
  "-"                 { return MINUS; }
  "/"                 { return SLASH; }
  "*"                 { return STAR; }
  "&&"                { return AND; }
  "||"                { return OR; }
  "<"                 { return LT; }
  ">"                 { return GT; }
  "<="                { return LE; }
  ">="                { return GE; }
  "="                 { return ASSIGN; }
  "=="                { return EQUAL; }
  "!="                { return NOT_EQUAL; }
  "!"                 { return EXCLAMETION; }
  "?"                 { return QUESTION; }
  ":"                 { return COLON; }
  "@"                 { return AT; }
  "."                 { return DOT; }
  "{"                 { return LEFT_BRACE; }
  "}"                 { return RIGHT_BRACE; }
  "("                 { return LEFT_PAREN; }
  ")"                 { return RIGHT_PAREN; }
  ","                 { return COMMA; }
  "->"                { return RIGHT_ARROW; }
  "'"                 { return SINGLE_QUOTE; }
  "\\"                { return BACK_SLASH; }
  "\\("               { return BACK_SLASH_PAREN; }

  {IDENTIFIER}        { return IDENTIFIER; }
  {COMMENT}           { return COMMENT; }
  {INTEGER}           { return INTEGER; }
  {FLOAT}             { return FLOAT; }
   "\""               { yybegin(STRING); return QUOTE; }
}

<STRING> {
  "\\("               { yybegin(STRING_EXPR); return STRING_LEFT_PAREN; }
  "\""                { yybegin(YYINITIAL); return QUOTE; }
  [^\n\"]+/(\\\()?    { return STRING_CONTENT; }
}

[^] { return BAD_CHARACTER; }
