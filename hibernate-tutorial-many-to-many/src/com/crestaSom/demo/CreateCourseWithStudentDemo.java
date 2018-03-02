package com.crestaSom.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Course;
import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Review;
import com.crestaSom.hibernatedemo.Student;



public class CreateCourseWithStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			//Instructor ins=new Instructor("Ram","Sharma","sharmaram@mail.com");
			Course tempCourse=new Course("Programming");
			System.out.println("Saving course: "+tempCourse);
			session.save(tempCourse);
			
			
			Student tempStudent=new Student("Ram","Sharma","sharmaram@mail.com");
			Student tempStudent1=new Student("Shyam","Sharma","sharmashyam@mail.com");
			
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent1);
			System.out.println("Saving student: "+tempStudent);
			session.save(tempStudent);
			System.out.println("Saving student: "+tempStudent1);
			session.save(tempStudent1);
			//ins.add(tempCourse);
			
			System.out.println("saved students: "+tempCourse.getStudents());
			
			//session.save(tempCourse);
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}


}
