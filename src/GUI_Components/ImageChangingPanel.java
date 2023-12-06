package GUI_Components;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GUI_Components.ColorChangingPanel.ColorChangeListener;
import Utils.GUtil;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

public class ImageChangingPanel extends JPanel {
    private BufferedImage defImage;
    private BufferedImage hoverImage;
    
    // Constructor that takes a Color parameter
    /**
     * @wbp.parser.constructor
     */
    public ImageChangingPanel (BufferedImage defImage, BufferedImage hoverImage) {
        this.defImage   = defImage;
        this.hoverImage = hoverImage;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights = new double[]{1.0};
        gridBagLayout.columnWeights = new double[]{1.0};
        this.setLayout(gridBagLayout);
        
        ImagePanel image= new ImagePanel(defImage);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        add(image, gbc_panel);
        this.addMouseListener(new ImageChangeListener(image, this.defImage, this.hoverImage));
    }
    
    public ImageChangingPanel (String defImage, String hoverImage) {
        this.defImage   = GUtil.fetchImage(defImage);
        this.hoverImage = GUtil.fetchImage(hoverImage);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights = new double[]{1.0};
        gridBagLayout.columnWeights = new double[]{1.0};
        this.setLayout(gridBagLayout);
        
        ImagePanel image= new ImagePanel(defImage);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        add(image, gbc_panel);
        this.addMouseListener(new ImageChangeListener(image, this.defImage, this.hoverImage));
        
    }
    
    static class ImageChangeListener extends MouseAdapter {
        private final ImagePanel panel;
        private final BufferedImage  hoverImage;
        private final BufferedImage  defImage;
        
        public ImageChangeListener (ImagePanel panel, BufferedImage defImage, BufferedImage hoverImage) {
            this.panel         = panel;
            this.hoverImage    = hoverImage;
            this.defImage = defImage;
        }
        
        @Override
        public void mouseEntered (MouseEvent e) {
            panel.changeImage(hoverImage);
        }
        
        @Override
        public void mouseExited (MouseEvent e) {
            panel.changeImage(defImage);
        }
    }
}
