import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel; 
class Ovals extends JPanel { 
    private Graphics g; 
    private int prevX, prevY; 
    private String drawtype; 
    
    public Ovals() { 
        addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent me) { 
                selectpaint(); 
            } 
        }); 
    } 

    private void selectpaint() { 
        g=getGraphics(); 
        Dimension d = getSize(); 
        int x =d.width/2; 
        int y = d.height/2; 
        int r1=(int) ((d.width < d.height)? 0.4*d.width: 0.4*d.height); 
 
        g.setColor(Color.red); 
        g.fillOval(x-r1, y-r1, 2*r1, 2*r1); 
        int r2 =(int) ((d.width < d.height)? 0.3*d.width: 0.3* d.height); 
 
        g.setColor(Color.blue); 
        g.fillOval(x-r2, y-r2, 2*r2, 2*r2); 
        int r3= (int) ((d.width < d.height)? 0.2*d.width: 0.2 *d.height); 
 
        g.setColor(Color.yellow); 
        g.fillOval(x-r3, y-r3, 2*r3, 2*r3); 
    } 
    // to choose polygon to draw 
} 

public class Q2 {
    public static void main(String[] args) { 
        Ovals ovalsPanel = new Ovals(); 
        JFrame newFrame = new JFrame(); 
        newFrame.getContentPane().add(new Ovals()); 
        newFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE); // 
        newFrame.add( ovalsPanel ); 
        newFrame.setSize( 550, 550 ); 
        newFrame.setVisible(true); 
    } 
}