package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Models.Player;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanel;
import UI.Components.Potion.IngredientButton;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransmuteView extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel         Background;
    IngredientButton   B1;
    ImagePanel         Card;
    ColorChangingPanel transmuteIngredient;
    
    public TransmuteView() {
        this.setSize(1000, 500);
        setLayout(null);
        
        
        B1 = new IngredientButton(425, 175, 150, 150, true);
        this.add(B1);
        
        
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.Card));
        Card.setBounds(421, 125, 158, 250);
        this.add(Card);
        
        
        transmuteIngredient = new ColorChangingPanel("#cf9d15", "#FFD700");
        transmuteIngredient.setBounds(830, 400, 120, 40);
        transmuteIngredient.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
                roundOneController.TransmuteIngredient(Player.getCurrPlayer(), B1.getType());
            }
        });
        this.add(transmuteIngredient);
        transmuteIngredient.setLayout(null);
        JLabel transmuteIngredientLbl = new JLabel("Transmute");
        transmuteIngredientLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        transmuteIngredientLbl.setHorizontalAlignment(SwingConstants.CENTER);
        transmuteIngredientLbl.setBounds(0, 0, 120, 40);
        transmuteIngredient.add(transmuteIngredientLbl);
        
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.TRANSMUTE_BACKGROUND));
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020, 520);
        frame.getContentPane().add(new TransmuteView());
        frame.setVisible(true);
    }
}
