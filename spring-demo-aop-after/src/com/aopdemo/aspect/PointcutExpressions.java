package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {

	// Pointcut for specific package
	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	// Pointcut for Getter Methods
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	public void getter() {};
	
	// Pointcut for Setter Method
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	public void setter() {};
	
	// Pointcut that joins specific package and excludes getters/setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageWithoutGetterAndSetter() {};
}
