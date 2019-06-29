package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class LeOP extends Expr implements Visitable {
	
	private Expr expr1;
	private Expr expr2;
	
	public LeOP(Expr expr1, Expr expr2) {
		super();
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	public Expr getExpr1() {
		return expr1;
	}

	public void setExpr1(Expr expr1) {
		this.expr1 = expr1;
	}

	public Expr getExpr2() {
		return expr2;
	}

	public void setExpr2(Expr expr2) {
		this.expr2 = expr2;
	}	

	public Element buildXMLNode(Document doc) {
		Element e = doc.createElement("Le_op");
		e.appendChild(expr1.buildXMLNode(doc));
		e.appendChild(expr2.buildXMLNode(doc));

		return e;	}

	@Override
	public String toString() {
		return "LeOP [expr1=" + expr1 + ", expr2=" + expr2 + "]\n";
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