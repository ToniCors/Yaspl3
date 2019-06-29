package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.TypeChecker;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class CharConst extends Expr  implements Visitable {
	
	private char charConst;
	private String nodeType; 


	public CharConst(String cConst) {
		super();
	
		if(cConst.length()==3) {
			charConst = cConst.charAt(1);
		}else if(cConst.length()==3) {
			switch(cConst) {
			case "\n": charConst='\n';break;
			case "\t": charConst='\t';break;
			case "\r": charConst='\r';break;
			case "\f": charConst='\f';break;
			case "\b": charConst='\b';break;
			default: System.out.println("NON DOVEVA CAPITARE.....CharConst.CLASS");break;
			}
			
		}else {
			System.out.println("NON DOVEVA CAPITARE.....CharConst.CLASS"+cConst.length());
		}
		
		this.nodeType = TypeChecker.CHAR;

	}

	
	
	public String getNodeType() {
		return nodeType;
	}



	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}



	public char getCharConst() {
		return charConst;
	}

	public void setCharConst(char cConst) {
		charConst = cConst;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("char_const");
		
		e.appendChild(doc.createTextNode(""+charConst));

		
		return e;	}

	@Override
	public String toString() {
		return "CharConst [charConst=" + charConst + "]\n";
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
