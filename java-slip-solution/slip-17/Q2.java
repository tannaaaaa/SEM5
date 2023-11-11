import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

 class Textbox extends JFrame implements ActionListener {
    JTextField tf1, tf2, tf3;
    JButton btn1, btn2;

    public Textbox() {
        tf1 = new JTextField();
        tf1.setBounds(50, 50, 150, 20);
        add(tf1);

        tf2 = new JTextField();
        tf2.setBounds(50, 100, 150, 20);
        add(tf2);

        tf3 = new JTextField();
        tf3.setBounds(50, 150, 150, 20);
        tf3.setEditable(false);
        add(tf3);

        btn1 = new JButton("Concatenate");
        btn1.setBounds(50, 200, 100, 30);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Reverse");
        btn2.setBounds(150, 200, 100, 30);
        btn2.addActionListener(this);
        add(btn2);

        setTitle("Textbox and Button Demo");
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String str1 = tf1.getText();
            String str2 = tf2.getText();
            String result = str1 + str2;
            tf3.setText(result);
        } else if (e.getSource() == btn2) {
            String str = tf1.getText();
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            tf3.setText(sb.toString());
        }
    }
 }

 public class Q2 {
    public static void main(String[] args) {
        new Textbox();
    }
}