package genericdemo;

public class App {

	public static void main(String[] args) {
		add(12, 13);
		MyCollection<Integer> list = new MyCollection<Integer>();
		list.setElements(new Integer[4]);
		list.add(1);
	}

	static <E> void add(E x, E y) {

	}
}
