
package main;

import org.omg.CosNaming.IstringHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import astNodes.Decls;
import astNodes.ProcDecelOP;
import astNodes.ProgramOP;
import astNodes.VarDecelOP;
import astNodes.VarInitOP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import lexical.Lexer;
import parser.CBuilder;
import parser.CircuitCup;
import parser.SemanticVisitor;
import parser.XMLBuilder;

public class ParserTest {
	
	//file di test
	
	//correct 0-2
	//wrong 0-4
	public static int index= 4;	
	
	public static String correct = "TestFile/inputC"+index+".txt";	
	public static String wrong = "TestFile/inputW"+index+".txt";
	
	public static String consegna4 = "TestEser4.txt";
	public static String consegna5 = "TestEser5.txt";

	
	public static String filePath = consegna5;
	
	public static String filePathAST = "namingError.err";
	public static String filePathSource = "namingError.err";

	public static void main(String[] args) throws Exception {
		
		String InputPrefix="";
	   	
		//linea di comando
		
		/* 
		String preInputPrefix = args[0].split("\\.")[0]; 
		String[] temp = preInputPrefix.split("/");
		InputPrefix= temp[temp.length-1];
		

		filePathAST = "/root/Scrivania/eclipse_workspace/AntonioCorsuto/outputFile/Ast/"+InputPrefix+"AST.xml";
		filePathSource = "/root/Scrivania/eclipse_workspace/AntonioCorsuto/outputFile/SourceC/"+InputPrefix+"Source.c";
		
		filePath = args[0];
		
		System.out.println("Parsing Start of file"+InputPrefix+"......\n");
		System.out.println("output Ast file Name: "+ filePathAST);		
		System.out.println("oputput Source file Name: "+ filePathSource);
		 
		 */
		
	   	/*prova in locale senza args....*/
		
		System.out.println("stai analizzando il file "+filePath);
		FileReader fr = new FileReader(new File(filePath));
		
		String preInputPrefix = filePath.split("\\.")[0]; 
		//String[] temp = preInputPrefix.split("/");
		InputPrefix= preInputPrefix;
		
		
		
		filePathAST= InputPrefix+"Ast.xml";
		filePathSource=InputPrefix+"Source.c";
		
	   	
	   	
	   	
	   	
	   	
		
	   	Lexer yy = new Lexer(fr, true);
		CircuitCup p = new CircuitCup(yy);
		ProgramOP prog = (ProgramOP) p.parse().value;
		
		//stampo a video il risulato del parsing...
		//System.out.println("Resistance is: \n\n "+ prog);

		//stampo l'ast in formato xml....
		XMLBuilder xmlB = new XMLBuilder();
		prog.accept(xmlB);	
		xmlB.exportDocument(new File(filePathAST));

		
		//eseguo l'analisi semantica
		System.out.println("\n Inizio seantica..... \n");		
		SemanticVisitor semanticVisitor = new SemanticVisitor();
		prog.accept(semanticVisitor);
		
		System.out.println("\n Inizio costruzione C..... \n");
		
		//File outputC = new File("compilato.c");
		File outputC = new File(filePathSource);
		CBuilder cBuilder = new CBuilder(outputC);
		prog.accept(cBuilder);
		
		
	}

}
