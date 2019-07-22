package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.istack.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.controllers.*.*(..))")
	private void forControllerPackage() {
	}
	
	@Pointcut("execution(* com.service.*.*(..))")
	private void forServicePackage() {
	}
	
	@Pointcut("execution(* com.dao.*.*(..))")
	private void forDaoPackage() {
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("@Before: " + theMethod);
		
		// display the arguments to the method
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg: args)
			myLogger.info("@Before " + theMethod + " argument: " + tempArg);
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("@AfterReturning: " + theMethod);
		
		myLogger.info("@AfterReturning Result: " + theResult);
	}
}
