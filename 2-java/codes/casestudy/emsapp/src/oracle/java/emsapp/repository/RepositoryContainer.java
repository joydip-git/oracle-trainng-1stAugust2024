package oracle.java.emsapp.repository;

import oracle.java.emsapp.entities.Employee;

public class RepositoryContainer {
	
	private static RepositoryContainer container;
	
	private RepositoryContainer() {

	}

	public static RepositoryContainer instantiate() {
		if(container ==null)
			container = new RepositoryContainer();
		
		return container;
	}
	public RepositoryContract<Employee> create() {
		return new EmployeeRepository();
	}
}
