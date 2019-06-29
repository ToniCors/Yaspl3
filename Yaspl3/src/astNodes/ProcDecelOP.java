package astNodes;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import lexical.SymbolTable;
import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class ProcDecelOP extends Decls implements Visitable{
	
	private Identifier id;
	private ArrayList<ParOP> pars;
	private BodyOP body;
	
	private SymbolTable symTable;
	private String nodeType; 

	
	public ProcDecelOP(Identifier id, ArrayList<ParOP> pars, BodyOP b) {
		super();
		this.id = id;
		this.pars = pars;
		this.body = b;
		this.nodeType="void";

		
	}
	
	public ProcDecelOP(Identifier id, ArrayList<ParOP> pars, BodyOP b, SymbolTable symTable) {
		super();
		this.id = id;
		this.pars = pars;
		this.body = b;
		this.symTable = symTable;
		this.nodeType="void";

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

	public Identifier getId() {
		return id;
	}
	public void setId(Identifier id) {
		this.id = id;
	}
	public ArrayList<ParOP> getPars() {
		return pars;
	}
	public void setPars(ArrayList<ParOP> pars) {
		this.pars = pars;
	}
	public BodyOP getBody() {
		return body;
	}
	public void setBody(BodyOP b) {
		this.body = b;
	}
	
	public Element buildXMLNode(Document doc) {
		Element e = doc.createElement("ProcDecel_op");
		
		Element i3 = doc.createElement("Id");
		i3.appendChild(doc.createTextNode(id.getNameId()));
		e.appendChild(i3);
		
		if(pars==null) {
			//System.out.println("pars is null........");
		}
		for(ParOP p : pars) {
			
			e.appendChild(p.buildXMLNode(doc));

		}
		
		e.appendChild(body.buildXMLNode(doc));

			return e;		}


	@Override
	public String toString() {
		return "ProcDecelOP [id=" + id + ", pars=" + pars + ", b=" + body + "]";
	}
	
	@Override
	public void accept(Visitor visitor) {
		
		if(visitor instanceof XMLBuilder) {
		 ((XMLBuilder)visitor).visit(this);
		 }
		
		if(visitor instanceof SemanticVisitor) {
			 ((SemanticVisitor)visitor).visit(this);
			}
		
		if(visitor instanceof CBuilder) {
			 ((CBuilder)visitor).visit(this);
			}
	}
	
	

}
