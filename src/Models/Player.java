package Models;

import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;
import Utils.AssetLoader;

import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


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
    
    public boolean isInInventory(Ingredient.IngredientTypes ingredientType){
        HashMap<Ingredient, Integer> inventory = this.getInventory().getIngredients();
        
        for (Ingredient ingrIter : inventory.keySet()) {
            Integer quantity = inventory.get(ingrIter);
            if (ingrIter.getType() == ingredientType && quantity > 0){
                // TODO: Add this to debug
                System.out.println("Ingredient: " + "`" + ingredientType + "`" + " is in PlayerID: " + "`" + this.getID() + "`");
                return true;
            }
        }
        return false;
    }
    public boolean isInInventory(Ingredient ingredientToCheck){ // This function is horrible because Ingredient implementation is horrible
        return isInInventory(ingredientToCheck.getType());
    }
    
    public boolean removeFromInventory(Ingredient.IngredientTypes ingrtypeToRemove, int amount){
        if (!this.isInInventory(ingrtypeToRemove)){return false;}
        HashMap<Ingredient, Integer> inventory = this.getInventory().getIngredients();
        
        for (Ingredient ingrIter : inventory.keySet()) {
            Integer quantity = inventory.get(ingrIter);
            if (ingrIter.getType() == ingrtypeToRemove){
                if (amount > quantity){
                    System.out.println("Amount is greater than the players Ingredient amount! Not removing Ingredient");
                    return false;
                }
                else {
                    quantity = quantity-amount;
                    System.out.println("Removing " + amount + " " + ingrtypeToRemove + ". From PlayerID: " + this.getID());
                    return true;
                }
            }
        }
        return false; // Ingredient wasn't found, which shouldn't happen.
    }
    public boolean removeFromInventory(Ingredient ingrToRemove, int amount){
        return this.removeFromInventory(ingrToRemove.getType(), amount);
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
        Player a = new Player("0", null);
        Player b = new Player("1", null);
        Player c = new Player("2", null);
        
        Ingredient ingr1 = new Ingredient(Ingredient.IngredientTypes.Feather);
        Ingredient ingr2 = new Ingredient(Ingredient.IngredientTypes.Feather);
        
        a.getInventory().addIngredient(ingr1, 1);
        
        System.out.println(a.isInInventory(ingr2));
        
        System.out.println(a.isInInventory(Ingredient.IngredientTypes.ChickenLeg));
        
        
        
//        System.out.println(Player.getCurrPlayer());
//        System.out.println(Player.getPlayers());
//
//        Player.nextPlayer();
//
//        System.out.println(Player.getCurrPlayer());
//        System.out.println(Player.getPlayers());
//        Player.nextPlayer();
//
//        System.out.println(Player.getCurrPlayer());
//        System.out.println(Player.getPlayers());
//        Player.nextPlayer();
//
//        System.out.println(Player.getCurrPlayer());
//        System.out.println(Player.getPlayers());
    }
}
