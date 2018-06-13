package oefening3;

import oefening3.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {

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

			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nstudent: " + tempStudent);
			System.out.println("lessen: " + tempStudent.getCourses());

			Course tempCourse1 = new Course("Rubik's Cube - Hoe snel oplossen");
			Course tempCourse2 = new Course("Random les - Game Development");

			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			System.out.println("\nLessen aan het opslaan ...");
			
			session.save(tempCourse1);
			session.save(tempCourse2);

			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {

			session.close();
			
			factory.close();
		}
	}

}





