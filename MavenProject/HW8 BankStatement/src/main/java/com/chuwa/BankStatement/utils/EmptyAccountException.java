package com.chuwa.BankStatement.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmptyAccountException extends ResourceNotFoundException{

    public EmptyAccountException(String resouceName, String fieldName, long fieldValue) {
        super(resouceName, fieldName, fieldValue);

    }

}
