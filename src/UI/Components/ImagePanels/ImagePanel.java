package UI.Components.ImagePanels;

import javax.imageio.ImageIO;
import javax.swing.*;

import Domain.GameController;
import Domain.Event.Type;
import UI.View.LoginView;
import Utils.AssetLoader;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;

public class ImagePanel extends JPanel {
    
    private BufferedImage image;
    private int shape=0;
    private int cornerVal=10;
    
    public ImagePanel(String source) {
        loadImage(source);
        this.setOpaque(false);
    }
    
    public ImagePanel(BufferedImage source) {
        loadImage(source);
        this.setOpaque(false);
    }
    
    public ImagePanel(String source, int shape) {
        loadImage(source);
        this.setOpaque(false);
        this.shape=shape;
    }
    
    public ImagePanel(String source, int shape,int cornerVal) {
        loadImage(source);
        this.setOpaque(false);
        this.shape=shape;
        this.cornerVal=cornerVal;
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
    
    public int getCornerVal() {
    	return cornerVal;
    }
    
    
    
    //makes image fit
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        if (image != null && shape==0) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            
            g.drawImage(image, 0, 0, panelWidth, panelHeight, this);
        }
        
        if (image != null && shape==1) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();


            // Create a rounded rectangle as the clipping area
            RoundRectangle2D.Double roundedRect = new RoundRectangle2D.Double(0, 0, panelWidth, panelHeight, cornerVal, cornerVal);
            ((Graphics2D) g).setClip(roundedRect);

            // Draw the image within the rounded rectangle clipping area
            g.drawImage(image, 0, 0, panelWidth, panelHeight, this);

            // Reset the clip to avoid affecting subsequent drawings
            ((Graphics2D) g).setClip(null);
        }
    }
    
    public void apllyFunc(MouseAdapter m1) {
    	
    	this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	switch(shape) {
            	case 0:
                	m1.mouseClicked(e);
                	break;
            	case 1:
            		if(isPointInsideRoundedRectangle(e.getPoint())) {
            			m1.mouseClicked(e);
            			
            		}
            		break;
            	}
                
            }
        });
    	
    }


    private boolean isPointInsideRoundedRectangle(Point point) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        
        RoundRectangle2D.Double roundedRect = new RoundRectangle2D.Double(0, 0, panelWidth, panelHeight, cornerVal, cornerVal);

        return roundedRect.contains(point);
    }
    
    public static void main(String[] args) { // TODO: Move to UnitTests
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1294, 757);
        frame.getContentPane().setLayout(null);
        
        ImagePanel pan1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_0));
        pan1.setBounds(50, 50, 100, 100);
        frame.getContentPane().add(pan1);
        
        ImagePanel pan2 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_0),1);
        pan2.setBounds(250, 50, 100, 200);
        frame.getContentPane().add(pan2);
        
        ImagePanel pan3 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_0),1);
        pan3.setBounds(550, 50, 200, 100);
        frame.getContentPane().add(pan3);
        
        ImageChangingPanel pan4 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_0),AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_1),1);
        pan4.setBounds(550, 350, 200, 100);
        frame.getContentPane().add(pan4);

        MouseAdapter M1 =new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                System.out.print("AAABBBB");
            }
        };
        pan2.apllyFunc(M1);
        
        frame.setVisible(true);
    }
    
}
