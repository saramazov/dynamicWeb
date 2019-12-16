package jdbc.test;

public class Main {

	public static void main(String[] args) throws Exception {
		
		QueryExecutor executor = new QueryExecutor();
		String query = "select * from province";
		String format = "csv";
		System.out.println(executor.eseguiQuery(query,
				ConvertitoreFactory.createConvertitore(format)));
	
	}
	
	

}
