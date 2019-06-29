package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class AssignOP extends Statment implements Visitable {
	
	private Identifier id;
	private Expr expr;
	private String nodeType; 

	
	
	public AssignOP(Identifier id, Expr e) {
		super();
		this.id = id;
		this.expr = e;
	}

	

	public Expr getExpr() {
		return expr;
	}



	public void setExpr(Expr expr) {
		this.expr = expr;
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
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("Assign_op");
		
		Element i = doc.createElement("id");
		i.appendChild(doc.createTextNode(id.getNameId()));
		
		e.appendChild(i);
		e.appendChild(expr.buildXMLNode(doc));
		
		return e;
	}


	@Override
	public String toString() {
		return "AssignOP [id=" + id + ", expr=" + expr + "]\n";
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
