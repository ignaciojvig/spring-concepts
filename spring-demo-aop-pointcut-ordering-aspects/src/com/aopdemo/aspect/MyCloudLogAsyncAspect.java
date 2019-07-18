package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {

	@Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageWithoutGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("\n ==========> Logging to Cloud in Async Fashion");
	}
	
}
