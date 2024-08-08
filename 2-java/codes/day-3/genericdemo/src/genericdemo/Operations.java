package genericdemo;

public interface Operations<T, E> {
	boolean add(T element);
	boolean remove(E id);	
}
