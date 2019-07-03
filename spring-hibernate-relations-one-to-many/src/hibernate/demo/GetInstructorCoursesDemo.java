package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Course.class)
											.buildSessionFactory();
		
		// Create a Session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// print instructor
			System.out.println(tempInstructor);
			
			System.out.println(tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}
