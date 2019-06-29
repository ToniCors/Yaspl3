package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class UminusOP extends Expr implements Visitable {
	
	private Expr expr1;
	private String nodeType; 	

	
	public UminusOP(Expr expr1) {
		super();
		this.expr1 = expr1;
	}

	public Expr getExpr1() {
		return expr1;
	}

	public void setExpr1(Expr expr1) {
		this.expr1 = expr1;
	}

	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("Uminus_op");
		e.appendChild(expr1.buildXMLNode(doc));
		
		return e;
		
		}

	@Override
	public String toString() {
		return "UminusOP [expr1=" + expr1 + "]\n";
	}
	
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
