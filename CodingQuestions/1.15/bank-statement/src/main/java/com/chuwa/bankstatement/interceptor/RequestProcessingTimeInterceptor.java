package com.chuwa.bankstatement.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class RequestProcessingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestProcessingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        // log it
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder();
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            logger.info("Handler : {} : {} : Execution time : {} ms",
                    handlerMethod.getBeanType().getName(),
                    handlerMethod.getMethod().getName(),
                    executeTime);
        }
    }
}
