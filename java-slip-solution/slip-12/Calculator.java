import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class Calculator extends JFrame implements ActionListener
{ 
	JButton one,two,three,four,five,six,seven,eight,nine,zero,eq,dot,add,sub,mul,div;
	JTextField t1; 
	JPanel p1,p2; 
	float op1,op2; 
	char oper; 
	float ans=0; 
	public Calculator() 
	{ 
		one=new JButton("1"); 
		two=new JButton("2");
		three=new JButton("3"); 
		four=new JButton("4"); 
		five=new JButton("5"); 
		six=new JButton("6"); 
		seven=new JButton("7"); 
		eight=new JButton("8"); 
		nine=new JButton("9"); 
		zero=new JButton("0"); 
		dot=new JButton("."); 
		add=new JButton("+"); 
		sub=new JButton("-"); 
		mul=new JButton("*"); 
		div=new JButton("/"); 
		eq=new JButton("="); 
        
		t1=new JTextField(20); 
		p1=new JPanel(); 
		p1.setLayout(new BorderLayout()); 
		p1.add(t1,BorderLayout.NORTH); 
		p2=new JPanel(); 
		p2.setLayout(new GridLayout(4,4)); 

		p2.add(one); 
		p2.add(two); 
		p2.add(three); 
		p2.add(add); 
		p2.add(four); 
		p2.add(five); 
		p2.add(six); 
		p2.add(sub); 
		p2.add(seven); 
		p2.add(eight); 
		p2.add(nine); 
		p2.add(mul); 
		p2.add(zero); 
		p2.add(dot); 
		p2.add(eq); 
		p2.add(div); 

		one.addActionListener(this); 
		two.addActionListener(this); 
		three.addActionListener(this); 
		four.addActionListener(this); 
		five.addActionListener(this); 
		six.addActionListener(this); 
		seven.addActionListener(this); 
		eight.addActionListener(this); 
		nine.addActionListener(this); 
		zero.addActionListener(this); 
		add.addActionListener(this); 
		sub.addActionListener(this); 
		mul.addActionListener(this); 
		div.addActionListener(this); 
		eq.addActionListener(this); 
		dot.addActionListener(this);

		setLayout(new GridLayout(2,1)); 
		add(p1); 
		add(p2); 
		setSize(500,200); 
		setVisible(true); 
		setTitle("Simple Calculator"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	} 
	public void actionPerformed(ActionEvent ae) 
	{ 
		String nm=(String)ae.getActionCommand(); 
		if(nm.equals("1")||nm.equals("2")||nm.equals("3")||nm.equals("4")||nm.equals("5")||nm.equals("6")||nm.equals("7")||nm.equals("8")||nm.equals("9")||nm.equals("0")||nm.equals(".")) 
		{ 
			String s=t1.getText(); 
			t1.setText(s+nm); 
		} 
		JButton b=(JButton)ae.getSource(); 
		if(b==add||b==sub||b==mul||b==div) 
		{ 
			op1=Float.parseFloat(t1.getText()); 
			t1.setText(""); 
			t1.requestFocus(); 
			oper=b.getText().charAt(0); 
		} 
		if(b==eq) 
		{ 
			op2=Float.parseFloat(t1.getText()); 
			switch(oper) 
			{ 
				case '+': 
					ans=op1+op2; 
				break; 
				case '-': 
					ans=op1-op2; 
				break; 
				case '*': 
					ans=op1*op2; 
				break; 
				case '/': 
					ans=op1/op2; 
				break; 
			} 
			t1.setText(Float.toString(ans)); 
		} 
	} 
	public static void main(String[] args) 
	{ 
		new Calculator(); 
	} 
}