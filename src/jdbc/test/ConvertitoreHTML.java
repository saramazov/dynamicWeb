package jdbc.test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConvertitoreHTML extends Convertitore {

	@Override
	public String converti(ResultSet results) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		ResultSetMetaData metadata = results.getMetaData();
		int nCol = metadata.getColumnCount();
		
		sb.append("<table>\n");
		sb.append("<tr>");
		
		for(int i=1; i<=nCol; i++) {
			sb.append("<th>");
    		sb.append(metadata.getColumnLabel(i));
    		sb.append("</th>");
    	}
		
		sb.append("</tr>\n");

		while(results.next()) {
			sb.append("<tr>");
        	for(int i=1; i<=nCol; i++) {
        		sb.append("<td>");
        		sb.append(results.getString(i));
        		sb.append("</td>");
        	}
    		sb.append("</tr>\n");
        }
		
		sb.append("</table>\n");

		return sb.toString();
		
	}

}
