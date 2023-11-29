package GUI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class AngledLinePanel extends JPanel {
	
	private Color lineColor=Color.BLACK;
	private Float lineThickness=(float) 2.0;
	private Boolean topToBot=true;
	
	public AngledLinePanel(){
		setOpaque(false);
	}
	public AngledLinePanel(String color,int thickness){
		setOpaque(false);
		lineColor=Color.decode(color);
		lineThickness= (float) thickness;
		
	}
	public AngledLinePanel(String color,int thickness,Boolean direction){
		setOpaque(false);
		lineColor=Color.decode(color);
		lineThickness= (float) thickness;
		topToBot=direction;
		
	}

    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(lineColor);

        g2d.setStroke(new BasicStroke(lineThickness));
        
        if(topToBot) {
        	g2d.drawLine(0, 0, getWidth(), getHeight());
        }
        else {
        	g2d.drawLine(0, getHeight(),getWidth(), 0);
        }
        
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Angled Line Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            AngledLinePanel angledLinePanel = new AngledLinePanel();
            frame.getContentPane().add(angledLinePanel);

            frame.setVisible(true);
        });
    }
}
