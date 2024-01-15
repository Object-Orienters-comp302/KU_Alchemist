package UI.Components.ImagePanels;

import Utils.AssetLoader;
import Utils.GUtil;
import Utils.KawaseBlur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class ImageBlurPanel extends JPanel {
    private String defImage;
    private ImagePanel    image;
    private int shape=0;
    
    
    
    public ImageBlurPanel(String defImage) {
        this.defImage   = defImage;
        
        initilize();
        
    }
    
    public ImageBlurPanel(String defImage, int shape ) {
        this.defImage   = defImage;
        this.shape=shape;
        
        initilize();
        
    }
    private void initilize() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights    = new double[]{ 1.0 };
        gridBagLayout.columnWeights = new double[]{ 1.0 };
        this.setLayout(gridBagLayout);
        setOpaque(false);
        
        image = new ImagePanel(defImage,shape);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill  = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        
        image.changeImage(KawaseBlur.applyKawaseBlur(Objects.requireNonNull(GUtil.fetchImage(defImage)), 5, 2));
        
        add(image, gbc_panel);
        this.addMouseListener(new ImageChangeListener(this.image, this.defImage));
    }
    
    public String getDefImage() {
        return defImage;
    }
    
    
    
    public void setDefImage(String defImage) {
        this.defImage = defImage;
        this.addMouseListener(new ImageChangeListener(this.image, this.defImage));
        this.image.changeImage(this.defImage);
        this.revalidate();
        this.repaint();
    }
    
    public void setActiveImage(AssetLoader.AssetPath path){
        image.changeImage(path);
    }
    
    static class ImageChangeListener extends MouseAdapter {
        private final ImagePanel    panel;
        private final BufferedImage hoverImage;
        private final BufferedImage defImage;
        
        public ImageChangeListener(ImagePanel panel, String defImage) {
            this.panel      = panel;
            this.hoverImage = GUtil.fetchImage(defImage);
            this.defImage   = KawaseBlur.applyKawaseBlur(Objects.requireNonNull(GUtil.fetchImage(defImage)), 5, 2);
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
