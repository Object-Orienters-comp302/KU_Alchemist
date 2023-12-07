package Models;

import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Deck implements Publisher {
    private static Deck                  single_instance;
    private        ArrayList<Ingredient> Ingredients;
    private        ArrayList<Artifact>   Artifacts;
    
    private ArrayList<Listener> listeners;
    
    private Deck() {
        Ingredients = new ArrayList<>();
        Artifacts   = new ArrayList<>();
        listeners   = new ArrayList<>();//TODO add an initializer
        
        Deck.single_instance = this;
    }
    
    public HashMap<Ingredient, Integer> getFirstThree() {
        HashMap<Ingredient, Integer> firstThreeCard = new HashMap<>();
        ArrayList<Ingredient> ingredients = Deck.getInstance().getIngredients();
        
        for (int i = 0; i < 3; i++) {
            firstThreeCard.put(ingredients.get(i), i);
        }
        
        return firstThreeCard;
    }
    
    
    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }
    
    public static synchronized Deck getInstance() {
        if (single_instance == null) { single_instance = new Deck(); }
        
        return single_instance;
    }
    
    public void setFirstThree(HashMap<Ingredient, Integer> to_set) {
        // Clear the current first three ingredients if they exist
        if (Ingredients.size() > 3) {
            Ingredients.subList(0, 3).clear();
        }
        
        // Add new ingredients in the correct order
        Ingredient[] newFirstThree = new Ingredient[3];
        for (Map.Entry<Ingredient, Integer> entry : to_set.entrySet()) {
            if (entry.getValue() >= 0 && entry.getValue() < 3) {
                newFirstThree[entry.getValue()] = entry.getKey();
            }
        }
        
        // Adding the new ingredients to the Ingredients list
        for (Ingredient ingredient : newFirstThree) {
            if (ingredient != null) {
                Ingredients.add(0, ingredient); // Add at the beginning
            }
        }
        
        publishEvent(Type.DECK_INGREDIENT);
    }
    
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    public void addIngredient(Ingredient ingredient, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Ingredients.add(ingredient);
        }
        publishEvent(Type.DECK_INGREDIENT);
    }
    
    public void addArtifactCard(Artifact artifact, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Artifacts.add(artifact);
        }
        publishEvent(Type.DECK_ARTIFACT);
    }
    
    public Ingredient popIngredient() {
        // remove random element from Ingredient list (the array is random, by shuffle)
        
        if (Ingredients.isEmpty()) {
            return null;
        }
        
        Ingredient ingredient = Ingredients.remove(0);
        publishEvent(Type.DECK_INGREDIENT);
        return ingredient;
    }
    
    public Artifact popArtifact() {
        // remove random element from Ingredient list (the array is random, by shuffle)
        
        if (Artifacts.isEmpty()) {
            return null;
        }
        
        Artifact artifact = getArtifacts().remove(0);
        publishEvent(Type.DECK_ARTIFACT);
        return artifact;
    }
    
    public ArrayList<Artifact> getArtifacts() {
        return Artifacts;
    }
    
    public void shuffleIngredients() {
        Collections.shuffle(Ingredients);
        publishEvent(Type.DECK_INGREDIENT);
    }
    
    public void shuffleArtifact() {
        Collections.shuffle(Artifacts);
        publishEvent(Type.DECK_ARTIFACT);
    }
    
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
}
