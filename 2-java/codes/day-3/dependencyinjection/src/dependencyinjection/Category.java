package dependencyinjection;

public class Category {
	private int categoryId;
	private String categoryName;
	
	//navigation proprty (one->many association)
	private Product[] products;
	
	public Category() {		
	}
	public Category(int categoryId, String categoryName, Product[] products) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.products = products;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}	
}
