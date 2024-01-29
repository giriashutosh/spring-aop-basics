package com.ashutosh.aop.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    //pointcut - when?
    private Logger logger = LoggerFactory.getLogger(getClass());

    //execution(* com.ashutosh.aop.learnspringaop.aopexample.business.*.*(..))
    @Before("com.ashutosh.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
        //Logic - what?
        logger.info("Before Aspect - Method is called - {}", joinPoint);
    }

    @After("com.ashutosh.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        //Logic - what?
        logger.info("After Aspect - Method has called - {}", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.ashutosh.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterExecption(JoinPoint joinPoint){
        //Logic - what?
        logger.info("After throwing exception - Method has called - {}", joinPoint);
    }

    @AfterReturning(
            pointcut = "com.ashutosh.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue){
        //Logic - what?
        logger.info("After returning - Method has called - {}", joinPoint);
    }
}
