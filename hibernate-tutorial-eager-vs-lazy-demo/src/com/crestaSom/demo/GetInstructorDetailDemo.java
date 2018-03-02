package com.crestaSom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Student;

public class GetInstructorDetailDemo {

	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			/**
			 * this will also save the detail of instructor detail
			 * because of Cascade.All
			 */
			
			int id=299;
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, id);
			System.out.println("instructor detail retrieved: "+instructorDetail);
			//print associated instructor
			System.out.println("instrutor: "+instructorDetail.getInstructor());
			session.getTransaction().commit();
		}catch(NullPointerException ex){
			ex.printStackTrace();
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
