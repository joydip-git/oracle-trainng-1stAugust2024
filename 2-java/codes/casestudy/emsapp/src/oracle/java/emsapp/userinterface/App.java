package oracle.java.emsapp.userinterface;

import oracle.java.emsapp.bl.BusinessComponentContract;
import oracle.java.emsapp.bl.BusinessContainer;

public class App {

	public static void main(String[] args) {
		BusinessComponentContract bo = BusinessContainer.instantiate().create();
		
	}

}
