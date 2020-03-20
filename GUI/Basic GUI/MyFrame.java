//to make  MyFrame inherit the JFrame
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MyFrame extends JFrame implements ActionListener
{
	JButton button;
	JButton button2;
	
	public MyFrame(String text)
	{
		super(text);
	
		button = new JButton("Again!");
		button2 = new JButton("Press Me!");
		
		//set a flowlayout for the content pane
		this.getContentPane().setLayout(new FlowLayout());
		
		this.getContentPane().add(BorderLayout.NORTH,button);
		this.getContentPane().add(BorderLayout.SOUTH,button2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		
		
		this.setVisible(true);
		
		button.addActionListener(this);
		button2.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton b = (JButton) e.getSource();
		
		   if (b==button)  
		   {   
			   JOptionPane.showConfirmDialog(this, "You clicked Button1","Button Click Event Handler", JOptionPane.PLAIN_MESSAGE);    
		   }
		   else if (b==button2)   
		   {   
			   JOptionPane.showConfirmDialog(this, "You clicked Button2","Button Click Event Handler", JOptionPane.PLAIN_MESSAGE);   
		   } 
	 } 
		
}





























