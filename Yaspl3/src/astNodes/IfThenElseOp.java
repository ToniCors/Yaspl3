package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class IfThenElseOp extends Statment implements Visitable {
	
	private Expr expr;
	private CompStatOP tureStatments;	
	private CompStatOP falseStatments;
	private String nodeType; 

	
	
	public IfThenElseOp(Expr expr, CompStatOP tureStatments, CompStatOP falseStatments) {
		super();
		this.expr = expr;
		this.tureStatments = tureStatments;
		this.falseStatments = falseStatments;
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

	public Expr getExpr() {
		return expr;
	}


	public void setExpr(Expr expr) {
		this.expr = expr;
	}


	public CompStatOP getTureStatments() {
		return tureStatments;
	}


	public void setTureStatments(CompStatOP tureStatments) {
		this.tureStatments = tureStatments;
	}


	public CompStatOP getFalseStatments() {
		return falseStatments;
	}


	public void setFalseStatments(CompStatOP falseStatments) {
		this.falseStatments = falseStatments;
	}	
	
	

	public Element buildXMLNode(Document doc) {
		Element n =doc.createElement("IfThenElseOP");
		n.appendChild(expr.buildXMLNode(doc));
		
		n.appendChild(tureStatments.buildXMLNode(doc));
		n.appendChild(falseStatments.buildXMLNode(doc));


		
		return n;		}


	@Override
	public String toString() {
		return "IfThenElseOp [expr=" + expr + ", tureStatments=" + tureStatments + ", falseStatments=" + falseStatments
				+ "]\n";
	}
	
	
	

}
