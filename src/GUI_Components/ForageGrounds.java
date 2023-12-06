package GUI_Components;

import Utils.AssetLoader;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForageGrounds extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    ImagePanel Card;
    
    public ForageGrounds() {
        this.setSize(1000, 500);
        setLayout(null);
        
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.Background));
        Card.setBounds(832, 240, 158, 250);
        this.add(Card);
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.Card));
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        
        Card.addMouseMotionListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //TODO Dummy Code
            }
        });
        
    }
    
}