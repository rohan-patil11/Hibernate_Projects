package com.controller;

import java.util.List;
import com.entity.Employee;
import com.services.EmployeeServices;

public class Controller {

	public static void salaryHike() {
		EmployeeServices.SalaryHike();
	}
    
	public static void changeName() {
		EmployeeServices.changeEmployeeName();
	}
	
	public static void insertEmployee() {
		EmployeeServices.InsertEmployee();
	}

	public static List<Employee> FetchAllEmployees() {
		return EmployeeServices.getAllEmployeeDetails();
	}

	public static void getEmployeeDetailsById() {
		EmployeeServices.FetchEmployeeDetailsById();
	}
	
	public static void getEmployeeDetailsByName() {
		EmployeeServices.FetchEmployeeDetailsById();
	}
	
	public static void fetchEmployeeDetailsBySalary() {
		 EmployeeServices.getEmployeeDetailsBySalary();
	}
	
	public static void ClearEmployeeDetailsByID() {
		EmployeeServices.deleteEmployeeDetailsByID();
	}

}
