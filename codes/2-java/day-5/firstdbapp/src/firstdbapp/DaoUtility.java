package firstdbapp;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoUtility {

	private static Properties properties;

	static {
		properties = new Properties();
	}

	public static void readConfigurationData(String path) throws IOException {
		FileReader reader = new FileReader(path);
		properties.load(reader);
	}

	public static void loadDriver() throws ClassNotFoundException {
		if (properties != null) {
			Class.forName(properties.getProperty("driver"));
		}
	}

	public static Connection createConnection() throws SQLException {
		// loadDriver();
		if (properties != null) {
			return DriverManager.getConnection(
					properties.getProperty("dburl"),
					properties.getProperty("username"),
					properties.getProperty("password")
					);
		} else
			return null;
	}
}
