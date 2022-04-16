package stopwatch;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class StopWatch extends JFrame {
JLabel time;
JButton button1,button2;
int x,y;
int z;
 Mythread t;
 String w,m,n,e;
 ActionEvent event1;
 int count=0;
 public StopWatch() {
	 super (" StopWatch ");
	 x=0;
	 y=0;
	 z=0;
	 w="0"+x;
	 m=":0"+y;
	 e="."+z;
	 n=w+m+e;
	 setLayout(new FlowLayout());
	 time = new JLabel(n);
	 time.setFont(new Font("Serif",Font.BOLD,50));
	 time.setForeground(Color.RED);
	 add(time);
	 button1=new JButton(" START ");
	 button1.setFont(new Font("Serif",Font.BOLD,16));
	 button1.setForeground(Color.BLUE);
	 add(button1);
	 button2=new JButton(" RESET  ");
	 button2.setFont(new Font("Serif",Font.BOLD,16));
	 button2.setForeground(Color.RED);
	 add(button2);
	 t=new Mythread();
	 button1.addActionListener(t);
	 button2.addActionListener(t);
	 
 }
 private class Mythread extends Thread implements ActionListener{
	 public Mythread() {
		 super();
	 }
	 public void actionPerformed(ActionEvent event) {
		 if (event.getSource()!=button2) { count++;}
		 if((event.getSource()==button1&&count%2==0)&&count!=0)
		 {
			 button1.setText(" START ");
			 button1.setFont(new Font("Serif",Font.BOLD,16));
			 button1.setForeground(Color.BLUE);
			event1=event;
		 }
		
		 if (event.getSource()==button1&& count%2!=0)
		 {   event1=event;
			 button1.setText("  PASHE ");
			 button1.setFont(new Font("Serif",Font.BOLD,16));
			 button1.setForeground(Color.YELLOW);
			Mythread thread;
			thread=new Mythread();
			thread.start();
		 }
		
		 if (event.getSource()== button2 )
			 
		 {   if(button1.getText()=="  PASHE ")
		 {
			 button1.setText(" START ");
			 button1.setFont(new Font("Serif",Font.BOLD,16));
			 button1.setForeground(Color.BLUE);
			 event1=event;
			 count++;
		 }
			if(button1.getText()==" START "&&count>=2)
			{  
				x=0; y=0; z=0;
				 w="0"+x;
				 m=":0"+y;
				 e="."+z;
				 n=w+m+e;
				 time.setText(n);
				 count++;
				 count++;
			}
		 }
		 
		 }
		 
	 
	public void run() {
		while (true) { 
			try {
			Thread.sleep(100);
			if(event1.getSource()==button2) {
				
				x=0; y=0; z=0;
				 w="0"+x;
				 m=":0"+y;
				 e="."+z;
				 n=w+m+e;
				 time.setText(n);
				 break;
				}
		if (event1.getSource()== button1 &&count%2==0&&count!=0)
			{ 
				break;
			}
			
		z++;
		z=z%10;
		if(z==0)
		{
			y++;
		y=y%60;
		}
		if(y==59&&z==9)
		{ 
			x++;
			x=x%60;
		}
      
		if(y<=9&& z<=9)
		{	w="0"+x;
			 m=":0"+y;
			 e="."+z;
			 n=w+m+e; 
			 time.setText(n);}
		
			if(y>9 &&z<=9)
			{
				w="0"+x;
				 m=":"+y;
				 e="."+z;
				 n=w+m+e; 
				 time.setText(n);
			}
			if(x>9 &&y<9)
			{
				w=""+x;
				 m=":0"+y;
				 e="."+z;
				 n=w+m+e; 
				 time.setText(n);
			}
			if(x>9 &&y>9)
			{

				w=""+x;
				 m=":"+y;
				 e="."+z;
				 n=w+m+e; 
				 time.setText(n);
			}
		
		
			}
			catch (InterruptedException interrupt) {
				System.err.print(interrupt.toString());
			}
	}
 
 }}
	public static void main(String[] args) {
		StopWatch application=new StopWatch();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);
		application.setSize(260,148);
	}

}
