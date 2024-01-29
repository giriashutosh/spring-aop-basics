package com.ashutosh.aop.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


public class CommonPointcutConfig {

    @Pointcut("execution(* com.ashutosh.aop.learnspringaop.aopexample.*.*.*(..))")
    public void businessPackageConfig(){

    }

    @Pointcut("@annotation(com.ashutosh.aop.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation(){

    }
}
