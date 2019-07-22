package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate an exception
			boolean tripWire = true;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception ex) {
			System.out.println("On Main - Caught Exception:\n" + ex);
		}
		
		
		
		System.out.println("On Main\n" + theAccounts);
		
		// close the context
		context.close();		
	}

}
