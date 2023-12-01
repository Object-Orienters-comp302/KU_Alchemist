package GUI_Components;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TriangleTableButtonPopup extends JPanel{
	private int width,height,x,y; 
	
	public TriangleTableButtonPopup(int x,int y,int width,int height,ImagePanel imgPanel) {
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setLayout(null);
		
		
		CircleImgButton B1 = new CircleImgButton(width*2/6,height*1/6,width*5/16,height*5/16,".\\Images\\triangleTable\\plusRed.png",imgPanel);
		add(B1);
		CircleImgButton B2 = new CircleImgButton(width*1/6,height*3/6,width*5/16,height*5/16,".\\Images\\triangleTable\\plusGreen.png",imgPanel);
		add(B2);
		CircleImgButton B3 = new CircleImgButton(width*2/6,height*5/6,width*5/16,height*5/16,".\\Images\\triangleTable\\plusBlue.png",imgPanel);
		add(B3);
		CircleImgButton B4 = new CircleImgButton(width*4/6,height*1/6,width*5/16,height*5/16,".\\Images\\triangleTable\\minusRed.png",imgPanel);
		add(B4);
		CircleImgButton B5 = new CircleImgButton(width*5/6,height*3/6,width*5/16,height*5/16,".\\Images\\triangleTable\\minusGreen.png",imgPanel);
		add(B5);
		CircleImgButton B6 = new CircleImgButton(width*4/6,height*5/6,width*5/16,height*5/16,".\\Images\\triangleTable\\minusBlue.png",imgPanel);
		add(B6);
		CircleImgButton B7 = new CircleImgButton(width*3/6,height*3/6,width*11/32,height*11/32,".\\Images\\triangleTable\\outline.png",imgPanel);
		add(B7);
		
		
		this.addMouseListener((MouseListener) new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	Container parent = TriangleTableButtonPopup.this.getParent();
	        	
	        	if (parent != null) {
	        		
	        	    parent.remove(TriangleTableButtonPopup.this);
	        	    parent.revalidate();
	        	    parent.repaint();
	        		
	        	}
	            
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	        	Container parent = TriangleTableButtonPopup.this.getParent();
	        	if (parent != null) {
	        		Point mousePoint = e.getPoint();
	                
	                // Check if the mouse is still within the bounds of the parent component
	                if (TriangleTableButtonPopup.this.contains(mousePoint)) {
	                    return;
	                }
	        	    parent.remove(TriangleTableButtonPopup.this);
	        	    parent.revalidate();
	        	    parent.repaint();
	        	}
	            
	        }
		});
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane().setLayout(null);
        TriangleTableButtonPopup login = new TriangleTableButtonPopup(200,200,600,600,null);
        
        
        frame.getContentPane().add(login);
        frame.setVisible(true);

	}

}
