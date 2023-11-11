import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField; 
class ComboBoxExample { 
    JFrame f; 
    JTextField t1; 
    ComboBoxExample() 
    { 
        f=new JFrame("ComboBox Example"); 
        t1=new JTextField(20); 
        JButton b=new JButton("Show"); 
        b.setBounds(200,100,75,20); 
        String languages[]={"C","C++","C#","Java","PHP"}; 
        final JComboBox cb = new JComboBox(languages); 
        cb.setBounds(50, 100,90,20); 
        f.add(cb);
        
        f.add(b); 
        f.add(t1); 
        f.setLayout(new FlowLayout()); 
        f.setSize(350,350); 
        f.setVisible(true); 
        b.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    String data = "Programming language Selected: " + 
                    cb.getItemAt(cb.getSelectedIndex()); 
                    t1.setText(data); 
                } 
        }); 
    } 
} 
public class Q2 {
    public static void main(String[] args) { 
        new ComboBoxExample(); 
    } 
}