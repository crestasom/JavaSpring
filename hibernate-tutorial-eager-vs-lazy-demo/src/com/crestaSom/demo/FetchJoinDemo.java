package com.crestaSom.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.crestaSom.hibernatedemo.Course;
import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Student;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			/**
			 * this will also save the detail of instructor detail because of
			 * Cascade.All
			 */

			int id = 1;

			Query<Instructor> query=
					session.createQuery("Select i from Instructor i "
										+ "JOIN FETCH i.courseList "
										+ "where i.id=:id", 
										Instructor.class);
			query.setParameter("id", id);
			
			Instructor instructor = query.getSingleResult();
			System.out.println("crestasom: instructor retrieved: " + instructor);
			
			session.getTransaction().commit();
			System.out.println("crestasom: courses: "+instructor.getCourseList());
			System.out.println("crestasom: Done");
		} catch (NullPointerException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
	}
}
