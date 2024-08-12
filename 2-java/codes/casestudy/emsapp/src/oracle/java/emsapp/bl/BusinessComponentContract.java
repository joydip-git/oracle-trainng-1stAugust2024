package oracle.java.emsapp.bl;

import java.util.List;

public interface BusinessComponentContract<T> {
	boolean insert(T record);
	boolean modify(T record);
	boolean remove(int id);
	List<T> fetchtAll(int sortChoice);
	T fetchById(int id);	
}
