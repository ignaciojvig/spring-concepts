package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// Pointcut for specific package
	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	// Pointcut for Getter Methods
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	private void getter() {};
	
	// Pointcut for Setter Method
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	private void setter() {};
	
	// Pointcut that joins specific package and excludes getters/setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageWithoutGetterAndSetter() {};
	
	
	
	// this is where all advices can be added
	@Before("forDaoPackageWithoutGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ==========> Executing @Before Advice on addAccount()");
	}
	
	@Before("forDaoPackageWithoutGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n ==========> Performing API Analytics");
	}
}
