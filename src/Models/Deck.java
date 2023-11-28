package Models;

import java.util.ArrayList;

public class Deck {
    ArrayList<Ingredient> Ingredients;
    ArrayList<ArtifactCard> Artifacts;

    public Deck(ArrayList<Ingredient> ingredients, ArrayList<ArtifactCard> artifacts) {
        Ingredients = ingredients;
        Artifacts = artifacts;
    }
    
}
