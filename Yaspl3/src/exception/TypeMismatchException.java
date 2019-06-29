package exception;

public class TypeMismatchException extends Exception {

	private static final long serialVersionUID = 1L;

	public TypeMismatchException(String message) {
        super(message);
    }
}
