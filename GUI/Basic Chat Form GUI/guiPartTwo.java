import javax.swing.*;
import java.awt.*;

class guiPartTwo{
    public static void main(String args[]) {

        //this creates the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(375,375);

        //this creates the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //this creates the panel at bottom and adding components
        JPanel panel = new JPanel();
        JLabel enter = new JLabel("Enter Text");
        JTextField text = new JTextField(10);
        JButton send_button = new JButton("Send");
        send_button.addActionListener(null);
        JButton reset_button = new JButton("Reset");
        panel.add(enter);
        panel.add(enter);
        panel.add(text);
        panel.add(send_button);
        panel.add(reset_button);

        //this makes the text area in the center of the gui
        JTextArea text_area = new JTextArea();
        text_area.setEditable(false);
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, text_area);
        frame.setVisible(true);
    }
}