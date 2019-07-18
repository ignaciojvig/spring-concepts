package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method is being advised
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("*AfterThrowing* on method: " + method);
		
		// log the exception
		System.out.println("*AfterThrowing* the exception is: " + theExc);
		
	}
	
	
	
	
	
	
	
	// add a new advice for @AfterReturning to the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("*AfterReturning* on method: " + method);
		
		System.out.println("*AfterReturning* result is: " + result);
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("*AfterReturning* after modification result is: " + result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for(Account tempAccount : result)
			tempAccount.setName(
					tempAccount.getName().toUpperCase());	
	}

	
	
	
	
	
	
	
	
	// this is where all advices can be added
	@Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageWithoutGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n ==========> Loggin Aspect");
		// Display the mthod signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// Display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// Downcast and print values
				Account theAccount = (Account) tempArg;
				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Account Level: " + theAccount.getLevel());
			}
		}
		
	}
	
}
