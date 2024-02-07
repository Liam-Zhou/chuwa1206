package com.chuwa.learn.statement.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RequestTimeInterceptorTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private RequestTimeInterceptor interceptor;

    @Test
    void preHandle_shouldSetStartTimeAttribute() throws Exception {
        // Arrange
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Object handler = new Object();

        // Act
        boolean result = interceptor.preHandle(request, response, handler);

        // Assert
        assertEquals(true, result);
        assertEquals(true, request.getAttribute("startTime") instanceof Long);
    }

    @Test
    void postHandle_shouldLogElapsedTime() throws Exception {
        // Arrange
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Object handler = new Object();
        ModelAndView modelAndView = new ModelAndView();

        // Set start time attribute
        interceptor.preHandle(request, response, handler);
        long startTime = (long) request.getAttribute("startTime");

        // Act
        interceptor.postHandle(request, response, handler, modelAndView);


    }
}