package com.gd.demo.exceptions;

public class WordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WordNotFoundException(String message, Throwable cause) {

        super(message, cause);
        }

    public WordNotFoundException(String message) {
            super(message);
        }

    }
