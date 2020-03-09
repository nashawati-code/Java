/*
Monte Carlo simulations are techniques that consist of choosing sample experiments at random from a large set 
and then making deductions on the basis of the probabilities estimated from the result of these experiments. 
In this problem, you are to implement a Monte Carlo method for estimating the value of pi 
Consider the first quadrant of a unit circle centered at (0; 0). 
This quarter circle lies inside a unit square. 
A point with coordinates (x; y) is inside the quarter circle when x2 + y2 = 1. 
The area of the quarter circle region can be estimated by picking, at random, points (x; y) that lie in the unit square, 
and for each point determining whether the point lies in the circular region or not. 
The fraction of points that fall in the region should give an estimate of pi 4 
(ratio of the area of the circular region and the area of the enclosing unit square). 
Multiplying by 4 gives an estimate of pi. 
 
Write a program mcpi.java that takes a command line integer parameter n and prints an estimate of pi using n random points as described above. 
Run your program with n = 10; 100; 10000 and comment on the values you get. 
*/

import java.util.Random; 
  
public class montecarlo 
{
	//=================================================================================//
    public static double estimate_pi(int n) 
    {
        double out=0;
        double in=0;
        double x;
        double y;
        double radius;
        for (int i = 0; i < n; i++) 
        {
            x=Math.random();
            y=Math.random();
            radius=Math.pow(x, 2)+Math.pow(y,2);
            
            if(radius<=1)
            {
                in+=1;
            }
                out+=1;
        }
        
        double pi=4*(in/out);
        return pi;
    }
    //=================================================================================//
    public static void main(String[] args) 
    {
        double ten=estimate_pi(10);
        double hundred=estimate_pi(100);
        double tenthou=estimate_pi(10000);
        System.out.println("Estimate using 10 points= " + ten); //2.8
        System.out.println("Estimate using 100 points= " + hundred); //2.92
        System.out.println("Estimate using 10000 points= " + tenthou); //3.1172
    }   
    //=================================================================================//
}
