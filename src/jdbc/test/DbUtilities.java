package jdbc.test;

import java.sql.Types;

public class DbUtilities {
	public static boolean isText(int type) {
		boolean verit� = true;
		switch(type) {
		case Types.BOOLEAN:
		case Types.BIGINT:
		case Types.BIT:
		case Types.DECIMAL:
		case Types.DOUBLE:
		case Types.FLOAT:
		case Types.INTEGER:
		case Types.NUMERIC:
		case Types.REAL:
		case Types.TINYINT:
		case Types.SMALLINT:
			verit� = false;
		}
		return verit�;
	}
	
	public static boolean isNumber(int type) {
		return !isText(type);
	}
}
