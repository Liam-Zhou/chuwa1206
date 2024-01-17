package com.chuwa.BankStatement.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resouceName;

    private String fieldName;

    public String getResouceName() {
        return resouceName;
    }

    public void setResouceName(String resouceName) {
        this.resouceName = resouceName;
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

    private long fieldValue;

    public ResourceNotFoundException(String resouceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s :  %s", resouceName, fieldName, fieldValue));
        this.resouceName = resouceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }
}