package Models;

import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;
import Utils.AssetLoader;

import java.awt.*;
import java.util.ArrayList;


public class Player implements Publisher {
    private static ArrayList<Player> instances = new ArrayList<>();
    private static int currPlayerIndex = 0;
    private String     ID;
    private Token   token;
    private Inventory inventory;
    private Integer   score;
    private Integer   reputation;
    private Integer             sicknessLevel;
    private ArrayList<Listener> listeners;
    private int[]       triangleTableArray;
    private int[][]     rectangleTableArray;
    
    public Player(String playerID, Token token) {
        this.ID        = playerID;
        this.token     = token;
        this.inventory = new Inventory();
        this.listeners = new ArrayList<>();
        this.score     = 0; // Start from 0
        this.reputation = 0;
        this.sicknessLevel = 0; // Sickness is an integer from 1 to 3 representing how sick the person is
        this.triangleTableArray=new int[28];
        this.rectangleTableArray=new int[8][8];
        
        
        instances.add(this);
        System.out.print("New Player Created!: "); System.out.println(this.ID);
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
        getInventory().setGold(0);
        setSicknessLevel(0);
    }
    
    // Auto-Generated getter setters
    public String getID() {
        return ID;
    }
    
    public Token getToken() {return token;}
    
    public void setToken(Token token) {
        this.token = token;
    }
    
    public Inventory getInventory() {
        return inventory;
    }
    
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
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
    public boolean removeFromInventory(Ingredient ingrToRemove){
        return false;
    }
    public boolean removeFromInventory(Ingredient.IngredientTypes ingrtypeToRemove){
        return false;
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
        new Player("0", null);
        new Player("1", null);
        new Player("2", null);
        
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
