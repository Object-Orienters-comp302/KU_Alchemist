package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Domain.RoundTwoController;
import Models.Player;
import Models.Potion;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Potion.IngredientButton;
import UI.Components.Potion.PotionButton;
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
    ImagePanel         Card_1;
    ColorChangingPanel transmuteIngredient;
    ColorChangingPanel sellPotion;
    
    PotionButton B2;
    
    public TransmuteView() {
        this.setSize(1000, 500);
        setLayout(null);
        
        
        B1 = new IngredientButton(425, 175, 150, 150, true);
        this.add(B1);
        
        
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
        Card.setBounds(421, 125, 158, 250);
        this.add(Card);
        
        B2 = new PotionButton(200, 175, 150, 150, true);
        this.add(B2);
        
        
        Card_1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
        Card_1.setBounds(200, 125, 158, 250);
        this.add(Card_1);
        
        
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
        
        
        sellPotion = new ColorChangingPanel("#cf9d15", "#FFD700");
        sellPotion.setBounds(600, 400, 120, 40);
        sellPotion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                RoundTwoController roundTwoController = GameController.getInstance().getRoundTwoController();
                Models.Potion.Identity identity = B2.getType();
                roundTwoController.sellPotion(Player.getCurrPlayer().getInventory(), Potion.deIdentify(identity),
                                              RoundTwoController.Guarantee.POSITIVE);
            }
        });
        this.add(sellPotion);
        sellPotion.setLayout(null);
        JLabel sellPotionLbl = new JLabel("Sell Potion");
        sellPotionLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        sellPotionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        sellPotionLbl.setBounds(0, 0, 120, 40);
        sellPotion.add(sellPotionLbl);
        
        
        
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
