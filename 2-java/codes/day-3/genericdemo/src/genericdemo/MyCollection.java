package genericdemo;

public class MyCollection<T> {
	private T[] elements;
	static int index=0;
	public MyCollection() {		
	}
//	public T[] getElements() {
//		return elements;
//	}
	public void setElements(T[] elements) {
		this.elements = elements;
	}
	public void add(T element) {
		if(elements.length==index) {
			//code to expand the size
		}
		elements[index]=element;
		index++;
	}
}
