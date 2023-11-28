package Models;

import java.util.ArrayList;

public class Deck {
    ArrayList<Ingredient> Ingredients;
    ArrayList<ArtifactCard> Artifacts;

    public Deck(ArrayList<Ingredient> ingredients, ArrayList<ArtifactCard> artifacts) {
        Ingredients = ingredients;
        Artifacts = artifacts;
    }

    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }

    public ArrayList<ArtifactCard> getArtifacts() {
        return Artifacts;
    }
    public Ingredient popIngredient(){
        Ingredient ingredient = getIngredients().getLast();
        getIngredients().remove(ingredient);
        return ingredient;
    }
    public ArtifactCard popArtifactCard(){
        ArtifactCard artifact = getArtifacts().getLast();
        getIngredients().remove(artifact);
        return artifact;
    }
}
