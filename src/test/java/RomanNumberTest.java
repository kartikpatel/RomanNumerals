/**
 * User: kartikpatel
 * Date: 2/23/13
 * Time: 12:41 AM
 */
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RomanNumberTest extends TestCase {
	/**
	 * Create the test case
	 * @param testName name of the test case
	 */
	public RomanNumberTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(RomanNumberTest.class);
	}

	/**
	 * Test RomanNumber.MIN_VALUE
	 */
	public void testRomanNumberMinValue() {
		romanNumberTesterHelper(RomanNumber.MIN_VALUE, "I");
	}

	/**
	 * Test RomanNumber.MAX_VALUE
	 */
	public void testRomanNumberMaxValue() {
		romanNumberTesterHelper(RomanNumber.MAX_VALUE, "MMMCMXCIX");
	}

	/**
	 * Test RomanNumber for known values
	 */
	public void testRomanNumberKnownValues() {
		romanNumberTesterHelper(3, "III");
		romanNumberTesterHelper(29, "XXIX");
		romanNumberTesterHelper(38, "XXXVIII");
		romanNumberTesterHelper(291, "CCXCI");
		romanNumberTesterHelper(1999, "MCMXCIX");
	}

	/**
	 * Test RomanNumber for all representable values
	 */
	public void testRomanNumberRepresentableValues() {
		for (int i = RomanNumber.MIN_VALUE; i <= RomanNumber.MAX_VALUE; i++) {
			romanNumberTesterHelper(i);
		}
	}

	/**
	 * Test RomanNumber for all representable values
	 */
	public void testRomanNumberUnrepresentableValues() {
		boolean exception = false;
		try {
			romanNumberTesterHelper(0);
		} catch (NumberFormatException e) {
			exception = true;
		}
		assertTrue("NumberFormatException expected", exception);
		
		exception = false;
		try {
			romanNumberTesterHelper(4000);
		} catch (NumberFormatException e) {
			exception = true;
		}
		assertTrue("NumberFormatException expected", exception);
	}

	/**
	 * helper method for testing RomanNumber with known integer and string
	 * representations
	 * 
	 * @param i integer value
	 * @param s string value
	 */
	private void romanNumberTesterHelper(int i, String s) {
		// test with int argument constructor
		RomanNumber rn = new RomanNumber(i);
		assertEquals(i, rn.intValue());
		assertEquals((long) i, rn.longValue());
		assertEquals((float) i, rn.floatValue());
		assertEquals((double) i, rn.doubleValue());
		assertEquals(s, rn.toString());

		// test with string argument constructor
		rn = new RomanNumber(s);
		assertEquals(i, rn.intValue());
		assertEquals((long) i, rn.longValue());
		assertEquals((float) i, rn.floatValue());
		assertEquals((double) i, rn.doubleValue());
		assertEquals(s, rn.toString());

		// test static methods
		assertEquals(i, RomanNumber.parseInt(s));
		assertEquals(s, RomanNumber.valueOf(i).toString());
		assertEquals(i, RomanNumber.valueOf(s).intValue());
		assertEquals(RomanNumber.toString(i), rn.toString());
	}

	private void romanNumberTesterHelper(int i) {
		// test with int argument constructor
		RomanNumber rn = new RomanNumber(i);
		assertEquals(i, rn.intValue());
		assertEquals((long) i, rn.longValue());
		assertEquals((float) i, rn.floatValue());
		assertEquals((double) i, rn.doubleValue());

		// test static methods
		assertEquals(i, RomanNumber.valueOf(i).intValue());
		assertEquals(RomanNumber.toString(i), rn.toString());
	}
}
