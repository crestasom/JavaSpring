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



public class CreateCourseWithReviewsDemo {

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
			Instructor ins=new Instructor("Ram","Sharma","sharmaram@mail.com");
			Course tempCourse=new Course("Programming");
			ins.add(tempCourse);
			tempCourse.addReview(new Review("I love this course"));
			tempCourse.addReview(new Review("I want this course"));
			tempCourse.addReview(new Review("I crave this course"));
			tempCourse.addReview(new Review("I hate this course"));
			tempCourse.addReview(new Review("I dont care about this course"));
		
			session.save(ins);
			session.save(tempCourse);
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}


}
