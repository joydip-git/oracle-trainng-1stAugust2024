package sortingapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class App {

	public static void main(String[] args) {
//		List<Product> products = createCollectionofProducts();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("1-id\n2-name\n3-price");
//		System.out.print("\nenter choice[1/2/3]: ");
//		int choice = scanner.nextInt();
//		sortProducts(choice, products);
//		for (Product product : products) {
//			System.out.println(product);
//		}
		// createSetOfProducts();

		Map<Integer, String> mapOfPeople = new TreeMap<Integer, String>();
		mapOfPeople.put(1, "anil");
		mapOfPeople.put(0, "sunil");
		mapOfPeople.put(2, "mahesh");
		
		Set<Entry<Integer, String>> setOfEntries = mapOfPeople.entrySet();
		for (Entry<Integer, String> entry : setOfEntries) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}	
		//mapOfPeople.put(1, null)
	}

	private static void createSetOfProducts() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(1);
		set.add(2);

		for (Integer i : set) {
			System.out.println(i);
		}

		Set<Product> products = new HashSet<Product>();
		Product p1 = new Product(3, "dell xps", "new laptop from dell", 12000);
		Product p2 = new Product(1, "hp probook", "new laptop from hp", 13000);
		Product p3 = new Product(2, "lenovo", "new laptop from lenovo", 11000);
		Product p4 = new Product(2, "lenovo", "new laptop from lenovo", 11000);
		products.add(p1); // create hash code
		products.add(p2); // create hash code
		products.add(p3); // create hash code
		products.add(p1); // create hash code
		products.add(p4); // create hash code

		for (Product p : products) {
			System.out.println(p);
		}
	}

	static void sortProducts(int choice, List<Product> products) {
		// internalization of sorting logic:
		// expects the Product implements Comaparable<T> interface and its method
		// "int compareTo(T other)"
		// products.get(i).compareTo(products.get(j))

		// Collections.sort(products);

		// externalization of sorting logic:
		// expects an external class (ProductComparison) implements Comaparator<T>
		// interface and its method "int compare(T t1, T t2)"
		// cmp.compare(products.get(i),products.get(j))

		ProductComparison cmp = new ProductComparison(choice);
		Collections.sort(products, cmp);
	}

	static List<Product> createCollectionofProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(3, "dell xps", "new laptop from dell", 12000));
		products.add(new Product(1, "hp probook", "new laptop from hp", 13000));
		products.add(new Product(2, "lenovo", "new laptop from lenovo", 11000));
		return products;
	}

}
