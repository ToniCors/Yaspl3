package astNodes;

import java.util.ArrayList;

import org.w3c.dom.*;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class VarDecelOP extends Decls  implements Visitable {
	
	private String type ;	
	private ArrayList<VarInitOP> varInit;
	
	public VarDecelOP(String t, ArrayList<VarInitOP> v) {
		this.type = t;
		this.varInit = v;	
		this.nodeType="void";

			}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<VarInitOP> getVarInit() {
		return varInit;
	}

	public void setVarInit(ArrayList<VarInitOP> varInit) {
		this.varInit = varInit;
	}
	
	public  Element buildXMLNode(Document doc){
		Element n =doc.createElement("VarDecl_op");
		
		Element e =doc.createElement("type");
		e.appendChild(doc.createTextNode(type));
		n.appendChild(e);
		
		for(VarInitOP v : varInit) {
			n.appendChild(v.buildXMLNode(doc));
			}
		
		return n;
	}

	@Override
	public String toString() {
		return "VarDecelOP [type=" + type + ", varInit=" + varInit + "]\n";
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
