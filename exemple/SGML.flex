import java_cup.runtime.*;
import java.util.Vector;
import java.lang.String;

%%

%class Lexer 
%line
%column
%unicode
%cup

%{
	public void yyerror() 
	{
    	System.out.println("error line " + yyline + " column " + yycolumn + " " + yytext());
	}
%}

/* models */

ALPHA=[A-z]
DIGIT=[0-9]
NUMBER=-?{DIGIT}+(,|\.)?{DIGIT}*
NAME={ALPHA}+
IDENTIFICATOR={ALPHA}({ALPHA}|{DIGIT}|_)*\=
VALUE=\"{NUMBER}\"

NEWLINE=\r|\n|\r\n

%%
/* rules */

"#if"				{return new Symbol(sym.IF);}
"#set"				{return new Symbol(sym.SET);}
"<"					{return new Symbol(sym.OPENTAG);}
"<\/"				{return new Symbol(sym.CLOSURE);}
">" 				{return new Symbol(sym.CLOSETAG);}
"\/>"				{return new Symbol(sym.CLOSEINLINE);}
{IDENTIFICATOR}		{return new Symbol(sym.IDENTIFICATOR, new String(yytext().substring(0, yytext().length() - 1)));}
{VALUE}		 		{return new Symbol(sym.VALUE, new Double(yytext().substring(1, yytext().length() - 1)));}
{NAME} 				{return new Symbol(sym.NAME, yytext());}

{NEWLINE}	{;}
.			{;}

