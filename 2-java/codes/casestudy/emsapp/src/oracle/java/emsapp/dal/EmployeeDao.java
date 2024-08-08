package oracle.java.emsapp.dal;

import oracle.java.emsapp.entities.Employee;
import oracle.java.emsapp.repository.EmployeeRepository;

public class EmployeeDao implements DaoContract {

	
	
	@Override
	public boolean add(Employee employee) {
		Employee[] all = EmployeeRepository.getEmployees();
		Integer index = null;

		for (int i = 0; i < all.length; i++) {
			if (all[i] == null) {
				index = i;
				break;
			}
		}
		if (index == null) {
			return false;
		} else {
			all[index] = employee;
			return true;
		}
	}

	@Override
	public boolean update(Employee employee) {
		Integer index = null;

		Employee[] all = EmployeeRepository.getEmployees();
		for (int i = 0; i < all.length; i++) {
			if (all[i] != null) {
				if (all[i].getId() == employee.getId()) {
					index = i;
					break;
				}
			}
		}
		if (index != null) {
			all[index] = employee;
			return true;
		} else
			return false;
	}

	@Override
	public boolean delete(int id) {
		Employee[] all = EmployeeRepository.getEmployees();
		Integer index = null;
		for (int i = 0; i < all.length; i++) {
			if (all[i] != null) {
				if (all[i].getId() == id) {
					index = i;
					break;
				}
			}
		}
		if (index != null) {
			all[index] = null;
			return true;
		} else
			return false;
	}

	@Override
	public Employee[] getAll() {
		return EmployeeRepository.getEmployees();
	}

	@Override
	public Employee get(int id) {
		Employee employee = null;
		Employee[] all = EmployeeRepository.getEmployees();
		for (Employee e : all) {
			if (e != null) {
				if (e.getId() == id) {
					employee = e;
					break;
				}
			}
		}
		return employee;
	}

}
