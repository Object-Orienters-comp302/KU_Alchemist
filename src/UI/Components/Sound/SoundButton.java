package UI.Components.Sound;

import Sound.DJ;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Potion.IngredientButton;
import UI.Components.Potion.IngredientButtonPopup;
import UI.Components.RoundedPanel;
import UI.View.LoginView;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SoundButton extends ImagePanel {
    
    int x,y,size;
    
    public SoundButton(int x, int y, int size) {
        super(AssetLoader.getAssetPath(AssetLoader.Sound.NOTEGOLD));
        setBounds(x,y,size,size);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                
                if (true) {//clicked inside does not work
                    //System.out.println("Button click inside the circle!");
                    SoundButtonPopup pop =
                            new SoundButtonPopup(x , y, size,SoundButton.this);
                    Container parent = getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop, 0);
                    parent.setComponentZOrder(SoundButton.this, 1);
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
    
    }
    
    
    
    
    private boolean isClickInsideCircle(int clickX, int clickY) {
        int radius = size / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        
        return distance <= radius;
    }
    
    public static void main(String[] args) { // TODO: Move to UnitTests
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1294, 757);
        frame.getContentPane().setLayout(null);
        JPanel login = new SoundButton(10,10,500);
        ImagePanel im = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Sound.NOTEGREEN));
        
        im.setBounds(500,500,50,50);
        
        RoundedPanel ro = new RoundedPanel(50);
        ro.setBackground(Color.red);
        ro.setBounds(0,0,50,100);
        frame.getContentPane().add(im);
        frame.getContentPane().add(login);
        frame.getContentPane().add(ro);
        frame.setVisible(true);
    }
}
