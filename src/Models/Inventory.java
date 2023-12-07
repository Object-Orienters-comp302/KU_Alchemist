package Models;

import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements Publisher {
    HashMap<Ingredient, Integer> Ingredients;
    HashMap<Potion, Integer>     Potions;
    
    HashMap<Artifact, Integer> Artifacts;
    Integer                    Gold;
    private ArrayList<Listener> listeners;
    
    public Inventory() {
        Ingredients = new HashMap<Ingredient, Integer>();
        Artifacts   = new HashMap<Artifact, Integer>();
        Gold        = 0;
        listeners   = new ArrayList<>();
    }
    
    public HashMap<Ingredient, Integer> getIngredients() {
        return Ingredients;
    }
    
    public HashMap<Potion, Integer> getPotions() {
        return Potions;
    }
    
    
    public void addIngredient (Ingredient ingredient, int quantity) {
        Ingredients.merge(ingredient, quantity, Integer::sum);
        publishEvent(Type.INGREDIENT);
    }
    
    public void addPotions (Potion potion, int quantity) {
        Potions.merge(potion, quantity, Integer::sum);
        publishEvent(Type.POTION);
    }
    
    public HashMap<Artifact, Integer> getArtifacts() {
        return Artifacts;
    }
    
    public void addArtifactCard (Artifact artifact, int quantity) {
        Artifacts.merge(artifact, quantity, Integer::sum);
        publishEvent(Type.ARTIFACT);
    }
    
    public Integer getGold() {
        return Gold;
    }
    
    public void setGold (Integer gold) {
        Gold = gold;
        publishEvent(Type.GOLD);
    }
    
    public void addGold(Integer num) {
        setGold(getGold() + num);
    }
    
    public void removeIngredient(Ingredient ingredient){
        this.getIngredients().put(ingredient,this.getIngredients().get(ingredient)-1); //TODO Add publisher.
    }
    public boolean checkIngredientExists(Ingredient.IngredientTypes Type){
        return this.getIngredients().get(new Ingredient(Type)) > 0;
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
