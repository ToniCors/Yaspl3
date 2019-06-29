package exception;

public class ParameterError extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ParameterError(String message) {
        super("Il numero dei parametri non corrisponde: richiesti:" + message + "  sono stati inseriti");
    }

}
