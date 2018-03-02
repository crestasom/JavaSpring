package com.crestaSom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crestaSom.hibernatedemo.Student;



public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try{
			/*System.out.println("create student object");
			Student s1=new Student("Ram", "Shrestha", "ramstha@mail.com");
			Student s2=new Student("Hari", "Shrestha", "ramstha@mail.com");
			Student s3=new Student("Sita", "Shrestha", "ramstha@mail.com");
			Student s4=new Student("Gita", "Shrestha", "ramstha@mail.com");*/
			
			session.beginTransaction();
			//System.out.println("saving student object");
			/*session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);*/
			
			List<Student> studentList=session.createQuery("from Student").getResultList();
			displayStudents(studentList);
			
			studentList=session.createQuery("from Student s where s.fName='ram'").getResultList();
			displayStudents(studentList);
			/*System.out.println(session.get(Student.class, s2.getId()));*/
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
