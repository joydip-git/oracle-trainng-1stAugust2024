package firstdbapp;

import java.sql.Statement;
import java.sql.Types;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import oracle.jdbc.driver.OracleDriver;

public class App {

	public static void main(String[] args) {
		/*
		 * create or replace function fetch_product_count_for_category(category_id
		 * number) return number as l_product_count number; begin select
		 * count(product_name) into l_product_count from products where
		 * category_id=category_id; return l_product_count; end;
		 */
		Connection connection = null;
		CallableStatement callableStatement = null;
		String query = "{?=call fetch_product_count_for_category(?)}";
		try {

			DaoUtility.readConfigurationData("src//database.properties");
			DaoUtility.loadDriver();
			connection = DaoUtility.createConnection();

			callableStatement = connection.prepareCall(query);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.setInt(2, 1);

			callableStatement.execute();
			System.out.println("total number of products for category:1 is: " + callableStatement.getInt(1));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	static void storedProcedureWithOutParameter() {
		/*
		 * create or replace procedure get_product_count( productcount OUT number) as
		 * l_product_count number; begin select count(product_name) into l_product_count
		 * from products; productcount :=l_product_count; end;
		 */
		Connection connection = null;
		CallableStatement callableStatement = null;
		String query = "{call get_product_count(?)}";
		try {

			DaoUtility.readConfigurationData("src//database.properties");
			DaoUtility.loadDriver();
			connection = DaoUtility.createConnection();

			callableStatement = connection.prepareCall(query);
			callableStatement.registerOutParameter(1, Types.INTEGER);

			callableStatement.execute();
			System.out.println("total number of products: " + callableStatement.getInt(1));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	static void useStoredProcedureForInsert() {
		/*
		 * create or replace procedure add_product( pisbn IN products.isbn%type, pname
		 * IN products.product_name%type, pprice IN products.price%type, pcid IN
		 * products.category_id%type ) as begin insert into
		 * products(isbn,product_name,price,category_id)
		 * values(pisbn,pname,pprice,pcid); end;
		 */
		Connection connection = null;
		CallableStatement callableStatement = null;
		String query = "{call add_product(?,?,?,?)}";
		try {

			DaoUtility.readConfigurationData("src//database.properties");
			DaoUtility.loadDriver();
			connection = DaoUtility.createConnection();

			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, 213);
			callableStatement.setString(2, "new product2");
			callableStatement.setDouble(3, 4100);
			callableStatement.setInt(4, 3);

			callableStatement.execute();
			System.out.println("record got added");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	static void insertRecord() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into products(isbn,product_name,price,category_id) values(?,?,?,?)";
		try {

			DaoUtility.readConfigurationData("src//database.properties");
			DaoUtility.loadDriver();
			connection = DaoUtility.createConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 321);
			preparedStatement.setString(2, "new product");
			preparedStatement.setDouble(3, 4999);
			preparedStatement.setInt(4, 1);

			int result = preparedStatement.executeUpdate();
			System.out.println(result > 0 ? result + " got added" : "no record added");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	static void fetchData() {
		Connection connection = null;
		// Statement statement = null;
		// String query = "select * from products";
		PreparedStatement preparedStatement = null;
		// String query = "select * from products where isbn=?";
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
			// preparedStatement.setInt(1, 102);
			preparedStatement.setDouble(1, 10000);
			preparedStatement.setDouble(2, 130000);

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
