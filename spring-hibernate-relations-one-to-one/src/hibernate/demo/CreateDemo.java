package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class CreateDemo {

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
			Instructor tempInstructor =
					new Instructor("João", "Ignacio", "ignaciojvig@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://youtube.com/canalDoJao", "Love2Code");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			session.save(tempInstructor);
			// Note: Will ALSO save the 'InstructorDetail' object, because of CascadeType.ALL
			
			System.out.println(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
