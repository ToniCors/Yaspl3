package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.TypeChecker;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class DoubleConst extends Expr implements Visitable {

	private double doubleConst;
	private String nodeType; 


	public DoubleConst(double doubleConst) {
		super();
		this.doubleConst = doubleConst;
		this.nodeType = TypeChecker.DOUBLE;

	}
	
	

	public String getNodeType() {
		return nodeType;
	}



	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}



	public double getDoubleConst() {
		return doubleConst;
	}

	public void setDoubleConst(double doubleConst) {
		this.doubleConst = doubleConst;
	}
	
	public Element buildXMLNode(Document doc) {

		Element e = doc.createElement("double_const");
		
		e.appendChild(doc.createTextNode(""+doubleConst));
	
		return e;
	
	}

	@Override
	public String toString() {
		return "DoubleConst [doubleConst=" + doubleConst + "]";
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
