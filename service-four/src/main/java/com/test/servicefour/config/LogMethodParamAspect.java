package com.test.servicefour.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LogMethodParamAspect {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(LogMethodParamAspect.class);

    @Around("execution(* *(..)) && @annotation(com.test.servicefour.config.LogMethodParam)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        List<Object> list = Arrays.asList(point.getArgs());
        list.forEach(item -> {
            logger.info(String.valueOf(item));
        });
        return point.proceed();
    }
}
