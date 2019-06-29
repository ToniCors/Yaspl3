package lexical;
import java_cup.runtime.Symbol;
import java.lang.Integer;
import parser.*;
import java.util.HashMap;
import java.io.*;
import astNodes.Identifier;
import exception.MultipleDeclaretionException;
 




%% 

										// Declarations for JFlex
%unicode 								// We wish to read text files
%cupsym parser.CircuitSym
%cup 									// Declare that we expect to use Java CUP
%class Lexer
%public
%line
%column 


%{
private SymbolTable symbolTable;

  /**
   * Creates a new scanner with symbol table inizialization.
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   * @param   inizialize  is @true if the symbolTable must be inizialized, @false otherwise
   */
  public Lexer(java.io.Reader in,  boolean inizialize) {
    this.zzReader = in;
    if(inizialize)
    symbolTable = new SymbolTable("Lexexr");
  }

  /**
   * Creates a new scanner with symbol table inizialization.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   * @param   inizialize  is @true if the symbolTable must be inizialized, @false otherwise
   */
  public Lexer(java.io.InputStream in, boolean inizialize) {
    this(new java.io.InputStreamReader(in));
    if(inizialize)
    symbolTable = new SymbolTable("Lexexr");
  }


	public void cleanSymbolTable() throws IOException{
	
		symbolTable = new SymbolTable("Lexexr");
		
	} 
	
	public SymbolTable getSymbolTable(){

		return symbolTable;
	}
	
	
	
%}
										// Abbreviations for regular expressions
whitespace = [ \n\r\t]
comment=("/*" [^*] ~"*/" | "/*" "*"+ "/")|("//"~"\r")

integer = ([1-9][0-9]*)|(0)
decimal= ("."([1-9]*[0-9]*[1-9]) | "."0)
esponent= "E"{integer}{decimal}?
numbers = {integer}{decimal}?{esponent}?  

id = [:jletter:] [:jletterdigit:]*

stringConst = \"[^\"]*\"
charEscape = (\'\\n\')|(\'\\r\')|(\'\\t\')|(\'\\f\')|(\'\\b\')
charConst = \'[^']\' | {charEscape}

%%

{comment}	{ /* ignore */ }
{whitespace} { /* ignore */ }
 

"head" {return new Symbol  (CircuitSym.HEAD, yyline, yycolumn );}

"start" { return new Symbol(CircuitSym.START, yyline, yycolumn ,yytext());}
"def" { return new Symbol(CircuitSym.DEF, yyline, yycolumn ,yytext());}
"int" {return new Symbol(CircuitSym.INT, yyline, yycolumn ,yytext()); }
"bool" { return new Symbol(CircuitSym.BOOL, yyline, yycolumn ,yytext()); }
"double" { return new Symbol(CircuitSym.DOUBLE, yyline, yycolumn ,yytext()); }
"string" { return new Symbol(CircuitSym.STRING, yyline, yycolumn ,yytext()); }
"char" { return new Symbol(CircuitSym.CHAR, yyline, yycolumn ,yytext()); }
"true" { return new Symbol(CircuitSym.TRUE, yyline, yycolumn ,yytext()); }
"false"  { return new Symbol(CircuitSym.FALSE, yyline, yycolumn ,yytext()); }
"if" { return new Symbol(CircuitSym.IF, yyline, yycolumn ,yytext()); }
"then" { return new Symbol(CircuitSym.THEN, yyline, yycolumn ,yytext()); }
"while" { return new Symbol(CircuitSym.WHILE, yyline, yycolumn ,yytext()); }
"do" { return new Symbol(CircuitSym.DO, yyline, yycolumn ,yytext()); }
"else" { return new Symbol(CircuitSym.ELSE, yyline, yycolumn ,yytext()); }

";" {return new Symbol(CircuitSym.SEMI, yyline, yycolumn ,yytext()); }
"," { return new Symbol(CircuitSym.COMMA, yyline, yycolumn ,yytext()); }
"(" {return new Symbol(CircuitSym.LPAR, yyline, yycolumn ,yytext()); }
")" {return new Symbol(CircuitSym.RPAR, yyline, yycolumn ,yytext()); }
"{" {return new Symbol(CircuitSym.LGPAR, yyline, yycolumn ,yytext()); }
"}" {return new Symbol(CircuitSym.RGPAR, yyline, yycolumn ,yytext()); }
"<-" {return new Symbol(CircuitSym.READ, yyline, yycolumn ,yytext()); }
"->" {return new Symbol(CircuitSym.WRITE, yyline, yycolumn ,yytext()); }
"+" { return new Symbol(CircuitSym.PLUS, yyline, yycolumn ,yytext()); }
"-" { return new Symbol(CircuitSym.MINUS, yyline, yycolumn ,yytext()); }
"*" { return new Symbol(CircuitSym.TIMES, yyline, yycolumn ,yytext()); }
"/" { return new Symbol(CircuitSym.DIV, yyline, yycolumn ,yytext()); }
"=" { return new Symbol(CircuitSym.ASSIGN, yyline, yycolumn ,yytext()); }
">" { return new Symbol(CircuitSym.GT, yyline, yycolumn ,yytext()); }
">=" { return new Symbol(CircuitSym.GE, yyline, yycolumn ,yytext()); }
"<" { return new Symbol(CircuitSym.LT, yyline, yycolumn ,yytext()); }
"<=" { return new Symbol(CircuitSym.LE, yyline, yycolumn ,yytext()); }
"==" { return new Symbol(CircuitSym.EQ, yyline, yycolumn ,yytext()); }

"not" { return new Symbol(CircuitSym.NOT, yyline, yycolumn ,yytext()); }
"and" { return new Symbol(CircuitSym.AND, yyline, yycolumn ,yytext()); }
"or" { return new Symbol(CircuitSym.OR, yyline, yycolumn ,yytext()); }

"in" { return new Symbol(CircuitSym.IN, yyline, yycolumn ,yytext()); }
"out" { return new Symbol(CircuitSym.OUT, yyline, yycolumn ,yytext()); }
"inout" { return new Symbol(CircuitSym.INOUT, yyline, yycolumn ,yytext()); }

{integer} { return new Symbol(CircuitSym.INT_CONST, yyline, yycolumn ,yytext()); }
{numbers}  { return new Symbol(CircuitSym.DOUBLE_CONST, yyline, yycolumn ,yytext()); }

{stringConst} {return new Symbol(CircuitSym.STRING_CONST, yyline, yycolumn ,yytext()); }
{charConst} { return new Symbol(CircuitSym.CHAR_CONST, yyline, yycolumn ,yytext()); }

{id}		{ /*try {System.out.print("Lexer...");symbolTable.installID(new Identifier(yytext()));} catch (MultipleDeclaretionException e) {
					} */return new Symbol(CircuitSym.ID, yyline, yycolumn ,yytext());}
 
[^]			{System.out.println("ERRORE....."+yytext() +" "+yyline+" "+yycolumn );  return new Symbol(CircuitSym.error);}

<<EOF>> {return new Symbol(CircuitSym.EOF);} 
