import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class SwingTemperatureConverter extends JFrame implements ActionListener {
    private JTextField celField, fahField;

    public SwingTemperatureConverter() {
        super("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));
        add(new JLabel("Celsius:"));
        celField = new JTextField(20);
        add(celField);
        add(new JLabel("Fahrenheit:"));
        fahField = new JTextField(20);
        add(fahField);
        celField.addActionListener(this);
        fahField.addActionListener(this);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == celField) {
            double celsius = Double.parseDouble(celField.getText());
            double fahrenheit = (9.0/5.0)*celsius + 32;
            fahField.setText(String.format("%.1f", fahrenheit));
        } else if (e.getSource() == fahField) {
            double fahrenheit = Double.parseDouble(fahField.getText());
            double celsius = (fahrenheit - 32)*(5.0/9.0);
            celField.setText(String.format("%.1f", celsius));
        }
    }
}
public class Q2 {
    public static void main(String[] args) {
        new SwingTemperatureConverter();
    }
}