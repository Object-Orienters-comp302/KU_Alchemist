package Models;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck implements Publisher {
    private static Deck                  single_instance;
    private        ArrayList<Ingredient.IngredientTypes> Ingredients;
    private        ArrayList<Artifact>   Artifacts;
    
    private ArrayList<Listener> listeners;
    
    private Deck() {
        Ingredients = new ArrayList<>();
        Artifacts   = new ArrayList<>();
        listeners   = new ArrayList<>(); //TODO add an initializer
        
        Deck.single_instance = this;
    }
    
    public HashMap<Integer, Ingredient.IngredientTypes> getFirstThree() {
        return IntStream.range(0, Math.min(3, Ingredients.size()))
                .boxed()
                .collect(Collectors.toMap(i -> i, Ingredients::get, (a, b) -> b, HashMap::new));
    }
    
    public ArrayList<Ingredient.IngredientTypes> getIngredients() {
        return Ingredients;
    }
    
    public static synchronized Deck getInstance() {
        if (single_instance == null) { single_instance = new Deck(); }
        
        return single_instance;
    }
    
    public void setFirstThree(HashMap<Integer, Ingredient.IngredientTypes> to_set) {
        to_set.forEach((index, ingredient) -> {
            if (index >= 0 && index < 3) {
                if (index < Ingredients.size()) {
                    Ingredients.set(index, ingredient);
                } else {
                    Ingredients.add(ingredient);
                }
            }
        });
        publishEvent(Type.DECK_INGREDIENT);
    }
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    public void addIngredient(Ingredient.IngredientTypes ingredient, int quantity) {
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
    
    public Ingredient.IngredientTypes popIngredient() {
        // remove random element from Ingredient list (the array is random, by shuffle)
        
        if (Ingredients.isEmpty()) {
            return null;
        }
        
        Ingredient.IngredientTypes ingredient = Ingredients.removeFirst();
        publishEvent(Type.DECK_INGREDIENT);
        return ingredient;
    }
    
    public Artifact popArtifact() {
        // remove random element from Ingredient list (the array is random, by shuffle)
        
        if (Artifacts.isEmpty()) {
            return null;
        }
        
        Artifact artifact = getArtifacts().removeFirst();
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
    
    public void clear() {
        single_instance = new Deck();
    }
}
