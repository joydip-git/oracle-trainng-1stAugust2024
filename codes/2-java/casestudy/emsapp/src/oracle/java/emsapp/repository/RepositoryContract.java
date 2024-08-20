package oracle.java.emsapp.repository;

import java.util.List;

public interface RepositoryContract<T> {
	boolean add(T record);
	boolean update(T record);
	boolean delete(int id);
	//Employee[] getAll();
	List<T> getAll();
	T get(int id);
}
