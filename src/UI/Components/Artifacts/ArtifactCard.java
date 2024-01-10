package UI.Components.Artifacts;

import Domain.GameController;
import Models.Artifact;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.Components.SuperViews.ElexirOfInsightView;
import UI.View.LoginView;
import UI.View.MenuView;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ArtifactCard extends JPanel {
    
    ImagePanel cardBackground;
    ImagePanel artifactImage;
    OutlinedLabel nameLabel;
    OutlinedLabel description;
    Artifact artifact;
    ImagePanel image;
    
    public ArtifactCard(Artifact artifact) {
        this.artifact = artifact;
        
        setBackground(Color.decode("#8E8E8E"));
        setSize(200, 289); // Adjusted size
        
        setLayout(null);
        
        cardBackground = new ImagePanel(AssetLoader.Artifacts.CARD);
        cardBackground.setBounds(5, 5, 190, 279); // Adjusted bounds
        cardBackground.setLayout(null);
        add(cardBackground);
        
        artifactImage = new ImagePanel(AssetLoader.TriangleTable.QUESTION_MARK);
        artifactImage.addCorner(10);
        artifactImage.setBounds(15, 15, 160, 113); // Adjusted bounds
        cardBackground.add(artifactImage);
        
        nameLabel = new OutlinedLabel("TEST but bit longer", Color.WHITE, Color.BLUE);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setVerticalAlignment(JLabel.CENTER);
        nameLabel.setBounds(20, 138, 170, 25); // Adjusted bounds
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Adjusted font size
        cardBackground.add(nameLabel);
        
        description = new OutlinedLabel("TEST", Color.WHITE, Color.BLUE);
        description.setBounds(20, 168, 170, 110); // Adjusted bounds
        description.setForeground(Color.white);
        description.setFont(new Font("Arial", Font.BOLD, 16)); // Adjusted font size
        description.setHorizontalAlignment(JLabel.CENTER);
        description.setVerticalAlignment(JLabel.TOP);
        cardBackground.add(description);
        if (artifact.isUsed()){
            ImagePanel giantX= new ImagePanel(AssetLoader.Artifacts.GIANTX);
            giantX.setBounds(5, 5, 190, 279);
            cardBackground.add(giantX,0);
        }
        
        setTextAndImage(artifact.getName());
        if (!artifact.isUsed()&&GameController.getInstance().getMenuController().
                getCurrentPlayer().getInventory().checkArtifactExists(artifact.getName())) {
            setFunction(artifact.getName());
        }
    }
    
    
    public void setTextAndImage(Artifact.Name name){//TODO: complete descriptions
        switch (name){
            case Elixir_of_Insight -> {artifactImage.changeImage(AssetLoader.Artifacts.WISDOM);
                nameLabel.setText("Elixir of Insight");
                description.setText("Elixir of Insight gives you insight");}
            case Magic_Mortar -> {artifactImage.changeImage(AssetLoader.Artifacts.MORTAR);
                nameLabel.setText("Magic Mortar");
                description.setText("Fill");}
            case Printing_Press -> {artifactImage.changeImage(AssetLoader.Artifacts.PRESS);
                nameLabel.setText("Printing Press");
                description.setText("Fill");}
            case Wisdom_Idol -> {artifactImage.changeImage(AssetLoader.Artifacts.IDOL);
                nameLabel.setText("Wisdom Idol");
                description.setText("Fill");}
        }
    
    }
    public void setFunction(Artifact.Name name){
        switch (name){
            case Elixir_of_Insight -> {
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ElixirOfInsightFunction();
                    }});
            }
        }
    }
    
    
    public void ElixirOfInsightFunction(){
        MenuView menu= GameController.getInstance().getMenuController().getMenuView();
        menu.Blockade();
        artifact.gotUsed();
        menu.addAndRunPage(new ElexirOfInsightView());
        
    }
    
    public static void main(String[] args) { // TODO: Move to UnitTests
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1294, 757);
        frame.getContentPane().setLayout(null);
        
        Artifact art1 = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        ArtifactCard card1 = new ArtifactCard(art1);
        card1.setLocation(10,20);
        frame.getContentPane().add(card1);
        
        Artifact art2 = new Artifact(Artifact.Name.Magic_Mortar, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        ArtifactCard card2 = new ArtifactCard(art2);
        card2.setLocation(290,20);
        frame.getContentPane().add(card2);
        
        Artifact art3 = new Artifact(Artifact.Name.Printing_Press, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        ArtifactCard card3 = new ArtifactCard(art3);
        card3.setLocation(570,20);
        frame.getContentPane().add(card3);
        
        Artifact art4 = new Artifact(Artifact.Name.Wisdom_Idol, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        ArtifactCard card4 = new ArtifactCard(art4);
        card4.setLocation(850,20);
        frame.getContentPane().add(card4);
        
        frame.setVisible(true);
    }
    
}
