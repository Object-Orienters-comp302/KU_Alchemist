package Models;

import java.util.HashMap;
import java.util.Map.Entry;

public class Deck {
    private HashMap<Ingredient, Integer> Ingredients;
    private HashMap<Artifact, Integer> Artifacts;

    private static Deck single_instance;

    private Deck() {
        Ingredients = new HashMap<>();
        Artifacts = new HashMap<>();

        Deck.single_instance = this;


    }

    public static synchronized Deck getInstance() {
        if (single_instance == null)
            single_instance = new Deck();

        return single_instance;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return Ingredients;
    }

    public HashMap<Artifact, Integer> getArtifacts() {
        return Artifacts;
    }

    public Ingredient popIngredient() {
        if (Ingredients.isEmpty()) {
            return null;
        }

        for (Entry<Ingredient, Integer> entry : Ingredients.entrySet()) {
            if (entry.getValue() > 0) {
                Ingredients.put(entry.getKey(), entry.getValue() - 1);
                return entry.getKey();
            }
        }

        return null;
    }

    public Artifact popArtifact() {
        if (Artifacts.isEmpty()) {
            return null;
        }

        for (Entry<Artifact, Integer> entry : Artifacts.entrySet()) {
            if (entry.getValue() > 0) {
                Artifacts.put(entry.getKey(), entry.getValue() - 1);
                return entry.getKey();
            }
        }

        return null;
    }
}
