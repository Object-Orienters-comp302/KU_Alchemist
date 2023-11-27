package GUI_Components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TrianglePanel extends JPanel {
		private Color triangleColor;//TODO: can be changed to hexcode later

	    // Constructor that takes a Color parameter
	    public TrianglePanel(Color triangleColor) {
	        this.triangleColor = triangleColor;
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        int width = getWidth();
	        int height = getHeight();

	        // Define the three points of the triangle
	        int[] xPoints = {0, width / 2, width};
	        int[] yPoints = {height, 0, height};

	        // Set the color of the triangle
	        g.setColor(triangleColor); // You can set your desired color here

	        // Fill the triangle
	        g.fillPolygon(xPoints, yPoints, 3);
	    }

	    
	}