package com.java.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductDataAccessTest {

    private ProductDataAccess dataAccess;

    @Before
    public void setUp() {
        dataAccess = new ProductDataAccess();
    }

    @After
    public void tearDown() {
        dataAccess = null;
    }

    @Test
    public void testGetProductByISBNPositive() throws DaoException {
        Product actual = dataAccess.getProductByISBN(102);
        Product expected = new Product(102, "iphone15", 43, 150000, null, 2);

        assertEquals(expected, actual);
    }

    @Test(expected = DaoException.class)
    public void testGetProductByISBNExceptionFlow() throws DaoException {
        dataAccess.getProductByISBN(0);
    }

    @Test
    public void testGetProductByISBNException() {
        try {
            dataAccess.getProductByISBN(-1);
        } catch (DaoException e) {
            assertEquals(
                    Constants.INCORRECT_ISBN_MESSAGE,
                    e.getMessage());
        }
    }
}
