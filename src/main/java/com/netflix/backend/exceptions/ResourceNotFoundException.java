package com.netflix.backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String resource;
    String resourceField;
    String fieldId;

    public ResourceNotFoundException(String resource, String resourceField, String fieldId) {
        super(resource+" with "+resourceField+" of field id "+fieldId+"not found");
        this.resource = resource;
        this.resourceField = resourceField;
        this.fieldId = fieldId;
    }
}
