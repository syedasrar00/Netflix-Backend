package com.netflix.backend.exceptions;

public class DuplicateEntryException extends RuntimeException {
    String message;

    public DuplicateEntryException(String message) {
        super(message);
        this.message = message;
    }
}
