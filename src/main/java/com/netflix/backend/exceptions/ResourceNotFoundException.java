package com.netflix.backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String message;

    public ResourceNotFoundException(String message) {
        this.message = message+ " not found!";
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
