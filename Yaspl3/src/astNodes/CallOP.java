package astNodes;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class CallOP extends Statment implements Visitable {
	
	private Identifier id;
	private ArrayList<Expr> arguments;
	private String nodeType; 

		
	public CallOP(Identifier id, ArrayList<Expr> arguments) {
		super();
		this.id = id;
		this.arguments = arguments;
	}
	
	
		
	public String getNodeType() {
		return nodeType;
	}



	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}



	public Identifier getId() {
		return id;
	}
	public void setId(Identifier id) {
		this.id = id;
	}
	public ArrayList<Expr> getArguments() {
		return arguments;
	}
	public void setArguments(ArrayList<Expr> arguments) {
		this.arguments = arguments;
	}
	
	public Element buildXMLNode(Document doc) {
		Element e = doc.createElement("Call_op");
		
		Element i = doc.createElement("id");
		i.appendChild(doc.createTextNode(id.getNameId()));
		
		e.appendChild(i);
		for(Expr exp: arguments) {
			e.appendChild(exp.buildXMLNode(doc));
		}
		
		return e;	}

	@Override
	public String toString() {
		return "CallOP [id=" + id + ", arguments=" + arguments + "]\n";
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
