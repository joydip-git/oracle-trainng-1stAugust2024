package oracle.java.emsapp.bl;

import oracle.java.emsapp.repository.RepositoryContainer;

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
		return new EmployeeBusinessComponent(RepositoryContainer.instantiate().create());
	}
}
