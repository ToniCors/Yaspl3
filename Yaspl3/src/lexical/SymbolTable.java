package lexical;

import java.util.HashMap;

import astNodes.Identifier;
import exception.MultipleDeclaretionException;
import java_cup.runtime.Symbol;
import parser.CircuitSym;

public class SymbolTable extends HashMap<String,Identifier> {

	private static final long serialVersionUID = 1L;
	private String name;


	public SymbolTable(String n) {
		super();
		name = n;
	}
	
	public Identifier installID(Identifier id) throws MultipleDeclaretionException{
		//System.out.println("Symbol table say: ID Ricevuto: " + id.toString());	

		//utilizzo come chiave della hashmap il lessema
		if(this.containsKey(id.getNameId())){
			throw new MultipleDeclaretionException(""+id.getNameId());
			//return null;
			
		}
		else{
			this.put(id.getNameId(), id);
			return id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


	

}
