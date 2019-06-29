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

public class ReadOP extends Statment implements Visitable {
	
	//ArrayList<String> ids;
	
	ArrayList<Identifier> identifier;

	
	public ReadOP(ArrayList<Identifier> ids) {
		super();
		//this.ids = ids;
		identifier = ids;
	}

	public ArrayList<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(ArrayList<Identifier> identifier) {
		this.identifier = identifier;
	}

	public ArrayList<Identifier> getIdentifiers() {
		return identifier;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("Read_op");
		
		Element i3;
		
		for(Identifier i : identifier) {
			
			i3 = doc.createElement("Id");
			i3.appendChild(doc.createTextNode(i.getNameId()));
			e.appendChild(i3);
		}		
		
		return e;

	}

	@Override
	public String toString() {
		return "ReadOP [ids=" + identifier + "]";
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
