package excetptionsdemo;

public class App {

	public static void main(String[] args) {
		DrivingLicenseApplication application = null;
		try {
			application = new DrivingLicenseApplication();
			application.setName("vikash");
			application.setAge(16);
		} catch (AgeLessThanPermissibleLimitException e) {
			e.printStackTrace();
		}
	}

	static void callDivide() {
		try {
			divide(12, 0);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			StackTraceElement[] traceStack = e.getStackTrace();
			for (StackTraceElement stackTraceElement : traceStack) {
				System.out.println(stackTraceElement.getClassName() + ", " + stackTraceElement.getLineNumber() + ", "
						+ stackTraceElement.getMethodName() + ", " + stackTraceElement.getFileName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// executes any code
		}
		try {
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
	}

	static void divide(int a, int b) {
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			throw e;
		}
	}
}
