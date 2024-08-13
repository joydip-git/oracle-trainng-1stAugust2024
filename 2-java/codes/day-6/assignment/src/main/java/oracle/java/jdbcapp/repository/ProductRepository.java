package oracle.java.jdbcapp.repository;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import oracle.java.jdbcapp.entities.Product;
import oracle.java.jdbcapp.repository.exceptions.DaoException;
import oracle.java.jdbcapp.repository.utility.DaoUtility;

public class ProductRepository implements AutoCloseable {

    private Connection connection;

    private void initializeAssets() throws DaoException {
        try {
            DaoUtility.loadDbConfiguration("src//recources//db.properties");
            DaoUtility.loadDriver();
        } catch (IOException e) {
            throw DaoUtility.wrapIntoDaoException(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw DaoUtility.wrapIntoDaoException(e.getMessage(), e);
        } catch (Exception e) {
            throw DaoUtility.wrapIntoDaoException(e.getMessage(), e);
        }

    }

    public void getProductsByCategory() throws DaoException {

        Map<String, List<Product>> result = null;
        CallableStatement statement = null;
        ResultSet records = null;
        String query = "{ ? = call GET_PRODUCTS_BY_CATEGORY() }";
        try {
            initializeAssets();
            connection = DaoUtility.createConnection();

            statement = connection.prepareCall(query);
            statement.registerOutParameter(1, Types.REF_CURSOR);

            statement.execute();
            records = (ResultSet) statement.getObject(1);

            if (records != null) {
                result = new TreeMap<>();
                while (records.next()) {
                    String cname = records.getString("category_name");
                    if (result.containsKey(cname)) {
                        List<Product> products = result.get(cname);
                        products.add(null);
                    }
                }
            }

        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw DaoUtility.wrapIntoDaoException(e.getMessage(), e);
        }
    }

    @Override
    public void close() throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw DaoUtility.wrapIntoDaoException(e.getMessage(), e);
        }
    }
}
