package GUI_Components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

public class TriangleTableButton extends JPanel {
	private int diameter,x,y;
	private ImagePanel img;
	
    
    public TriangleTableButton(int x,int y,int width,int height) {
    	this.setOpaque(false);
    	setLayout(null);
    	this.setBounds(x,y,width,height);
    	
    	img = new ImagePanel(".\\Images\\triangleTable\\outline.png");
    	img.setBounds(0, 0, width, height);
    	add(img);
    	
    	
    	this.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();

                if (isClickInsideCircle(clickX, clickY)) {
                    System.out.println("Button click inside the circle!");
                    TriangleTableButtonPopup pop = new TriangleTableButtonPopup(x-width*1,y-height*1,width*3,height*3,img);
                    //how to make it add to it
                    Container parent= getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop, 0);
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
        

    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = Math.min(getWidth(), getHeight()); 
        this.diameter=diameter;

        int x = (getWidth() - diameter) / 2; 
        int y = (getHeight() - diameter) / 2; 
        this.x=x;
        this.y=y;

        
        g.setColor(Color.WHITE); 
        g.fillOval(x+5, y+5, diameter-10, diameter-10);/// these fixed values can be changed to dynamics later
    }
    
    
    private boolean isClickInsideCircle(int clickX, int clickY) {
        int radius = diameter / 2;
        int centerX = x + radius;
        int centerY = y + radius;

        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));

        return distance <= radius;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane().setLayout(null);
        TriangleTableButton login = new TriangleTableButton(300,300,400,400);
        
        
        frame.getContentPane().add(login);
        frame.setVisible(true);
        

	}

}
