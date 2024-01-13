package com.example.redbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private long fieldValue;
    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        //implicty and explicy call super
        super(String.format("%s not found with %s : '%s' ", resourceName, fieldName, fieldValue));
        //Calling super(...) is necessary because the constructor of the superclass (RuntimeException) needs to be executed before the constructor of the subclass (ResourceNotFoundException). The super(...) call
        // ensures that the necessary initialization from the superclass is performed.
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(long fieldValue) {
        this.fieldValue = fieldValue;
    }
}
