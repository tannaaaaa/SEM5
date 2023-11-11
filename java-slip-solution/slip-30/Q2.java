import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class IntegerDivisionUI extends JFrame implements ActionListener {
    private JTextField number1Field, number2Field, resultField;

    public IntegerDivisionUI() {
        super("Integer Division");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Number1:"));
        number1Field = new JTextField(20);
        add(number1Field);
        add(new JLabel("Number2:"));
        number2Field = new JTextField(0);
        add(number2Field);
        add(new JLabel("Result:"));
        resultField = new JTextField(20);
        resultField.setEditable(false);
        add(resultField);
        JButton divideButton = new JButton("Divide");
        add(divideButton);
        divideButton.addActionListener(this);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int number1 = Integer.parseInt(number1Field.getText());
            int number2 = Integer.parseInt(number2Field.getText());
            int result = number1 / number2;
            resultField.setText(Integer.toString(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Cannot divide by zero: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        new IntegerDivisionUI();
    }
}