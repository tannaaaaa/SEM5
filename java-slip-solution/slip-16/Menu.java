import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea; 
public class Menu extends JFrame implements ActionListener 
{ 
    JMenu m1,m2; 
    JMenuBar mb; 
    JMenuItem i1,i2,i3,i4,i5,i6,i7; 
    JTextArea t; 
    JPanel p; 
    Menu() 
    { 
        p=new JPanel(); 
        mb=new JMenuBar(); 
        m1=new JMenu("File"); 
        m2=new JMenu("Save As"); 
        
        i1=new JMenuItem("New"); 
        i2=new JMenuItem("Open"); 
        i3=new JMenuItem("Save"); 
        i4=new JMenuItem("ppt"); 
        i5=new JMenuItem("doc"); 
        i6=new JMenuItem("pdf"); 
        i7=new JMenuItem("Exit"); 
        
        t=new JTextArea("Text Area"); 
        
        m1.add(i1); 
        m1.add(i2); 
        m1.add(i3); 
        m1.add(m2); 
        m1.addSeparator(); 
        m1.add(i7); 
        m2.add(i4); 
        m2.add(i5); 
        m2.add(i6); 
        
        mb.add(m1);
        setJMenuBar(mb); 
        p.setLayout(new BorderLayout()); 
        p.add(t,BorderLayout.SOUTH); 
        add(p); 
 
        i2.addActionListener(this); 
 
        setTitle("MenuBar"); 
        setVisible(true); 
        setSize(500,500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        if(e.getSource()==i2) 
        { 
            JFileChooser fc=new JFileChooser(); 
            int i=fc.showOpenDialog(this); 
            if(i==JFileChooser.APPROVE_OPTION) 
            { 
                File f=fc.getSelectedFile(); 
                String fpath=f.getPath(); 
                try { 
                    BufferedReader br=new BufferedReader(new FileReader (fpath)); 
                    String s1="",s2=""; 
                    while((s1=br.readLine())!=null)  { 
                            s2+=s1+"\n"; 
                    } 
                    t.setText(s2); 
                }catch(Exception ev) {}  
            } 
        } 
    } 
    public static void main(String args[])  { 
        new Menu(); 
    } 
}