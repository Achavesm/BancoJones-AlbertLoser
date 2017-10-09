package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	static Connection connection ;
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test1", "aleix", "jupiter");
			
		} catch (Exception e) {
			
			System.out.println("Falló la coneción");
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
