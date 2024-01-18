package Models;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;

import java.io.SequenceInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Player implements Publisher, Serializable {
    private static ArrayList<Player>   instances       = new ArrayList<>();
    private static int                 currPlayerIndex = 0;
    private        String              ID;
    private        Token               token;
    private        Inventory           inventory;
    private        Integer             score;
    private        Integer             reputation;
    private        Integer             sicknessLevel;
    private        ArrayList<Listener> listeners;
    private        int[]               triangleTableArray;
    private        int[][]             rectangleTableArray;
    private        int                 forageRight; // Count of forageing rights left
    
    public Player(String playerID, Token token) {
        this.ID                  = playerID;
        this.token               = token;
        this.inventory           = new Inventory();
        this.listeners           = new ArrayList<>();
        this.score               = 0; // Start from 0
        this.reputation          = 0;
        this.sicknessLevel       = 0; // Sickness is an integer from 1 to 3 representing how sick the person is
        this.triangleTableArray  = new int[28];
        this.rectangleTableArray = new int[8][8];
        this.forageRight         = 2;
        
        
        instances.add(this);
        System.out.print("New Player Created!: ");
        System.out.println(this.ID);
    }
    
    public static Player getCurrPlayer() {
        return getPlayers().get(currPlayerIndex);
    }
    
    public static ArrayList<Player> getPlayers() {
        return instances;
    }
    
    public static Player nextPlayer() {
        // Increment the current player index, and loop back if it reaches the end of the list
        Player.getCurrPlayer().setForageRight(Player.getCurrPlayer().getForageRight()+1);
        currPlayerIndex = (currPlayerIndex + 1) % instances.size();
        Player.getCurrPlayer().publishEvent(Type.GOLD);//This has to update inventory thus to publish event I get the current instance.
        Player.getCurrPlayer().publishEvent(Type.INGREDIENT);
        Player.getCurrPlayer().publishEvent(Type.POTION);
        
        return instances.get(currPlayerIndex);
    }
    public void haveSurgery() {
        // If the player gets surgery remove all gold and set sickness to 0
        getInventory().setGold(0);
        setSicknessLevel(0);
    }
    public Inventory getInventory() {
        return inventory;
    }
    public String getID() {
        return ID;
    }
    
    public Token getToken() { return token; }
    public void setToken(Token token) {
        this.token = token;
    }
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public void addReputation(Integer num) {
        setReputation(getReputation() + num);
    }
    
    public Integer getReputation() {
        return reputation;
    }
    
    public void setReputation(Integer reputation) {
        this.reputation = reputation;
        publishEvent(Type.REPUTATION);
    }
    public Integer getSicknessLevel() {
        return sicknessLevel;
    }
    public void setSicknessLevel(Integer sicknessLevel) {
        if (sicknessLevel > 3) {
            this.sicknessLevel = 3;
        } else if (sicknessLevel < 0) {
            this.sicknessLevel = 0;
        } else {
            this.sicknessLevel = sicknessLevel;
        }
        publishEvent(Type.SICKNESS);
        // TODO: Refactor the event names
    }
    public int[] getTriangleTableArray() {
        return triangleTableArray;
    }
    
    public void setTriangleTableArray(int[] triangleTableArray) {
        this.triangleTableArray = triangleTableArray;
    }
    
    public int[][] getRectangleTableArray() {
        return rectangleTableArray;
    }
    
    public void setRectangleTableArray(int[][] rectangleTableArray) {
        this.rectangleTableArray = rectangleTableArray;
    }
    
    public int getForageRight() {
        return forageRight;
    }
    
    public void setForageRight(int forageRight) {
        this.forageRight = forageRight;
        this.publishEvent(Type.FORAGERIGHT);
    }
    
    // Listener Functions
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
}
