import java_cup.runtime.*;
import java.util.Vector;
import java.lang.String;

%%

%class Lexer
%line
%column
%unicode
%standalone

%{
	public void yyerror()
	{
    	System.out.println("error line " + yyline + " column " + yycolumn + " " + yytext());
	}
%}

/* models */

ALPHA=[A-z]
DIGIT=[0-9]

IDENTIFICATOR={ALPHA}({ALPHA}|{DIGIT})*
NEWLINE=\r|\n|\r\n

CONSTANTEENT={DIGIT}+
CONSTANTECHAINE=[\"]([^\"]|\"\")*[\"]
COMMENTAIRE=\/\/.*


%%
/* rules */


/*{IDENTIFICATOR}		{return new Symbol(sym.IDENTIFICATOR, new String(yytext()));}
{CONSTANTEENT} 		{return new Symbol(sym.CONSTANTEENT, new Integer(yytext()));}
{CONSTANTECHAINE}	{return new Symbol(sym.CONSTANTECHAINE, new String(yytext()));}
{COMMENTAIRE}	{return new Symbol(sym.COMMENTAIRE, new String(yytext()));}*/

{IDENTIFICATOR}		{System.out.println(new String(yytext()));}
{CONSTANTEENT} 		{System.out.println(new String(yytext()));}
{CONSTANTECHAINE}	{System.out.println(new String(yytext()));}
{COMMENTAIRE}			{System.out.println(new String(yytext()));}

{NEWLINE}	{;}
.			{;}
