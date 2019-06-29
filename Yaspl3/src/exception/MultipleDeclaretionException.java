package exception;

public class MultipleDeclaretionException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MultipleDeclaretionException(String message) {
        super("La variabile: " + message + " è gia stata dichiarata in questo scoop");
    }
}