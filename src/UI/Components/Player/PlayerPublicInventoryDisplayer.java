package UI.Components.Player;

import Domain.GameController;
import Models.Artifact;
import Models.Player;
import UI.Components.Artifacts.ArtifactCard;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;

public class PlayerPublicInventoryDisplayer extends ImagePanel {
    Player player;
    
    public PlayerPublicInventoryDisplayer(Player player){
        super(AssetLoader.Backgrounds.INVENTORY);
        this.player=player;
        setBounds(0,0,1000,500);
        setLayout(null);
        addArtifacts();
    }
    
    
    public void addArtifacts(){
        int i=0;
        for(Artifact art: player.getInventory().getArtifacts()){
            ArtifactCard card = new ArtifactCard(art);
            card.setLocation(80+i*220,50);
            add(card);
            i++;
        
        }
    }
    
    
    
    
    public static void main(String[] args) { // TODO: Move to UnitTests
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1294, 757);
        frame.getContentPane().setLayout(null);
        
        Player play = new Player("sexy joe",null);
        
        
        Artifact art1 = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        
        
        Artifact art2 = new Artifact(Artifact.Name.Magic_Mortar, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        
        
        Artifact art3 = new Artifact(Artifact.Name.Printing_Press, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);

        
        Artifact art4 = new Artifact(Artifact.Name.Wisdom_Idol, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        
        
        play.getInventory().addArtifactCard(art1);
        play.getInventory().addArtifactCard(art2);
        play.getInventory().addArtifactCard(art3);
        play.getInventory().addArtifactCard(art4);
        
        PlayerPublicInventoryDisplayer dis = new PlayerPublicInventoryDisplayer(play);
        dis.setLocation(20,20);
        frame.getContentPane().add(dis);
        frame.setVisible(true);
    }
    
    
    
}
