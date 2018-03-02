package com.crestaSom.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/instructordb?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try{
			System.out.println("connection to database:"+url);
			Connection con=DriverManager.getConnection(url,user,pass);
			System.out.println("Connection Successful");
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
