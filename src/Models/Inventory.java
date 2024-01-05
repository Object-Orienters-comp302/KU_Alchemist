package Models;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements Publisher {
    HashMap<Ingredient.IngredientTypes, Integer> Ingredients;
    HashMap<Potion, Integer>     Potions;
    
    HashMap<Artifact, Integer> Artifacts;
    Integer                    Gold;
    private ArrayList<Listener> listeners;
    
    public Inventory() {
        Ingredients = new HashMap<Ingredient.IngredientTypes, Integer>();
        Artifacts   = new HashMap<Artifact, Integer>();
        Potions     = new HashMap<Potion, Integer>();
        Gold        = 0;
        listeners   = new ArrayList<>();
    }
    
    
    public HashMap<Ingredient.IngredientTypes, Integer> getIngredients() {
        return Ingredients;
    }
    
    public void addIngredient(Ingredient.IngredientTypes type, int quantity) {
        // Check if the ingredient type is already in the inventory
        if (Ingredients.containsKey(type)) {
            // If it exists, update the quantity
            int currentQuantity = Ingredients.get(type);
            Ingredients.put(type, currentQuantity + quantity);
        } else {
            // If it does not exist, add it with the given quantity
            Ingredients.put(type, quantity);
        }
        publishEvent(Type.INGREDIENT);
    }
    public void removeIngredient(Ingredient.IngredientTypes type) {
        Ingredients.remove(type);
        publishEvent(Type.INGREDIENT);
    }
    
    public int getIngredientCount(Ingredient.IngredientTypes type) {
        return Ingredients.getOrDefault(type, 0);
    }
    
    public boolean isInInventory(Ingredient.IngredientTypes type) {
        return Ingredients.getOrDefault(type, 0) > 0;
    }
    
    
    
    
    
    public HashMap<Potion, Integer> getPotions() {
        return Potions;
    }
    public void addPotions(Potion potion, int quantity) {
        Potions.merge(potion, quantity, Integer::sum);
        publishEvent(Type.POTION);
    }
    
    public HashMap<Artifact, Integer> getArtifacts() {
        return Artifacts;
    }
    
    public void addArtifactCard(Artifact artifact, int quantity) {
        Artifacts.merge(artifact, quantity, Integer::sum);
        publishEvent(Type.ARTIFACT);
    }
    
    public void addGold(Integer num) {
        setGold(getGold() + num);
    }
    
    public Integer getGold() {
        return Gold;
    }
    
    public void setGold(Integer gold) {
        Gold = gold;
        publishEvent(Type.GOLD);
    }
    
    public boolean checkArtifactExists(String artifactName){
        for (Artifact artifact1: Artifacts.keySet()){
            if(artifact1.getName().equals(artifactName)){
                return true;
            }
        }
        return false;
    }
    public void removeArtifact(String artifactName){
        boolean deleted = false;
        for (Artifact artifact1: Artifacts.keySet()){
            if(artifact1.getName().equals(artifactName) && !deleted){
                getArtifacts().remove(artifact1);
                deleted = true;
            }
        }
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
