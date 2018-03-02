package com.crestaSom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Student;

public class CreateDemo {

	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try{
			
			Instructor instructor=new Instructor("Ram", "Khanal","khanalram@gmail.com");
			InstructorDetail instructorDetail=new InstructorDetail("youtube.com/aa","designing");
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			/**
			 * this will also save the detail of instructor detail
			 * because of Cascade.All
			 */
			
			System.out.println("saving instructor"+ instructor);
			session.save(instructor);
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
}
