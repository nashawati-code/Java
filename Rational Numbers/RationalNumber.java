public class RationalNumber
{
	
   public int num, dem;

   //==================================================================================//
   public RationalNumber (int numerator, int denominator)
   {
	   if (denominator == 0) 
       {
		   throw new IllegalArgumentException("The denominator can't be zero.");
       }

	   if (denominator < 0)
	   {
		   numerator = numerator * -1;
		   denominator = denominator * -1;
	   }

	   num = numerator;
	   dem = denominator;

	   reduce();
   }
   //==================================================================================//
   public RationalNumber()
   {
	   //constructs new rational number to represent the ratio (0/1)
       setNumerator(0);
       setDenominator(1);
   }
   //==================================================================================//
   public void setNumerator(int numerator) 
   {
	   this.num = numerator;
   }
   //==================================================================================//
   public void setDenominator(int denominator) 
   {
       if (denominator == 0) 
       {
    	   throw new IllegalArgumentException("The denominator can't be zero.");
       }
       else 
       {
           this.dem = denominator;
       }
   }
   //==================================================================================//
   public int getNumerator()
   {
      return num;
   }
   //==================================================================================//
   public int getDenominator()
   {
      return dem;
   }
   //==================================================================================//
   public String toString ()
   {
      String result;

      if (num == 0)
      {
         result = "0";
      }
      else
      {
         if (dem == 1)
         {
            result = num + "";
         }
         else
         {
            result = num + "/" + dem;
         }
      }
    
      return result;
   }
   //==================================================================================//
   public RationalNumber reciprocal ()
   {
      return new RationalNumber (dem, num);
   }
   //==================================================================================//
   public RationalNumber add (RationalNumber rnum)
   {
      int commondem = dem * rnum.getDenominator();
      int num1 = num * rnum.getDenominator();
      int num2 = rnum.getNumerator() * dem;
      int sum = num1 + num2;

      return new RationalNumber (sum, commondem);
   }
   //==================================================================================//
   public RationalNumber subtract (RationalNumber rnum)
   {
      int commondem = dem * rnum.getDenominator();
      int num1 = num * rnum.getDenominator();
      int num2 = rnum.getNumerator() * dem;
      int difference = num1 - num2;

      return new RationalNumber (difference, commondem);
   }
   //==================================================================================//
   public RationalNumber multiply (RationalNumber rnum)
   {
      int numerator = num * rnum.getNumerator();
      int denominator = dem * rnum.getDenominator();

      return new RationalNumber (numerator, denominator);
   }
   //==================================================================================//
   public RationalNumber divide (RationalNumber rnum)
   {
      return multiply (rnum.reciprocal());
   }
   //==================================================================================//
   private void reduce ()
   {
      if (num != 0)
      {
         int common = gcd (Math.abs(num), dem);

         num = num / common;
         dem = dem / common;
      }
   }
   //==================================================================================//
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
      {
         if (num1 > num2)
         {
            num1 = num1 - num2;
         }
         else
         {
            num2 = num2 - num1;
         }
      }
      return num1;
   }
   //==================================================================================//
   //==================================================================================//
   public static void main (String[] args)
   {	
	   RationalNumber rational1 = new RationalNumber(2, 4);
	   RationalNumber rational2 = new RationalNumber(6, 2);

	   System.out.println("Print the first RationalNumber: " + rational1.toString());
	   System.out.println("Print the second RationalNumber: " + rational2.toString());
	   
	   RationalNumber rational3 = rational1.add(rational2);
	   System.out.println ("r1 + r2: " + rational3);
	   
	   RationalNumber rational4 = rational1.subtract(rational2);
	   System.out.println("r1 - r2: " + rational4);
	   
	   RationalNumber rational5 = rational1.multiply(rational2);
	   System.out.println("r1 * r2: " + rational5);
	   
	   RationalNumber rational6 = rational1.divide(rational2);
	   System.out.println("r1 / r2: " + rational6);
	   
	   
	   System.out.println("==================================================");
	   
	   RationalNumber rational_hard1 = new RationalNumber(23, 842);
	   RationalNumber rational_hard2 = new RationalNumber(35, 32);
	   
	   System.out.println("Print the first RationalNumber: " + rational_hard1.toString());
	   System.out.println("Print the second RationalNumber: " + rational_hard2.toString());
	   
	   RationalNumber rational_hard3 = rational_hard1.add(rational_hard2);
	   System.out.println ("r1 + r2: " + rational_hard3);
	   
	   RationalNumber rational_hard4 = rational_hard1.subtract(rational_hard2);
	   System.out.println("r1 - r2: " + rational_hard4);
	   
	   RationalNumber rational_hard5 = rational_hard1.multiply(rational_hard2);
	   System.out.println("r1 * r2: " + rational_hard5);
	   
	   RationalNumber rational_hard6 = rational_hard1.divide(rational_hard2);
	   System.out.println("r1 / r2: " + rational_hard6);
	   
   }
   //==================================================================================//
   //==================================================================================//
}

