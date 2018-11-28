package pack;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBMS {

	public DBMS() {
		getConnection();
	}
	
		public static Connection getConnection() {

		
			Connection connection = null;

			
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "houssam123");
			

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

	   return connection;
	   
		}
}

	

