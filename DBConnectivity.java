package student;

import java.sql.*;

public class DBConnectivity {
	
	/*
	 * This class is exclusively made to create connection to our database. 
	 * In our DaiImpl classes again and again we will have to register driver and make connection so same code
	 * will be repeated again and again in all methods.
	 * So instead of repeating the code we have made a static method which will make connection for us.
	 * So from mow on whenever we need to make connection object, we will simply call this method from DBConnectivity class
	 */
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=10111999");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
