package jdbc.test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConvertitoreCSV extends Convertitore {

	@Override
	public String converti(ResultSet results) throws SQLException {
		
		StringBuilder sb= new StringBuilder();
		ResultSetMetaData metadata = results.getMetaData();
		int nCol = metadata.getColumnCount();
		
		for(int i=1; i<=nCol; i++) {
			sb.append('\"');
    		sb.append(metadata.getColumnLabel(i));
    		sb.append("\";");
    	}
		
		sb.setLength(sb.length()-1);
    	sb.append('\n');
		
		while(results.next()) {
        	for(int i=1; i<=nCol; i++) {
        		if(DbUtilities.isText(metadata.getColumnType(i))) {
        			sb.append('\"');
        		}
        		sb.append(results.getString(i));
        		if(DbUtilities.isText(metadata.getColumnType(i))) {
        			sb.append('\"');
        		}
        		sb.append(';');
        	}
        	sb.setLength(sb.length()-1);
        	sb.append('\n');
        }
		
		return sb.toString();
		
	}

}
