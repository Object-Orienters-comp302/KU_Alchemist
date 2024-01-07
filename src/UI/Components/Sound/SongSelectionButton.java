package UI.Components.Sound;

import Sound.DJ;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Potion.IngredientButton;
import UI.Components.Potion.IngredientButtonPopup;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class SongSelectionButton extends JPanel {
    int number;
    DJ.BackgroundSounds song;
    
    public SongSelectionButton(int num, DJ.BackgroundSounds song, SoundButtonPopup sou){
        this.number=num;
        this.song=song;
        
        setOpaque(false);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                
                if (isClickInsideCircle(clickX, clickY)) {
                    DJ.getDJ().setAndStartBackgroundSound(song);
                    sou.parent.changeImage(AssetLoader.Sound.NOTEGOLD.getPath());
                    sou.continuePause.changeImage(AssetLoader.Sound.PAUSEGOLD.getPath());
                    sou.mute.changeImage(AssetLoader.Sound.NOTEGOLD.getPath());
                    SoundButtonPopup.muted=false;
                    SoundButtonPopup.paused=false;
                    
                
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int diameter = Math.min(getWidth(), getHeight());
        
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        g.setColor(new Color(90, 85, 112, 120));
        g.fillOval(x, y, diameter, diameter);
        
        // Draw the number in the center of the circle
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, diameter / 2);
        g.setFont(font);
        
        String numberStr = String.valueOf(number);
        FontMetrics metrics = g.getFontMetrics(font);
        int textX = x + (diameter - metrics.stringWidth(numberStr)) / 2;
        int textY = y + ((diameter - metrics.getHeight()) / 2) + metrics.getAscent();
        
        g.drawString(numberStr, textX, textY);
    }
    
    
    public boolean isClickInsideCircle(int pointX, int pointY) {
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        Ellipse2D circle = new Ellipse2D.Float(x, y, diameter, diameter);
        return circle.contains(pointX, pointY);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SongSelectionButton button = new SongSelectionButton(1, DJ.BackgroundSounds.TRACK1,null);
        frame.add(button);
        
        frame.setVisible(true);
        
        // Example of using isPointInsideCircle
        int mouseX = 100; // Replace with actual mouse coordinates
        int mouseY = 100; // Replace with actual mouse coordinates
        
        if (button.isClickInsideCircle(mouseX, mouseY)) {
            System.out.println("Mouse is inside the circle.");
        } else {
            System.out.println("Mouse is outside the circle.");
        }
    }
    
}
