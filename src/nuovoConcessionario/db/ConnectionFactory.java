package nuovoConcessionario.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException, 
									SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =
     	       DriverManager.getConnection("jdbc:mysql://localhost/corso?"+
     	       "user=master&password=manager&serverTimezone=Europe/Rome");
		return connection;
	}

}
