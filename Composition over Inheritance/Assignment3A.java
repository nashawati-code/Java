   //+++++++++++++++++//
  //  Aya Nashawati  //
 //    201902869    //
//+++++++++++++++++//

//--------------------------------------------------------------------------------------------//
public class Assignment3A 
{
	public static void main(String[] args) 
	{
		TeachingAssistant ta = new TeachingAssistant(6000000.00, 2000000.00, 5000000.00);
		Student s = ta;
		s.payTuition();
		Employee e = ta;
		e.cashPaycheck();
		ta.receiveWaiver();
	}
}
//--------------------------------------------------------------------------------------------//
interface Student 
{
    public void payTuition();
}

class StudentImplementation implements Student
{
    private double tuition;

    public StudentImplementation(double t)
    {
        this.tuition = t;
    }
    
    public void payTuition() 
    { 
        System.out.println ("I paid " + tuition + " LL as tuition"); 
    }
} 
//--------------------------------------------------------------------------------------------//
interface Employee
{
    public void cashPaycheck();
}

class EmployeeImplementation implements Employee
{
    private double salary;

    public EmployeeImplementation(double s)
    {
        this.salary = s;
    }
    
    public void cashPaycheck() 
    { 
        System.out.println( "I received " + salary + " LL as salary"); 
    }
    
}
//--------------------------------------------------------------------------------------------//
class TeachingAssistant implements Student, Employee
{
    private StudentImplementation student;
    private EmployeeImplementation employee;
    private double waiver;

    public TeachingAssistant (double t, double s, double w) 
    { 
        student = new StudentImplementation(t);
        employee = new EmployeeImplementation(s);
        this.waiver = w; 
    }
    
    public void receiveWaiver() 
    { 
        System.out.println("I received " + waiver + " LL as tuition waiver"); 
    }
    
    public void payTuition() 
    { 
        student.payTuition();
    }
    
    public void cashPaycheck() 
    { 
        employee.cashPaycheck();
    }
}
//--------------------------------------------------------------------------------------------//