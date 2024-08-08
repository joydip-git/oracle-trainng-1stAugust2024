package oracle.java.emsapp.repository;

import oracle.java.emsapp.entities.Employee;

public class EmployeeRepository {
	private static Employee[] employees;
	
	static {
		employees = new Employee[10];
	}
	
	public static Employee[] getEmployees() {
		return employees;
	}
}
