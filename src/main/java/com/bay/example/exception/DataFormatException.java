package com.bay.example.exception;


/**
 * @Class DataFormatException
 * for HTTP 400 errors
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */
public final class DataFormatException extends RuntimeException {
    public DataFormatException() {
        super();
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }
}