package Models;

import java.awt.*;
import java.util.ArrayList;


public class Player {
    
    private static ArrayList<Player> instances = new ArrayList<>();
    String    PlayerID;
    Image     Avatar;
    Inventory PlayerInventory;
    
    Integer PlayerScore;
    Integer Reputation;
    
    Integer Sickness;
    
    public Player (String PlayerID, Image Avatar) {// ToDo: Delete this. It is only to support gorkemsPackage
        this.PlayerID        = PlayerID;
        this.Avatar          = Avatar;
        this.PlayerInventory = new Inventory();
        this.PlayerScore     = 0;
        this.Sickness        = 0;
        this.Reputation      = 0;
        instances.add(this);
    }
    
    public Player (String PlayerID, Image Avatar, Integer StartingGold) {
        this.PlayerID        = PlayerID;
        this.Avatar          = Avatar;
        this.PlayerInventory = new Inventory();
        this.PlayerScore     = 0;
        this.Sickness        = 0;
        this.Reputation      = 0;
        
        instances.add(this);
    }
    
    
    public static ArrayList<Player> getInstances () {
        return instances;
    }
    
    public String getPlayerID () {
        return PlayerID;
    }
    
    public Image getAvatar () {
        return Avatar;
    }
    
    public Inventory getPlayerInventory () {
        return PlayerInventory;
    }
    
    public Integer getReputation () {
        return Reputation;
    }
    
    public void setReputation (Integer reputation) {
        Reputation = reputation;
    }
    public void addReputation (Integer num){
        this.Reputation = this.Reputation + num;
    }
    public Integer getSickness () {
        return Sickness;
    }
    
    public void setSickness (Integer sickness) {
        Sickness = sickness;
    }
    public void getSurgery(){
        getPlayerInventory().setGold(0);
        setSickness(0);
    }
}
