/**
 * User: kartikpatel
 * Date: 2/23/13
 * Time: 12:38 AM
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Class to represent Roman numbers
 * @author kartikpatel
 */
public class RomanNumber extends Number {
	
	/**
	 * serialVersionUID for interoperability
	 */
	private static final long serialVersionUID = -6802642821576965650L;
	
	/**
	 * A constant holding the maximum value a RomanNumber can have
	 */
	public static int MAX_VALUE = 3999;
	
	/**
	 * A constant holding the minimum value a RomanNumber can have
	 */
	public static int MIN_VALUE = 1;
	
	/**
	 * cache to hold RomanNumber values
	 */
	private static final Map<Integer, String> cache = new HashMap<Integer, String>(MAX_VALUE - 1);
	
	/**
	 * static block to initialize cache
	 */
	static {
		// loop over all represented values
		for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
			int target = i;
			StringBuilder sb = new StringBuilder();
			// loop over RomanNumerals in descending order
			for (RomanNumeral rn : RomanNumeral.DESCENDING_ORDER) {
				int div = target / rn.intValue();
				target = target % rn.intValue();
				for (int j = 0; j < div; j++)
				{
					sb.append(rn.toString());
				}
			}
			cache.put(Integer.valueOf(i), sb.toString());		
		}
	}
	
	private final int value;
	
	/**
	  * Constructs a newly allocated {@code RomanNumber} object that
	  * represents the specified {@code int} value.
	  *
	  * @param   value   the value to be represented by the
	  *                  {@code Integer} object.
	  */
	public RomanNumber(int value) throws NumberFormatException {
		if (value < MIN_VALUE || value > MAX_VALUE) throw new NumberFormatException("value is outside RomanNumber range");
		this.value = value;
	}
	
	/**
	  * Constructs a newly allocated {@code RomanNumber} object that
	  * represents the {@code int} value indicated by the
	  * {@code String} parameter. The string is converted to an
	  * {@code int} value in exactly the manner used by the
	  * {@code parseInt} method.
	  *
	  * @param      s   the {@code String} to be converted to an
	  *                 {@code RomanNumber}.
	  * @exception  NumberFormatException  if the {@code String} does not
	  *             contain a parsable RomanNumber.
	  * @see        RomanNumber#parseInt(java.lang.String, int)
	  */
	public RomanNumber(String s) throws NumberFormatException {
		this.value = parseInt(s);
	}

	/**
	  * Returns the value of this {@code RomanNumber} as a
	  * {@code double}.
	  */
	@Override
	public double doubleValue() {
		return (double)value;
	}

	/**
	  * Returns the value of this {@code RomanNumber} as a
	  * {@code float}.
	  */
	@Override
	public float floatValue() {
		return (float)value;
	}

	/**
	  * Returns the value of this {@code RomanNumber} as a
	  * {@code int}.
	  */
	@Override
	public int intValue() {
		return value;
	}

	/**
	  * Returns the value of this {@code RomanNumber} as a
	  * {@code long}.
	  */
	@Override
	public long longValue() {
		return (long)value;
	}
	
	/**
	 * Parses the string argument as a Roman Number into a 
	 * an integer value that is returned.
	 * @param s the {@code String} containing the Roman number
     *          representation to be parsed
	 * @return the integer represented by the string argument
	 * @throws NumberFormatException  if the string cannot be parsed 
	 * 	       as an integer
	 */
	public static int parseInt(String s) throws NumberFormatException {
		for (Map.Entry<Integer, String> entry : cache.entrySet()) {
			if (entry.getValue().equals(s))
			{
				return entry.getKey().intValue();
			}
		}
		throw new NumberFormatException("Error formatting " + s + " to RomanNumber");
	}
	
	/**
	 * Returns a {@code RomanNumber} object holding the
	 * value of the specified {@code String}.
	 * @param      s the string to be parsed
	 * @return     a {@code RomanNumber} object holding the value
     *             represented by the string argument.
	 * @exception  NumberFormatException  if the string cannot be parsed 
	 * 	           as an integer
	 * @see        RomanNumber#parseInt(java.lang.String, int)
	 */
	public static RomanNumber valueOf(String s) throws NumberFormatException {
		return RomanNumber.valueOf(parseInt(s));
	}
	
	/**
	 * Returns a {@code RomanNumber} object holding the
	 * value of the specified {@code int}.
	 * @param i an {@code int} value.
	 * @return an {@code RomanNumber} instance representing {@code i}.
	 */
	public static RomanNumber valueOf(int i) {
		assert i >= MIN_VALUE;
		assert i <= MAX_VALUE;
		return new RomanNumber(i);
	}
	
	/**
	 * Returns a string representation of the integer argument
	 * @param  i an integer to be converted to a roman number string.
	 * @return a roman number string representation of the 
	  *        argument
	 */
	public static String toString(int i) {
		assert i >= MIN_VALUE;
		assert i <= MAX_VALUE;
		return cache.get(Integer.valueOf(i));
	}

	/**
	  * Returns a {@code String} object representing this
	  * {@code RomanNumber}'s value. The value is returned 
	  * as a string, exactly as if the integer value were 
	  * given as an argument to the {@link
	  * RomanNumber#toString(int)} method.
	  *
	  * @return  a roman number string representation of the 
	  *          value of this object
	  */
	@Override
	public String toString() {
		return toString(value);
	}
	
}
