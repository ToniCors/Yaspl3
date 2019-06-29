package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class IfThenOp extends Statment implements Visitable {
	
	private Expr expr;
	private CompStatOP statment;
	
	public IfThenOp(Expr expr, CompStatOP statment) {
		super();
		this.expr = expr;
		this.statment = statment;
	}

	private String nodeType; 

	
	
	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	
	public Expr getExpr() {
		return expr;
	}

	public void setExpr(Expr expr) {
		this.expr = expr;
	}

	public CompStatOP getStatment() {
		return statment;
	}

	public void setStatment(CompStatOP statment) {
		this.statment = statment;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element n =doc.createElement("IfThenOP");
		n.appendChild(expr.buildXMLNode(doc));
		
		n.appendChild(statment.buildXMLNode(doc));

		
		return n;		}

	@Override
	public String toString() {
		return "IfThenOp [expr=" + expr + ", statment=" + statment + "]\n";
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
