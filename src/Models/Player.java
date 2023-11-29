package Models;

import java.awt.*;
import java.util.ArrayList;


public class Player {

    private static ArrayList<Player> instances = new ArrayList<Player>();
    String PlayerID;
    Image Avatar;
    Inventory PlayerInventory;

    Integer PlayerScore;

    public Player(String PlayerID, Image Avatar) {// ToDo: Delete this. It is only to support gorkemsPackage
        this.PlayerID = PlayerID;
        this.Avatar = Avatar;
        this.PlayerInventory = new Inventory();
        this.PlayerScore = 0;
        instances.add(this);
    }

    public Player(String PlayerID, Image Avatar, Integer StartingGold) {
        this.PlayerID = PlayerID;
        this.Avatar = Avatar;
        this.PlayerInventory = new Inventory();
        this.PlayerScore = 0;
        instances.add(this);
    }

    public static ArrayList<Player> getInstances() {
        return instances;
    }

    public String getPlayerID() {
        return PlayerID;
    }

    public Image getAvatar() {
        return Avatar;
    }

    public Inventory getPlayerInventory() {
        return PlayerInventory;
    }

}
