package firstdbapp;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import oracle.jdbc.driver.OracleDriver;

public class App {

	public static void main(String[] args) {

		Connection connection = null;
		// Statement statement = null;
		// String query = "select * from products";
		PreparedStatement preparedStatement = null;
		//String query = "select * from products where isbn=?";
		String query = "select * from products where price>=? and price<=?";
		ResultSet records = null;
		try {

			// 1. dynamically load JDBC class from OJDBC 11 jar file
			DaoUtility.readConfigurationData("src//database.properties");
			DaoUtility.loadDriver();

			// 2. get connection object
			connection = DaoUtility.createConnection();

			// 3. create statement
			// statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setInt(1, 102);
			preparedStatement.setDouble(1,10000);
			preparedStatement.setDouble(2,130000);
			
			// 4. execute a query
			// executeQuery => used to execute a SELECT query which returns many values
			// records = statement.executeQuery(query);
			records = preparedStatement.executeQuery();
			while (records.next()) {
				int isbn = records.getInt("isbn");
				int id = records.getInt("product_id");
				String name = records.getString("product_name");
				double price = records.getDouble("price");
				String description = records.getString("description");
				int categoryId = records.getInt("category_id");
				System.out.println(
						isbn + ", " + id + ", " + name + ", " + price + ", " + description + ", " + categoryId);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
