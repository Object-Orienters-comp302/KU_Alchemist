package UI.Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HQImagePanel extends JPanel {
    
    private Image image;
    
    public HQImagePanel(Image image) {
        this.image = image;
    }
    
    public HQImagePanel(String source) {
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
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("HQImagePanel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 600));
        
        // Creating an HQImagePanel with an empty string as the path
        HQImagePanel hqImagePanel = new HQImagePanel("./Images/backgrounds/slaanesh_background.png");
        frame.getContentPane().add(hqImagePanel);
        
        frame.setVisible(true);
    }
    
    public void changeImage(String newSource) {
        loadImage(newSource);
        repaint();
    }
    
    
    public void changeImage(Image newSource) {
        loadImage(newSource);
        repaint();
    }
    
    private void loadImage(Image source) {
        
        image = source;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (image != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            
            // Enable anti-aliasing and rendering hints for better quality
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                                 RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            
            // Draw the image maintaining aspect ratio
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            
            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);
            
            double scale = Math.min((double) panelWidth / imageWidth, (double) panelHeight / imageHeight);
            
            int scaledWidth = (int) (scale * imageWidth);
            int scaledHeight = (int) (scale * imageHeight);
            
            int x = (panelWidth - scaledWidth) / 2;
            int y = (panelHeight - scaledHeight) / 2;
            
            g2d.drawImage(image, x, y, scaledWidth, scaledHeight, this);
            
            g2d.dispose();
        }
    }
    
    
}
