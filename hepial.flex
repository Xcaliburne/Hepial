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
	public Boolean debug = false;
	public void yyerror()
	{
    	System.out.println("error line " + yyline + " column " + yycolumn + " " + yytext());
	}
	
	public int getLine(){
		return yyline;
	}
	
	public void print(String text){
		if (debug){
			System.out.println(text);
		}
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

/*{IDENTIFICATOR}	{print("IDENTIFICATOR");return new Symbol(sym.IDENTIFICATOR, new String(yytext()));}
{CONSTANTEENT} 		{print("CONSTANTEENT");return new Symbol(sym.CONSTANTEENT, new Integer(yytext()));}
{CONSTANTECHAINE}	{print("CONSTANTECHAINE");return new Symbol(sym.CONSTANTECHAINE, new String(yytext()));}
{COMMENTAIRE}		{print("COMMENTAIRE"));return new Symbol(sym.COMMENTAIRE, new String(yytext()));}*/

";"					{print("POINTVIRGULE");return new Symbol(sym.POINTVIRGULE);}
","					{print("VIRGULE");return new Symbol(sym.VIRGULE);}
"["					{print("CROCHETOUVERT");return new Symbol(sym.CROCHETOUVERT);}
"]"					{print("CROCHETFERME");return new Symbol(sym.CROCHETFERME);}
"("					{print("PARENTHESEOUVERT");return new Symbol(sym.PARENTHESEOUVERT);}
")"					{print("PARENTHESEFERME");return new Symbol(sym.PARENTHESEFERME);}
"+"					{print("PLUS");return new Symbol(sym.PLUS);}
"-"					{print("MOINS");return new Symbol(sym.MOINS);}
"*"					{print("FOIS");return new Symbol(sym.FOIS);}
"/"					{print("DIVISE");return new Symbol(sym.DIVISE);}
"=="				{print("EGALITE");return new Symbol(sym.EGALITE);}
"<>"				{print("DIFFERENCE");return new Symbol(sym.DIFFERENCE);}
"<"					{print("PLUSPETIT");return new Symbol(sym.PLUSPETIT);}
">"					{print("PLUSGRAND");return new Symbol(sym.PLUSGRAND);}
">="				{print("PLUSGRANDEGAL");return new Symbol(sym.PLUSGRANDEGAL);}
"<="				{print("PLUSPETITEGAL");return new Symbol(sym.PLUSPETITEGAL);}
"="					{print("EGAL");return new Symbol(sym.EGAL);}
"~"					{print("TILDE");return new Symbol(sym.TILDE);}
".."				{print("RANGE");return new Symbol(sym.RANGE);}
"debutprg"			{print("DEBUTPRG");return new Symbol(sym.DEBUTPRG);}
"finprg"			{print("FINPRG");return new Symbol(sym.FINPRG);}
"programme"			{print("PROG");return new Symbol(sym.PROG);}
"constante"			{print("CONSTANTE");return new Symbol(sym.CONSTANTE);}
"debutfonc"			{print("DEBUTFONC");return new Symbol(sym.DEBUTFONC);}
"finfonc"			{print("FINFONC");return new Symbol(sym.FINFONC);}
"entier"			{print("ENTIER");return new Symbol(sym.ENTIER);}
"booleen"			{print("BOOLEEN");return new Symbol(sym.BOOLEEN);}
"lire"				{print("LIRE");return new Symbol(sym.LIRE);}
"ecrire"			{print("ECRIRE");return new Symbol(sym.ECRIRE);}
"retourne"			{print("RETOURNE");return new Symbol(sym.RETOURNE);}
"si"				{print("SI");return new Symbol(sym.SI);}
"alors"				{print("ALORS");return new Symbol(sym.ALORS);}
"sinon"				{print("SINON");return new Symbol(sym.SINON);}
"finsi"				{print("FINSI");return new Symbol(sym.FINSI);}
"tantque"			{print("TANTQUE");return new Symbol(sym.TANTQUE);}
"faire"				{print("FAIRE");return new Symbol(sym.FAIRE);}
"fintantque"		{print("FINTANTQUE");return new Symbol(sym.FINTANTQUE);}
"pour"				{print("POUR");return new Symbol(sym.POUR);}
"allantde"			{print("ALLANTDE");return new Symbol(sym.ALLANTDE);}
"vrai"				{print("VRAI");return new Symbol(sym.VRAI);}
"faux"				{print("FAUX");return new Symbol(sym.FAUX);}
"a"					{print("A");return new Symbol(sym.A);}
"finpour"			{print("FNPOUR");return new Symbol(sym.FINPOUR);}
"ou"				{print("OU");return new Symbol(sym.OU);}
"et"				{print("ET");return new Symbol(sym.ET);}
"non"				{print("NON");return new Symbol(sym.NON);}
{IDENTIFICATOR}		{print("IDENTIFICATOR"); return new Symbol(sym.IDENTIFICATOR, new String(yytext()));}
{CONSTANTEENT} 		{print("CONSTANTEENT"); return new Symbol(sym.CONSTANTEENT, new Integer(yytext()));}
{CONSTANTECHAINE}	{print("CONSTANTECHAINE"); return new Symbol(sym.CONSTANTECHAINE, new String(yytext()));}
{COMMENTAIRE}		{/*print("");*/}

{NEWLINE}	{;}
.			{;}
