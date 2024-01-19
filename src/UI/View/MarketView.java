package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Domain.RoundTwoController;
import Models.Artifact;
import Models.Player;
import Models.Potion;
import Networking.GameAction;
import Networking.GameClient;
import UI.Components.Artifacts.ArtifactCard;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.GifPanel;
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
        potionButton= new PotionButton(150,144,200,200);
        
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
        
        Background.add(potionButton);
        
        potionCard.setBounds(150, 100, 200, 289);
        Background.add(potionCard);
        
        
        sellPotionButton.setBounds(150,400,200,50);
        Background.add(sellPotionButton);
        sellPotionButton.setLayout(null);
        
        sellPotionLabel = new OutlinedLabel("SELL POTION","#a96148", "#be7a57", OutlinedLabel.Versions.MID_ORIENTED);
        sellPotionLabel.setBounds(0,0,200,50);
        sellPotionLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        sellPotionButton.add(sellPotionLabel);
        
        buyArtifactButton.setBounds(600, 400, 200, 50);
        Background.add(buyArtifactButton);
        buyArtifactButton.setLayout(null);
        buyArtifactLabel = new OutlinedLabel("BUY ARTIFACT","#a96148", "#be7a57", OutlinedLabel.Versions.MID_ORIENTED);
        buyArtifactLabel.setBounds(0,0,200,50);
        buyArtifactLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
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
                
                if(GameController.getInstance().getRound() > 1) {
                    if (potionButton.getCurrentPotionPath() != AssetLoader.TriangleTable.QUESTION_MARK) {
                        
                        sellPotion(potionButton.getType());
                    }
                }
            }
        });
        
    }
    
    private void sellPotion(Potion.IdentityTypes identityTypes){ //TODO:make it work with type
        if(GameController.getInstance().isOnline()){
            GameClient.getInstance().sendAction(new GameAction(GameAction.ActionType.SELL_POTION,"Sold Potion",identityTypes));
        }else{
            RoundTwoController roundTwoController = GameController.getInstance().getRoundTwoController();
            roundTwoController.sellPotion(identityTypes);
            potionButton.reset();
        }

        
    }
    private Artifact CardClicked(Player player) { //Calls Forage for Ingredient on controller then, returns its type for the function.
        return GameController.getInstance().getRoundOneController().BuyArtifacts(player);
    }
    
    private void artifactAnimation(Artifact artifact){
        if (arti!=null){
            Background.remove(arti);
            Background.repaint();
        }
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
    public void reset(){
        if (arti != null) {
            Background.remove(arti);
            Background.repaint();
            artifactCard.repaint();
        }
        potionButton.reset();
    }
}

