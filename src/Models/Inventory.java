package Models;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Ingredient> Ingredients;
    ArrayList<ArtifactCard> Artifacts;
    Integer Gold;

    public Inventory(ArrayList<Ingredient> ingredients, ArrayList<ArtifactCard> artifacts, Integer gold) {
        Ingredients = ingredients;
        Artifacts = artifacts;
        Gold = gold;
    }

    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }
    public void addIngredient(Ingredient ingredient) {
        getIngredients().add(ingredient);
    }

    public ArrayList<ArtifactCard> getArtifacts() {
        return Artifacts;
    }
    public void addArtifactCard(ArtifactCard artifact) {
        getArtifacts().add(artifact);
    }

    public Integer getGold() {
        return Gold;
    }

    public void setGold(Integer gold) {
        Gold = gold;
    }
}
