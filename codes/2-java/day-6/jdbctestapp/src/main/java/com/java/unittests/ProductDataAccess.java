package com.java.unittests;

import java.io.FileNotFoundException;
//import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDataAccess {

    // create a method to fecth a record with some id
    // select * from products where pk_value=?
    // method returns an object of Product class

    public Product getProductByISBN(int isbn) throws DaoException {
        if (isbn > 0) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet records = null;
            String query = "select isbn, product_id as PID, product_name as NAME, price, description, category_id as CID from products where isbn=?";
            Product product = null;
            try {
                DaoUtility.loadDbConfiguration("src//resources//db.properties");
                DaoUtility.loadDriver();
                connection = DaoUtility.createConnection();

                statement = connection.prepareStatement(query);
                statement.setInt(1, isbn);

                records = statement.executeQuery();

                while (records.next()) {
                    product = new Product();
                    product.setIsbn(isbn);
                    product.setProductId(records.getInt("PID"));
                    product
                            .setProductName(records.getString("NAME"));
                    product.setDescription(records.getString("description"));
                    product.setPrice(records.getDouble("price"));
                    product.setCategoryId(records.getInt("CID"));
                }
                return product;
            } catch (FileNotFoundException e) {
                DaoException ex = new DaoException(e.getMessage(), e);
                throw ex;
            } catch (SQLException e) {
                DaoException ex = new DaoException(e.getMessage(), e);
                throw ex;
            } catch (ClassNotFoundException e) {
                DaoException ex = new DaoException(e.getMessage(), e);
                throw ex;
            } catch (IOException e) {
                DaoException ex = new DaoException(e.getMessage(), e);
                throw ex;
            } catch (Exception e) {
                DaoException ex = new DaoException(e.getMessage(), e);
                throw ex;
            } finally {
                try {
                    DaoUtility.closeConnection(connection);
                } catch (SQLException e) {
                    DaoException ex = new DaoException(e.getMessage(), e);
                    throw ex;
                } catch (Exception e) {
                    DaoException ex = new DaoException(e.getMessage(), e);
                    throw ex;
                }
            }
        } else
            throw new DaoException(Constants.INCORRECT_ISBN_MESSAGE);
    }
}
