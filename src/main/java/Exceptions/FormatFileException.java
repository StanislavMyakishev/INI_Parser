package Exceptions;

import Parser.FileConnection;

public class FormatFileException extends Exception {

    public FormatFileException() {
    }

    public FormatFileException(String message) {
        super(message);
    }

    public FormatFileException(Throwable cause) {
        super(cause);
    }

    public FormatFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatFileException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
