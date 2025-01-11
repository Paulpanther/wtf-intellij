// This is a generated file. Not intended for manual editing.
package com.paulmethfessel.wtfintellij.lang;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.paulmethfessel.wtfintellij.lang.psi.WtfTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WtfParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return wtfFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(CALL_STMT, RETURN_STMT, STMT, VARIABLE_ASSIGNMENT_STMT,
      VARIABLE_DECLARATION_STMT),
    create_token_set_(BINARY_EXPR, CALL_EXPR, CONSTRUCTOR_EXPR, EXPR,
      LITERAL_EXPR, PARENTHESIZED_EXPR, REFERENCE_EXPR, UNARY_EXPR),
  };

  /* ********************************************************** */
  // PLUS | MINUS | SLASH | STAR | AND | OR | LT | LE | GT | GE | EQUAL | NOT_EQUAL
  static boolean binary_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_operator")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GE);
    if (!r) r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    return r;
  }

  /* ********************************************************** */
  // (expr nl? (COMMA nl? expr nl?)? COMMA?)?
  static boolean call_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args")) return false;
    call_args_0(b, l + 1);
    return true;
  }

  // expr nl? (COMMA nl? expr nl?)? COMMA?
  private static boolean call_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    r = r && call_args_0_1(b, l + 1);
    r = r && call_args_0_2(b, l + 1);
    r = r && call_args_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean call_args_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // (COMMA nl? expr nl?)?
  private static boolean call_args_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_0_2")) return false;
    call_args_0_2_0(b, l + 1);
    return true;
  }

  // COMMA nl? expr nl?
  private static boolean call_args_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && call_args_0_2_0_1(b, l + 1);
    r = r && expr(b, l + 1, -1);
    r = r && call_args_0_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean call_args_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_0_2_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean call_args_0_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_0_2_0_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // COMMA?
  private static boolean call_args_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_0_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // function_call_name nl? '(' nl? call_args nl? ')'
  public static boolean call_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_call_name(b, l + 1);
    r = r && call_expr_1(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && call_expr_3(b, l + 1);
    r = r && call_args(b, l + 1);
    r = r && call_expr_5(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, CALL_EXPR, r);
    return r;
  }

  // nl?
  private static boolean call_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean call_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean call_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr_5")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // call_expr
  public static boolean call_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_stmt")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expr(b, l + 1);
    exit_section_(b, m, CALL_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // (constructor_argument nl? (COMMA nl? constructor_argument nl?)*)?
  static boolean constructor_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_args")) return false;
    constructor_args_0(b, l + 1);
    return true;
  }

  // constructor_argument nl? (COMMA nl? constructor_argument nl?)*
  private static boolean constructor_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constructor_argument(b, l + 1);
    r = r && constructor_args_0_1(b, l + 1);
    r = r && constructor_args_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean constructor_args_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_args_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // (COMMA nl? constructor_argument nl?)*
  private static boolean constructor_args_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_args_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constructor_args_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constructor_args_0_2", c)) break;
    }
    return true;
  }

  // COMMA nl? constructor_argument nl?
  private static boolean constructor_args_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_args_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constructor_args_0_2_0_1(b, l + 1);
    r = r && constructor_argument(b, l + 1);
    r = r && constructor_args_0_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean constructor_args_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_args_0_2_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean constructor_args_0_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_args_0_2_0_3")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // constructor_argument_name ':' expr
  public static boolean constructor_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_argument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constructor_argument_name(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, CONSTRUCTOR_ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean constructor_argument_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_argument_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CONSTRUCTOR_ARGUMENT_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // named_identifier nl? '{' nl? constructor_args nl? '}'
  public static boolean constructor_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_expr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    r = r && constructor_expr_1(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && constructor_expr_3(b, l + 1);
    r = r && constructor_args(b, l + 1);
    r = r && constructor_expr_5(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, CONSTRUCTOR_EXPR, r);
    return r;
  }

  // nl?
  private static boolean constructor_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_expr_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean constructor_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_expr_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean constructor_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_expr_5")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // use_declaration | record_declaration | resource_declaration | enum_declaration | variant_declaration | func_declaration
  static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    r = use_declaration(b, l + 1);
    if (!r) r = record_declaration(b, l + 1);
    if (!r) r = resource_declaration(b, l + 1);
    if (!r) r = enum_declaration(b, l + 1);
    if (!r) r = variant_declaration(b, l + 1);
    if (!r) r = func_declaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // EXPORT? ENUM enum_name nl? '{' nl? (enum_value (nl enum_value)*)? nl? '}'
  public static boolean enum_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration")) return false;
    if (!nextTokenIs(b, "<enum declaration>", ENUM, EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECLARATION, "<enum declaration>");
    r = enum_declaration_0(b, l + 1);
    r = r && consumeToken(b, ENUM);
    r = r && enum_name(b, l + 1);
    r = r && enum_declaration_3(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && enum_declaration_5(b, l + 1);
    r = r && enum_declaration_6(b, l + 1);
    r = r && enum_declaration_7(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPORT?
  private static boolean enum_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_0")) return false;
    consumeToken(b, EXPORT);
    return true;
  }

  // nl?
  private static boolean enum_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean enum_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_5")) return false;
    nl(b, l + 1);
    return true;
  }

  // (enum_value (nl enum_value)*)?
  private static boolean enum_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_6")) return false;
    enum_declaration_6_0(b, l + 1);
    return true;
  }

  // enum_value (nl enum_value)*
  private static boolean enum_declaration_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_value(b, l + 1);
    r = r && enum_declaration_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl enum_value)*
  private static boolean enum_declaration_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_6_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_declaration_6_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_declaration_6_0_1", c)) break;
    }
    return true;
  }

  // nl enum_value
  private static boolean enum_declaration_6_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_6_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && enum_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean enum_declaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_7")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // named_identifier
  public static boolean enum_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    exit_section_(b, m, ENUM_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // named_identifier
  public static boolean enum_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    exit_section_(b, m, ENUM_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // typed_identifier
  public static boolean func_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_argument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typed_identifier(b, l + 1);
    exit_section_(b, m, FUNC_ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // nl? (func_argument (',' func_argument)*)? nl?
  static boolean func_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_arguments_0(b, l + 1);
    r = r && func_arguments_1(b, l + 1);
    r = r && func_arguments_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean func_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arguments_0")) return false;
    nl(b, l + 1);
    return true;
  }

  // (func_argument (',' func_argument)*)?
  private static boolean func_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arguments_1")) return false;
    func_arguments_1_0(b, l + 1);
    return true;
  }

  // func_argument (',' func_argument)*
  private static boolean func_arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_argument(b, l + 1);
    r = r && func_arguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' func_argument)*
  private static boolean func_arguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_arguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_arguments_1_0_1", c)) break;
    }
    return true;
  }

  // ',' func_argument
  private static boolean func_arguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && func_argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean func_arguments_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arguments_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // nl? (stmt (nl stmt)*)? nl?
  public static boolean func_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_BODY, "<func body>");
    r = func_body_0(b, l + 1);
    r = r && func_body_1(b, l + 1);
    r = r && func_body_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nl?
  private static boolean func_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body_0")) return false;
    nl(b, l + 1);
    return true;
  }

  // (stmt (nl stmt)*)?
  private static boolean func_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body_1")) return false;
    func_body_1_0(b, l + 1);
    return true;
  }

  // stmt (nl stmt)*
  private static boolean func_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt(b, l + 1);
    r = r && func_body_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl stmt)*
  private static boolean func_body_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_body_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_body_1_0_1", c)) break;
    }
    return true;
  }

  // nl stmt
  private static boolean func_body_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean func_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EXPORT? FUNC nl? function_name nl? '(' func_arguments ')' nl? ('->' nl? type_identifier)? nl? '{' func_body '}'
  public static boolean func_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration")) return false;
    if (!nextTokenIs(b, "<func declaration>", EXPORT, FUNC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_DECLARATION, "<func declaration>");
    r = func_declaration_0(b, l + 1);
    r = r && consumeToken(b, FUNC);
    r = r && func_declaration_2(b, l + 1);
    r = r && function_name(b, l + 1);
    r = r && func_declaration_4(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && func_arguments(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && func_declaration_8(b, l + 1);
    r = r && func_declaration_9(b, l + 1);
    r = r && func_declaration_10(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && func_body(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPORT?
  private static boolean func_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_0")) return false;
    consumeToken(b, EXPORT);
    return true;
  }

  // nl?
  private static boolean func_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_2")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean func_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_4")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean func_declaration_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_8")) return false;
    nl(b, l + 1);
    return true;
  }

  // ('->' nl? type_identifier)?
  private static boolean func_declaration_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_9")) return false;
    func_declaration_9_0(b, l + 1);
    return true;
  }

  // '->' nl? type_identifier
  private static boolean func_declaration_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RIGHT_ARROW);
    r = r && func_declaration_9_0_1(b, l + 1);
    r = r && type_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean func_declaration_9_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_9_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean func_declaration_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_declaration_10")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean function_call_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_CALL_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // named_identifier
  public static boolean function_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // call_expr | constructor_expr | variable | parenthesized_expr
  static boolean initial_reference_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initial_reference_expr")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, LEFT_PAREN)) return false;
    boolean r;
    r = call_expr(b, l + 1);
    if (!r) r = constructor_expr(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = parenthesized_expr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean named_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, NAMED_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE+
  public static boolean nl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nl")) return false;
    if (!nextTokenIs(b, NEW_LINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW_LINE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "nl", c)) break;
    }
    exit_section_(b, m, NL, r);
    return r;
  }

  /* ********************************************************** */
  // PACKAGE package_namespace ':' package_name ('@' package_version)?
  public static boolean package_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_declaration")) return false;
    if (!nextTokenIs(b, PACKAGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PACKAGE);
    r = r && package_namespace(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && package_name(b, l + 1);
    r = r && package_declaration_4(b, l + 1);
    exit_section_(b, m, PACKAGE_DECLARATION, r);
    return r;
  }

  // ('@' package_version)?
  private static boolean package_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_declaration_4")) return false;
    package_declaration_4_0(b, l + 1);
    return true;
  }

  // '@' package_version
  private static boolean package_declaration_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_declaration_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && package_version(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean package_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PACKAGE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean package_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_namespace")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PACKAGE_NAMESPACE, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER
  public static boolean package_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_version")) return false;
    if (!nextTokenIs(b, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    exit_section_(b, m, PACKAGE_VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // '(' nl? expr nl? ')'
  public static boolean parenthesized_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesized_expr")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARENTHESIZED_EXPR, null);
    r = consumeToken(b, LEFT_PAREN);
    p = r; // pin = 1
    r = r && report_error_(b, parenthesized_expr_1(b, l + 1));
    r = p && report_error_(b, expr(b, l + 1, -1)) && r;
    r = p && report_error_(b, parenthesized_expr_3(b, l + 1)) && r;
    r = p && consumeToken(b, RIGHT_PAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // nl?
  private static boolean parenthesized_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesized_expr_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean parenthesized_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesized_expr_3")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EXPORT? RECORD record_name nl? '{' nl? (record_field (nl record_field)*)? nl? '}'
  public static boolean record_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration")) return false;
    if (!nextTokenIs(b, "<record declaration>", EXPORT, RECORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_DECLARATION, "<record declaration>");
    r = record_declaration_0(b, l + 1);
    r = r && consumeToken(b, RECORD);
    r = r && record_name(b, l + 1);
    r = r && record_declaration_3(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && record_declaration_5(b, l + 1);
    r = r && record_declaration_6(b, l + 1);
    r = r && record_declaration_7(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPORT?
  private static boolean record_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_0")) return false;
    consumeToken(b, EXPORT);
    return true;
  }

  // nl?
  private static boolean record_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean record_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_5")) return false;
    nl(b, l + 1);
    return true;
  }

  // (record_field (nl record_field)*)?
  private static boolean record_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_6")) return false;
    record_declaration_6_0(b, l + 1);
    return true;
  }

  // record_field (nl record_field)*
  private static boolean record_declaration_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_field(b, l + 1);
    r = r && record_declaration_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl record_field)*
  private static boolean record_declaration_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_6_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!record_declaration_6_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "record_declaration_6_0_1", c)) break;
    }
    return true;
  }

  // nl record_field
  private static boolean record_declaration_6_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_6_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && record_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean record_declaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_declaration_7")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // typed_identifier
  public static boolean record_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_field")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typed_identifier(b, l + 1);
    exit_section_(b, m, RECORD_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // named_identifier
  public static boolean record_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    exit_section_(b, m, RECORD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // CONSTRUCTOR nl? '(' func_arguments ')' nl? '{' func_body '}'
  public static boolean resource_constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_constructor")) return false;
    if (!nextTokenIs(b, CONSTRUCTOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSTRUCTOR);
    r = r && resource_constructor_1(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && func_arguments(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && resource_constructor_5(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && func_body(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, RESOURCE_CONSTRUCTOR, r);
    return r;
  }

  // nl?
  private static boolean resource_constructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_constructor_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean resource_constructor_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_constructor_5")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EXPORT? RESOURCE resource_name nl? '{' nl? (resource_item (nl resource_item)*)? nl? '}'
  public static boolean resource_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration")) return false;
    if (!nextTokenIs(b, "<resource declaration>", EXPORT, RESOURCE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE_DECLARATION, "<resource declaration>");
    r = resource_declaration_0(b, l + 1);
    r = r && consumeToken(b, RESOURCE);
    r = r && resource_name(b, l + 1);
    r = r && resource_declaration_3(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && resource_declaration_5(b, l + 1);
    r = r && resource_declaration_6(b, l + 1);
    r = r && resource_declaration_7(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPORT?
  private static boolean resource_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_0")) return false;
    consumeToken(b, EXPORT);
    return true;
  }

  // nl?
  private static boolean resource_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean resource_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_5")) return false;
    nl(b, l + 1);
    return true;
  }

  // (resource_item (nl resource_item)*)?
  private static boolean resource_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_6")) return false;
    resource_declaration_6_0(b, l + 1);
    return true;
  }

  // resource_item (nl resource_item)*
  private static boolean resource_declaration_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = resource_item(b, l + 1);
    r = r && resource_declaration_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl resource_item)*
  private static boolean resource_declaration_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_6_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!resource_declaration_6_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "resource_declaration_6_0_1", c)) break;
    }
    return true;
  }

  // nl resource_item
  private static boolean resource_declaration_6_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_6_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && resource_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean resource_declaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_declaration_7")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // typed_identifier
  public static boolean resource_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_field")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typed_identifier(b, l + 1);
    exit_section_(b, m, RESOURCE_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // resource_field | resource_constructor | resource_method
  static boolean resource_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_item")) return false;
    boolean r;
    r = resource_field(b, l + 1);
    if (!r) r = resource_constructor(b, l + 1);
    if (!r) r = resource_method(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // FUNC nl? function_name nl? '(' func_arguments ')' nl? ('->' nl? type_identifier)? nl? '{' func_body '}'
  public static boolean resource_method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method")) return false;
    if (!nextTokenIs(b, FUNC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNC);
    r = r && resource_method_1(b, l + 1);
    r = r && function_name(b, l + 1);
    r = r && resource_method_3(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && func_arguments(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && resource_method_7(b, l + 1);
    r = r && resource_method_8(b, l + 1);
    r = r && resource_method_9(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && func_body(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, RESOURCE_METHOD, r);
    return r;
  }

  // nl?
  private static boolean resource_method_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean resource_method_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean resource_method_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method_7")) return false;
    nl(b, l + 1);
    return true;
  }

  // ('->' nl? type_identifier)?
  private static boolean resource_method_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method_8")) return false;
    resource_method_8_0(b, l + 1);
    return true;
  }

  // '->' nl? type_identifier
  private static boolean resource_method_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RIGHT_ARROW);
    r = r && resource_method_8_0_1(b, l + 1);
    r = r && type_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean resource_method_8_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method_8_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean resource_method_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_method_9")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // named_identifier
  public static boolean resource_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    exit_section_(b, m, RESOURCE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN expr
  public static boolean return_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_stmt")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, RETURN_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // variable_declaration_stmt | variable_assignment_stmt | call_stmt | return_stmt
  public static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, STMT, "<stmt>");
    r = variable_declaration_stmt(b, l + 1);
    if (!r) r = variable_assignment_stmt(b, l + 1);
    if (!r) r = call_stmt(b, l + 1);
    if (!r) r = return_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '"' (STRING_CONTENT | string_expression)* '"'
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && string_1(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, STRING, r);
    return r;
  }

  // (STRING_CONTENT | string_expression)*
  private static boolean string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_1", c)) break;
    }
    return true;
  }

  // STRING_CONTENT | string_expression
  private static boolean string_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_1_0")) return false;
    boolean r;
    r = consumeToken(b, STRING_CONTENT);
    if (!r) r = string_expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STRING_LEFT_PAREN expr STRING_RIGHT_PAREN
  public static boolean string_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_expression")) return false;
    if (!nextTokenIs(b, STRING_LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LEFT_PAREN);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, STRING_RIGHT_PAREN);
    exit_section_(b, m, STRING_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean type_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // named_identifier ':' type_identifier
  public static boolean typed_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_identifier(b, l + 1);
    exit_section_(b, m, TYPED_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS | EXCLAMETION
  static boolean unary_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_operator")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, EXCLAMETION);
    return r;
  }

  /* ********************************************************** */
  // USE use_namespace ':' use_package '/' use_interface '.' '{' nl? use_items nl? '}'
  public static boolean use_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_declaration")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USE);
    r = r && use_namespace(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && use_package(b, l + 1);
    r = r && consumeToken(b, SLASH);
    r = r && use_interface(b, l + 1);
    r = r && consumeTokens(b, 0, DOT, LEFT_BRACE);
    r = r && use_declaration_8(b, l + 1);
    r = r && use_items(b, l + 1);
    r = r && use_declaration_10(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, USE_DECLARATION, r);
    return r;
  }

  // nl?
  private static boolean use_declaration_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_declaration_8")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean use_declaration_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_declaration_10")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean use_interface(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_interface")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, USE_INTERFACE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean use_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_item")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, USE_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // use_item (nl? ',' nl? use_item)*
  static boolean use_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = use_item(b, l + 1);
    r = r && use_items_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl? ',' nl? use_item)*
  private static boolean use_items_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!use_items_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "use_items_1", c)) break;
    }
    return true;
  }

  // nl? ',' nl? use_item
  private static boolean use_items_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = use_items_1_0_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && use_items_1_0_2(b, l + 1);
    r = r && use_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean use_items_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_1_0_0")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean use_items_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_1_0_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean use_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_namespace")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, USE_NAMESPACE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean use_package(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_package")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, USE_PACKAGE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // reference_expr nl? '=' nl? expr
  public static boolean variable_assignment_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment_stmt")) return false;
    if (!nextTokenIs(b, "<variable assignment stmt>", IDENTIFIER, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_ASSIGNMENT_STMT, "<variable assignment stmt>");
    r = reference_expr(b, l + 1);
    r = r && variable_assignment_stmt_1(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && variable_assignment_stmt_3(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nl?
  private static boolean variable_assignment_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment_stmt_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean variable_assignment_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment_stmt_3")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (LET | VAR) nl? named_identifier nl? '=' nl? expr
  public static boolean variable_declaration_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_stmt")) return false;
    if (!nextTokenIs(b, "<variable declaration stmt>", LET, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DECLARATION_STMT, "<variable declaration stmt>");
    r = variable_declaration_stmt_0(b, l + 1);
    r = r && variable_declaration_stmt_1(b, l + 1);
    r = r && named_identifier(b, l + 1);
    r = r && variable_declaration_stmt_3(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && variable_declaration_stmt_5(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LET | VAR
  private static boolean variable_declaration_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_stmt_0")) return false;
    boolean r;
    r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, VAR);
    return r;
  }

  // nl?
  private static boolean variable_declaration_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_stmt_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean variable_declaration_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_stmt_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean variable_declaration_stmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_stmt_5")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EXPORT? VARIANT variant_name nl? '{' nl? (variant_value (nl variant_value)*)? nl? '}'
  public static boolean variant_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration")) return false;
    if (!nextTokenIs(b, "<variant declaration>", EXPORT, VARIANT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIANT_DECLARATION, "<variant declaration>");
    r = variant_declaration_0(b, l + 1);
    r = r && consumeToken(b, VARIANT);
    r = r && variant_name(b, l + 1);
    r = r && variant_declaration_3(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && variant_declaration_5(b, l + 1);
    r = r && variant_declaration_6(b, l + 1);
    r = r && variant_declaration_7(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPORT?
  private static boolean variant_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_0")) return false;
    consumeToken(b, EXPORT);
    return true;
  }

  // nl?
  private static boolean variant_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean variant_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_5")) return false;
    nl(b, l + 1);
    return true;
  }

  // (variant_value (nl variant_value)*)?
  private static boolean variant_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_6")) return false;
    variant_declaration_6_0(b, l + 1);
    return true;
  }

  // variant_value (nl variant_value)*
  private static boolean variant_declaration_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variant_value(b, l + 1);
    r = r && variant_declaration_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl variant_value)*
  private static boolean variant_declaration_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_6_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variant_declaration_6_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variant_declaration_6_0_1", c)) break;
    }
    return true;
  }

  // nl variant_value
  private static boolean variant_declaration_6_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_6_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && variant_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean variant_declaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_declaration_7")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // named_identifier
  public static boolean variant_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    exit_section_(b, m, VARIANT_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // named_identifier nl? '(' nl? (typed_identifier (nl? ',' nl? typed_identifier)*)? nl? ')'
  public static boolean variant_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_identifier(b, l + 1);
    r = r && variant_value_1(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && variant_value_3(b, l + 1);
    r = r && variant_value_4(b, l + 1);
    r = r && variant_value_5(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, VARIANT_VALUE, r);
    return r;
  }

  // nl?
  private static boolean variant_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean variant_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_3")) return false;
    nl(b, l + 1);
    return true;
  }

  // (typed_identifier (nl? ',' nl? typed_identifier)*)?
  private static boolean variant_value_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_4")) return false;
    variant_value_4_0(b, l + 1);
    return true;
  }

  // typed_identifier (nl? ',' nl? typed_identifier)*
  private static boolean variant_value_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typed_identifier(b, l + 1);
    r = r && variant_value_4_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl? ',' nl? typed_identifier)*
  private static boolean variant_value_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variant_value_4_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variant_value_4_0_1", c)) break;
    }
    return true;
  }

  // nl? ',' nl? typed_identifier
  private static boolean variant_value_4_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_4_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variant_value_4_0_1_0_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && variant_value_4_0_1_0_2(b, l + 1);
    r = r && typed_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean variant_value_4_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_4_0_1_0_0")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean variant_value_4_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_4_0_1_0_2")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean variant_value_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_value_5")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // nl? package_declaration nl? (declaration (nl declaration)*)? nl?
  static boolean wtfFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile")) return false;
    if (!nextTokenIs(b, "", NEW_LINE, PACKAGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wtfFile_0(b, l + 1);
    r = r && package_declaration(b, l + 1);
    r = r && wtfFile_2(b, l + 1);
    r = r && wtfFile_3(b, l + 1);
    r = r && wtfFile_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean wtfFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile_0")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean wtfFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile_2")) return false;
    nl(b, l + 1);
    return true;
  }

  // (declaration (nl declaration)*)?
  private static boolean wtfFile_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile_3")) return false;
    wtfFile_3_0(b, l + 1);
    return true;
  }

  // declaration (nl declaration)*
  private static boolean wtfFile_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = declaration(b, l + 1);
    r = r && wtfFile_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nl declaration)*
  private static boolean wtfFile_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wtfFile_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wtfFile_3_0_1", c)) break;
    }
    return true;
  }

  // nl declaration
  private static boolean wtfFile_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && declaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean wtfFile_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wtfFile_4")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: PREFIX(unary_expr)
  // 1: BINARY(binary_expr)
  // 2: ATOM(reference_expr)
  // 3: ATOM(literal_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_expr(b, l + 1);
    if (!r) r = reference_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && binary_expr_0(b, l + 1)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, BINARY_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean unary_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = unary_operator(b, l + 1);
    p = r;
    r = p && expr(b, l, 0);
    exit_section_(b, l, m, UNARY_EXPR, r, p, null);
    return r || p;
  }

  // binary_operator nl?
  private static boolean binary_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary_operator(b, l + 1);
    r = r && binary_expr_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean binary_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expr_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // initial_reference_expr (nl? DOT nl? (call_expr | IDENTIFIER))*
  public static boolean reference_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_expr")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, REFERENCE_EXPR, "<reference expr>");
    r = initial_reference_expr(b, l + 1);
    r = r && reference_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (nl? DOT nl? (call_expr | IDENTIFIER))*
  private static boolean reference_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!reference_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "reference_expr_1", c)) break;
    }
    return true;
  }

  // nl? DOT nl? (call_expr | IDENTIFIER)
  private static boolean reference_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_expr_1_0_0(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && reference_expr_1_0_2(b, l + 1);
    r = r && reference_expr_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean reference_expr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_expr_1_0_0")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean reference_expr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_expr_1_0_2")) return false;
    nl(b, l + 1);
    return true;
  }

  // call_expr | IDENTIFIER
  private static boolean reference_expr_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_expr_1_0_3")) return false;
    boolean r;
    r = call_expr(b, l + 1);
    if (!r) r = consumeTokenSmart(b, IDENTIFIER);
    return r;
  }

  // INTEGER
  //     | FLOAT
  //     | string
  //     | TRUE
  //     | FALSE
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeTokenSmart(b, INTEGER);
    if (!r) r = consumeTokenSmart(b, FLOAT);
    if (!r) r = string(b, l + 1);
    if (!r) r = consumeTokenSmart(b, TRUE);
    if (!r) r = consumeTokenSmart(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
