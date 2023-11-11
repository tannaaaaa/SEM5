import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 
class converter extends KeyAdapter { 
    JLabel l1,l2,l3; 
    JTextField t1,t2,t3; 
    converter()  { 
        JFrame ob=new JFrame(); 
        l1=new JLabel("US Dollars"); 
        l2=new JLabel("Singapore Dollars"); 
        l3=new JLabel("Euros"); 
        t1=new JTextField(10); 
        t2=new JTextField(10); 
        t3=new JTextField(10); 
        ob.add(l1); 
        ob.add(t1); 
        ob.add(l2); 
        ob.add(t2); 
        ob.add(l3); 
        ob.add(t3); 
        ob.setVisible(true);
        t1.addKeyListener(this); 
        ob.setLayout(new FlowLayout()); 
        ob.setSize(400,400); 
        ob.setDefaultCloseOperation(3); 
    } 
 
    public void keyReleased(KeyEvent ke) { 
        try { 
            Double USD=Double.parseDouble(t1.getText()); 
            Double S=1.41; 
            Double E=0.92; 
            //Double sgd =Double.parseDouble(t1.getText()); 
            Double SGD= USD * S; 
            //Double euro =Double.parseDouble(t1.getText()); 
            Formatter fob=new Formatter(); 
            fob.format("%.2f",SGD); 
            Double Euro=USD * E; 
            fob.format("%.2f",Euro); 
            t2.setText(""+SGD); 
            t3.setText(""+Euro); 
        } catch(Exception e) { 
            System.out.println("Enter Vaules in Box"); 
        } 
    } 
 
} 

public class Q2 {
    public static void main(String []args) { 
        new converter(); 
        Scanner sc=new Scanner(System.in); 
    } 
}