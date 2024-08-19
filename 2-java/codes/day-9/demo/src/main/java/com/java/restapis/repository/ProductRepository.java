package com.java.restapis.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;

import com.java.restapis.entities.Product;

public class ProductRepository implements RepositoryContract<Product>, AutoCloseable {
    private Connection connection;

    public ProductRepository() throws IOException, SQLException, ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Oracle2024");
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    @Override
    public List<Product> getAll() throws Exception {
        String query = "select * from products";
        Statement statement = null;
        List<Product> products = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                // resultSet = statement.executeQuery(query);
                products = new ArrayList<>();
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        Product p = new Product();
                        p.setIsbn(resultSet.getInt("isbn"));
                        p.setProductId(resultSet.getInt("product_id"));
                        p.setProductName(resultSet.getString("product_name"));
                        p.setPrice(resultSet.getDouble("price"));
                        p.setDescription(resultSet.getString("description"));
                        p.setCategoryId(resultSet.getInt("category_id"));

                        products.add(p);
                    }
                } catch (Exception e) {
                    throw e;
                }

                return products;
            } else
                throw new Exception("connection is null");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Product get(int id) throws Exception {
        String query = "select * from products where isbn=?";
        PreparedStatement statement = null;
        Product product = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        product = new Product();
                        product.setIsbn(resultSet.getInt("isbn"));
                        product.setProductId(resultSet.getInt("product_id"));
                        product.setProductName(resultSet.getString("product_name"));
                        product.setPrice(resultSet.getDouble("price"));
                        product.setDescription(resultSet.getString("description"));
                        product.setCategoryId(resultSet.getInt("category_id"));
                    }
                } catch (Exception e) {
                    throw e;
                }
                return product;
            } else
                throw new Exception("connection is null");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean add(Product data) throws Exception {
        String query = "insert into products(isbn, product_name,description, price, category_id) values(?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(query);
                statement.setInt(1, data.getIsbn());
                statement.setString(2, data.getProductName());
                statement.setString(3, data.getDescription());
                statement.setDouble(4, data.getPrice());
                statement.setInt(5, data.getCategoryId());

                int result = statement.executeUpdate();
                return result > 0;
            } else
                throw new Exception("connection is null");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update(int id, Product data) throws Exception {
        String query = "update products set product_name=?, description=?, price=?, category_id=? where isbn=?";
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(query);
                statement.setInt(5, id);
                statement.setString(1, data.getProductName());
                statement.setString(2, data.getDescription());
                statement.setDouble(3, data.getPrice());
                statement.setInt(4, data.getCategoryId());

                int result = statement.executeUpdate();
                return result > 0;
            } else
                throw new Exception("connection is null");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "delete from products where isbn=?";
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);

                return statement.executeUpdate() > 0;
            } else
                throw new Exception("connection is null");
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

}
