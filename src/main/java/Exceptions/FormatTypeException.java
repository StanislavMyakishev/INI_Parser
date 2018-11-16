package Exceptions;

public class FormatTypeException extends Exception {
    public FormatTypeException() {
    }

    public FormatTypeException(String message) {
        super(message);
    }

    public FormatTypeException(Throwable cause) {
        super(cause);
    }

    public FormatTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
