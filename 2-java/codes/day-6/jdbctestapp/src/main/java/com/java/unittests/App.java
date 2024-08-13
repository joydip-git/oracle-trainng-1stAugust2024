package com.java.unittests;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ProductDataAccess dataAccess = null;
        Product product = null;

        try {
            dataAccess = new ProductDataAccess();
            product = dataAccess.getProductByISBN(102);
            System.out.println(product);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
