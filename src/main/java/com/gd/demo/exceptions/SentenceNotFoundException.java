package com.gd.demo.exceptions;

public class SentenceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SentenceNotFoundException(String message, Throwable cause) {
            super(message, cause);
            }

    public SentenceNotFoundException(String message) {
            super(message);
            }
}
