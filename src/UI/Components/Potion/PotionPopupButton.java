package UI.Components.Potion;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PotionPopupButton extends JPanel {
    private int diameter, x, y;
    private ImagePanel img;
    
    public PotionPopupButton(int x, int y, int width, int height, AssetLoader.AssetPath imgPath,
                             ImagePanel panelToChange, PotionButton book, boolean works) {
        
        setLayout(null);
        this.setBounds(x - width / 2, y - height / 2, width, height);
        img = new ImagePanel(AssetLoader.getAssetPath(imgPath));
        img.setBounds(width / 10, width / 10, width*4 / 5, height*4 / 5);
        add(img);
        this.setOpaque(false);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (works) {
                    int clickX = e.getX();
                    int clickY = e.getY();
                    Container parent = PotionPopupButton.this.getParent();
                    Container grandParent = parent.getParent();
                    
                    if (isClickInsideCircle(clickX, clickY)) {
                        
                        
                        panelToChange.changeImage(AssetLoader.getAssetPath(imgPath));
                        book.setCurrentPotion(imgPath);
                        if (grandParent != null) {
                            
                            grandParent.remove(parent);
                            grandParent.revalidate();
                            grandParent.repaint();
                            
                        }
                        
                        
                    } else {
                        if (grandParent != null) {
                            
                            grandParent.remove(parent);
                            grandParent.revalidate();
                            grandParent.repaint();
                            
                        }
                        
                    }
                }
            }
        });
        
        
    }
    
    private boolean isClickInsideCircle(int clickX, int clickY) {
        int radius = diameter / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        
        return distance <= radius;
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int originalDiameter = Math.min(getWidth(), getHeight());
        int customDiameter = originalDiameter * 1;
        
        int x = (getWidth() - customDiameter) / 2;
        int y = (getHeight() - customDiameter) / 2;
        diameter = originalDiameter;
        
        g.setColor(Color.decode("#ebd2a9"));
        g.fillOval(x, y, customDiameter, customDiameter);
    }
    
}