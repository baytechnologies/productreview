package com.bay.example.exception;


/**
 * @Class ResourceNotFoundException
 * For HTTP 404 errros
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

}
