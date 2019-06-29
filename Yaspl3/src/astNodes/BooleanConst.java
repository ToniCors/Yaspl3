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

public class BooleanConst extends Expr implements Visitable {


	private boolean booleanConst;

	private String nodeType; 

	
	public BooleanConst(boolean boouleConst) {
		super();
		this.booleanConst = boouleConst;
		this.nodeType = TypeChecker.BOOLE;

	}

	
	
	public boolean isBooleanConst() {
		return booleanConst;
	}



	public void setBooleanConst(boolean booleanConst) {
		this.booleanConst = booleanConst;
	}



	public String getNodeType() {
		return nodeType;
	}



	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("boolean_const");
		
		e.appendChild(doc.createTextNode(""+booleanConst));

		
		return e;
		
	}
	
	
	@Override
	public String toString() {
		return "BooleanConst [booleanConst=" + booleanConst + "]\n";
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
