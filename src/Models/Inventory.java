package Models;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Inventory implements Publisher {
    HashMap<Ingredient.IngredientTypes, Integer> ingredientHashMap;
    HashMap<Potion, Integer>                     potions;
    ArrayList<Artifact> artifacts;
    Integer                    gold;
    private ArrayList<Listener> listeners;
    
    public Inventory() {
        ingredientHashMap = new HashMap<Ingredient.IngredientTypes, Integer>();
        artifacts         = new ArrayList<Artifact>();
        potions   = new HashMap<Potion, Integer>();
        gold      = 0;
        listeners = new ArrayList<>();
    }
    
    
    public HashMap<Ingredient.IngredientTypes, Integer> getIngredientHashMap() {
        return ingredientHashMap;
    }
    
    public void addIngredient(Ingredient.IngredientTypes type, int quantity) {
        // Check if the ingredient type is already in the inventory
        if (ingredientHashMap.containsKey(type)) {
            // If it exists, update the quantity
            int currentQuantity = ingredientHashMap.get(type);
            ingredientHashMap.put(type, currentQuantity + quantity);
        } else {
            // If it does not exist, add it with the given quantity
            ingredientHashMap.put(type, quantity);
        }
        publishEvent(Type.INGREDIENT);
    }
    
    /**
     * Removes an ingredient of the specified type from the collection.
     *
     * @param type The type of ingredient to be removed.
     * @throws NoSuchElementException if the ingredient type is not found.
     */
    public void removeIngredient(Ingredient.IngredientTypes type) {
        if (ingredientHashMap.containsKey(type)){
            ingredientHashMap.remove(type);
            publishEvent(Type.INGREDIENT);
        }
        else{
            throw new NoSuchElementException("Ingredient of type " + type + " not found.");
        }
    }
    /**
     * Removes a specified quantity of an ingredient of the specified type.
     *
     * @param type The type of ingredient to be removed.
     * @param quantity The quantity of the ingredient to remove.
     * @throws NoSuchElementException if the ingredient type is not found.
     * @throws IllegalArgumentException if the removal quantity is greater than the available quantity.
     */
    public void removeIngredient(Ingredient.IngredientTypes type, int quantity) {
        if (!ingredientHashMap.containsKey(type)) {
            throw new NoSuchElementException("Ingredient of type " + type + " not found.");
        }
        
        int currentQuantity = ingredientHashMap.get(type);
        if (quantity > currentQuantity) {
            throw new IllegalArgumentException("Removal quantity " + quantity + " exceeds available quantity of " + currentQuantity);
        }
        
        int newQuantity = currentQuantity - quantity;
        if (newQuantity > 0) {
            ingredientHashMap.put(type, newQuantity);
        } else {
            ingredientHashMap.remove(type);
        }
        
        publishEvent(Type.INGREDIENT);
    }
    
    public int getIngredientCount(Ingredient.IngredientTypes type) {
        return ingredientHashMap.getOrDefault(type, 0);
    }
    
    public boolean isInInventory(Ingredient.IngredientTypes type) {
        return ingredientHashMap.getOrDefault(type, 0) > 0;
    }
    
    public HashMap<Potion, Integer> getPotions() {
        return potions;
    }
    public void addPotions(Potion potion, int quantity) {
        potions.merge(potion, quantity, Integer::sum);
        publishEvent(Type.POTION);
    }
    
    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }
    
    public void addArtifactCard(Artifact artifact) {
        artifacts.add(artifact);
        publishEvent(Type.ARTIFACT);
    }
    
    public void addGold(Integer num) {
        setGold(getGold() + num);
    }
    
    public Integer getGold() {
        return gold;
    }
    
    public void setGold(Integer gold) {
        this.gold = gold;
        publishEvent(Type.GOLD);
    }
    
    public boolean checkArtifactExists(Artifact.Name artifactName){
        for (Artifact artifact: artifacts){
            if(artifact.getName().equals(artifactName)){
                return true;
            }
        }
        return false;
    }
    public void removeArtifact(Artifact.Name artifactName){ // TODO: This function seems odd, may not work
        for (Artifact artifact: artifacts){
            if(artifact.getName().equals(artifactName)){
                getArtifacts().remove(artifact);
            }
        }
    }
    public boolean repOK() {
        // Null checks for maps and listeners
        if (ingredientHashMap == null || potions == null || artifacts == null || listeners == null) {
            return false;
        }
        
        // Check for non-negative gold value
        if (gold == null || gold < 0) {
            return false;
        }
        
        // Check for non-negative values in ingredientHashMap
        for (Integer quantity : ingredientHashMap.values()) {
            if (quantity == null || quantity < 0) {
                return false;
            }
        }
        
        // Check for non-negative values in potions
        for (Integer quantity : potions.values()) {
            if (quantity == null || quantity < 0) {
                return false;
            }
        }
        /*
        // Check for non-negative values in artifacts
        for (Integer quantity : artifacts.values()) {
            if (quantity == null || quantity < 0) {
                return false;
            }
        }
        */
        return true;
    }
    
    
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
