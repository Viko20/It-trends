package oefening3;

import oefening3.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {			

			session.beginTransaction();

			int studentId = 1;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nGeladen student: " + tempStudent);
			System.out.println("Lessen: " + tempStudent.getCourses());

			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {

			session.close();
			
			factory.close();
		}
	}

}





