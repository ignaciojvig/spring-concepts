package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Calling Fortune");
		
		boolean tripWire = true;
		
		String fortune = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("My Fortune is: " + fortune);
		
		System.out.println("Finished");
		
		// close the context
		context.close();		
	}

}
