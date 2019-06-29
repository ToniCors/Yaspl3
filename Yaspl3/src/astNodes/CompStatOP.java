package astNodes;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class CompStatOP  implements Visitable {

	private ArrayList<Statment> statments;
	private String nodeType; 

	
	
	public CompStatOP(ArrayList<Statment> statments) {
		super();
		this.statments = statments;
	}

	
	
	public String getNodeType() {
		return nodeType;
	}



	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}



	public ArrayList<Statment> getStatments() {
		return statments;
	}

	public void setStatments(ArrayList<Statment> statments) {
		this.statments = statments;
	}
	
	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("CompStat_op");
		
		for(Statment stat: statments) {
			e.appendChild(stat.buildXMLNode(doc));
		}
		
		return e;	
		
	}
	
	@Override
	public String toString() {
		return "CompStatOP [statments:\n " + statments.toString() + "]\n";
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
