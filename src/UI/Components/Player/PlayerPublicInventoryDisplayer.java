package UI.Components.Player;

import Domain.GameController;
import Models.Artifact;
import Models.Player;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

public class PlayerPublicInventoryDisplayer extends ImagePanel {
    Player player;
    
    public PlayerPublicInventoryDisplayer(Player player){
        super(AssetLoader.Backgrounds.INVENTORY);
        this.player=player;
        setBounds(0,0,1000,500);
        setLayout(null);
        
    }
    
    /*
    public void addArtifacts(){
        for(Artifact art: player.getInventory().getArtifacts()){
        
        }
    }
    
     */
    
}
