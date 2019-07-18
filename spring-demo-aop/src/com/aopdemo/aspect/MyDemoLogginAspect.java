package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// this is where all advices can be added
	@Before("execution(* com.aopdemo.dao.*.*(..))") // Pointcut Expression
	public void beforeAddAccountAdvice() {
		System.out.println("\n ==========> Executing @Before Advice on addAccount()");
	}
}
