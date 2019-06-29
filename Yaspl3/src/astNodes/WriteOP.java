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

public class WriteOP extends Statment  implements Visitable {
	
	ArrayList<Expr> expr;
	
	public WriteOP(ArrayList<Expr> ids) {
		super();
		this.expr = ids;
	}

	public ArrayList<Expr> getExprs() {
		return expr;
	}

	public void setExprs(ArrayList<Expr> ids) {
		this.expr = ids;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element n =doc.createElement("Write_op");
		
		for(Expr ex : expr) {
			
			n.appendChild(ex.buildXMLNode(doc));			
			
		}

	return n;
	
	}

	@Override
	public String toString() {
		return "WriteOP [expr=" + expr + "]\n";
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
