package oracle.java.emsapp.bl;

import oracle.java.emsapp.entities.Employee;

public interface BusinessComponentContract {
	boolean insert(Employee employee);
	boolean modify(Employee employee);
	boolean remove(int id);
	Employee[] fetchtAll(int sortChoice);
	Employee fetchById(int id);
}
