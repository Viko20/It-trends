package oefening3;

import oefening3.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {

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

			Course tempCourse = new Course("Pacman - Hoe veel punten scoren");

			System.out.println("\nLessen aan het opslaan!");
			session.save(tempCourse);
			System.out.println("Les opgeslagen: " + tempCourse);

			Student tempStudent1 = new Student("John", "Doe", "john@mail.be");
			Student tempStudent2 = new Student("Mary", "Public", "mary@mary.be");

			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			System.out.println("\nStudenten opslaan ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Opgeslagen Studenten: " + tempCourse.getStudents());

			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {

			session.close();
			
			factory.close();
		}
	}

}





