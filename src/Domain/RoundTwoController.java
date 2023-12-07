package Domain;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundTwoController {
    
    public Potion sellPotion(Inventory inventory, Potion potion, Guarantee guarantee) {
        Potion removed_potion = removePotion(inventory.getPotions(), potion);
        
        if (removed_potion != null) {
            switch (guarantee) {
                case POSITIVE -> {
                    inventory.setGold(inventory.getGold() + 3);
                }
                case NEUTRAL -> {
                    inventory.setGold(inventory.getGold() + 2);
                }
                case NEGATIVE -> {
                    inventory.setGold(inventory.getGold() + 1);
                }
            }
            
            return removed_potion;
        }
        
        return null;
    }
    
    public Potion removePotion(HashMap<Potion, Integer> Potions, Potion potion) {
        
        if (Potions.isEmpty()) {
            return null;
        }
        
        int potion_num = Potions.get(potion);
        
        if (potion_num != 0) {
            Potions.put(potion, potion_num - 1);
            return potion;
            
        } else {
            return null;
        }
    }
    
    public boolean publishTheory(Player currentPlayer, Ingredient selectedIngredient, ArrayList<Aspect> alchemyMarker, Integer certainityPoint ) {
        if (selectedIngredient != null && alchemyMarker != null && (certainityPoint == 1 || certainityPoint == 2 || certainityPoint == 3)) {
            // Check if the selected ingredient has an available alchemy marker and does not have a published theory
            if (!PublicationTrack.getInstance().isInPublicationTrack(selectedIngredient, alchemyMarker)) {
                // Assign the marker to the selected ingredient
                PublicationCard new_Theory = new PublicationCard(selectedIngredient, alchemyMarker, certainityPoint, currentPlayer); // Todo: The certainty point is a point that can take the values 1, 2, 3, expressing the player's confidence in the theory. It should be checked again after Phase 1
                // Mark the marker as used
                PublicationTrack.getInstance().addPublicationCard(new_Theory);
                // Pay 1 gold piece to the bank
                currentPlayer.getInventory().addGold(-1);
                // Gain 1 point of reputation
                currentPlayer.addReputation(1);
                return true; // Theory published successfully
            }
        }
        return false; // Publishing theory failed due to invalid inputs or unavailable markers/ingredients
    }
    
    public enum Guarantee {
        POSITIVE,
        NEUTRAL,
        NEGATIVE,
    }
}
