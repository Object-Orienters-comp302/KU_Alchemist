package UI.Components.Publish;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BookButton extends JPanel {
    public static ArrayList<Integer> taken = new ArrayList<Integer>();
    ImagePanel img;
    private int                   diameter;
    private int                   x;
    private int                   y;
    private AssetLoader.AssetPath currentPath;
    
    public BookButton(int x, int y, int width, int height, AssetLoader.AssetPath path) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        currentPath = BookPanel.traitUsed.contains(path) ? path : AssetLoader.TriangleTable.QUESTION_MARK;
        img         = new ImagePanel(AssetLoader.getAssetPath(currentPath));
        img.setBounds(width * 9 / 40, width * 9 / 40, width * 9 / 16, height * 9 / 16);
        add(img);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();
                
                if (isClickInsideCircle(clickX, clickY) && !BookPanel.published.get(path)) {
                    System.out.println("Button click inside the circle!");
                    BookButtonPopup pop = new BookButtonPopup(x - width / 2, y - height / 2, width * 2, height * 2, img,
                                                              BookButton.this);
                    //how to make it add to it
                    Container parent = getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop, 0);
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
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
        int customDiameter = originalDiameter * 3 / 4;
        
        int x = (getWidth() - customDiameter) / 2;
        int y = (getHeight() - customDiameter) / 2;
        diameter = originalDiameter;
        
        g.setColor(Color.decode("#ebd2a9"));
        g.fillOval(x, y, customDiameter, customDiameter);
    }
    
    public AssetLoader.AssetPath getCurrentPath() {
        return currentPath;
    }
    
    public void setCurrentPath(AssetLoader.AssetPath val) {
        currentPath = val;
        img.changeImage(val);
        repaint();
    }
    
    public void disable(){
        MouseListener[] mouseListeners = getMouseListeners();
        for (MouseListener listener : mouseListeners) {
            removeMouseListener(listener);
        }
    }
    
}
