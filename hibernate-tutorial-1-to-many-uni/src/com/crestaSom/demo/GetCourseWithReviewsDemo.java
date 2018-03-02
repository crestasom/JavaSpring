package com.crestaSom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Course;
import com.crestaSom.hibernatedemo.Instructor;
import com.crestaSom.hibernatedemo.InstructorDetail;
import com.crestaSom.hibernatedemo.Review;
import com.crestaSom.hibernatedemo.Student;



public class GetCourseWithReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			int courseid=13;
			Course tempCourse=session.get(Course.class, courseid);
			System.out.println("course retrieve: " +tempCourse);
			
			System.out.println("course reviews: "+tempCourse.getReviews());
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}


}
