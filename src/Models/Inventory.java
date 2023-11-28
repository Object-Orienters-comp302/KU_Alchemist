package Models;

import java.util.HashMap;

public class Inventory {
    HashMap<Ingredient, Integer> Ingredients;
    HashMap<Artifact, Integer> Artifacts;
    Integer Gold;

    public Inventory() {
        Ingredients = new HashMap<Ingredient, Integer>();
        Artifacts = new HashMap<Artifact, Integer>();
        Gold = 0;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return Ingredients;
    }

    public void addIngredient(Ingredient ingredient, int quantity) {
        Ingredients.merge(ingredient, quantity, Integer::sum);
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
}
