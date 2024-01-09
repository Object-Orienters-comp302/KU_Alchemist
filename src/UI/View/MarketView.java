package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Domain.RoundTwoController;
import Models.Artifact;
import Models.Player;
import Models.Potion;
import UI.Components.Artifacts.ArtifactCard;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.Components.Potion.PotionButton;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MarketView extends JPanel {
    ImagePanel Background;
    ImagePanel artifactCard,potionCard;
    
    PotionButton potionButton;
    JTextField textField;
    
    ColorChangingPanel sellPotionButton,buyArtifactButton;
    OutlinedLabel sellPotionLabel,buyArtifactLabel;
    
    ArtifactCard arti;
    
    MarketView(){
        this.setSize(1000, 500);
        setLayout(null);
        
        CreateObjects();
        SetupObjects();
        SetupListeners();
        
    }
    private void CreateObjects() {
        artifactCard = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Artifacts.CARD));
        Background   = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.BACKGROUND));
        textField = new JTextField();
        potionCard = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
        potionButton= new PotionButton(225,175,100,100);
        
        sellPotionButton = new ColorChangingPanel("#aaaaaa", "#cccccc",
                                                  20, ColorChangingPanel.RoundingStyle.BOTH);
        buyArtifactButton = new ColorChangingPanel("#aaaaaa", "#cccccc",
                                                  20, ColorChangingPanel.RoundingStyle.BOTH);
    }
    
    private void SetupObjects() {
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        artifactCard.setBounds(600, 100, 200, 289);
        Background.add(artifactCard);
        
        potionCard.setBounds(150, 100, 200, 289);
        Background.add(potionCard);
        Background.add(potionButton);
        
        sellPotionButton.setBounds(150,400,200,50);
        Background.add(sellPotionButton);
        sellPotionButton.setLayout(null);
        
        sellPotionLabel = new OutlinedLabel("SELL POTION","#a96148", "#be7a57", OutlinedLabel.Versions.MID_ORIENTED);
        sellPotionLabel.setBounds(0,0,150,50);
        sellPotionButton.add(sellPotionLabel);
        
        buyArtifactButton.setBounds(600, 400, 200, 50);
        Background.add(buyArtifactButton);
        buyArtifactButton.setLayout(null);
        buyArtifactLabel = new OutlinedLabel("BUY ARTIFACT","#a96148", "#be7a57", OutlinedLabel.Versions.MID_ORIENTED);
        buyArtifactLabel.setBounds(0,0,150,50);
        buyArtifactButton.add(buyArtifactLabel);
        
        
        textField.setForeground(Color.BLACK);
        textField.setEditable(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setText(MarketView.Texts.Start.getText());
        textField.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        textField.setBounds(200, 10, 900, 32);
        Background.add(textField);
        textField.setColumns(10);
        textField.setOpaque(false);

    }
    
    private void SetupListeners() {
        
        buyArtifactButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Artifact artifact =
                        CardClicked(Player.getCurrPlayer());
                if (artifact != null) {
                    textField.setText(String.format(MarketView.Texts.Success.getText(), artifact.getName()));
                    artifactAnimation(artifact);
                } else {
                    textField.setText(MarketView.Texts.Fail.getText());
                }
                
            }
        });
        
        sellPotionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (potionButton.getCurrentPotionPath()!=AssetLoader.TriangleTable.QUESTION_MARK){
                
                }
            }
        });
        
    }
    
    private void sellPotion(Potion pot){ //TODO:make it work with type
        GameController game=GameController.getInstance();
        Player curr= game.getMenuController().getCurrentPlayer();
        game.getRoundTwoController().sellPotion(curr.getInventory(),pot);
        potionButton.reset();
    }
    private Artifact CardClicked(Player player) { //Calls Forage for Ingredient on controller then, returns its type for the function.
        return GameController.getInstance().getRoundOneController().BuyArtifacts(player);
    }
    
    private void artifactAnimation(Artifact artifact){
        arti = new ArtifactCard(artifact);
        arti.setLocation(artifactCard.getLocation());
        Background.add(arti);
        Background.setComponentZOrder(arti,0);
        Background.repaint();
        
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

