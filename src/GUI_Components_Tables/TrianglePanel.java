package GUI_Components_Tables;

import javax.swing.*;
import java.awt.*;

public class TrianglePanel extends JPanel {
    private Color triangleColor;//TODO: can be changed to hexcode later
    
    
    public TrianglePanel (Color triangleColor) {
        
        this.triangleColor = triangleColor;
        
    }
    
    public TrianglePanel (String color) {
        
        this.triangleColor = Color.decode(color);
        
    }
    
    public static void main (String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        TrianglePanel login = new TrianglePanel(Color.red);
        login.setPreferredSize(new Dimension(800, 400));
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
    }
    
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        
        int width = getWidth();
        int height = getHeight();
        
        // Define the three points of the triangle
        int[] xPoints = { 0, width / 2, width };
        int[] yPoints = { height, 0, height };
        
        // Set the color of the triangle
        g.setColor(triangleColor); // You can set your desired color here
        
        // Fill the triangle
        g.fillPolygon(xPoints, yPoints, 3);
    }
    
    
}