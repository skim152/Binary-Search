
package shinyeobproject3;

/**
 *
 * @author Shinyeob Kim
 */

@SuppressWarnings("serial")
public class Expression extends Exception
{
	/**
	 * no-arg Constructor
	 */
	public Expression()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if NumberFormatExpression is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public Expression(String message)
	{	
		super(message);	
	}


}