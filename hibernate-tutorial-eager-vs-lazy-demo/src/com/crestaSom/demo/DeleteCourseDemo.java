package com.crestaSom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Course;
import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Student;



public class DeleteCourseDemo {

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
			Instructor instructor=session.get(Instructor.class, id);
			
			Course c1=new Course("Programming");
			Course c2=new Course("Maths");
			instructor.add(c1);
			instructor.add(c2);
			
			
			session.save(c1);
			session.save(c2);
			
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
