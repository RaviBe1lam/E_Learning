package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	public static Connection connect() throws Exception {
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String URL="jdbc:mysql://localhost/elearning/";
		Connection con=DriverManager.getConnection(URL, "root", "50014");
		return con;
	}
}
