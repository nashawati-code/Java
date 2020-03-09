package hw1;
//Write a program that reads in the name of a month (3 letter abbreviation) 
//and the day of the month as command line arguments, and prints the number of that day (a number between 1 and 365). 
//Assume that the year is not a leap year. 
//> java day mar 10 
//Day of the year: 69 
//Your program will first build a map whose keys are the names of the months ('jan'-'dec'), 
//and whose values are 28, 30, or 31, and will loop through the months accumulating the days. 

import java.util.HashMap;
import java.util.Map;

public class dayoftheyear 
{
    //==========================================================================//
    public static int dayno(String month,int day) 
    {
        String[] listofmonth={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
        Map daysinmonth = new HashMap();
        //--------------------------------------------------/
        for (int i = 0; i < listofmonth.length; i++) 
        {
            //--------------------------------------------------/
            if( 
            listofmonth[i]=="jan" || 
            listofmonth[i]=="mar" || 
            listofmonth[i]=="may" || 
            listofmonth[i]=="jul" || 
            listofmonth[i]=="aug" || 
            listofmonth[i]=="oct" ||
            listofmonth[i]=="dec")
            {
                daysinmonth.put(listofmonth[i],31);
            }
            //--------------------------------------------------/
            else if(listofmonth[i]=="feb")
            {
                daysinmonth.put(listofmonth[i],28);     
            }
            //--------------------------------------------------/
            else
            {
                    daysinmonth.put(listofmonth[i], 30); 
            }
            //--------------------------------------------------/
        }
        //--------------------------------------------------/
        int sumofdays=0;

        for (int i = 0; i < listofmonth.length; i++) 
        {
            //--------------------------------------------------/
            if(month.equals(listofmonth[i]))
            {
                sumofdays +=day;
                break;
            }
            //--------------------------------------------------/
            else
            {
                int val=(int)daysinmonth.get(listofmonth[i]);
                sumofdays +=val;
            }
            //--------------------------------------------------/
        }
        return sumofdays;
    }
    //==========================================================================//
    public static void main(String[] args)
    {
        String month= args[0];
        int day=Integer.parseInt(args[1]);
        int x=dayno(month,day);
        System.out.println("Day of the year: "+x);
    }
    //==========================================================================//
}
