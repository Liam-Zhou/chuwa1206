package com.chuwa.bankstatement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Pointcut("execution(* com.chuwa.bankstatement.service.*.*(..))")
    private void forServicePackage() {}

    @Before("forServicePackage()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("Entering Method: " + method);
    }

    @AfterReturning(pointcut = "forServicePackage()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("Exiting Method: " + method);
        logger.info("Result: " + result);
    }
}
