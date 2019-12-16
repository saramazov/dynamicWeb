package jdbc.test;

import java.sql.Connection;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {

	public String eseguiQuery(String query, Convertitore convertitore) throws Exception {
		Connection connection = null;
    	Statement statement = null;
    	ResultSet results = null;
        try {     
        	
        	connection = ConnectionFactory.getConnection();
	        statement = connection.createStatement(
	        		ResultSet.TYPE_SCROLL_SENSITIVE,  
	        		ResultSet.CONCUR_READ_ONLY
	        		);
	        
	        results = statement.executeQuery (query);
	        return convertitore.converti(results);
	      
	        	        
        } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new Exception("Errore durante l'accesso al DB!");
			
		} finally { 
	        try {
				results.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	        
   
	}
	
	
}


