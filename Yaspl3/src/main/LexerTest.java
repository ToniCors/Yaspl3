package main;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import astNodes.Identifier;
import java_cup.runtime.Symbol;
import lexical.Lexer;
import lexical.SymbolTable;
import parser.CircuitSym;

// Circuit.java
//
// Code to join lexer and parser for circuit description language.
//
// Ian Stark

public class LexerTest {
	
	
	private SymbolTable s = new SymbolTable("Lexexr");
	
	public static void main(String[] args) throws Exception {
		
	   	System.out.println("Type in input, hit Return");
		System.out.println("To finish hit Return then Ctrl-Z (or Ctrl-D on a MacOSX)");
		System.out.println("(if it does not finish, before Ctrl-Z/D give focus to another window first)");
		System.out.println("----------------------------------------------");
		System.out.println("");

		
		FileReader fr = new FileReader(new File("PROGRAMMA1.txt"));
				
	   	Lexer yy = new Lexer(fr, true);
	   	
	   	SymbolTable symTable = yy.getSymbolTable();
	    
	   
	   	if(symTable == null) {
	   		System.out.println("symbol table is not inizialized !");
	   	}else {
	   		System.out.println("symbol table is inizialized !");
	   	}
	   	
	   	


	   	
	   	for(int tokenId= yy.next_token().sym; tokenId != CircuitSym.EOF && tokenId != CircuitSym.error; tokenId  = yy.next_token().sym) {
	   		System.out.println("lexem discovered: "+ yy.yytext()+"\n-TOKEN- returned is: ("+ CircuitSym.terminalNames[tokenId] +")\n");
	   	}
	   	
	   	
		System.out.println("****************** symbol table printing....*********************");
		//HashMap<String, Symbol> hm =  lexicalAnalyzer.getSymbolTable();
			
		for (String name: symTable.keySet()){
			
            String key =name.toString();
            Identifier value = (Identifier)symTable.get(name); 
            
            
            System.out.println(key + " (ID,"+value.getNameId()+")");  
		}
		
	}
}

