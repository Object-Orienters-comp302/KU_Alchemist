package UI.Components.Artifacts;


import Domain.RoundOneController;
import Models.Ingredient;
import Models.Player;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;

public class ArtifactMarketplace extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    private ImagePanel Card1;
    private ImagePanel Card2;
    private ImagePanel Card3;
    
    public ArtifactMarketplace() {
        
        
        this.setSize(1000, 500);
        setLayout(null);
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.GREEN));
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        Card1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Artifacts.CARD));
        Card1.setBounds(150, 125, 150, 250);
        Background.add(Card1);
        
        Card2 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Artifacts.CARD));
        Card2.setBounds(375, 125, 150, 250);
        Background.add(Card2);
        
        Card3 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Artifacts.CARD));
        Card3.setBounds(600, 125, 150, 250);
        Background.add(Card3);
        
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane().setLayout(null);
        ArtifactMarketplace login = new ArtifactMarketplace();
        frame.getContentPane().add(login);
        frame.setVisible(true);
        
        
    }
    
    private Ingredient.IngredientTypes CardClicked(Player player,
                                                   RoundOneController roundOneController) { //Calls Forage for Ingredient on controller then, returns its type for the function.
        Ingredient ingredient = roundOneController.ForageForIngredient(player);
        if (ingredient != null) {
            return ingredient.getType();
        } else {
            return null;
        }
    }
    
    
    private enum Texts {
        Start("To forage press the card!! It costs 1 gold."),
        Success("Foraging successful!! Spent 1 gold. Ingredient:%s"),
        Fail("Foraging is not successful!!Need more gold.");
        
        private final String Text;
        
        Texts(String text) {
            Text = text;
        }
        
        public String getText() {
            return Text;
        }
    }
    
}