package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	// this is where all advices can be added
	@Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageWithoutGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ==========> Executing @Before Advice on addAccount()");
	}
	
}
