import javax.swing.*;
import java.awt.FlowLayout;

//The program consists of a simple class with a main method 
//which was able to create a graphical window because it created an object of type JFrame.

//JFrame is a class that was coded to draw a window; 
//nevertheless it is a bona fide java class with method, properties, constructor, etc.

/*
 * BorderLayout
 * A BorderLayout places components in up to five areas: top, bottom, left, right, and center. 
 * It is the default layout manager for every JFrame
 * 
 * FlowLayout
 * FlowLayout is the default layout manager for every JPanel. 
 * It simply lays out components in a single row one after the other.
 * 
 * GridBagLayout
 * It is the most sophisticated of all layouts. 
 * It aligns components by placing them within a grid of cells, allowing components to span more than one cell.
*/

class gui{
	public static void main(String args[])
	{
		//creates the frame
		JFrame frame = new JFrame("My First GUI");
		//causes the frame to close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		
		/*
		//to add a button to the window
		//Adding a button consists of creating an object of type JButton, then adding that object to the content pane.
		//We did not specify the size of the button, so it filled the window.
		//Pressing the button does nothing so far
		JButton button1 = new JButton("Press");
		frame.getContentPane().add(button1);
		
		//changes the button from Press to Press Me!
		button1.setText("Press Me!");
		
		//adding another button to the same window
		//Adding a second button also filled the window and thus concealed the first button
		JButton button2 = new JButton("Button 2");
		frame.getContentPane().add(button2);
		*/
		
		/*
		JButton button1 = new JButton("Press");
		button1.setText("Press Me!");
		
		JButton button2 = new JButton("Button 2");
		button2.setText("Again!");
		
		//to solve the issue above,
		//Replace the two lines that add the buttons to the content pane by these two lines:
		frame.getContentPane().add(BorderLayout.NORTH,button1);
		frame.getContentPane().add(BorderLayout.SOUTH,button2);
		*/
		
		//Set the layout of the content pane right before you add the buttons to it:
		//The two buttons are now displayed from left to right starting from the top of the window.
		//Change the order of the two lines that add the buttons and notice how the buttons have swapped positions

		frame.getContentPane().setLayout(new FlowLayout());
		
		JButton button1 = new JButton("Press");
		frame.getContentPane().add(button1);
		button1.setText("Press Me!");
		
		JButton button2 = new JButton("Button 2");
		frame.getContentPane().add(button2);
		button2.setText("Again!");
		
		MyFrame new_myframe = new MyFrame("My First GUI!");
		
		frame.setVisible(true);
		
		
	}

}

/*
 * ========================================================================================================================
 * 
 * QUESTION
 * What does the constructor of JFrame look like? (Write the formal method signature of the constructor that was used).
 * 
 * ANSWER
 * JFrame(string frame_title);
 * 
 * QUESTION
 * What is the parameter of this specific constructor used for?
 * 
 * ANSWER
 * Creates a new, initially invisible Frame with the specified title.
 * The first line of code creates a frame using a constructor that lets you set the frame title. 
 * The other frequently used JFrame constructor is the no-argument constructor.
 * 
 * QUESTION
 * What is the nature of JFrame.EXIT_ON_CLOSE? (is it a method, field,…). Write down its formal declaration line.
 * 
 * ANSWER
 * JFrame.EXIT_ON_CLOSE is a frame. It creates an initially invisible Frame with the specified title.
 * frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 * 
 * QUESTION
 * Find out which method of JFrame changes the cursor displayed when the mouse is over the window. 
 * Write down the line you would use to change the cursor to an hourglass.
 * 
 * ANSWER
 * First we must import java.awt.Cursor;
 * we then write this line of code: frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
 * 
 * ========================================================================================================================
 * 
 * QUESTION
 * Type button then press the dot . and choose the method that sets the text of the button. 
 * Write the line of code required to change the text of the button to “Press Me”
 * 
 * ANSWER
 * button1.setText("Press Me!");

 * QUESTION
 * Type button then press the dot . and choose the method that sets the tooltip of the button. 
 * Write the line of code required to change the tooltip of the button to “Press me and watch what happens”
 * 
 * ANSWER
 * button1.setToolTipText("Press me and watch what happens!");
 * 
 * ========================================================================================================================
 * 
 * QUESTION
 * Change the position of the two buttons to make them bound to the left and right side of the window (west, east) instead of up and down (north, south). 
 * Write the two lines of code required to do so:
 * 
 * ANSWER
 * frame.getContentPane().add(BorderLayout.EAST,button1);
 * frame.getContentPane().add(BorderLayout.WEST,button2);
 * 
 * ========================================================================================================================
 * 
*/
