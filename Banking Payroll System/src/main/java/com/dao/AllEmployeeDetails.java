package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.*;
import com.utlity.Utility;

public class AllEmployeeDetails {
	
	static public List<Employee> AllEmployees(){
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
	    
	    Criteria criteria = session.createCriteria(Employee.class);
	    List <Employee>listofEmployees = criteria.list(); 
	  return listofEmployees;
	}
}



