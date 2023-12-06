package Models;

import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;

import java.awt.*;
import java.util.ArrayList;


public class Player implements Publisher {
    
    private static ArrayList<Player> instances = new ArrayList<>();
    String    PlayerID;
    Image     Avatar;
    Inventory PlayerInventory;
    
    Integer PlayerScore;
    Integer Reputation;
    Integer Sickness;
    
    private ArrayList<Listener> listeners;
    
    public Player (String PlayerID, Image Avatar) {// ToDo: Delete this. It is only to support gorkemsPackage
        this.PlayerID        = PlayerID;
        this.Avatar          = Avatar;
        this.PlayerInventory = new Inventory();
        this.PlayerScore     = 0;
        Reputation           = 0;
        this.Sickness        = 0;
        instances.add(this);
    }
    
    public Player (String PlayerID, Image Avatar, Integer StartingGold) {
        this.PlayerID        = PlayerID;
        this.Avatar          = Avatar;
        this.PlayerInventory = new Inventory();
        this.PlayerScore     = 0;
        this.Sickness        = 0;
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
    
    public Integer getReputation () {
        return Reputation;
    }
    
    public void setReputation (Integer reputation) {
        Reputation = reputation;
        publishEvent(Type.REPUTATION);
    }
    
    @Override
    public void publishEvent (Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    @Override
    public void addListener (Listener lis) {
        listeners.add(lis);
    }
    public void addReputation (Integer num){
        this.Reputation = this.Reputation + num;
    }
    public Integer getSickness () {
        return Sickness;
    }
    
    public void setSickness (Integer sickness) {
        Sickness = sickness;
        publishEvent(Type.SICKNESS);
    }
    
    public void getSurgery () {
        getPlayerInventory().setGold(0);
        setSickness(0);
    }
    
    public Inventory getPlayerInventory () {
        return PlayerInventory;
    }
}
