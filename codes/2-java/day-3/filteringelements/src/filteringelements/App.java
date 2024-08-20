package filteringelements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		// list.remove(0);
		// list.remove(12);

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Object[] arr = new Object[4];
		arr[0] = 12;

//		long x = 1234567891;
//		Object xObj = x;
//		short sh = (short) xObj;
	}

}
