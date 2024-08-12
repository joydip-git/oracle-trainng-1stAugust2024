package oracle.java.emsapp.bl;

import java.util.List;
import java.util.stream.Stream;

import oracle.java.emsapp.entities.Employee;
import oracle.java.emsapp.repository.RepositoryContract;

public class EmployeeBusinessComponent
		implements EmployeeBusinessComponentContract {

	private RepositoryContract<Employee> dao;

	public EmployeeBusinessComponent(RepositoryContract<Employee> dao) {
		this.dao = dao;
	}

	@Override
	public boolean insert(Employee employee) {
		if (employee != null) {
			List<Employee> all = dao.getAll();
			if (all.size() > 0) {
				Employee lastEmp = all.stream().sorted((e1, e2) -> e1.getId() - e2.getId()).toList().getLast();
				employee.setId(lastEmp.getId() + 1);
			} else
				employee.setId(100);

			return dao.add(employee);
		} else
			return false;
	}

	@Override
	public boolean modify(Employee employee) {
		if (employee != null) {
			return dao.update(employee);
		} else
			return false;
	}

	@Override
	public boolean remove(int id) {
		return dao.delete(id);
	}

	@Override
	public List<Employee> fetchtAll(int sortChoice) {
		Stream<Employee> all = dao.getAll().stream();
		switch (sortChoice) {
		case 1:
			all = all.sorted((e1, e2) -> e1.getId() - e2.getId());
			break;

		case 2:
			all = all.sorted((e1, e2) -> e1.getName().compareTo(e2.getName()));
			break;

		case 3:
			all = all.sorted((e1, e2) -> Double.compare(e1.getTotalPayment(), e2.getTotalPayment()));
			break;

		default:
			all = all.sorted((e1, e2) -> e1.getId() - e2.getId());
			break;
		}
		return all.toList();
	}

	@Override
	public Employee fetchById(int id) {
		return dao.get(id);
	}

	@Override
	public List<Employee> filterEmployeesBySalaryRange(int minSalary, int maxSalary) {
		return dao.getAll().stream()
				.filter(e -> e.getTotalPayment() >= minSalary && e.getTotalPayment() <= maxSalary)
				.toList();
	}

	@Override
	public List<Employee> filterEmployeeByName(String name) {
		return dao.getAll().stream().filter(e -> e.getName().contains(name)).toList();
	}
}
