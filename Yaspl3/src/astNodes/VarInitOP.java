package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class VarInitOP  implements Visitable {
	
	private Identifier id;
	private Expr exp;
	
	
	public VarInitOP(Identifier id, Expr exp) {
		super();
		this.id = id;
		this.exp = exp;
	}


	public Identifier getId() {
		return id;
	}


	public void setId(Identifier id) {
		this.id = id;
	}


	public Expr getExp() {
		return exp;
	}


	public void setExp(Expr exp) {
		this.exp = exp;
	}


	public Element buildXMLNode(Document doc) {
		
		Element n =doc.createElement("VaInit_op");
		
		Element e =doc.createElement("id");
		e.appendChild(doc.createTextNode(id.getNameId()));
		n.appendChild(e);	
		
		if(exp != null) {				
			n.appendChild(exp.buildXMLNode(doc));}
		
		return n;
		
	}


	@Override
	public String toString() {
		return "VarInitOP [id=" + id + ", exp=" + exp + "]\n";
	}
	
	private String nodeType; 	
	
	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
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
