package com.chuwa.transaction.exception;

import com.chuwa.transaction.exception.BlogAPIException;
import com.chuwa.transaction.exception.GlobalExceptionHandler;
import com.chuwa.transaction.exception.ResourceNotFoundException;
import com.chuwa.transaction.payload.ErrorDetails;
import com.mysql.cj.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import static java.lang.String.valueOf;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    @Test
    void handleMethodArgumentNotValid() {
        // Arrange
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        MethodArgumentNotValidException exception = Mockito.mock(MethodArgumentNotValidException.class);
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        WebRequest request = Mockito.mock(WebRequest.class);

        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        Mockito.when(exception.getBindingResult()).thenReturn(bindingResult);
        Mockito.when(bindingResult.getAllErrors()).thenReturn(singletonList(new FieldError("objectName", "fieldName", "Error message")));


        // Act
        ResponseEntity<Object> responseEntity = handler.handleMethodArgumentNotValid(exception, headers, status, request);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(singletonMap("fieldName", "Error message"), responseEntity.getBody());
    }

    @Test
    void handleResourceNotFoundException() {
        // Arrange
        long id = 1;

        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResourceNotFoundException exception = new ResourceNotFoundException("ResourceName", "FieldName", id);
        String idString = String.format("%s not found with %s : '%s' ", "ResourceName",  "FieldName", id);
        WebRequest request = Mockito.mock(WebRequest.class);

        // Act
        ResponseEntity<ErrorDetails> responseEntity = handler.handleResourceNotFoundException(exception, request);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(idString, responseEntity.getBody().getMessage());
    }

    @Test
    void handleBlogAPIException() {
        // Arrange
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        BlogAPIException exception = new BlogAPIException(HttpStatus.BAD_REQUEST, "Blog API exception");
        WebRequest request = Mockito.mock(WebRequest.class);

        // Act
        ResponseEntity<ErrorDetails> responseEntity = handler.handleBlogAPIException(exception, request);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Blog API exception", responseEntity.getBody().getMessage());
    }

    @Test
    void handleGlobalException() {
        // Arrange
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        Exception exception = new Exception("Generic exception");
        WebRequest request = Mockito.mock(WebRequest.class);

        // Act
        ResponseEntity<ErrorDetails> responseEntity = handler.handleGlobalException(exception, request);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Generic exception", responseEntity.getBody().getMessage());
    }
}
