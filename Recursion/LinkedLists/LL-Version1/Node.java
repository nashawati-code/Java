//simple recursive datatype
public class Node {

	public int value;

	//defined in terms of itself
	Node next;
	
	@Override
	public String toString()
	{
		return " " + value;
	}
	
	public Node(int v)
	{
		this.value = v; 
	}

	public Node() {}
}
 