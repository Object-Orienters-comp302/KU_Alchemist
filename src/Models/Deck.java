package Models;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    
    public ArrayList<Ingredient> getFirstThree() {
        ArrayList<Ingredient> ar= new ArrayList<Ingredient>();
        if (Ingredients.size()<3){
            return null;
        }
        for (int i=0;i<3;i++){
            ar.set(i,Ingredients.get(i));
        }
        return ar;
    }
    
    
    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }
    
    public static synchronized Deck getInstance() {
        if (single_instance == null) { single_instance = new Deck(); }
        
        return single_instance;
    }
    
    public void setFirstThree(ArrayList<Ingredient> to_set) {
        int i=0;
        for (Ingredient ing:to_set){
            Ingredients.set(i,ing);
            i++;
        }
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
    
    public void  initializeArtifacts(){
        Artifacts= Artifact.createArtifacts();
    }
    
    public void shuffleIngredients() {
        Collections.shuffle(Ingredients);
        publishEvent(Type.DECK_INGREDIENT);
    }
    
    public void shuffleArtifact() {
        Collections.shuffle(Artifacts);
        publishEvent(Type.DECK_ARTIFACT);
    }
    
    public void clear() {
        single_instance = new Deck();
    }
    
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
}
