package astNodes;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import parser.CBuilder;
import parser.SemanticVisitor;
import parser.TypeChecker;
import parser.Visitable;
import parser.Visitor;
import parser.XMLBuilder;

public class Identifier extends Expr implements Visitable {
	
	private String nodeType;
	private String id;
	private String inOrOut;
	private ArrayList<ParamCallFunction> paramTypeFunction;

	
	public Identifier(String id) {
		super();
		this.id = id;
		paramTypeFunction = new ArrayList<>();
		
		inOrOut="null";
		nodeType="null";

	}
			
	public Identifier(String id, String inOrOut,String nodeType) {
		super();
		this.nodeType = nodeType;
		this.id = id;
		this.inOrOut = inOrOut;
		paramTypeFunction = new ArrayList<>();
	}
	
	public void addParamTypeFunction(ParamCallFunction p) {
	
		paramTypeFunction.add(p);		
	}
		
	
	public ArrayList<ParamCallFunction> getParamTypeFunction() {
		return paramTypeFunction;
	}

	public void setParamTypeFunction(ArrayList<ParamCallFunction> paramTypeFunction) {
		this.paramTypeFunction = paramTypeFunction;
	}

	public String getType() {
		return getNodeType();
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setType(String type) {
		setNodeType(type);
	}
	
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getNameId() {
		return id;
	}

	public void setNameId(String id) {
		this.id = id;
	}
		
	public String getInOrOut() {
		return inOrOut;
	}

	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}

	public boolean isVariable() {
		if(nodeType.equals(TypeChecker.FUNCTION))
			return false;
			else
			return true;
	}


	public Element buildXMLNode(Document doc) {
		
		Element e = doc.createElement("Id");
		e.appendChild(doc.createTextNode(id));
		

		return e;	
		
	}

	public boolean isFunction() {
		return nodeType.equals(TypeChecker.FUNCTION);
	}

	
	@Override
	public String toString() {
		return "Identifier [nodeType=" + nodeType + ", id=" + id + ", inOrOut=" + inOrOut + "]";
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
