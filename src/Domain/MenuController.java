package Domain;

import Models.Player;
import UI.View.MenuView;

import java.util.ArrayList;

public class MenuController {
    private   MenuView  MenuView;
    
    public MenuView getMenuView() {
        return MenuView;
    }
    
    public void setMenuView(UI.View.MenuView menuView) {
        MenuView = menuView;
    }
    
    protected MenuController() { }
    
    public ArrayList<Player> getPlayers() {
        return Player.getPlayers();
    }
    public int getPlayerCount(){
        return Player.getPlayers().size();
    }
    public Player getCurrentPlayer() {
    	return Player.getCurrPlayer();
    }
}
