package com.chuwa.transaction.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequiredArgsConstructor
public class ExecuteTimeInterceptor implements HandlerInterceptor {
     private static final Logger log = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);

    /**
     * 在handler执行之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        log.info("interceptor preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 在handler执行之后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        System.out.println("[" + handler + "] executeTime : " + executeTime + "ms");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        log.info("interceptor postHandle");
    }
}
