package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " { }
"\b" { }
"\t" { }
"\r\n" { }
"\f" { }

"program" { return new_symbol(sym.PROGRAM, yytext()); }
"break"	  { return new_symbol(sym.BREAK, yytext()); }
"class"	  { return new_symbol(sym.CLASS, yytext()); }
"true" { return new_symbol(sym.BOOLCONST, "true"); }
"false" { return new_symbol(sym.BOOLCONST, "false"); }
"enum"	  { return new_symbol(sym.ENUM, yytext()); }
"else"	  { return new_symbol(sym.ELSE, yytext()); }
"const"	  { return new_symbol(sym.CONST, yytext()); }
"if"	  { return new_symbol(sym.IF, yytext()); }
"do"	  { return new_symbol(sym.DO, yytext()); }
"while"	  { return new_symbol(sym.WHILE, yytext()); }
"new"	  { return new_symbol(sym.NEW, yytext()); }
"print"	  { return new_symbol(sym.PRINT, yytext()); }
"read"	  { return new_symbol(sym.READ, yytext()); }
"return"  { return new_symbol(sym.RETURN, yytext()); }
"void"	  { return new_symbol(sym.VOID, yytext()); }
"extends" { return new_symbol(sym.EXTENDS, yytext()); }
"continue" { return new_symbol(sym.CONTINUE, yytext()); }
"record"  { return new_symbol(sym.RECORD, yytext()); }
"+"	  	  { return new_symbol(sym.PLUS, yytext()); }
"-"	  { return new_symbol(sym.MINUS, yytext()); }
"*"	  { return new_symbol(sym.MUL, yytext()); }
"/"	  { return new_symbol(sym.DIV, yytext()); }
"%"	  { return new_symbol(sym.MOD, yytext()); }
"=="	  { return new_symbol(sym.EQUAL, yytext()); }
"!="	  { return new_symbol(sym.NEQUAL, yytext()); }
">"	  { return new_symbol(sym.GREATER, yytext()); }
">="	  { return new_symbol(sym.GEQ, yytext()); }
"<"	  { return new_symbol(sym.LOWER, yytext()); }
"<="	  { return new_symbol(sym.LEQ, yytext()); }
"&&"	  { return new_symbol(sym.AND, yytext()); }
"||"	  { return new_symbol(sym.OR, yytext()); }
"="	  { return new_symbol(sym.ASSIGN, yytext()); }
"++"	  { return new_symbol(sym.INC, yytext()); }
"--"	  { return new_symbol(sym.DEC, yytext()); }
";"	  { return new_symbol(sym.SEMICOLON, yytext()); }
":"	  { return new_symbol(sym.COLON, yytext()); }
","	  { return new_symbol(sym.COMMA, yytext()); }
"."	  { return new_symbol(sym.STOP, yytext()); }
"("	  { return new_symbol(sym.LPAREN, yytext()); }
")"	  { return new_symbol(sym.RPAREN, yytext()); }
"["	  { return new_symbol(sym.LBOX, yytext()); }
"]"	  { return new_symbol(sym.RBOX, yytext()); }
"{"	  { return new_symbol(sym.LBRACES, yytext()); }
"}"	  { return new_symbol(sym.RBRACES, yytext()); }
"??"	  { return new_symbol(sym.COALESCE, yytext()); }

"//"	  { yybegin(COMMENT); }
<COMMENT> . { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

'.' { return new_symbol(sym.CHARCONST, yytext().charAt(1)); }
'\\n' { return new_symbol(sym.CHARCONST, yytext()); } 
[0-9]+  { return new_symbol(sym.NUMCONST, new Integer (yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }

. {System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }



