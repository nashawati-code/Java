/*
Write a function subString(s1, s2, k) that takes two Strings and an integer index k,
and returns True if the first String appears as a subString in the second starting at location k, and
False otherwise. You may assume that all Strings consist of lower case characters only.
Write a function how_many() that takes two Strings and returns the number of times the first
String occurs in the second. Again, you may assume that all Strings consist of lower case
characters only.
For example, the call how_many(c) should return 2.
*/

public class substring_match 
{
	//==================================================================//
    public static Boolean substring(String s1,String s2,int k) 
    {
        int x=0;
        if(s2.charAt(k)==s1.charAt(0))
        {
            for(int i=1;i<s1.length();i++)
            {
                if(s1.charAt(i)==s2.charAt(k+i))
                {
                    x++;
                }
                if(s1.length()-x==1){
                    return true;
                } 
            }
        }
        return false;
    }
    //==================================================================//
    public static int how_many(String s1,String s2) 
    {
        int counter=0;
        for(int i=0;i<s2.length();i++)
        {
            if(substring(s1, s2, i))
            {
                counter++;
            }
        }
        return counter;
    }
    //==================================================================//
    public static void main(String[] args) 
    {
        int test=how_many("bob", "azcbobobegghakl");
        System.out.println(test);
    }
    //==================================================================//
}
