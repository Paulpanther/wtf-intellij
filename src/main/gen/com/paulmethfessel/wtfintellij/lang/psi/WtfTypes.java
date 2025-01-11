// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.paulmethfessel.wtfintellij.lang.psi.impl.*;

public interface WtfTypes {

  IElementType BINARY_EXPR = new WtfElementType("BINARY_EXPR");
  IElementType CALL_EXPR = new WtfElementType("CALL_EXPR");
  IElementType CALL_STMT = new WtfElementType("CALL_STMT");
  IElementType CONSTRUCTOR_ARGUMENT = new WtfElementType("CONSTRUCTOR_ARGUMENT");
  IElementType CONSTRUCTOR_ARGUMENT_NAME = new WtfElementType("CONSTRUCTOR_ARGUMENT_NAME");
  IElementType CONSTRUCTOR_EXPR = new WtfElementType("CONSTRUCTOR_EXPR");
  IElementType ENUM_DECLARATION = new WtfElementType("ENUM_DECLARATION");
  IElementType ENUM_NAME = new WtfElementType("ENUM_NAME");
  IElementType ENUM_VALUE = new WtfElementType("ENUM_VALUE");
  IElementType EXPR = new WtfElementType("EXPR");
  IElementType FUNCTION_CALL_NAME = new WtfElementType("FUNCTION_CALL_NAME");
  IElementType FUNCTION_NAME = new WtfElementType("FUNCTION_NAME");
  IElementType FUNC_ARGUMENT = new WtfElementType("FUNC_ARGUMENT");
  IElementType FUNC_BODY = new WtfElementType("FUNC_BODY");
  IElementType FUNC_DECLARATION = new WtfElementType("FUNC_DECLARATION");
  IElementType LITERAL_EXPR = new WtfElementType("LITERAL_EXPR");
  IElementType NAMED_IDENTIFIER = new WtfElementType("NAMED_IDENTIFIER");
  IElementType NL = new WtfElementType("NL");
  IElementType PACKAGE_DECLARATION = new WtfElementType("PACKAGE_DECLARATION");
  IElementType PACKAGE_NAME = new WtfElementType("PACKAGE_NAME");
  IElementType PACKAGE_NAMESPACE = new WtfElementType("PACKAGE_NAMESPACE");
  IElementType PACKAGE_VERSION = new WtfElementType("PACKAGE_VERSION");
  IElementType PARENTHESIZED_EXPR = new WtfElementType("PARENTHESIZED_EXPR");
  IElementType RECORD_DECLARATION = new WtfElementType("RECORD_DECLARATION");
  IElementType RECORD_FIELD = new WtfElementType("RECORD_FIELD");
  IElementType RECORD_NAME = new WtfElementType("RECORD_NAME");
  IElementType REFERENCE_EXPR = new WtfElementType("REFERENCE_EXPR");
  IElementType RESOURCE_CONSTRUCTOR = new WtfElementType("RESOURCE_CONSTRUCTOR");
  IElementType RESOURCE_DECLARATION = new WtfElementType("RESOURCE_DECLARATION");
  IElementType RESOURCE_FIELD = new WtfElementType("RESOURCE_FIELD");
  IElementType RESOURCE_METHOD = new WtfElementType("RESOURCE_METHOD");
  IElementType RESOURCE_NAME = new WtfElementType("RESOURCE_NAME");
  IElementType RETURN_STMT = new WtfElementType("RETURN_STMT");
  IElementType STMT = new WtfElementType("STMT");
  IElementType STRING = new WtfElementType("STRING");
  IElementType STRING_EXPRESSION = new WtfElementType("STRING_EXPRESSION");
  IElementType TYPED_IDENTIFIER = new WtfElementType("TYPED_IDENTIFIER");
  IElementType TYPE_IDENTIFIER = new WtfElementType("TYPE_IDENTIFIER");
  IElementType UNARY_EXPR = new WtfElementType("UNARY_EXPR");
  IElementType USE_DECLARATION = new WtfElementType("USE_DECLARATION");
  IElementType USE_INTERFACE = new WtfElementType("USE_INTERFACE");
  IElementType USE_ITEM = new WtfElementType("USE_ITEM");
  IElementType USE_NAMESPACE = new WtfElementType("USE_NAMESPACE");
  IElementType USE_PACKAGE = new WtfElementType("USE_PACKAGE");
  IElementType VARIABLE = new WtfElementType("VARIABLE");
  IElementType VARIABLE_ASSIGNMENT_STMT = new WtfElementType("VARIABLE_ASSIGNMENT_STMT");
  IElementType VARIABLE_DECLARATION_STMT = new WtfElementType("VARIABLE_DECLARATION_STMT");
  IElementType VARIANT_DECLARATION = new WtfElementType("VARIANT_DECLARATION");
  IElementType VARIANT_NAME = new WtfElementType("VARIANT_NAME");
  IElementType VARIANT_VALUE = new WtfElementType("VARIANT_VALUE");

  IElementType AND = new WtfTokenType("&&");
  IElementType ASSIGN = new WtfTokenType("=");
  IElementType AT = new WtfTokenType("@");
  IElementType BACK_SLASH = new WtfTokenType("\\");
  IElementType BACK_SLASH_PAREN = new WtfTokenType("\\(");
  IElementType BREAK = new WtfTokenType("break");
  IElementType COLON = new WtfTokenType(":");
  IElementType COMMA = new WtfTokenType(",");
  IElementType COMMENT = new WtfTokenType("COMMENT");
  IElementType CONSTRUCTOR = new WtfTokenType("constructor");
  IElementType CONTINUE = new WtfTokenType("continue");
  IElementType DOT = new WtfTokenType(".");
  IElementType ELSE = new WtfTokenType("else");
  IElementType ENUM = new WtfTokenType("enum");
  IElementType EQUAL = new WtfTokenType("==");
  IElementType EXCLAMETION = new WtfTokenType("!");
  IElementType EXPORT = new WtfTokenType("export");
  IElementType FALSE = new WtfTokenType("false");
  IElementType FLOAT = new WtfTokenType("FLOAT");
  IElementType FOR = new WtfTokenType("for");
  IElementType FUNC = new WtfTokenType("func");
  IElementType GE = new WtfTokenType(">=");
  IElementType GT = new WtfTokenType(">");
  IElementType IDENTIFIER = new WtfTokenType("IDENTIFIER");
  IElementType IF = new WtfTokenType("if");
  IElementType IN = new WtfTokenType("in");
  IElementType INTEGER = new WtfTokenType("INTEGER");
  IElementType LE = new WtfTokenType("<=");
  IElementType LEFT_BRACE = new WtfTokenType("{");
  IElementType LEFT_PAREN = new WtfTokenType("(");
  IElementType LET = new WtfTokenType("let");
  IElementType LT = new WtfTokenType("<");
  IElementType MATCH = new WtfTokenType("match");
  IElementType MINUS = new WtfTokenType("-");
  IElementType NEW_LINE = new WtfTokenType("NEW_LINE");
  IElementType NOT_EQUAL = new WtfTokenType("!=");
  IElementType OR = new WtfTokenType("||");
  IElementType PACKAGE = new WtfTokenType("package");
  IElementType PLUS = new WtfTokenType("+");
  IElementType QUESTION = new WtfTokenType("?");
  IElementType QUOTE = new WtfTokenType("\"");
  IElementType RECORD = new WtfTokenType("record");
  IElementType RESOURCE = new WtfTokenType("resource");
  IElementType RETURN = new WtfTokenType("return");
  IElementType RIGHT_ARROW = new WtfTokenType("->");
  IElementType RIGHT_BRACE = new WtfTokenType("}");
  IElementType RIGHT_PAREN = new WtfTokenType(")");
  IElementType SINGLE_QUOTE = new WtfTokenType("'");
  IElementType SLASH = new WtfTokenType("/");
  IElementType STAR = new WtfTokenType("*");
  IElementType STRING_CONTENT = new WtfTokenType("STRING_CONTENT");
  IElementType STRING_LEFT_PAREN = new WtfTokenType("STRING_LEFT_PAREN");
  IElementType STRING_RIGHT_PAREN = new WtfTokenType("STRING_RIGHT_PAREN");
  IElementType TRUE = new WtfTokenType("true");
  IElementType USE = new WtfTokenType("use");
  IElementType VAR = new WtfTokenType("var");
  IElementType VARIANT = new WtfTokenType("variant");
  IElementType WHILE = new WtfTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BINARY_EXPR) {
        return new WtfBinaryExprImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new WtfCallExprImpl(node);
      }
      else if (type == CALL_STMT) {
        return new WtfCallStmtImpl(node);
      }
      else if (type == CONSTRUCTOR_ARGUMENT) {
        return new WtfConstructorArgumentImpl(node);
      }
      else if (type == CONSTRUCTOR_ARGUMENT_NAME) {
        return new WtfConstructorArgumentNameImpl(node);
      }
      else if (type == CONSTRUCTOR_EXPR) {
        return new WtfConstructorExprImpl(node);
      }
      else if (type == ENUM_DECLARATION) {
        return new WtfEnumDeclarationImpl(node);
      }
      else if (type == ENUM_NAME) {
        return new WtfEnumNameImpl(node);
      }
      else if (type == ENUM_VALUE) {
        return new WtfEnumValueImpl(node);
      }
      else if (type == FUNCTION_CALL_NAME) {
        return new WtfFunctionCallNameImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new WtfFunctionNameImpl(node);
      }
      else if (type == FUNC_ARGUMENT) {
        return new WtfFuncArgumentImpl(node);
      }
      else if (type == FUNC_BODY) {
        return new WtfFuncBodyImpl(node);
      }
      else if (type == FUNC_DECLARATION) {
        return new WtfFuncDeclarationImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new WtfLiteralExprImpl(node);
      }
      else if (type == NAMED_IDENTIFIER) {
        return new WtfNamedIdentifierImpl(node);
      }
      else if (type == NL) {
        return new WtfNlImpl(node);
      }
      else if (type == PACKAGE_DECLARATION) {
        return new WtfPackageDeclarationImpl(node);
      }
      else if (type == PACKAGE_NAME) {
        return new WtfPackageNameImpl(node);
      }
      else if (type == PACKAGE_NAMESPACE) {
        return new WtfPackageNamespaceImpl(node);
      }
      else if (type == PACKAGE_VERSION) {
        return new WtfPackageVersionImpl(node);
      }
      else if (type == PARENTHESIZED_EXPR) {
        return new WtfParenthesizedExprImpl(node);
      }
      else if (type == RECORD_DECLARATION) {
        return new WtfRecordDeclarationImpl(node);
      }
      else if (type == RECORD_FIELD) {
        return new WtfRecordFieldImpl(node);
      }
      else if (type == RECORD_NAME) {
        return new WtfRecordNameImpl(node);
      }
      else if (type == REFERENCE_EXPR) {
        return new WtfReferenceExprImpl(node);
      }
      else if (type == RESOURCE_CONSTRUCTOR) {
        return new WtfResourceConstructorImpl(node);
      }
      else if (type == RESOURCE_DECLARATION) {
        return new WtfResourceDeclarationImpl(node);
      }
      else if (type == RESOURCE_FIELD) {
        return new WtfResourceFieldImpl(node);
      }
      else if (type == RESOURCE_METHOD) {
        return new WtfResourceMethodImpl(node);
      }
      else if (type == RESOURCE_NAME) {
        return new WtfResourceNameImpl(node);
      }
      else if (type == RETURN_STMT) {
        return new WtfReturnStmtImpl(node);
      }
      else if (type == STRING) {
        return new WtfStringImpl(node);
      }
      else if (type == STRING_EXPRESSION) {
        return new WtfStringExpressionImpl(node);
      }
      else if (type == TYPED_IDENTIFIER) {
        return new WtfTypedIdentifierImpl(node);
      }
      else if (type == TYPE_IDENTIFIER) {
        return new WtfTypeIdentifierImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new WtfUnaryExprImpl(node);
      }
      else if (type == USE_DECLARATION) {
        return new WtfUseDeclarationImpl(node);
      }
      else if (type == USE_INTERFACE) {
        return new WtfUseInterfaceImpl(node);
      }
      else if (type == USE_ITEM) {
        return new WtfUseItemImpl(node);
      }
      else if (type == USE_NAMESPACE) {
        return new WtfUseNamespaceImpl(node);
      }
      else if (type == USE_PACKAGE) {
        return new WtfUsePackageImpl(node);
      }
      else if (type == VARIABLE) {
        return new WtfVariableImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT_STMT) {
        return new WtfVariableAssignmentStmtImpl(node);
      }
      else if (type == VARIABLE_DECLARATION_STMT) {
        return new WtfVariableDeclarationStmtImpl(node);
      }
      else if (type == VARIANT_DECLARATION) {
        return new WtfVariantDeclarationImpl(node);
      }
      else if (type == VARIANT_NAME) {
        return new WtfVariantNameImpl(node);
      }
      else if (type == VARIANT_VALUE) {
        return new WtfVariantValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
