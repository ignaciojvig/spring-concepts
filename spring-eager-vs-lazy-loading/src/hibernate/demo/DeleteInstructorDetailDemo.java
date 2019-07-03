package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.buildSessionFactory();
		
		// Create a Session
		Session session = factory.getCurrentSession();
		
		try {		
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 3;
			
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);			
			
			// print the instructor detail
			System.out.println(tempInstructorDetail);
			
			
			// print the associated instructor		
			System.out.println(tempInstructorDetail.getInstructor());
			
			// remove the associated object reference
			// ** break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
