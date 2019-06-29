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

public class IntConst extends Expr  implements Visitable {
	
	private int intConst;	
	private String nodeType;

	public IntConst(int intConst) {
		super();
		this.intConst = intConst;
		this.nodeType = TypeChecker.INT;
	}

	public int getIntConst() {
		return intConst;
	}
	
	public void setIntConst(int intConst) {
		this.intConst = intConst;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("int_const");
		e.appendChild(doc.createTextNode(""+intConst));
		return e;	
		
	}
	
	@Override
	public String toString() {
		return "IntConst [intConst=" + intConst + "]\n";
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
