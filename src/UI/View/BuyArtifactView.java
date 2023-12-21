package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Models.Artifact;
import Models.Ingredient;
import Models.Player;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuyArtifactView extends JPanel {
    ImagePanel Background;
    ImagePanel Card;
    JTextField textField;
    
    
    BuyArtifactView(){
        this.setSize(1000, 500);
        setLayout(null);
        
        CreateObjects();
        SetupObjects();
        SetupListeners();
        
    }
    private void CreateObjects() {
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.BACKGROUND));
        textField = new JTextField();
        
        
    }
    
    private void SetupObjects() {
        Card.setBounds(773, 223, 158, 250);
        this.add(Card);
        
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        textField.setForeground(Color.BLACK);
        textField.setEditable(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setText(BuyArtifactView.Texts.Start.getText());
        textField.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        textField.setBounds(200, 10, 900, 32);
        Background.add(textField);
        textField.setColumns(10);
        textField.setOpaque(false);

    }
    
    private void SetupListeners() {
        
        Card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Artifact artifact =
                        CardClicked(Player.getCurrPlayer(), GameController.getInstance().getRoundOneController());
                if (artifact != null) {
                    textField.setText(String.format(BuyArtifactView.Texts.Success.getText(), artifact.getName()));
                } else {
                    textField.setText(BuyArtifactView.Texts.Fail.getText());
                }
                
            }
        });
        
    }
    
    private Artifact CardClicked(Player player,
                                                   RoundOneController roundOneController) { //Calls Forage for Ingredient on controller then, returns its type for the function.
        return roundOneController.BuyArtifacts(player);
    }
    
    private enum Texts {
        Start("To buy artifact press the card! It costs 3 golds"),
        Success("Artifact bought successfully!! Artifact:%s"),
        Fail("You don't have enough gold.");//It will fail as long as the artifact deck is empty.
        
        private final String Text;
        
        Texts(String text) {
            Text = text;
        }
        
        public String getText() {
            return Text;
        }
    }
}

