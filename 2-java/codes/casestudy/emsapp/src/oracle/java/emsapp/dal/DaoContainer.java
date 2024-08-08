package oracle.java.emsapp.dal;

public class DaoContainer {
	
	private static DaoContainer container;
	
	private DaoContainer() {

	}

	public static DaoContainer instantiate() {
		if(container ==null)
			container = new DaoContainer();
		
		return container;
	}
	public EmployeeDao create() {
		return new EmployeeDao();
	}
}
