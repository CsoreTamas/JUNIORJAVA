package com.example.spring_boot_practice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {
    //If i were use my own custom annotation
    //@Around("execution(* com.example.spring_boot_practice.annotation.TrackTime)")

    //Warps all method in the controller package.
    @Around("execution(* com.example.spring_boot_practice.controller..*(..))")
    //ProceedJoinPoint is a "handle" to a method lets an aspect check what's happening, do something before or after,
    //and then actually ron the method.
    //ProceedingJoinPoint gives the aspect a way to “look at” the method before it runs.
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //getSignature() gets the name of the method being called
        String methodName = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();

        //Calls the actual controller method
        Object result = joinPoint.proceed();

        long elapsed = System.currentTimeMillis() - start;
        log.info("Execution time of {}: {} ms", methodName, elapsed);

        return result;
    }
}
