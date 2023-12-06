package Domain;

import Models.Player;

import java.util.ArrayList;

public class MenuController {
    protected MenuController() { }
    
    public ArrayList<Player> getPlayers() {
        return Player.getPlayers();
    }
    public int getPlayerCount(){
        return Player.getPlayers().size();
    }
}
