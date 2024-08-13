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
}
