package oracle.java.jdbcapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet records = null;
        String query = "{ ? = call GET_PRODUCTS_BY_CATEGORY() }";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                            "Oracle2024");

            statement = connection.prepareCall(query);
            statement.registerOutParameter(1, Types.REF_CURSOR);

            statement.execute();
            records = (ResultSet) statement.getObject(1);
            while (records.next()) {
                System.out.println(records.getString("category_name"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
