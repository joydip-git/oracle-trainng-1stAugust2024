package excetptionsdemo;

/*
public class AgeLessThanPermissibleLimitException 
								extends Exception {
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public AgeLessThanPermissibleLimitException() {
		this.errorMessage = "age is lessn than permissible limit";
	}

	public AgeLessThanPermissibleLimitException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
*/
public class AgeLessThanPermissibleLimitException extends Exception {
	private static final long serialVersionUID = 1L;

	public AgeLessThanPermissibleLimitException() {
		super("age is lessn than permissible limit");
	}

	public AgeLessThanPermissibleLimitException(String errorMessage) {
		super(errorMessage);
	}
}
