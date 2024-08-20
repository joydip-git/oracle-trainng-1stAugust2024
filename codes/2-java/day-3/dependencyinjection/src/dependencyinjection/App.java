package dependencyinjection;

public class App {

	public static void main(String[] args) {
		Category[] categories = new Category[3];
		categories[0] = new Category(1, "laptop", null);
		categories[1] = new Category(2, "mobile", null);
		categories[2] = new Category(3, "book", null);

		Product[] products = new Product[3];
		products[0] = new Product(1, "dell xps", "new laptop from dell", 12000, 0, null);
		products[0].setCategoryInfo(categories[0]);

		products[1] = new Product(2, "iphone 15", "new mobile from apple", 120000, 0, categories[1]);
		products[2] = new Product(3, "the alchemist", "new book from pal cohelo", 1200, 0, categories[2]);

		categories[0].setProducts(new Product[] { products[0] });
		categories[1].setProducts(new Product[] { products[1] });
		categories[2].setProducts(new Product[] { products[2] });

		System.out.println(products[0].getCategoryInfo().getCategoryName());

		System.out.println("products belonging to category: 1");
		for (Category category : categories) {
			if (category.getCategoryId() == 1) {
				Product[] cproducts = category.getProducts();
				for (Product product : cproducts) {
					System.out.println(product.getProductName());
				}
			}
		}
	}

}
