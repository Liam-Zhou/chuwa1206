package com.example.redbook.interceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.EnumerationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            final Object handler
    ) throws Exception {
        long startTime = System.currentTimeMillis();
        corsHeaders(request, response);
        request.setAttribute("startTime", startTime);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Object handler,
            final ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Object handler,
            final Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        logger.info("Request URL: {}, Method: {}, Total Time: {} ms", request.getRequestURI(), request.getMethod(), executionTime);

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


    //If it is, the Access-Control-Allow-Origin header is set to the value(s) of the Origin header, allowing requests from that origin
    private void corsHeaders(final HttpServletRequest request, final HttpServletResponse response) {
        response.setHeader("Strict-Transport-Security", "max-age=60; includeSubDomains ");
        if (Objects.nonNull(request.getHeader("Origin"))) {
            final List<String> list = EnumerationUtils.toList(request.getHeaders("Origin"));
            final String[] array = list.toArray(new String[CollectionUtils.size(list)]);
            response.setHeader("Access-Control-Allow-Origin", String.join(",", array));
        }

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader(
                "Access-Control-Allow-Methods",
                String.join(
                        ",",
                        Stream.of(HttpMethod.values())
                                .map(HttpMethod::name)
                                .collect(Collectors.toList())
                                .toArray(new String[HttpMethod.values().length])
                )
        );
        response.addHeader(
                "Access-Control-Allow-Headers",
                "X-Requested-With, Origin, Content0Type, Accept, responseType, Authorization, x-xsrf-token, jsessionid"
        );
    }

}