package GUI_Components_Publish;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI_Components.ImagePanel;

public class BooksDisplayer extends JPanel {
	
	public BooksDisplayer() {
		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);
		setBackground(Color.red);
		ImagePanel Background= new ImagePanel("./Images/backgrounds/publishBackground.png");
		Background.setBounds(0, 0, 1000	, 500);
		add(Background);
		Background.setLayout(null);
		BookPanel B0 = new BookPanel(0);
		BookPanel B1 = new BookPanel(1);
		BookPanel B2 = new BookPanel(2);
		BookPanel B3 = new BookPanel(3);
		BookPanel B4 = new BookPanel(4);
		BookPanel B5 = new BookPanel(5);
		BookPanel B6 = new BookPanel(6);
		BookPanel B7 = new BookPanel(7);
		
		B0.setBounds(10,5,400,200);
		B1.setBounds(335,5,400,200);
		B2.setBounds(670,5,400,200);
		B3.setBounds(10,160,400,200);
		B4.setBounds(670,160,400,200);
		B5.setBounds(10,315,400,200);
		B6.setBounds(335,315,400,200);
		B7.setBounds(670,315,400,200);
		Background.add(B0);
		Background.add(B1);
		Background.add(B2);
		
		
		Background.add(B3);
		Background.add(B4);
		Background.add(B5);
		Background.add(B6);
		Background.add(B7);
		
	}
	
	 public static void main (String[] args) {
	        // TODO Auto-generated method stub
	        
	        JFrame frame = new JFrame("test");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1500, 1500);
	        frame.getContentPane()
	                .setLayout(null);
	        frame.getContentPane().setBackground(Color.blue);
	        BooksDisplayer bo= new BooksDisplayer();
	        bo.setBounds(0, 0, 1500, 1500);
	        frame.getContentPane().add(bo);
	        
	        
	        
	        
	        frame.setVisible(true);
	        
	    }
}
