package com.bay.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Class RestControllerAspect
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */

@Aspect
@Component
public class RestControllerAspect {

    @Before("execution(public * com.bay.example.api.rest.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
        System.out.println(":::::AOP Before REST call:::::" + pjp);
    }
}
