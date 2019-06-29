package exception;

public class NotDeclaretionException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotDeclaretionException(String message) {
        super("La variabile: " + message + " non è mai stata dichiarata");
    }
}
