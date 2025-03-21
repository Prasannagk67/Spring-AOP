package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

    // Logging before and after method execution
    @Before("execution(* com.aop.service.EmployeeService.*(..))")
    public void logBefore() {
        System.out.println("Executing method in EmployeeService...");
    }

    @After("execution(* com.aop.service.EmployeeService.*(..))")
    public void logAfter() {
        System.out.println("Execution completed for EmployeeService method.");
    }

    // Security check (Simulated: Prints a message)
    @Before("execution(* com.aop.service.EmployeeService.getEmployeeById(..))")
    public void securityCheck() {
        System.out.println("Security Check Passed ");
    }

    // Transaction Management (Simulated)
    @Around("execution(* com.aop.service.EmployeeService.addEmployee(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Transaction Started...");
        Object result = joinPoint.proceed();
        System.out.println("Transaction Committed ");
        return result;
    }

    // Performance Monitoring
    @Around("execution(* com.aop.service.EmployeeService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature() + " executed in " + (end - start) + "ms");
        return result;
    }

    // Exception Handling
    @AfterThrowing(pointcut = "execution(* com.aop.service.EmployeeService.getEmployeeById(..))", throwing = "ex")
    public void handleException(Exception ex) {
        System.out.println("Exception Handled: " + ex.getMessage());
    }
}

