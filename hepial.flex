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
	
	public int getLine(){
		return yyline;
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

/*{IDENTIFICATOR}	{return new Symbol(sym.IDENTIFICATOR, new String(yytext()));}
{CONSTANTEENT} 		{return new Symbol(sym.CONSTANTEENT, new Integer(yytext()));}
{CONSTANTECHAINE}	{return new Symbol(sym.CONSTANTECHAINE, new String(yytext()));}
{COMMENTAIRE}		{return new Symbol(sym.COMMENTAIRE, new String(yytext()));}*/

";"					{return new Symbol(sym.POINTVIRGULE);}
","					{return new Symbol(sym.VIRGULE);}
"["					{return new Symbol(sym.CROCHETOUVERT);}
"]"					{return new Symbol(sym.CROCHETFERME);}
"("					{return new Symbol(sym.PARENTHESEOUVERT);}
")"					{return new Symbol(sym.PARENTHESEFERME);}
"+"					{return new Symbol(sym.PLUS);}
"-"					{return new Symbol(sym.MOINS);}
"*"					{return new Symbol(sym.FOIS);}
"/"					{return new Symbol(sym.DIVISE);}
"=="				{return new Symbol(sym.EGALITE);}
"<>"				{return new Symbol(sym.DIFFERENCE);}
"<"					{return new Symbol(sym.PLUSPETIT);}
">"					{return new Symbol(sym.PLUSGRAND);}
">="				{return new Symbol(sym.PLUSGRANDEGAL);}
"<="				{return new Symbol(sym.PLUSPETITEGAL);}
"="					{return new Symbol(sym.EGAL);}
"~"					{return new Symbol(sym.TILDE);}
".."				{return new Symbol(sym.RANGE);}
"debutprg"			{return new Symbol(sym.DEBUTPRG);}
"finprg"			{return new Symbol(sym.FINPRG);}
"programme"			{return new Symbol(sym.PROG);}
"constante"			{return new Symbol(sym.CONSTANTE);}
"debutfonc"			{return new Symbol(sym.DEBUTFONC);}
"finfonc"			{return new Symbol(sym.FINFONC);}
"entier"			{return new Symbol(sym.ENTIER);}
"booleen"			{return new Symbol(sym.BOOLEEN);}
"lire"				{return new Symbol(sym.LIRE);}
"ecrire"			{return new Symbol(sym.ECRIRE);}
"retourne"			{return new Symbol(sym.RETOURNE);}
"si"				{return new Symbol(sym.SI);}
"alors"				{return new Symbol(sym.ALORS);}
"sinon"				{return new Symbol(sym.SINON);}
"finsi"				{return new Symbol(sym.FINSI);}
"tantque"			{return new Symbol(sym.TANTQUE);}
"faire"				{return new Symbol(sym.FAIRE);}
"fintantque"		{return new Symbol(sym.FINTANTQUE);}
"pour"				{return new Symbol(sym.POUR);}
"allantde"			{return new Symbol(sym.ALLANTDE);}
"vrai"			{return new Symbol(sym.VRAI);}
"faux"			{return new Symbol(sym.FAUX);}
"a"					{return new Symbol(sym.A);}
"finpour"			{return new Symbol(sym.FINPOUR);}
"ou"				{return new Symbol(sym.OU);}
"et"				{return new Symbol(sym.ET);}
"non"				{return new Symbol(sym.NON);}
{IDENTIFICATOR}		{/*System.out.println(yytext());*/ return new Symbol(sym.IDENTIFICATOR, new String(yytext()));}
{CONSTANTEENT} 		{/*System.out.println(yytext());*/ return new Symbol(sym.CONSTANTEENT, new Integer(yytext()));}
{CONSTANTECHAINE}	{/*System.out.println(yytext());*/ return new Symbol(sym.CONSTANTECHAINE, new String(yytext()));}
{COMMENTAIRE}		{/*System.out.println(yytext());*/}

{NEWLINE}	{;}
.			{;}
