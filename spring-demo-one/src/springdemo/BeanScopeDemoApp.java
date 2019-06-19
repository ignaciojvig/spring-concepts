package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// Load the Spring Configuration File
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		// Retrieve Bean from Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		System.out.println("Is the same Bean? " + result);
		System.out.println("Memory Location of theCoach? " + theCoach);
		System.out.println("Memory Location of alphaCoach? " + alphaCoach);
		
		context.close();
	}

}
