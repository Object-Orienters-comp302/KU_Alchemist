package GUI_Components;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookButtonPopup extends JPanel {
    private int width, height, x, y;
    
    public BookButtonPopup (int x, int y, int width, int height, ImagePanel imgPanel) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setLayout(null);
        int [] data=new int[3];
        int current=1;
        
        
        BookPopupButton B0 = new BookPopupButton(width * 3 / 8, height * 1/8, width * 5 / 16, height * 5 / 16,
        		0, imgPanel);
        add(B0);
        BookPopupButton B1 = new BookPopupButton(width* 1 / 8, height * 3/8 , width * 5 / 16, height * 5 / 16,
        		1, imgPanel);
        add(B1);
        BookPopupButton B2 = new BookPopupButton(width *1/ 8, height * 5/8 , width * 5 / 16, height * 5 / 16,
        		2, imgPanel);
        add(B2);
        BookPopupButton B3 = new BookPopupButton(width * 3 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
        		3, imgPanel);
        add(B3);
        BookPopupButton B4 = new BookPopupButton(width * 5/ 8, height *7/ 8, width * 5 / 16, height * 5 / 16,
        		4, imgPanel);
        add(B4);
        BookPopupButton B5 = new BookPopupButton(width * 7 / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
        		5, imgPanel);
        add(B5);
        BookPopupButton B6 = new BookPopupButton(width * 7 / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
        		6, imgPanel);
        add(B6);
        BookPopupButton B7 = new BookPopupButton(width * 5 / 8, height * 1 / 8, width * 5 / 16, height * 5 / 16,
        		7, imgPanel);
        add(B7);
        
        BookPopupButton B8 = new BookPopupButton(width * 4 / 8, height * 4 / 8, width * 8 / 16, height * 8 / 16,
        		8, imgPanel);
        add(B8);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                Container parent = BookButtonPopup.this.getParent();
                
                if (parent != null) {
                    
                    parent.remove(BookButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                    
                }
                
            }
            
            @Override
            public void mouseExited (MouseEvent e) {
                Container parent = BookButtonPopup.this.getParent();
                if (parent != null) {
                    Point mousePoint = e.getPoint();
                    
                    // Check if the mouse is still within the bounds of the parent component
                    if (BookButtonPopup.this.contains(mousePoint)) {
                        return;
                    }
                    parent.remove(BookButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                }
                
            }
        });
        
    }
    
    private int select(int current, int desired) {
    	if(current==desired){
    		return 0;
    	}
    	else {
    		return desired;
    	}
    }
    private void Disable() {
    	if(BookButton.taken.contains(1)) {
    	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
    	}
    	if(BookButton.taken.contains(1)) {
        	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
        	}
    	if(BookButton.taken.contains(1)) {
        	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
        	}
    	if(BookButton.taken.contains(1)) {
        	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
        	}
    	if(BookButton.taken.contains(1)) {
        	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
        	}
    	if(BookButton.taken.contains(1)) {
        	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
        	}
    	if(BookButton.taken.contains(1)) {
        	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
        	}
    	if(BookButton.taken.contains(1)) {
        	CircleTransparentPanel pan= new CircleTransparentPanel(10,10,100,100);
        	}
    }
    
    public static void main (String[] args) {
        // TODO Auto-generated method stub
        /*
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane()
                .setLayout(null);
        /*
        TriangleTableButtonPopup login = new TriangleTableButtonPopup(200, 200, 600, 600, null);
        
        
        frame.getContentPane()
                .add(login);
        *//*
        
        frame.setVisible(true);*/
        
    	int[] testArr= new int[4];
    	JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane()
                .setLayout(null);
        
        frame.getContentPane().setBackground(Color.red);
        BookButtonPopup boo=new BookButtonPopup(100, 100, 100 * 3, 100 * 3,null);
        frame.getContentPane().add(boo);
        frame.setVisible(true);
        
        
    }
}
