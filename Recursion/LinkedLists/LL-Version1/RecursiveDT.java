//RECURSIVE DATA TYPES are very useful when doing LinkedLists
public class RecursiveDT 
{	
	public static void main(String[] args)
	{
		/*
		Node n = new Node();
		n.value = 1;
		n.next = new Node();
		n.next.value = 2;
		n.next.next = new Node();
		n.next.next.value = 3;
		
		//because next is of type Node,
		//and Node is of type class
		//the default value of the referenced type would be null
		 
		//there is a DANGEROUS problem here --> we are changing n
		while(n!=null) //the output would be 1 2 3
		{   
			System.out.println(n.value);
			n = n.next;
		}
	
		//System.out.println(n.value); --> NullPointerException
		//becomes what is known as a lost object
	}
		*/
	
	//=============================================================
	//LESSON 1
	//when we're dealing with a recursive data type
	//we don't want to lose the "head" (which is n=1 in this case)
	//=============================================================
	
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(13);
		l.print();
		//will output 1 2 13 when commenting the code above LESSON 1
	}
}