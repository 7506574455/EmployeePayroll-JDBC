package com.jdbc;

import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

       //class created
public class DBDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "sanket@98";
        Connection con;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("Driver loaded");
        	
        } catch (ClassNotFoundException e) {
        	throw new IllegalStateException("Cannot find the driver in the classpath!",e);
        }
        listDrivers();
        
        try {
        	System.out.println("Connecting to database:"+jdbcURL);
        	con = DriverManager.getConnection(jdbcURL, userName, password);
        	System.out.println("Connecting is successful!!!!!"+con);
        }	
        	catch(Exception e) {
        		e.printStackTrace();
        }
	}
	
	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("  "+driverClass.getClass().getName());
			
		}
	}

}