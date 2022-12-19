package com.netflix.backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String resource;

    public ResourceNotFoundException(String resource) {
        super(resource+" not found");
        this.resource = resource;
    }
}
