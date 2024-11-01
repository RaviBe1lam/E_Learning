package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	public static Connection connect() throws Exception {
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String URL="jdbc:C://Program Files/MySQLMySQL Server 8.0/my.ini/DESKTOP-4MF2OSG/elearning";
		Connection con=DriverManager.getConnection(URL, "root", "50014");
		return con;
	}
}
