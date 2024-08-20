package sortingapp;

public class Product implements Comparable<Product> {
	private int productId;
	private String productName;
	private String description;
	private double price;

	public Product() {

	}

	public Product(int productId, String productName, String description, double price) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
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

	@Override
	public int compareTo(Product o) {
		return Integer.compare(this.productId, o.productId);
//		if (this.productId == o.productId)
//			if (this.productName.equals(o.productName))
//				return Double.compare(this.price, o.price);
//			else
//				return this.productName.compareTo(o.productName);
//		else
//			return Integer.compare(this.productId, o.productId);
	}

	@Override
	public String toString() {
		// return this.getClass().getCanonicalName();
		return this.productName + ", " + this.productId + "," + this.price;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(productId);
//		final int prime = 31;
//		int hash = Integer.hashCode(productId) * prime;
//		hash = productName.hashCode() * hash;
//		hash = Double.hashCode(price) * hash;
//		return description.hashCode() * hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj instanceof Product) {
			Product other = (Product) obj;
			if (this == other)
				return true;

			if (this.productId != other.productId)
				return false;

			if (!this.productName.equals(other.productName))
				return false;

			if (this.price != other.price)
				return false;

			if (!this.description.equals(other.description))
				return false;

			return true;

		} else
			return false;
	}

}
