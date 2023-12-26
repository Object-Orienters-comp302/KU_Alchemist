package UI.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleTransparentPanel extends JPanel {
    
    public CircleTransparentPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane().setLayout(null);
        
        Button but = new Button();
        but.setBounds(10, 10, 500, 50);
        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.print("as");
            }
        });
        frame.getContentPane().add(but);
        
        CircleTransparentPanel pan = new CircleTransparentPanel(10, 10, 100, 100);
        frame.getContentPane().add(pan);
        frame.getContentPane().setComponentZOrder(pan, 0);
        
        frame.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int originalDiameter = Math.min(getWidth(), getHeight());
        int customDiameter = originalDiameter * 1;
        
        int x = (getWidth() - customDiameter) / 2;
        int y = (getHeight() - customDiameter) / 2;
        
        g.setColor(new Color(90, 85, 112, 120));
        g.fillOval(x, y, customDiameter, customDiameter);
    }
}
