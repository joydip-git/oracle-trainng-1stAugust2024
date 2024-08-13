package com.java.unittests;

public class Product {
    private int isbn;
    private String productName;
    private int productId;
    private double price;
    private String description;
    private int categoryId;

    public Product() {
    }

    public Product(int isbn, String productName, int productId, double price, String description, int categoryId) {
        this.isbn = isbn;
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + isbn;
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + productId;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + categoryId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;
        if (isbn != other.isbn)
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productId != other.productId)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (categoryId != other.categoryId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [isbn=" + isbn + ", productName=" + productName + ", productId=" + productId + ", price="
                + price + ", description=" + description + ", categoryId=" + categoryId + "]";
    }

}
