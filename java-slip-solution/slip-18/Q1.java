import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame; 
class FrameDemo extends JFrame { 
    FrameDemo() 
    { 
        JButton b1=new JButton("North"); 
        JButton b2=new JButton("South"); 
        JButton b3=new JButton("East"); 
        JButton b4=new JButton("West"); 
        JButton b5=new JButton("Center"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        add(b1,BorderLayout.NORTH); 
        add(b2,BorderLayout.SOUTH); 
        add(b3,BorderLayout.EAST); 
        add(b4,BorderLayout.WEST); 
        add(b5,BorderLayout.CENTER); 
        setSize(300,300); 
        setVisible(true); 
    } 
} 
public class Q1 {
    public static void main(String[] args) { 
        new FrameDemo(); 
    } 
}