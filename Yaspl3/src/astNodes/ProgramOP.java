package astNodes;

import java.util.ArrayList;

import org.w3c.dom.Element;

import lexical.SymbolTable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class ProgramOP implements Visitable {

	private ArrayList<Decls> decs = new ArrayList<>();
	private ArrayList<Statment> statments = new ArrayList<>();
	private SymbolTable symTable;
	private String nodeType; 


	public ProgramOP(ArrayList<Decls>d, ArrayList<Statment>s ) throws Exception {
		decs =d;
		statments =s;	
		this.nodeType= "void";

	}
		
	public ProgramOP(ArrayList<Decls> decs, ArrayList<Statment> statments, SymbolTable symTable) {
		super();
		this.decs = decs;
		this.statments = statments;
		this.symTable = symTable;
		this.nodeType= "void";
	}
	
	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public SymbolTable getSymTable() {
		return symTable;
	}

	public void setSymTable(SymbolTable symTable) {
		this.symTable = symTable;
	}

	public ArrayList<Decls> getDecs() {
		return decs;
	}

	public void setDecs(ArrayList<Decls> decs) {
		this.decs = decs;
	}

	public ArrayList<Statment> getStatments() {
		return statments;
	}

	public void setStatments(ArrayList<Statment> statments) {
		this.statments = statments;
	}
	
	public Document buildXMLast(Document doc) {
		
		
		Element e = doc.createElement("ProgramOP");
		
		//System.out.println("size: "+ decs.size()+"  "+ statments.size());
		
		for(Decls d: decs ){
			e.appendChild(d.buildXMLNode(doc));
		}
		
		for(Statment s: statments ){
			e.appendChild(s.buildXMLNode(doc));

		}
		doc.appendChild(e);
		
		return doc;
	}

	@Override
	public String toString() {
		return "ProgramOP [decs:\n" + decs + ", statments:\n" + statments + "]\n";
	}

	@Override
	public void accept(Visitor visitor) {
		
		if(visitor instanceof XMLBuilder) {
			buildXMLast(((XMLBuilder)visitor).getDocument());
		 //((XMLBuilder)visitor).visit(this);
		 }
		
		if(visitor instanceof SemanticVisitor) {
			 ((SemanticVisitor)visitor).visit(this);
			}
		
		if(visitor instanceof CBuilder) {
			 ((CBuilder)visitor).visit(this);
			}
	}
	
}
