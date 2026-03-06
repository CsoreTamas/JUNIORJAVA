package com.example.spring_boot_practice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    //The separate logger is needed so that te measurements are written to a separate file.
    private static final Logger logger = LoggerFactory.getLogger("TimerLogger");

    //Warps all method in the controller package.
    @Around("execution(* com.example.spring_boot_practice.controller..*(..)) || @annotation(com.example.spring_boot_practice.annotation.TrackTime)")
    //ProceedJoinPoint is a "handle" to a method lets an aspect check what's happening, do something before or after,
    //and then actually ron the method.
    //ProceedingJoinPoint gives the aspect a way to “look at” the method before it runs.
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //getSignature() gets the name of the method being called
        String methodName = joinPoint.getSignature().toShortString();
        long start = System.nanoTime(); //(nanosec)

        //Calls the actual controller method
        Object result = joinPoint.proceed();

        long elapsed = (System.nanoTime() - start) / 1_000_000;
        logger.info("Execution time of {}: {} ms", methodName, elapsed);

        return result;
    }
}
