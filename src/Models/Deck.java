package Models;

import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class Deck implements Publisher {
    private static Deck                  single_instance;
    private        ArrayList<Ingredient> Ingredients;
    private        ArrayList<Artifact>   Artifacts;
    
    private ArrayList<Listener> listeners;
    
    private Deck() {
        Ingredients = new ArrayList<>();
        Artifacts   = new ArrayList<>();
        
        Deck.single_instance = this;
    }
    
    public static synchronized Deck getInstance() {
        if (single_instance == null) { single_instance = new Deck(); }
        
        return single_instance;
    }
    
    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }
    
    public ArrayList<Artifact> getArtifacts() {
        return Artifacts;
    }
    
    public void addIngredient(Ingredient ingredient, int quantity) {
        for(int i = 0; i < quantity ; i++){
            Ingredients.add(ingredient);
        }
        publishEvent(Type.DECK_INGREDIENT);
    }
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    public void addArtifactCard(Artifact artifact, int quantity) {
        for(int i = 0; i < quantity ; i++ ){
            Artifacts.add(artifact);
        }
        publishEvent(Type.DECK_ARTIFACT);
    }
    
    public Ingredient popIngredient() {
        // remove random element from Ingredient list
        
        if (Ingredients.isEmpty()) {
            return null;
        }
        
        Random random = new Random();
        int index = random.nextInt(Ingredients.size());
        
        Ingredient ingredient = Ingredients.remove(index);
        publishEvent(Type.DECK_INGREDIENT);
        return ingredient;
    }
    
    public Artifact popArtifact() {
        // remove random element from Ingredient list
        
        if (Artifacts.isEmpty()) {
            return null;
        }
        
        Random random = new Random();
        int index = random.nextInt(Ingredients.size());
        
        Artifact artifact = Artifacts.remove(index);
        publishEvent(Type.DECK_ARTIFACT);
        return artifact;
    }
    
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
}
