package parser;

import org.w3c.dom.Element;

public interface Visitable {
	
	public void accept(Visitor visitor);

}
