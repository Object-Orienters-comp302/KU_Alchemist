package Models;

import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;

import java.awt.*;
import java.util.ArrayList;


public class Player implements Publisher {
    private static ArrayList<Player> instances = new ArrayList<>();
    private static int currPlayerIndex = 0;
    private String    playerID;
    private Inventory playerInventory;
    private Integer             playerScore;
    private Integer             reputation;
    private Integer             sicknessLevel;
    private ArrayList<Listener> listeners;
    
    public Player(String playerID) {
        this.playerID        = playerID;
        this.playerInventory = new Inventory();
        this.playerScore   = 0; // Start from 0
        this.sicknessLevel = 0; // Sickness is an integer from 1 to 3 representing how sick the person is

        instances.add(this);
    }
    
    public static ArrayList<Player> getPlayers() {
        return instances;
    }
    
    public static Player getCurrPlayer() {
        return getPlayers().get(currPlayerIndex);
    }
    
    public static Player nextPlayer() {
        // Increment the current player index, and loop back if it reaches the end of the list
        currPlayerIndex = (currPlayerIndex + 1) % instances.size();
        
        return instances.get(currPlayerIndex);
    }
    
    public void haveSurgery() {
        // If the player gets surgery remove all gold and set sickness to 0
        getPlayerInventory().setGold(0);
        setSicknessLevel(0);
    }
    
    // Auto-Generated getter setters
    public String getPlayerID() {
        return playerID;
    }
    
    public Inventory getPlayerInventory() {
        return playerInventory;
    }
    
    public Integer getPlayerScore() {
        return playerScore;
    }
    
    public void setPlayerScore(Integer playerScore) {
        this.playerScore = playerScore;
    }
    
    public Integer getReputation() {
        return reputation;
    }
    
    public void setReputation(Integer reputation) {
        this.reputation = reputation;
        publishEvent(Type.REPUTATION);
    }
    
    public void addReputation(Integer num) {
        setReputation(getReputation() + num);
    }

    public Integer getSicknessLevel() {
        return sicknessLevel;
    }
    
    public void setSicknessLevel(Integer sicknessLevel) {
        this.sicknessLevel = sicknessLevel;
        publishEvent(Type.SICKNESS); // Sickness yerine playerGotSick gibi bisey yapsak daha iyi olmaz mi?
        // TODO: Refactor the event names
    }
    
    
    // Listener Functions
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    // Testing function
    public static void main(String[] args){
        new Player("0");
        new Player("1");
        new Player("2");
        
        System.out.println(Player.getCurrPlayer());
        System.out.println(Player.getPlayers());
        
        Player.nextPlayer();
        
        System.out.println(Player.getCurrPlayer());
        System.out.println(Player.getPlayers());
        Player.nextPlayer();
        
        System.out.println(Player.getCurrPlayer());
        System.out.println(Player.getPlayers());
        Player.nextPlayer();
        
        System.out.println(Player.getCurrPlayer());
        System.out.println(Player.getPlayers());
    }
}
