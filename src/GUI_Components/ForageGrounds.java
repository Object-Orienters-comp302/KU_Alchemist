package GUI_Components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import GUI_Components.ImagePanel;
import Utils.AssetLoader;

public class ForageGrounds extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    ImagePanel Card;
    JTextField textField;
    
    
    public ForageGrounds() {
        this.setSize(1000,500);
        setLayout(null);
        
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.Background));
        Card.setBounds(832,240 ,158, 250);
        this.add(Card);
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.Card));
        Background.setBounds(0,0 ,1000, 500);
        this.add(Background);
        
        textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setText("To forage press the card!! It costs 1 gold.");
        textField.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        textField.setBounds(228, 294, 554, 96);
        Background.add(textField);
        textField.setColumns(10);
        
        textField.setOpaque(false);
        
        Card.addMouseMotionListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //TODO Dummy Code
            }
        });
        
    }
    
}