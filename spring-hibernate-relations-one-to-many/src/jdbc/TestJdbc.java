package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = ""; //"jdbc:mysql://{address}:{port}/{database}?useSSL=false&serverTimezone=UTC" 
		String user = "";
		String pass = "";
		
		try {
			System.out.println("Connecting to Database: " + jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Succesfull");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
