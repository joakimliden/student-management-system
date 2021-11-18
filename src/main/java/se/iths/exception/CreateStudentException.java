package se.iths.exception;

public class CreateStudentException extends RuntimeException{

    private static final long serialVersionUID = -321654696544581L;

    public CreateStudentException(String message) {
        super(message);
    }
}
