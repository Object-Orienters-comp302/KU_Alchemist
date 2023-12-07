package UI.View;

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
public class ForageGroundsView extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    ImagePanel Card;
    JTextField textField;
    
    public ForageGroundsView() {

        
        this.setSize(1000,500);
        setLayout(null);
        
        Card = new ImagePanel("./Images/ForageGroundsAssets/ingredientCard.png");
        Card.setBounds(773, 223 ,158, 250);
        this.add(Card);
        
        Background = new ImagePanel("./Images/ForageGroundsAssets/forageGrounds.png");
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setEditable(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setText(Texts.Start.getText());
        textField.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        textField.setBounds(200, 10, 600, 32);
        Background.add(textField);
        textField.setColumns(10);
        
        textField.setOpaque(false);
        
        Card.addMouseMotionListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Ingredient.IngredientTypes ingredientType = CardClicked(Player.getCurrPlayer(), GameController.getInstance()
                        .getRoundOneController());
                if (ingredientType != null){
                    textField.setText(String.format(Texts.Success.getText(),ingredientType.getTypeString()));
                }
                else {
                    textField.setText(Texts.Fail.getText());
                }
            }
        });
        
        
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