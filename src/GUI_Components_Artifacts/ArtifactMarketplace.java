package GUI_Components_Artifacts;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Domain.GameController;
import Domain.RoundOneController;
import GUI_Components.ImagePanel;
import Models.Ingredient;
import Models.Player;
import Utils.AssetLoader;
public class ArtifactMarketplace extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    JTextField txtJesusLovesYou;
    private ImagePanel Card1;
    private ImagePanel Card2;
    private ImagePanel Card3;
    
    public ArtifactMarketplace() {

        
        this.setSize(1000,500);
        setLayout(null);
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.Background));
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        txtJesusLovesYou = new JTextField();
        txtJesusLovesYou.setForeground(Color.BLACK);
        txtJesusLovesYou.setEditable(false);
        txtJesusLovesYou.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtJesusLovesYou.setText("JESUS LOVES YOU");
        txtJesusLovesYou.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        txtJesusLovesYou.setBounds(200, 10, 600, 32);
        Background.add(txtJesusLovesYou);
        txtJesusLovesYou.setColumns(10);
        
        txtJesusLovesYou.setOpaque(false);
        
        Card1 = new ImagePanel("Images/ForageGroundsAssets/ingredientCard.png");
        Card1.setBounds(150, 125, 150, 250);
        Background.add(Card1);
        
        Card2 = new ImagePanel("Images/ForageGroundsAssets/ingredientCard.png");
        Card2.setBounds(375, 125, 150, 250);
        Background.add(Card2);
        
        Card3 = new ImagePanel("Images/ForageGroundsAssets/ingredientCard.png");
        Card3.setBounds(600, 125, 150, 250);
        Background.add(Card3);
        
        
    }
    
    private enum Texts{
        Start("To forage press the card!! It costs 1 gold."),
        Success("Foraging successful!! Spent 1 gold. Ingredient:%s"),
        Fail("Foraging is not successful!!Need more gold.");
        
        private final String Text;
        
        Texts (String text) {
            Text = text;
        }
        
        public String getText () {
            return Text;
        }
    }
    private Ingredient.IngredientTypes CardClicked (Player player, RoundOneController roundOneController){ //Calls Forage for Ingredient on controller then, returns its type for the function.
        Ingredient ingredient = roundOneController.ForageForIngredient(player);
        if(ingredient != null){
            return ingredient.getType();
        }
        else{
            return null;
        }
    }
    
}