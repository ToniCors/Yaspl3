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

public class StringConst extends Expr  implements Visitable {
	
	private String stringConst;
	private String nodeType; 	


	public StringConst(String stringConst) {
		super();
		this.stringConst = stringConst;
		this.nodeType = TypeChecker.STRING;

	}

	public String getStringConst() {
		return stringConst;
	}

	public void setStringConst(String stringConst) {
		this.stringConst = stringConst;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("string_const");
		
		e.appendChild(doc.createTextNode(stringConst));		
		return e;
		
	}

	@Override
	public String toString() {
		return "StringConst [stringConst=" + stringConst + "]\n";
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
