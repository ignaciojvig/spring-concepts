package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		// Create a Session
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student...");
			
			myStudent.setFirstName("Scooby");
						
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
			// Bulk update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update Email for all students
			System.out.println("Updating Emails for all Students");
			session.createQuery("update Student set email='foo@gmail.com'")
						.executeUpdate();
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
