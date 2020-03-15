import static org.junit.Assert.*;

import org.junit.Test;

public class RationalNumberTest 
{
	//==================================================================================//
	@Test
	public void testNumeratorZero() 
	{  		
		System.out.println("------------------------------");
		System.out.println("TESTING NUMERATOR ZERO");
	
		
		RationalNumber zero1 = new RationalNumber();
		assertEquals("Failed Test", 0, zero1.getNumerator());
		assertEquals("Failed Test", 1, zero1.getDenominator());
		System.out.println("Rational number to represent the ratio (0/1) = " + zero1);
	}
	//==================================================================================//
	@Test
	public void testDenominatorZero() 
	{
		RationalNumber zero2 = new RationalNumber();
		assertEquals("Failed Test", 1, zero2.getNumerator());
		assertEquals("Failed Test", 0, zero2.getDenominator());
		System.out.println("Rational number to represent the ratio (1/0) = " + zero2);
	}
	//==================================================================================//
	@Test
	public void testBothZero() 
	{
		RationalNumber zero3 = new RationalNumber();
		assertEquals("Failed Test", 0, zero3.getNumerator());
		assertEquals("Failed Test", 0, zero3.getDenominator());
		System.out.println("Rational number to represent the ratio (0/0) = " + zero3);
	}
	//==================================================================================//
	@Test
	public void testRationalPositiveLong() 
	{		
		System.out.println("------------------------------");
		System.out.println("TESTING POSITIVE LONG");
	
		//-------------------------------------------------------------------//
		RationalNumber rational_long_positive_1 = new RationalNumber(4000,8000);
		assertEquals("Failed Test", 1, rational_long_positive_1.getNumerator());
		assertEquals("Failed Test", 2, rational_long_positive_1.getDenominator());
		System.out.println("Test rational_long_positive_1 = " + rational_long_positive_1);
		//-------------------------------------------------------------------//
	}
	
	//==================================================================================//
	@Test
	public void testRationalNegativeLong() 
	{		
		System.out.println("------------------------------");
		System.out.println("TESTING NEGATIVE LONG");
	
		//-------------------------------------------------------------------//
		RationalNumber rational_long_negative_5 = new RationalNumber(-3000,9000);
		assertEquals("Failed Test",-1, rational_long_negative_5.getNumerator());
		assertEquals("Failed Test", 3, rational_long_negative_5.getDenominator());
		System.out.println("Test rational_long_negative_5 = " + rational_long_negative_5);
		//-------------------------------------------------------------------//
	}
	//==================================================================================//
	@Test
	public void testRationalNegativeInt() 
	{
		System.out.println("------------------------------");
		System.out.println("TESTING NEGATIVE INT");
		//-------------------------------------------------------------------//
		RationalNumber rational_negative_1 = new RationalNumber(-4,8);
		assertEquals("Failed Test", -1, rational_negative_1.getNumerator());
		assertEquals("Failed Test", 2, rational_negative_1.getDenominator());
		System.out.println("Test rational_negative_1 = " + rational_negative_1);
		//-------------------------------------------------------------------//
	}
    //==================================================================================//
    @Test
	public void testRationalPositiveInt() 
	{
    	System.out.println("------------------------------");
		System.out.println("TESTING POSITIVE INT");
	
    	//-------------------------------------------------------------------//
		RationalNumber rational_postive_5 = new RationalNumber(4,8);
		assertEquals("Failed Test", 1, rational_postive_5.getNumerator());
		assertEquals("Failed Test", 2, rational_postive_5.getDenominator());
		System.out.println("Test rational_postive_5 = " + rational_postive_5);
		//-------------------------------------------------------------------//
	}
    //==================================================================================//
    @Test
	public void testRationalPositiveInt2() 
	{
    	System.out.println("------------------------------");
		System.out.println("TESTING POSITIVE INT 2");
	
    	//-------------------------------------------------------------------//
		RationalNumber rational_postive_6 = new RationalNumber(0,7);
		assertEquals("Failed Test", 0, rational_postive_6.getNumerator());
		assertEquals("Failed Test", 7, rational_postive_6.getDenominator());
		System.out.println("Test rational_postive_6 = " + rational_postive_6);
		//-------------------------------------------------------------------//
	}
  //==================================================================================//
  	@Test
  	public void testAddRational() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING ADD");
	
  		//-------------------------------------------------------------------//
  		RationalNumber rational9 = new RationalNumber(1,4);
  		RationalNumber rational10 = new RationalNumber(3,4);
  		RationalNumber add1 = rational9.add(rational10);
  		assertEquals("Failed Test", 1, add1.getNumerator());
  		assertEquals("Failed Test", 1, add1.getDenominator());
  		System.out.println("Adding rational9 + rational10 = " + add1);
  		//-------------------------------------------------------------------//
  	}
    //==================================================================================//
  	@Test
  	public void testAddRational2() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING ADD 2");
	
		//-------------------------------------------------------------------//
  		RationalNumber rational11 = new RationalNumber(3,4);
  		RationalNumber rational12 = new RationalNumber(2,4);
  		RationalNumber add2 = rational11.add(rational12);
  		assertEquals("Failed Test", 5, add2.getNumerator());
  		assertEquals("Failed Test", 4, add2.getDenominator());
  		System.out.println("Adding rational11 + rational12 = " + add2);
  		//-------------------------------------------------------------------//
  	}
  	//==================================================================================//
  	@Test
  	public void testSubRational() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING SUBTRACT");
		
  		//-------------------------------------------------------------------//
  		RationalNumber rational17 = new RationalNumber(5,6);
  		RationalNumber rational18 = new RationalNumber(1,6);
  		RationalNumber sub1 = rational17.subtract(rational18);
  		assertEquals("Failed Test", 2, sub1.getNumerator());
  		assertEquals("Failed Test", 3, sub1.getDenominator());
  		System.out.println("Subtracting rational17 - rational18 = " + sub1);
  		//-------------------------------------------------------------------//
  	}
  	//==================================================================================//
  	@Test
  	public void testSubRational2() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING SUBTRACT 2");
		
		//-------------------------------------------------------------------//
  		RationalNumber rational19 = new RationalNumber(2,3);
  		RationalNumber rational20 = new RationalNumber(-1,3);
  		RationalNumber sub2 = rational19.subtract(rational20);
  		assertEquals("Failed Test", 1, sub2.getNumerator());
  		assertEquals("Failed Test", 1, sub2.getDenominator());
  		System.out.println("Subtracting rational19 - rational20 = " + sub2);
  		//-------------------------------------------------------------------//
  	}
  	//==================================================================================//
  	@Test
  	public void testMultRational() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING MULTIPLY");
	
  		//-------------------------------------------------------------------//
  		RationalNumber rational25 = new RationalNumber(1,2);
  		RationalNumber rational26 = new RationalNumber(1,3);
  		RationalNumber mult1 = rational25.multiply(rational26);
  		assertEquals("Failed Test", 1, mult1.getNumerator());
  		assertEquals("Failed Test", 6, mult1.getDenominator());
  		System.out.println("Multiplying rational25 * rational26 = " + mult1);
  		//-------------------------------------------------------------------//
  	}
  	//==================================================================================//
  	@Test
  	public void testMultRational2() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING MULTIPLY 2");
	
  		//-------------------------------------------------------------------//
  		RationalNumber rational27 = new RationalNumber(2,3);
  		RationalNumber rational28 = new RationalNumber(-4,5);
  		RationalNumber mult2 = rational27.multiply(rational28);
  		assertEquals("Failed Test", -8, mult2.getNumerator());
  		assertEquals("Failed Test", 15, mult2.getDenominator());
  		System.out.println("Multiplying rational27 * rational28 = " + mult2);
  		//-------------------------------------------------------------------//
  	}
  	//==================================================================================//
  	@Test
  	public void testDivRational() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING DIVIDE");
		
  		//-------------------------------------------------------------------//
  		RationalNumber rational33 = new RationalNumber(3,4);
  		RationalNumber rational34 = new RationalNumber(1,2);
  		RationalNumber div1 = rational33.divide(rational34);
  		assertEquals("Failed Test", 3, div1.getNumerator());
  		assertEquals("Failed Test", 2, div1.getDenominator());
  		System.out.println("Dividing rational33 / rational34 = " + div1);
  		//-------------------------------------------------------------------//
  	}
 	//==================================================================================//
  	@Test
  	public void testDivRational2() 
  	{
  		System.out.println("------------------------------");
		System.out.println("TESTING DIVIDE 2");
		
  		//-------------------------------------------------------------------//
  		RationalNumber rational35 = new RationalNumber(5,8);
  		RationalNumber rational36 = new RationalNumber(-3,4);
  		RationalNumber div2 = rational35.divide(rational36);
  		assertEquals("Failed Test", -5, div2.getNumerator());
  		assertEquals("Failed Test", 6, div2.getDenominator());
  		System.out.println("Dividing rational35 / rational36 = " + div2);
  		//-------------------------------------------------------------------//
  	}
  	//==================================================================================//
	@Test
	public void testToString() 
	{
		System.out.println("------------------------------");
		System.out.println("TESTING STRING");
		
		String testString = "";
		//-------------------------------------------------------------------//
		RationalNumber str_rational1 = new RationalNumber(5,5);
		testString = str_rational1.toString();
		assertEquals("Failed Test", "1", testString);
		System.out.println("toString test when answer is 1: " + testString);
		//-------------------------------------------------------------------//
	}
  	//==================================================================================//
	@Test
	public void testToString2() 
	{
		System.out.println("------------------------------");
		System.out.println("TESTING STRING 2");
		
		String testString = "";
		//-------------------------------------------------------------------//
		RationalNumber str_rational3 = new RationalNumber(3,4);
		testString = str_rational3.toString();
		assertEquals("Failed Test", "3/4", testString);
		System.out.println("toString test when answer is a fraction: " + testString);
		//-------------------------------------------------------------------//
	}
  	//==================================================================================//
	@Test
	public void testToString3() 
	{
		System.out.println("------------------------------");
		System.out.println("TESTING STRING 3");
		
		String testString = "";
		//-------------------------------------------------------------------//
		RationalNumber str_rational4 = new RationalNumber(-2,4);
		testString = str_rational4.toString();
		assertEquals("Failed Test", "-1/2", testString);
		System.out.println("toString test when answer is a negative fraction: " + testString);
		//-------------------------------------------------------------------//
	}
	//==================================================================================//
}