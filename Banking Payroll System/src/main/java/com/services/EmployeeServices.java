package com.services;


import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.dao.AllEmployeeDetails;
import com.entity.Employee;

public class EmployeeServices {

	public static Employee SalaryHike() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Scanner s1 = new Scanner(System.in);

		System.out.print("Enter EmpId For Salary Hike: ");
		int empId = s1.nextInt();
		Employee employee = session.get(Employee.class, empId);

		System.out.print("Enter Salary Hike Percentage: ");
		int percentage = s1.nextInt();
		int currentSalary = employee.getEmpSalary();
		int Hike = (percentage * currentSalary) / 100;
		int newSalary = currentSalary + Hike;

		employee.setEmpSalary(newSalary);
		System.out.println("Salary Updated Successfully! New Salary: " + newSalary);
		employee.setEmpSalary(newSalary);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		return employee;
	}

	public static void changeEmployeeName() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Scanner s2 = new Scanner(System.in);
		System.out.print("Enter EmpId To Change Name: ");
		int empId = s2.nextInt();
		s2.nextLine();
		Employee e1 = session.get(Employee.class, empId);
		if (e1 == null) {
			System.out.println("Enter Valid Id");
		} else {
			System.out.print("Enter New Name: ");
			String empName = s2.nextLine();
			e1.setEmpName(empName);
			Transaction tx = session.beginTransaction();
			tx.commit();
			System.out.println("The Name Has Been Changed Successfully!!");
		}

	}

	public static void InsertEmployee() {
		Configuration cfg = new Configuration();
		cfg.configure();// read hibernate.cfg.xml file
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Scanner s3 = new Scanner(System.in);

		System.out.println("Enter empId :");
		int empId = s3.nextInt();
		s3.nextLine();

		System.out.println("Enter empSalary :");
		int empSalary = s3.nextInt();
		s3.nextLine();

		System.out.println("Enter empName :");
		String empName = s3.nextLine();

		Employee e1 = new Employee(empId, empName, empSalary);
		session.save(e1);
		session.beginTransaction().commit();
	}

	static public List<Employee> getAllEmployeeDetails() {
		List<Employee> allEmployees1 = AllEmployeeDetails.AllEmployees();
		for (Employee employee : allEmployees1) {
			System.out.println(employee);
		}
		return allEmployees1;

	}

	static public Employee FetchEmployeeDetailsById() {
		Scanner s4 = new Scanner(System.in);
		int Id = s4.nextInt();
		List<Employee> e1 = AllEmployeeDetails.AllEmployees();
		Employee ee = new Employee();
		for (Employee employee : e1) {
			if (Id == employee.getEmpId()) {
				ee.setEmpId(employee.getEmpId());
				ee.setEmpName(employee.getEmpName());
				ee.setEmpSalary(employee.getEmpSalary());
				System.out.println("Empid=" + ee.getEmpId());
				System.out.println("EmpName=" + ee.getEmpName());
				System.out.println("EmpSalary=" + ee.getEmpSalary());

			}
		}
		return ee;
	}

	static public Employee FetchEmployeeDetailsByName() {
		Scanner s5 = new Scanner(System.in);
		String Name = s5.nextLine();
		List<Employee> e1 = AllEmployeeDetails.AllEmployees();
		Employee ee = new Employee();
		for (Employee employee : e1) {
			if (Name == employee.getEmpName()) {
				ee.setEmpId(employee.getEmpId());
				ee.setEmpName(employee.getEmpName());
				ee.setEmpSalary(employee.getEmpSalary());
				System.out.println("Empid=" + ee.getEmpId());
				System.out.println("EmpName=" + ee.getEmpName());
				System.out.println("EmpSalary=" + ee.getEmpSalary());
			}
		}
		return ee;
	}

	public static Employee getEmployeeDetailsBySalary() {
		Scanner s6 = new Scanner(System.in);
		int salary = s6.nextInt();
		List<Employee> List = AllEmployeeDetails.AllEmployees();
		for (Employee employee : List) {
			if (employee.getEmpSalary() == salary) {
				return employee;
			} 
		}
		System.out.println("Enter Correct Salary");
		return null;

	}

	static public void deleteEmployeeDetailsByID() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Scanner s4 = new Scanner(System.in);

		System.out.println("Enter EmpId To delete record: ");
		int empId = s4.nextInt();
		Employee e1 = session.get(Employee.class, empId);
		session.delete(e1);
		session.beginTransaction().commit();
	}
}
