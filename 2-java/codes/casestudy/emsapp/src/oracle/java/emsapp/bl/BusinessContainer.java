package oracle.java.emsapp.bl;

import oracle.java.emsapp.dal.DaoContainer;
import oracle.java.emsapp.dal.EmployeeDao;

public class BusinessContainer {

private static BusinessContainer container;
	
	private BusinessContainer() {

	}

	public static BusinessContainer instantiate() {
		if(container ==null)
			container = new BusinessContainer();
		
		return container;
	}
	public EmployeeBusinessComponent create() {
		return new EmployeeBusinessComponent(DaoContainer.instantiate().create());
	}
}
