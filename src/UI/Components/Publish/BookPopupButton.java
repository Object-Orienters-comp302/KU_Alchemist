package UI.Components.Publish;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookPopupButton extends JPanel {
    private int diameter, x, y;
    private ImagePanel img;
    
    public BookPopupButton(int x, int y, int width, int height, AssetLoader.AssetPath imgPath, ImagePanel panelToChange,
                           BookButton book) {
        
        setLayout(null);
        this.setBounds(x - width / 2, y - height / 2, width, height);
        
        img = new ImagePanel(AssetLoader.getAssetPath(imgPath));
        img.setBounds(width / 10, width / 10, width*4 / 5, height*4 / 5);
        add(img);
        this.setOpaque(false);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!BookPanel.traitUsed.contains(imgPath) || imgPath == AssetLoader.TriangleTable.QUESTION_MARK) {
                    int clickX = e.getX();
                    int clickY = e.getY();
                    Container parent = BookPopupButton.this.getParent();
                    Container grandParent = parent.getParent();
                    
                    if (isClickInsideCircle(clickX, clickY)) {
                        
                        BookPanel.traitUsed.remove(book.getCurrentPath());
                        panelToChange.changeImage(AssetLoader.getAssetPath(imgPath));
                        book.setCurrentPath(imgPath);
                        BookPanel.traitUsed.add(imgPath);
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
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane().setLayout(null);
        
        
        //frame.getContentPane()
        //      .add(login);
        frame.setVisible(true);
        
        
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
