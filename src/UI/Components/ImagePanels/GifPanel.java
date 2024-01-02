package UI.Components.ImagePanels;

import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;

public class GifPanel extends JPanel {
    private String gifPath;
    private int x,y,width,height;
    
    public GifPanel(int x,int y,int width,int height,String source) {
        this.setBounds(x,y,width,height);
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        
        this.gifPath = source;
        this.setOpaque(false);
    }
    
    public void changeGifPath(String gifPath) {
        this.gifPath = gifPath;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (!gifPath.isEmpty()) {
            ImageIcon gifIcon = new ImageIcon(gifPath);
            Image image = gifIcon.getImage();
            
            // Scale the image to fit the panel
            int scaledWidth = width;
            int scaledHeight = (int) ((double) width / image.getWidth(this) * image.getHeight(this));
            
            if (scaledHeight > height) {
                scaledWidth = (int) ((double) height / image.getHeight(this) * image.getWidth(this));
                scaledHeight = height;
            }
            
            int x = (width - scaledWidth) / 2;
            int y = (height - scaledHeight) / 2;
            
            g.drawImage(image, x, y, scaledWidth, scaledHeight, this);
        }
    }
    
    public void ChangeLocationBy(int x,int y){
        this.x+=x;
        this.y+=y;
        this.setBounds(this.x,this.y,width,height);
        //this.getParent().repaint();
    }
    
    public void ChangeLocationTo(int x,int y){
        this.x=x;
        this.y=y;
        this.setBounds(this.x,this.y,width,height);
        //this.getParent().repaint();
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("GifPanel Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel pane= new JPanel();
            pane.setLayout(null);
            pane.setBounds(0,0,200,200);
            GifPanel gifPanel = new GifPanel(0, 0, 100, 100, AssetLoader.getAssetPath(AssetLoader.Gifs.HOURGLASS));
            
            frame.getContentPane().add(pane);
            pane.setBackground(Color.blue);
            
            
            pane.add(gifPanel);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
            
            
        });
    }
    
}