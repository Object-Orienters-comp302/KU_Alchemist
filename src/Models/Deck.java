package Models;

import java.util.ArrayList;

public class Deck {
    ArrayList<Ingredient> Ingredients;
    ArrayList<Artifact> Artifacts;

    public Deck(ArrayList<Ingredient> ingredients, ArrayList<Artifact> artifacts) {
        Ingredients = ingredients;
        Artifacts = artifacts;
    }

    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }

    public ArrayList<Artifact> getArtifacts() {
        return Artifacts;
    }
    public Ingredient popIngredient(){
        Ingredient ingredient = getIngredients().getLast();
        getIngredients().remove(ingredient);
        return ingredient;
    }
    public Artifact popArtifactCard(){
        Artifact artifact = getArtifacts().getLast();
        getArtifacts().remove(artifact);
        return artifact;
    }
}
