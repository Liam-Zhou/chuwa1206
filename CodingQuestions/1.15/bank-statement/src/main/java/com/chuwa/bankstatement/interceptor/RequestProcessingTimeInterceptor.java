package com.chuwa.bankstatement.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
@Slf4j
public class RequestProcessingTimeInterceptor implements HandlerInterceptor {

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
            log.info("Handler : {} : {} : Execution time : {} ms",
                    handlerMethod.getBeanType().getName(),
                    handlerMethod.getMethod().getName(),
                    executeTime);
        }
    }
}
