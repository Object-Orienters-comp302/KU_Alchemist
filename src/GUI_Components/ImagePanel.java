package GUI_Components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(String source) {
        loadImage(source);
        this.setOpaque(false);
    }
    
    public ImagePanel(BufferedImage source) {
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
    
    
    
    
    
    
    // saves ratio
    /*
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the image on the panel with scaling to fit
        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            double scaleFactor = Math.min(1.0 * panelWidth / image.getWidth(), 1.0 * panelHeight / image.getHeight());

            int scaledWidth = (int) (image.getWidth() * scaleFactor);
            int scaledHeight = (int) (image.getHeight() * scaleFactor);

            int x = (panelWidth - scaledWidth) / 2;
            int y = (panelHeight - scaledHeight) / 2;

            g.drawImage(image, x, y, scaledWidth, scaledHeight, this);
        }
    }
    */
    
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel imagePanel = new ImagePanel("../khorne.png");
            frame.getContentPane().add(imagePanel);

            frame.setVisible(true);
        });
    }
}
