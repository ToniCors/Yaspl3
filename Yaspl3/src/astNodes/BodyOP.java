package astNodes;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class BodyOP  implements Visitable {

	private ArrayList<VarDecelOP> decs = new ArrayList<>();
	private ArrayList<Statment> statments = new ArrayList<>();
	private String nodeType; 

	
	public BodyOP(ArrayList<VarDecelOP> decs, ArrayList<Statment> statments) {
		super();
		this.decs = decs;
		this.statments = statments;
		this.nodeType="void";
	}
	
	
	
	
	public String getNodeType() {
		return nodeType;
	}




	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}




	public ArrayList<VarDecelOP> getDecs() {
		return decs;
	}
	public void setDecs(ArrayList<VarDecelOP> decs) {
		this.decs = decs;
	}
	public ArrayList<Statment> getStatments() {
		return statments;
	}
	public void setStatments(ArrayList<Statment> statments) {
		this.statments = statments;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("Body_op");
		
		for(Decls d: decs) {
			e.appendChild(d.buildXMLNode(doc));

		}
		for(Statment s: statments) {
			e.appendChild(s.buildXMLNode(doc));

		}
		
		return e;
	}


	@Override
	public String toString() {
		return "BodyOP [decs:\n " + decs.toString() + ", statments:\n " + statments.toString() + "]\n";
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
