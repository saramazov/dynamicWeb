package jdbc.test;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Convertitore {
	
	public abstract String converti(ResultSet results) throws SQLException;
	

	
}
