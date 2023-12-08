package UI.Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    
    private BufferedImage image;
    
    public ImagePanel(String source) {
        loadImage(source);
        this.setOpaque(false);
    }
    
    private void loadImage(String source) {
        try {
            // Load an image from a file
            image = ImageIO.read(new File(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ImagePanel(BufferedImage source) {
        loadImage(source);
        this.setOpaque(false);
    }
    
    private void loadImage(BufferedImage source) {
        
        image = source;
    }
    
    public void changeImage(String newSource) {
        loadImage(newSource);
        repaint();
    }
    
    
    public void changeImage(BufferedImage newSource) {
        loadImage(newSource);
        repaint();
    }
    
    //makes image fit
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw the image on the panel without maintaining aspect ratio
        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            
            g.drawImage(image, 0, 0, panelWidth, panelHeight, this);
        }
    }
}
