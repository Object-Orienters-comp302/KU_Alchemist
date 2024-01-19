package UI.Components.Artifacts;

import Domain.GameController;
import Models.Artifact;
import Models.Deck;
import Networking.GameAction;
import Networking.GameClient;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.Components.SuperViews.ArtifactTargetSelectorView;
import UI.Components.SuperViews.ElixirOfInsightView;
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
        
        nameLabel = new OutlinedLabel("TEST but bit longer", "#a57c00", "#C0C0C0", OutlinedLabel.Versions.MID_ORIENTED);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setVerticalAlignment(JLabel.CENTER);
        nameLabel.setBounds(5, 138, 180, 30); // Adjusted bounds
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cardBackground.add(nameLabel);
        
        description = new OutlinedLabel("TEST", Color.WHITE, Color.BLUE);
        description.setBounds(5, 175, 180, 100); // Adjusted bounds
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
                description.setText("Elixir of Insight allows you to view and change first three cards from the ingredients deck");}
            case Magic_Mortar -> {artifactImage.changeImage(AssetLoader.Artifacts.MORTAR);
                nameLabel.setText("Magic Mortar");
                description.setText("Magic Mortar allows you to recover one of the ingredients you use during potion brewing");}
            case Printing_Press -> {artifactImage.changeImage(AssetLoader.Artifacts.PRESS);
                nameLabel.setText("Printing Press");
                description.setText("Printing Press allows you to publish your theories free of charge");}
            case Wisdom_Idol -> {artifactImage.changeImage(AssetLoader.Artifacts.IDOL);
                nameLabel.setText("Wisdom Idol");
                description.setText("Wisdom Idol allows you to not lose any reputation points even if your theory has been proven to be wrong");}
            case Pistol_of_Sickness_Classic -> {
                artifactImage.changeImage(AssetLoader.Artifacts.GUNCLASSIC);
                nameLabel.setText("Pistol of Sickness");
                description.setText("Increase sickness level of your target by 1");
            }
            case Pistol_of_Sickness_Silver -> {
                artifactImage.changeImage(AssetLoader.Artifacts.GUNSILVER);
                nameLabel.setText("Silver Pistol of Sickness");
                description.setText("Increase sickness level of your target by 1");
            }
            case Pistol_of_Sickness_Gold -> {
                artifactImage.changeImage(AssetLoader.Artifacts.GUNGOLD);
                nameLabel.setText("Golden Pistol of Sickness");
                description.setText("Increase sickness level of your target by 2");
            }
            case Letter_of_DissContent_Red -> {
                artifactImage.changeImage(AssetLoader.Artifacts.LETTERRED);
                nameLabel.setText("Red Letter of DissContent");
                description.setText("Tarnish reputation of your target by 1");
            }
            case Letter_of_DissContent_Blue -> {
                artifactImage.changeImage(AssetLoader.Artifacts.LETTERBLUE);
                nameLabel.setText("Blue Letter of DissContent");
                description.setText("Tarnish reputation of your target by 1");
            }
            case Inquisition_Accusation -> {
                artifactImage.changeImage(AssetLoader.Artifacts.INQUISITION);
                nameLabel.setText("Accusation to Inquisition");
                description.setText("Tarnish reputation of your target by 2");
            }
            case Chair_of_Alchemy -> {
                artifactImage.changeImage(AssetLoader.Artifacts.CHAIR);
                nameLabel.setText("Chair of Alchemy");
                description.setText("Due to chair diff you gain 1 reputation");
            }
            case Syringe_Kit_Basic1 -> {
                artifactImage.changeImage(AssetLoader.Artifacts.SYRINGE1);
                nameLabel.setText("Syringe Kit");
                description.setText("Heals you by 1");
            }
            case Syringe_Kit_Basic2 -> {
                artifactImage.changeImage(AssetLoader.Artifacts.SYRINGE2);
                nameLabel.setText("Syringe Kit");
                description.setText("Heals you by 1");
            }
            case Elixir_of_Healing -> {
                artifactImage.changeImage(AssetLoader.Artifacts.HEALTHELIXIR);
                nameLabel.setText("Elixir of Healing");
                description.setText("Heals you by 2");
            }
            case Big_Black_Chicken -> {
                artifactImage.changeImage(AssetLoader.Artifacts.CHICKEN);
                nameLabel.setText("Big Black Chicken");
                description.setText("You send your Big Black Chicken to forage and it brings you back 2 of feathers and chicken leg");
            }
            case Magical_Boar -> {
                artifactImage.changeImage(AssetLoader.Artifacts.BOAR);
                nameLabel.setText("Magical Boar");
                description.setText("You send your Magical Boar to forage and it brings you back 2 of flower and plant");
            }
            case Hunting_Phoenix -> {
                artifactImage.changeImage(AssetLoader.Artifacts.PHOENIX);
                nameLabel.setText("Hunting Phoenix");
                description.setText("You send your Hunting Phoenix to hunt and it brings you back 2 of toad and scorpion");
            }
            case Mystic_Meerkat -> {
                artifactImage.changeImage(AssetLoader.Artifacts.MEERKAT);
                nameLabel.setText("Mystic Meerkat");
                description.setText("You send your Mystic Meerkat to forage and it brings you back 2 of mandrake and mushroom");
            }
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
            case Pistol_of_Sickness_Classic ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        PistolofSicknessFunction(Artifact.Name.Pistol_of_Sickness_Classic);
                    }});
            }
            case Pistol_of_Sickness_Silver ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        PistolofSicknessFunction(Artifact.Name.Pistol_of_Sickness_Silver);
                    }});
            }
            case Pistol_of_Sickness_Gold ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        PistolofSicknessFunction(Artifact.Name.Pistol_of_Sickness_Gold);
                    }});
            }
            case Letter_of_DissContent_Red ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ReputationAttackFunction(Artifact.Name.Letter_of_DissContent_Red);
                    }});
            }
            case Letter_of_DissContent_Blue ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ReputationAttackFunction(Artifact.Name.Letter_of_DissContent_Blue);
                    }});
            }
            case Inquisition_Accusation ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ReputationAttackFunction(Artifact.Name.Inquisition_Accusation);
                    }});
            }
            case Chair_of_Alchemy ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactReputationAbility(GameController.getInstance().getMenuController().getCurrentPlayer(),10);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Chair_of_Alchemy);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            case Syringe_Kit_Basic1 ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactHealingAbility(1);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Syringe_Kit_Basic1);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            case Syringe_Kit_Basic2 ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactHealingAbility(1);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Syringe_Kit_Basic2);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            case Elixir_of_Healing ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactHealingAbility(1);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Elixir_of_Healing);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            case Magical_Boar ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactGatheringAbility(
                                Artifact.Name.Magical_Boar);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Magical_Boar);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            case Hunting_Phoenix ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactGatheringAbility(
                                Artifact.Name.Hunting_Phoenix);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Hunting_Phoenix);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            case Mystic_Meerkat ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactGatheringAbility(
                                Artifact.Name.Mystic_Meerkat);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Mystic_Meerkat);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            case Big_Black_Chicken ->{
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameController.getInstance().getRoundOneController().ArtifactGatheringAbility(
                                Artifact.Name.Big_Black_Chicken);
                        GameController.getInstance().getRoundOneController().ArtifactGotUsed(
                                Artifact.Name.Big_Black_Chicken);
                        GameController.getInstance().getMenuController().getMenuView().reset();
                    }});
            }
            
        }
    }
    
    
    public void ElixirOfInsightFunction(){
        
        if(GameController.getInstance().isOnline()) {
            GameClient.getInstance().sendAction(new GameAction(GameAction.ActionType.ELIXIR_REQUEST,"ELIXIR_REQUEST"));
            
        }else{
            
            MenuView menu = GameController.getInstance().getMenuController().getMenuView();
            menu.Blockade();
            GameController.getInstance().getRoundOneController().ArtifactGotUsed(Artifact.Name.Elixir_of_Insight);
            menu.addAndRunPage(new ElixirOfInsightView());
        }
    }
    public void PistolofSicknessFunction(Artifact.Name name){
        MenuView menu= GameController.getInstance().getMenuController().getMenuView();
        menu.Blockade();
        GameController.getInstance().getRoundOneController().ArtifactGotUsed(name);
        menu.addAndRunPage(new ArtifactTargetSelectorView(name));
    }
    public void ReputationAttackFunction(Artifact.Name name){
        MenuView menu= GameController.getInstance().getMenuController().getMenuView();
        menu.Blockade();
        GameController.getInstance().getRoundOneController().ArtifactGotUsed(name);
        menu.addAndRunPage(new ArtifactTargetSelectorView(name));
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
