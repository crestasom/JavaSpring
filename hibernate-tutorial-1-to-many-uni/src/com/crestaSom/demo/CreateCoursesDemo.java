package com.crestaSom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Course;
import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Student;



public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try{
		
			session.beginTransaction();
			int id=1;
			Course c=session.get(Course.class, id);
			session.delete(c);
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentList) {
		for(Student tempStudent:studentList){
			System.out.println(tempStudent);
		}
	}
}
