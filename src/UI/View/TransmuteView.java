package UI.View;

import javax.swing.JPanel;

import Domain.GameController;
import Domain.RoundOneController;
import GUI_Components.ColorChangingPanel;
import GUI_Components.HQImagePanel;
import GUI_Components.ImagePanel;
import GUI_Components_Potion.IngredientButton;
import Models.Ingredient;
import Models.Inventory;
import Models.Player;
import Models.Potion;
import UI.GamePage;
import Utils.AssetLoader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TransmuteView extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    IngredientButton B1;
    ImagePanel   Card;
    ColorChangingPanel transmuteIngredient;
    
    public TransmuteView() {
        this.setSize(1000,500);
        setLayout(null);
        
        
        B1= new IngredientButton(425 ,175,150,150,true);
        this.add(B1);
        
        
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.Card));
        Card.setBounds(421, 125 ,158, 250);
        this.add(Card);
        
        
        transmuteIngredient = new ColorChangingPanel("#cf9d15", "#FFD700");
        transmuteIngredient.setBounds(830, 400, 120, 40);
        transmuteIngredient.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
                roundOneController.TransmuteIngredient(Player.getCurrPlayer(),B1.getType());
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
        Background.setBounds(0,0,1000,500);
        this.add(Background);
        Background.setLayout(null);
        

        

        
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020,520);
        frame.getContentPane().add(new TransmuteView());
        frame.setVisible(true);
    }
}
