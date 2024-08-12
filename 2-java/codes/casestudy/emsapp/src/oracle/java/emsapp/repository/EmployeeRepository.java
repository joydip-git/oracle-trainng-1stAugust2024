package oracle.java.emsapp.repository;

import java.util.List;
import java.util.Optional;

import oracle.java.emsapp.entities.Employee;
import oracle.java.emsapp.storage.EmployeeStorage;

public class EmployeeRepository implements RepositoryContract<Employee> {

	@Override
	public boolean add(Employee employee) {
		List<Employee> all = EmployeeStorage.getRecords();
		return all.add(employee);
	}

	@Override
	public boolean update(Employee employee) {
		List<Employee> all = EmployeeStorage.getRecords();
		boolean status = all.removeIf(e -> e.getId() == employee.getId());
		if (status) {
			all.add(employee);
			return true;
		} else
			return false;
	}

	@Override
	public boolean delete(int id) {
		List<Employee> all = EmployeeStorage.getRecords();
		boolean status = all.removeIf(e -> e.getId() == id);
		return status;
	}

	@Override
	public List<Employee> getAll() {
		return EmployeeStorage.getRecords();
	}

	@Override
	public Employee get(int id) {
		List<Employee> all = EmployeeStorage.getRecords();
		Optional<Employee> found = all.stream()
				.filter(e -> e.getId() == id).findFirst();
		if (!found.isEmpty()) {
			return found.get();
		} else
			return null;
	}

}
