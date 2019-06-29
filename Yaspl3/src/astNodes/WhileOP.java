package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class WhileOP extends Statment  implements Visitable {
	
	private Expr expr;
	private CompStatOP statment;
	
	public WhileOP(Expr expr, CompStatOP statment) {
		super();
		this.expr = expr;
		this.statment = statment;
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
		
		Element n =doc.createElement("WhileOP");
		n.appendChild(expr.buildXMLNode(doc));
		
		n.appendChild(statment.buildXMLNode(doc));

		
		return n;	
		
	}

	@Override
	public String toString() {
		return "WhileOP [expr=" + expr + ", statment=" + statment + "]\n";
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
