package oracle.java.emsapp.storage;

import java.util.ArrayList;
import java.util.List;

import oracle.java.emsapp.entities.Employee;

public class EmployeeStorage {
	//private static Employee[] employees;
	private static List<Employee> employees;
	
	static {
		employees = new ArrayList<Employee>();
	}
	
	public static List<Employee> getRecords() {
		return employees;
	}
}
