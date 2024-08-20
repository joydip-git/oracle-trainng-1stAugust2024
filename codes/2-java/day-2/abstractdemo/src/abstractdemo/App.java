package abstractdemo;

public class App {

	public static void main(String[] args) {
		//abstract base class
		DataAccess dataAccess = null;
		dataAccess = new DbDataAccess("");
		System.out.println(dataAccess.getData());
		
		//interface as base
		Calculation calc = new CalculationImplementation();
		
	}
}
