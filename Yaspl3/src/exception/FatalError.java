package exception;

public class FatalError extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public FatalError(String message) {
        super("NON DOVEVA CAPITARE: NELLA CLASSE" + message + " VI è STATO UN ERRORE NON ATTESO");
    }

}
