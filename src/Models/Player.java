package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private static ArrayList<Player> instances = new ArrayList<Player>();
    String PlayerID;
    Image Avatar;
    public Player(String PlayerID, Image Avatar){
        this.PlayerID = PlayerID;
        this.Avatar = Avatar;
        instances.add(this);
    }

    public static ArrayList<Player> getInstances(){
        return instances;
    }

    public String getPlayerID() {
        return PlayerID;
    }

    public Image getAvatar() {
        return Avatar;
    }
}
