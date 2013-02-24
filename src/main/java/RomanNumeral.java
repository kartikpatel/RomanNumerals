/**
 * User: kartikpatel
 * Date: 2/23/13
 * Time: 12:41 AM
 */
/**
 * Enumeration of Roman numerals that can appear in Roman numbers
 * @author kartikpatel
 */
public enum RomanNumeral {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);
    
    /**
     * RomarnNumeral array in descending order by value
     */
    public static final RomanNumeral[] DESCENDING_ORDER = new RomanNumeral[] {M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I};

    /**
     * int value of RomanNumeral
     */
    private final int intValue;
    
    /**
     * indicates the RomanNumeral is a composite two RomanNumeral values
     */
    private final boolean composite;

    /**
     * RomanNumeral constructor
     * defaults composite to false
     * @param intValue int value of RomanNumeral
     */
    RomanNumeral(int intValue) {
        this.intValue = intValue;
        composite = false;
    }

    /**
     * RomanNumeral constructor
     * @param intValue int value of RomanNumeral
     * @param composite composite value of RomanNumeral
     */
    RomanNumeral(int intValue, boolean composite) {
        this.intValue = intValue;
        this.composite = composite;
    }

    /**
     * int value of this RomanNumeral
     * @return int value of this RomanNumeral
     */
    public final int intValue() {
        return intValue;
    }

    /**
     * true if this RomanNumeral is a composite, false otherwise
     * @return composite value of this RomanNumeral
     */
    public final boolean isComposite() {
        return composite;
    }
}
