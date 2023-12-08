package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Models.Ingredient;
import Models.Player;
import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForageGroundsView extends JPanel {
    
    ImagePanel Background;
    ImagePanel Card;
    JTextField textField;
    
    public ForageGroundsView() {
        
        
        this.setSize(1000, 500);
        setLayout(null);
        
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
        Card.setBounds(773, 223, 158, 250);
        this.add(Card);
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.BACKGROUND));
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setEditable(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setText(Texts.Start.getText());
        textField.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        textField.setBounds(200, 10, 900, 32);
        Background.add(textField);
        textField.setColumns(10);
        
        textField.setOpaque(false);
        
        
        Card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ingredient.IngredientTypes ingredientType =
                        CardClicked(Player.getCurrPlayer(), GameController.getInstance().getRoundOneController());
                if (ingredientType != null) {
                    textField.setText(String.format(Texts.Success.getText(), ingredientType.getTypeString()));
                } else {
                    textField.setText(Texts.Fail.getText());
                }
                
            }
        });
        
        
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
        Start("To forage press the card!! It costs 1 forage right."),
        Success("Foraging successful!! Ingredient:%s"),
        Fail("Foraging is not successful!!You can't forage more.");
        
        private final String Text;
        
        Texts(String text) {
            Text = text;
        }
        
        public String getText() {
            return Text;
        }
    }
    
}