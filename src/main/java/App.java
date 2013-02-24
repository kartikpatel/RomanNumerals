/**
 * User: kartikpatel
 * Date: 2/23/13
 * Time: 12:38 AM
 */
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * RomanNumber command line application
 */
public class App 
{
	private static final Options options;
	
	static {
		options = new Options();
	}
	
	/**
	 * Main method for App
	 * @param args input arguments
	 */
    public static void main(String[] args)
    {
    	// create the parser
        CommandLineParser parser = new GnuParser();
        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);
            
            // process arguments that are not options
            for (String s : line.getArgs()) {
            	if (NumberUtils.isNumber(s)) {
            		// output Roman number string of integer
            		System.out.println(RomanNumber.toString(NumberUtils.createInteger(s)));
            	} else {
            		// output integer value of Roman number string
            		System.out.println(RomanNumber.parseInt(s));
            	}
            }
        }
        catch( ParseException exp ) {
            // oops, something went wrong
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
        }
    }
}
