package com.stringexception;

public class StringException extends Exception {
    public StringException() {
        super("Invalid input provided");
    }
	
    public StringException(String message) {
        super(message);
    }
	
    public StringException(String message, Throwable cause) {
        super(message, cause);
    }
}
