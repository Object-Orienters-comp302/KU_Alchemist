package Models;

import java.util.HashMap;

public class Inventory {
    HashMap<Ingredient, Integer> Ingredients;
    HashMap<Potion, Integer>     Potions;
    
    HashMap<Artifact, Integer> Artifacts;
    Integer                    Gold;
    
    public Inventory() {
        Ingredients = new HashMap<Ingredient, Integer>();
        Artifacts   = new HashMap<Artifact, Integer>();
        Potions = new HashMap<Potion, Integer>();
        Gold        = 0;
    }
    
    public HashMap<Ingredient, Integer> getIngredients() {
        return Ingredients;
    }
    
    public HashMap<Potion, Integer> getPotions() {
        return Potions;
    }
    
    
    public void addIngredient(Ingredient ingredient, int quantity) {
        Ingredients.merge(ingredient, quantity, Integer::sum);
    }
    
    public void addPotions(Potion potion, int quantity) {
        Potions.merge(potion, quantity, Integer::sum);
    }
    
    public HashMap<Artifact, Integer> getArtifacts() {
        return Artifacts;
    }
    
    public void addArtifactCard(Artifact artifact, int quantity) {
        Artifacts.merge(artifact, quantity, Integer::sum);
    }
    
    public Integer getGold() {
        return Gold;
    }
    
    public void setGold(Integer gold) {
        Gold = gold;
    }
    
    public void addGold(Integer num) {
        setGold(getGold() + num);
    }
}
