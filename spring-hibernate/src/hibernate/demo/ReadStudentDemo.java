package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");
			
			// start a transaction
			session.beginTransaction();

			
			// save the student object
			System.out.println("Saving the Student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			// NOW RETRIEVING THE OBJECT
			
			// find out the student's id
			System.out.println("Primary Key from Student: " + tempStudent.getId());
			
			// now get a new session and start a new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Retrieved from Database: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
