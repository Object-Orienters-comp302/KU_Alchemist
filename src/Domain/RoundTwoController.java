package Domain;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundTwoController extends RoundOneController{
    
    /**
     * Sells a potion from the inventory and updates the inventory's gold based on the potion's sign.
     * 
     * @param inventory The inventory from which the potion is to be sold.
     * @param potion    The potion to be sold.
     * @return          The potion that was sold.
     * @throws IllegalArgumentException if the potion is not found in the inventory.
     */
    public Potion sellPotion(Inventory inventory, Potion potion) {
        Potion removedPotion = removePotion(inventory.getPotions(), potion);
    
        if (removedPotion == null) {
            throw new IllegalArgumentException("Potion not found in inventory.");
        }
    
        int goldToAdd;
        switch (removedPotion.getSign()) {
            case Potion.Signs.Positive:
                goldToAdd = 3;
                break;
            case Potion.Signs.Neutral:
                goldToAdd = 2;
                break;
            case Potion.Signs.Negative:
                goldToAdd = 1;
                break;
            default:
                throw new IllegalStateException("Unknown potion sign.");
        }
    
        inventory.setGold(inventory.getGold() + goldToAdd);
    
        return removedPotion;   
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
    
    public boolean publishTheory(Player currentPlayer, Ingredient.IngredientTypes selectedIngredient, Ingredient.AspectTrio alchemyMarker) {
        if (selectedIngredient != null && alchemyMarker != null && currentPlayer.getInventory().getGold() > 0) {
            // Check if the selected ingredient has an available alchemy marker and does not have a published theory
            if (!PublicationTrack.getInstance().isInPublicationTrack(selectedIngredient, alchemyMarker)) {
                // Assign the marker to the selected ingredient
                PublicationCard new_Theory = new PublicationCard(selectedIngredient, alchemyMarker,  currentPlayer); // Todo: The certainty point is a point that can take the values 1, 2, 3, expressing the player's confidence in the theory. It should be checked again after Phase 1
                // Mark the marker as used
                PublicationTrack.getInstance().addPublicationCard(new_Theory);
                // Pay 1 gold piece to the bank
                currentPlayer.getInventory().addGold(-1);
                // Gain 1 point of reputation
                currentPlayer.addReputation(1);
                return true; // Theory published successfully
            }
            return false;
        }
        return false; // Publishing theory failed due to invalid inputs or unavailable markers/ingredients
    }
    public PublicationCard getCardForIngredient(Ingredient.IngredientTypes ingre){
        for(PublicationCard card: PublicationTrack.getInstance().getPublicationCards()){
            if (card.getIngredient()==ingre){
                return card;
            }
        }
        return null;
    }
    
    public boolean canPublish(Player player, Ingredient.IngredientTypes type){
        if (player.getInventory().getGold()>=1 && !PublicationTrack.getInstance().isPublished(type)){
            return true;
        }
        return false;
    }
    public boolean canEndorse(Player player,PublicationCard card){
        return card.playerCanEndorse(player);
    }
    public void endorseTheory(Player player, PublicationCard card, int i){
        if (canEndorse(player,card)) {
            card.addEndorser(i, player);
        }
    }
    
    

    //just gonna keep this here
    public enum Guarantee {
        POSITIVE,
        NEUTRAL,
        NEGATIVE,
    }
}
