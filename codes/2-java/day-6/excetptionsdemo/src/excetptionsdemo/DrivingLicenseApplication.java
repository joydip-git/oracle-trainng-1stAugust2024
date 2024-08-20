package excetptionsdemo;

public class DrivingLicenseApplication {
	private String name;
	private int age;

	public DrivingLicenseApplication() {
	}

	public DrivingLicenseApplication(String name, int age) 
			throws AgeLessThanPermissibleLimitException{
		this.name = name;
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeLessThanPermissibleLimitException{
		if (age < 18) {
			AgeLessThanPermissibleLimitException e 
			= new AgeLessThanPermissibleLimitException(
					"current age: "+age
					+" is less than the permissible age limit: 18");
			throw e;
		} else {
			this.age = age;
		}
	}
}
