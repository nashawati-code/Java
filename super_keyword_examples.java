public class super_keyword_examples 
{
	public void print()
	{
		System.out.println("This is a simple example on how to use \"super\" and \"super()\" om Java. ");
	}
}

//=========================================================================================================================//
//=========================================================================================================================//
/*									============ super ============
 * - The super keyword in Java is a reference variable that is used to refer parent class objects.
 * - super can be used to call parent class’ variables and methods.
 * - The variables and methods to be called through super keyword can be done at any time.
 * - If one does not explicitly invoke a superclass variables or methods, by using super keyword, then nothing happens.
 */
//=========================================================================================================================//
//=========================================================================================================================//

//this is a base class
class Vehicle 
{ 
	int maxSpeed = 2000; 
	
	void print_vehicle()
	{
		System.out.println("Hello I am a Vehicle!");
	}
} 

//-----------------------------------------------------------------//
  
//this is a subclass that extends from the base class Vehicle
class Car extends Vehicle 
{ 
    int maxSpeed = 5000; 
  
    void display() 
    { 
    	//prints "Hello I am a Vehicle!"
    	super.print_vehicle();
    	
        //prints the maxSpeed of the base class NOT the subclass
        System.out.println("I am this fast: " + super.maxSpeed); 
    } 
} 

//=========================================================================================================================//
//=========================================================================================================================//
/*									============ super() ============
 * - The super() in Java is a reference variable that is used to refer parent class constructors.
 * - super() can be used to call parent class’ constructors only.
 * - Call to super() must be first statement in Derived(Student) Class constructor.
 * - If a constructor does not explicitly invoke a superclass constructor by using super(),
 * 	 the Java compiler automatically inserts a call to the no-argument constructor of the superclass.
 */
//=========================================================================================================================//
//=========================================================================================================================//

//this is a superclass
class Person 
{ 
	Person() 
	{ 
	    System.out.println("PERSON CLASS CONSTRUCTOR"); 
	} 
} 

//-----------------------------------------------------------------//

//this is a subclass that extends from the superclass Person
class Student extends Person 
{ 
	Student() 
	{ 
		//calls the parent class constructor
		super(); 

		System.out.println("STUDENT CLASS CONSTRUCTOR"); 
	} 
} 

//=========================================================================================================================//

class Test 
{ 
    public static void main(String[] args) 
    { 
    	System.out.println("------------------------------------");
 
    	super_keyword_examples ske = new super_keyword_examples();
    	ske.print();
    	
    	System.out.println("------------------------------------");
    	
        Car small = new Car(); 
        small.display(); 
        
        System.out.println("------------------------------------");
        
        Student s = new Student(); 
        
        System.out.println("------------------------------------");
    } 
}
//=========================================================================================================================//