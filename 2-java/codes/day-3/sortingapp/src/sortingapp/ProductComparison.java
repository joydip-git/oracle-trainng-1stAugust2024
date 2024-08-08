package sortingapp;

import java.util.Comparator;

public class ProductComparison implements Comparator<Product> {

	private int choice;

	public ProductComparison(int choice) {
		this.choice = choice;
	}

	public int compare(Product p1, Product p2){
		Integer compRes = null;
		switch (choice) {
		case 1:
			compRes =Integer.compare(p1.getProductId(),p2.getProductId());
			break;
		case 2:
			compRes =p1.getProductName().compareTo(p2.getProductName());
			break;
		case 3:
			compRes =Double.compare(p1.getPrice(),p2.getPrice());
			break;

		default:
			break;
		}
		if(compRes==null)
			return 0;
		else
			return compRes.intValue();
		/*
		 * if (p1.getProductId() == p2.getProductId()) if
		 * (p1.getProductName().equals(p2.getProductName())) return
		 * Double.compare(p1.getPrice(), p2.getPrice()); else return
		 * p1.getProductName().compareTo(p2.getProductName()); else return
		 * Integer.compare(p1.getProductId(), p2.getProductId());
		 */
	}
}
