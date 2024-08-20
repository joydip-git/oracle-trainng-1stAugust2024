package oracle.java.unittests.junitdemo;

import junit.framework.TestCase;

//TestSuite => CalculationTest (collection of test methods)

public class CalculationTest extends TestCase {

	public void testMultiply() {
		// Arrange
		Calculation calculation = new Calculation();
		int expected = 39;

		// Act
		int actual = calculation.multiply(12, 3);

		// Assert
		Assert.assertEquals(expected, actual);
	}
}
