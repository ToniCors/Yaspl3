package astNodes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class ParOP  implements Visitable {

	private String returnType;
	private String type;
	private Identifier id;
	private String nodeType; 	

	
	
	
	public ParOP(String returnType, String type, Identifier id) {
		super();
		this.returnType = returnType;
		this.type = type;
		this.id = id;
		this.nodeType="void";

	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Identifier getId() {
		return id;
	}
	public void setId(Identifier id) {
		this.id = id;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("Par_op");
		
		Element i1 = doc.createElement("ReturnType");
		i1.appendChild(doc.createTextNode(returnType));
		e.appendChild(i1);
		
		Element i2 = doc.createElement("Type");
		i2.appendChild(doc.createTextNode(type));
		e.appendChild(i2);
		
		Element i3 = doc.createElement("Id");
		i3.appendChild(doc.createTextNode(id.getNameId()));
		e.appendChild(i3);	

			return e;		
	}
	@Override
	public String toString() {
		return "ParOP [returnType=" + returnType + ", type=" + type + ", id=" + id + "]\n";
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
