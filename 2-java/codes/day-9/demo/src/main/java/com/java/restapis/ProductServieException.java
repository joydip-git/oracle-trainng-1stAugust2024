package com.java.restapis;

public class ProductServieException extends Exception {
    public ProductServieException() {
        super("error occurred");
    }

    public ProductServieException(String message) {
        super(message);
    }
}
