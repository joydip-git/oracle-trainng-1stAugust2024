package oracle.java.emsapp.ioc;

import oracle.java.emsapp.dal.DaoContainer;

public class AppContainer {

private static AppContainer container;
	
	private AppContainer() {

	}

	public static AppContainer instantiate() {
		if(container ==null)
			container = new AppContainer();
		
		return container;
	}
	
}
