package UI.Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Domain.GameController;
import Models.Ingredient;
import Models.Player;
import UI.Components.ImagePanels.ImagePanel;

import Utils.AssetLoader;

public class RoundedPanel extends JPanel {

	private int cornerRadius;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);
        g2d.setColor(getForeground());
        g2d.draw(roundedRectangle);

        g2d.dispose();
    }
    
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        super.paintChildren(g2);
        g2.dispose();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded Panel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            RoundedPanel roundedPanel = new RoundedPanel(50);
            roundedPanel.setBackground(Color.BLUE);
            frame.getContentPane().setLayout(null);
            roundedPanel.setBounds(50, 50, 100, 100);
            
            RoundedPanel roundedPanel1 = new RoundedPanel(50);
            roundedPanel1.setBackground(Color.BLUE);
            
            roundedPanel1.setBounds(250, 50, 100, 100);
            frame.getContentPane().add(roundedPanel1);
            
            roundedPanel.setLayout(null);
            ImagePanel img = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_0));
            img.setBounds(0,0,100,100);
            roundedPanel.add(img);
            
            
            roundedPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.print("xx");
                    
                }
            });

            frame.getContentPane().add(roundedPanel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}