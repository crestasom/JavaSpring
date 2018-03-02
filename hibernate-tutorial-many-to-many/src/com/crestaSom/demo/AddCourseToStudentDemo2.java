package com.crestaSom.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Course;
import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Review;
import com.crestaSom.hibernatedemo.Student;



public class AddCourseToStudentDemo2 {

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
			int id=8;
			Student student=session.get(Student.class, 8);
			System.out.println("student loaded: "+student);
			System.out.println("\ncourses :"+student.getCourses());
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}


}
