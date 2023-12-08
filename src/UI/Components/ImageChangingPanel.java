package UI.Components;

import Utils.GUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ImageChangingPanel extends JPanel {
    private BufferedImage defImage;
    private BufferedImage hoverImage;
    private ImagePanel    image;
    // Constructor that takes a Color parameter
    
    /**
     * @wbp.parser.constructor
     */
    public ImageChangingPanel(BufferedImage defImage, BufferedImage hoverImage) {
        this.defImage   = defImage;
        this.hoverImage = hoverImage;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights    = new double[]{ 1.0 };
        gridBagLayout.columnWeights = new double[]{ 1.0 };
        this.setLayout(gridBagLayout);
        setOpaque(false);
        
        image = new ImagePanel(defImage);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill  = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        add(image, gbc_panel);
        this.addMouseListener(new ImageChangeListener(this.image, this.defImage, this.hoverImage));
    }
    
    public ImageChangingPanel(String defImage, String hoverImage) {
        this.defImage   = GUtil.fetchImage(defImage);
        this.hoverImage = GUtil.fetchImage(hoverImage);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights    = new double[]{ 1.0 };
        gridBagLayout.columnWeights = new double[]{ 1.0 };
        this.setLayout(gridBagLayout);
        setOpaque(false);
        
        image = new ImagePanel(defImage);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill  = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        add(image, gbc_panel);
        this.addMouseListener(new ImageChangeListener(image, this.defImage, this.hoverImage));
        
    }
    
    public BufferedImage getDefImage() {
        return defImage;
    }
    
    // Setter for defImage
    public void setDefImage(BufferedImage defImage) {
        this.defImage = defImage;
        this.addMouseListener(new ImageChangeListener(this.image, this.defImage, this.hoverImage));
        this.image.changeImage(this.defImage);
        this.revalidate();
        this.repaint();
    }
    
    public void setDefImage(String defImage) {
        this.defImage = GUtil.fetchImage(defImage);
        this.addMouseListener(new ImageChangeListener(this.image, this.defImage, this.hoverImage));
        this.image.changeImage(this.defImage);
        this.revalidate();
        this.repaint();
    }
    
    // Getter for hoverImage
    public BufferedImage getHoverImage() {
        return hoverImage;
    }
    
    // Setter for hoverImage
    public void setHoverImage(BufferedImage hoverImage) {
        this.hoverImage = hoverImage;
        this.addMouseListener(new ImageChangeListener(this.image, this.defImage, this.hoverImage));
        this.revalidate();
        this.repaint();
    }
    
    public void setHoverImage(String hoverImage) {
        this.hoverImage = GUtil.fetchImage(hoverImage);
        this.addMouseListener(new ImageChangeListener(this.image, this.defImage, this.hoverImage));
        this.revalidate();
        this.repaint();
    }
    
    static class ImageChangeListener extends MouseAdapter {
        private final ImagePanel    panel;
        private final BufferedImage hoverImage;
        private final BufferedImage defImage;
        
        public ImageChangeListener(ImagePanel panel, BufferedImage defImage, BufferedImage hoverImage) {
            this.panel      = panel;
            this.hoverImage = hoverImage;
            this.defImage   = defImage;
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.changeImage(hoverImage);
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            panel.changeImage(defImage);
        }
    }
}
