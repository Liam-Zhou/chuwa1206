package com.example.bankstatement.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Alex D.
 */
@Aspect
@Component
@Order(2)
public class LoggingAspect {
}
