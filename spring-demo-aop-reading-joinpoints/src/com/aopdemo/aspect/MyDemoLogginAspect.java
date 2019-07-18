package com.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	// this is where all advices can be added
	@Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageWithoutGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		// Display the mthod signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// Display method arguments
		
	}
	
}
