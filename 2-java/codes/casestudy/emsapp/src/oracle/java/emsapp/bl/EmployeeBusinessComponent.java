package oracle.java.emsapp.bl;

import oracle.java.emsapp.dal.DaoContainer;
import oracle.java.emsapp.dal.DaoContract;
import oracle.java.emsapp.entities.Employee;

public class EmployeeBusinessComponent implements BusinessComponentContract {

	private DaoContract dao;

	public EmployeeBusinessComponent(DaoContract dao) {
		//dao = DaoContainer.instantiate().create();
		this.dao = dao;
	}

	@Override
	public boolean insert(Employee employee) {
		return dao.add(employee);
	}

	@Override
	public boolean modify(Employee employee) {
		return dao.update(employee);
	}

	@Override
	public boolean remove(int id) {
		return dao.delete(id);
	}

	@Override
	public Employee[] fetchtAll(int sortChoice) {
		return dao.getAll();
	}

	@Override
	public Employee fetchById(int id) {
		return dao.get(id);
	}

}
