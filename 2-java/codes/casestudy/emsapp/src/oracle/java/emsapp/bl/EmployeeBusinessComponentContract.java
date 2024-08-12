package oracle.java.emsapp.bl;

import java.util.List;

import oracle.java.emsapp.entities.Employee;

public interface EmployeeBusinessComponentContract 
extends BusinessComponentContract<Employee> {
	List<Employee> filterEmployeesBySalaryRange(int minSalary, int maxSalary);

	List<Employee> filterEmployeeByName(String name);
}
