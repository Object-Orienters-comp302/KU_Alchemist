package Domain;

import Models.Artifact;
import Models.Deck;
import Models.Ingredient;
import Models.Player;

import java.util.HashMap;

public class RoundOneControllerBranch {
    
    public void ForageForIngredient (Player player) {
        Deck deck = Deck.getInstance();
        player.getPlayerInventory()
                .addIngredient(deck.popIngredient(), 1);
    }
    
    public void TransmuteIngredient (Player player, Ingredient ingredient) {
        HashMap<Ingredient, Integer> ingredients = player.getPlayerInventory()
                .getIngredients();
        if (ingredients.get(ingredient) > 0) {
            
            ingredients.put(ingredient, ingredients.get(ingredient) - 1);
            player.getPlayerInventory()
                    .setGold(player.getPlayerInventory()
                                     .getGold() + 1);
        }
    }
    
    public void BuyArtifacts (Player player, Artifact artifact) {
        HashMap<Artifact, Integer> artifacts = player.getPlayerInventory()
                .getArtifacts();
        if (player.getPlayerInventory()
                .getGold() > 3) {
            
            artifacts.put(artifact, artifacts.get(artifact) + 1);
            player.getPlayerInventory()
                    .setGold(player.getPlayerInventory()
                                     .getGold() - 3);
        }
    }
    
    public void Make_experiments (Player player, Ingredient ingredient_1, Ingredient ingredient_2) {
    
    }
    
    //TODO Add Make Experiment
    
}
