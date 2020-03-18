   //+++++++++++++++++//
  //  Aya Nashawati  //
 //    201902869    //
//+++++++++++++++++//


import java.util.*;

//--------------------------------------------------------------------------------------------//
interface Container
{
	public double volume();
}
//--------------------------------------------------------------------------------------------//

class Can implements Container {
    private double radius;
    private double height;
    Can(double r, double h) {
        radius = r; height = h;
    }
    public double volume() {
        return 3.14*radius*radius*height;
    }
}

class Carton implements Container {
    private double length;
    private double width;
    private double height;
    Carton(double l, double w, double h) {
        length = l; width = w; height = h;
    }
    public double volume() {
        return length*width*height;
    }
}

public class Assignment3C {
	
	//--------------------------------------------------------------------------------------------//
    //Implement a polymorphic function price that accepts either a Can or a Carton object 
    //and returns the price of the juice in the container, knowing that the price rate is 2 LL/mL.
	
	public static String price(Container c)
	{
		int money = 2;
		return "Price of the can is: " + money * c.volume();
	}
	//--------------------------------------------------------------------------------------------//
	
	//--------------------------------------------------------------------------------------------//
    //Implement a polymorphic function evens that takes a List<Can> object and returns a new List<Can> object, 
    //or takes a List<Carton> object and returns a new List<Carton> object, 
    //where the returned list contains only the elements of the provided list with an even index. 
	
	public static <T> List<T> evens (List<T> list)
	{
		List<T> count = new ArrayList<T>();
		
		for(int i=0; i < list.size(); i++)
		{
			if(i % 2 == 0)
			{
				count.add(list.get(i));
			}
		}
		
		System.out.println("---------------------------------");
		System.out.println("Hello! I considered 0 as an even number, that's what the results are as follows.");
		System.out.println("But if you consider 1 as the first even number, then please change int i=0 to i=1");
		
		System.out.print("Number of elements with an even index: ");
		return count;
	}
	//--------------------------------------------------------------------------------------------//
	
	//--------------------------------------------------------------------------------------------//
	//Implement a polymorphic function numLarger that takes a List<Can> object or a List<Carton> object and a value v
	///and returns the number of Can or Carton objects in the list with a volume larger than v. 

	public static <T extends Container> String numLarger(List<T> list, double volume)
	{
		int count = 0;
		
		for(int i=0; i < list.size(); i++)
		{
			if(list.get(i).volume() > volume)
			{
				count++;
			}
		}
		
		System.out.println("---------------------------------");
		return "Number of objects in the list with a volume larger than v: " + count;	
	}
	//--------------------------------------------------------------------------------------------//
   
	//============================================================================================//
    public static void main(String[] args) {
        List<Can> canList = new ArrayList<Can>() {{
            add(new Can(1.5,10.0));
            add(new Can(2.5,10.0));
            add(new Can(2.5,12.0));
            add(new Can(3.0,10.0));
        }};
        List<Carton> cartonList = new ArrayList<Carton>() {{
            add(new Carton(2.5,2.5,10.0));
            add(new Carton(5.0,5.0,10.0));
            add(new Carton(5.0,5.0,15.0));
            add(new Carton(5.0,10.0,10.0));
            add(new Carton(7.5,10.0,10.0));
        }};
        // Test price
        Can c1 = canList.get(2);
        System.out.println(price(c1));
        Carton c2 = cartonList.get(1);
        System.out.println(price(c2));
        // Test evens
        List<Can> canList2 = evens(canList);
        System.out.println(canList2.size());
        List<Carton> cartonList2 = evens(cartonList);
        System.out.println(cartonList2.size());
        // Test numLarger
        System.out.println(numLarger(canList, 250.0));
        System.out.println(numLarger(cartonList, 250.0));
    }
    //============================================================================================//
}