package com.ashutosh.aop.learnspringaop.aopexample.aspects;

import com.ashutosh.aop.learnspringaop.aopexample.annotations.TrackTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    //@Around("execution(* com.ashutosh.aop.learnspringaop.aopexample.*.*.*(..))")
    @Around("CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMills = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();
        long stopTimeMills = System.currentTimeMillis();

        long executionDuration = stopTimeMills - startTimeMills;

        logger.info("Performance Tracking aspect - {} Method excuted in {} ms",proceedingJoinPoint,executionDuration);
        return returnValue;
    }
}
