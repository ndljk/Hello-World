package com.helloworld.helloworld.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {
    private Logger log= LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* com.helloworld.helloworld.controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint){
        log.info("Executing {}", joinPoint);
    }

    @After(value = "execution(* com.helloworld.helloworld.controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint){
        log.info("Execution completed of {}", joinPoint);
    }

    @Around(value = "execution(* com.helloworld.helloworld.controller.*.*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime=System.currentTimeMillis();
        try {
            Object obj=joinPoint.proceed();
            long executionTime=System.currentTimeMillis()-startTime;
            log.info("Execution time of {} is {}ms", joinPoint,executionTime);
            return obj;
        }
        catch (Exception e){
            log.info(e.toString());
        }
        return null;
    }

}
