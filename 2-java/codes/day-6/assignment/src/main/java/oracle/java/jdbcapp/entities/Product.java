package oracle.java.jdbcapp.entities;

public class Product {
    private int isbn;
    private String productName;
    private int productId;
    private double price;
    private String description;
    private int categoryId;
    private Category category;

    public Product() {
    }

    public Product(int isbn, String productName, int productId, double price, String description, int categoryId,
            Category category) {
        this.isbn = isbn;
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.category = category;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [isbn=" + isbn + ", productName=" + productName + ", productId=" + productId + ", price="
                + price + ", description=" + description + ", categoryId=" + categoryId + ", category=" + category
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + productId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId != other.productId)
            return false;
        return true;
    }
}
