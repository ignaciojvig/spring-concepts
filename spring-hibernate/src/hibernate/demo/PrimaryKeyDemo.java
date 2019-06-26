package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		// Create a Session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new Student object...");
			Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
			Student tempStudent2 = new Student("Mary", "Public", "marypublic@gmail.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@gmail.com");
			
			// start a transaction
			session.beginTransaction();

			
			// save the student object
			System.out.println("Saving the Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
