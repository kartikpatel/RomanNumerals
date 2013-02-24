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
public class RomanNumeralTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RomanNumeralTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RomanNumeralTest.class );
    }

    /**
     * Tests RomanNumeral.DESCENDING_ORDER contains all RomanNumeral values
     */
    public void testDescendingOrderArray()
    {
    	boolean containsAll = true;
    	for (RomanNumeral rn : RomanNumeral.values()) {
    		boolean contains = false;
    		for (RomanNumeral dorn : RomanNumeral.DESCENDING_ORDER) {
    			contains |= rn == dorn;
    		}
    		containsAll &= contains;
    	}
    	
        assertTrue("RomanNumeral.DESCENDING_ORDER does not contain all RomanNumeral values", containsAll);
    }
}
