package com.zoho.stringbuilder.exception;

public class StringBuilderException extends Exception {
    public StringBuilderException(String message) {
        super(message);
    }

    public StringBuilderException(String message, Throwable cause) {
        super(message, cause);
    }
}
