import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseAdapterDemo extends Frame {
    Label label;
    MouseAdapterDemo() {
        label = new Label();
        label.setAlignment(Label.CENTER);
        label.setSize(300, 100);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked");
                label.setForeground(Color.RED);
            }
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered");
                label.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited");
                label.setForeground(Color.RED);
            }
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed");
                label.setForeground(Color.RED);
            }
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released");
                label.setForeground(Color.RED);
            }
        });
        add(label);
        setSize(400, 400);
        setLayout(new FlowLayout());
        setVisible(true);
    }
}

public class Q2 {
    public static void main(String[] args) {
        new MouseAdapterDemo();
    }
}