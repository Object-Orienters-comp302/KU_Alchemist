package UI.Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//TODO: not working at all, will look at it later 
public class SideRoundedPanel extends JPanel { 
    private int arcWidth;
    private int arcHeight;

    public SideRoundedPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Create a polygon with one rounded corner
        Polygon polygon = new Polygon();
        polygon.addPoint(arcWidth, 0);
        polygon.addPoint(width, 0);
        polygon.addPoint(width, height);
        polygon.addPoint(0, height);
        polygon.addPoint(0, arcHeight);

        // Set the background color of the panel
        g2d.setColor(getBackground());
        g2d.fill(polygon);

        // Draw the border of the polygon
        g2d.setColor(getForeground());
        g2d.draw(polygon);

        g2d.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rounded Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);

        SideRoundedPanel sid = new SideRoundedPanel(100, 100);
        sid.setBounds(50, 50, 100, 100);
        sid.setBackground(Color.BLUE);
        sid.setForeground(Color.WHITE);
        frame.add(sid);

        frame.setVisible(true);
    }
}