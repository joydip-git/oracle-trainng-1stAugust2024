package oracle.java.emsapp.dal;

import oracle.java.emsapp.entities.Employee;

public interface DaoContract {
	boolean add(Employee employee);
	boolean update(Employee employee);
	boolean delete(int id);
	Employee[] getAll();
	Employee get(int id);
}
