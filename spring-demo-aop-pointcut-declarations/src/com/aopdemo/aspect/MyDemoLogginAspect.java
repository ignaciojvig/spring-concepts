package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	// this is where all advices can be added
	@Before("forDaoPackage()") // Pointcut Expression
	public void beforeAddAccountAdvice() {
		System.out.println("\n ==========> Executing @Before Advice on addAccount()");
	}
}
