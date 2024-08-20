package oracle.java.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculationTest {

    private static Calculation calculation;

    @BeforeClass
    public static void init() {
        calculation = new Calculation();
    }

    @AfterClass
    public static void dispose() {
        calculation = null;
    }

    // @Before
    // public void setUp() {
    // calculation = new Calculation();
    // }

    // @After
    // public void tearDown() {
    // calculation = null;
    // }

    @Test
    public void testMultiForSuccess() {

        int actual = calculation.multiply(12, 3);

        assertEquals(36, actual);
    }

    @Test
    public void testMultiForError() {
        int actual = calculation.multiply(2, 3);
        int expected = 6;
        assertEquals(expected, actual);
    }
}
