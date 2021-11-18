package se.iths.exception;

public class DataNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -3216546984651681L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
