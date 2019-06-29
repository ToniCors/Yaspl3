package astNodes;

import org.w3c.dom.*;

import parser.Visitor;

public abstract class Expr {
	
	public abstract Element buildXMLNode(Document doc);
	
	public abstract String toString();

	public abstract void accept(Visitor visitor);

	public abstract String getNodeType();
	
}
