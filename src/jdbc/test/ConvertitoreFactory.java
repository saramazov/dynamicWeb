package jdbc.test;

import java.lang.reflect.InvocationTargetException;

public class ConvertitoreFactory {
	
	public static Convertitore createConvertitore(String format) {
		/*if(format.toUpperCase().equals("HTML")) {
			return new ConvertitoreHTML();
		}
		if(format.toUpperCase().equals("CSV")) {
			return new ConvertitoreCSV();
		}*/
		
		try {
			String pkg =  Convertitore.class.getPackage().getName();
			pkg =  Convertitore.class.getPackageName();

			return (Convertitore) 
				Class.forName(pkg+".Convertitore"+format.toUpperCase())
				.getDeclaredConstructor().newInstance();
				
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

}
