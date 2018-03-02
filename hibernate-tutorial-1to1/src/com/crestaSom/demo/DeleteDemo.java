package com.crestaSom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Student;

public class DeleteDemo {

	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try{
			
			
			session.beginTransaction();
			int id=1;
			Instructor instructor=session.get(Instructor.class, id);
			System.out.println("Found Instructor: "+instructor);
			if(!instructor.equals(null))
			{
				/**
				 * this will also delete the detail of instructor detail
				 * because of Cascade.All
				 */
				System.out.println("deleting instructor: "+instructor);
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
}
