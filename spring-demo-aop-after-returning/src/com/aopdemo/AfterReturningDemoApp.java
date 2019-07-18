package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("On Main\n" + theAccounts);
		
		// close the context
		context.close();		
	}

}
