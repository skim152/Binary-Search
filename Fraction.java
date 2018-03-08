
package shinyeobproject3;

/**
 *
 * @author Shinyeob Kim
 */
import javax.swing.JOptionPane;


public class Fraction implements Comparable
{
	private String fraction; // String that will hold the string representation of a fraction. 
	
	
	public Fraction(String frac) throws Expression
	{
		fraction = frac;
		
		//Take the string representation of the fraction from the constructor, and splits the numerator and denominator, using the "/" as a delimiter 
		String values[] = fraction.split("/");
		
		//The denominator cannot be a negative integer. This is to ensure a proper result when comparing negative fractions in the compareTo method. 
		if(values[1].charAt(0) ==('-'))
		{	
			throw new Expression("Error. If a fraction is negative, then the '-' sign should be placed in the numerator and not the denominator of the fraction");	
		}	
	}
    

	public int compareTo(Object o)
	{
	
		
		String values[] = fraction.split("/");
		
		int fraction1Numerator = Integer.valueOf(values[0]);
		int fraction1Denominator = Integer.valueOf(values[1]);
		
		
		String s = o.toString();
		values = s.split("/");
		
		int fraction2Numerator = Integer.valueOf(values[0]);
		int fraction2Denominator = Integer.valueOf(values[1]);
		

	    // cross multiply the two fractions, so that the denominator will be the same for both.
		int numerator1 = fraction1Numerator * fraction2Denominator;
		int numerator2 = fraction2Numerator * fraction1Denominator;

	
		// returns an integer value of 1 if numerator1 is greater than numerator2 after the cross multiplication
		if(numerator1 < numerator2)
		{
			return -1;
		}
		// If numerator1 is equal to numerator2 after the cross multiplication, then return 0
		else if(numerator1 == numerator2)
		{
			return 0;
		}
		// return 1 in all other scenarios, which will signify that numerator1 is greater than numerator2 after the cross multiplication.  
		else
		{
			return 1;
		}	
	}
	
	
	public String toString()
	 {
		// TODO Auto-generated method stub
		return fraction;
	}
}