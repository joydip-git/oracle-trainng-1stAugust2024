package genericdemo;

public class Product {
	private int productId;
	private String productName;
	private String description;
	private double price;
	private int categoryId;
	
	//navigation or association property
	private Category categoryInfo;
	
	public Product() {
		
	}
	public Product(int productId, String productName, String description, double price, int categoryId, Category categoryInfo) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.categoryId = categoryId;
		this.categoryInfo = categoryInfo;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategoryInfo() {
		return categoryInfo;
	}
	public void setCategoryInfo(Category categoryInfo) {
		this.categoryInfo = categoryInfo;
	}	
}
