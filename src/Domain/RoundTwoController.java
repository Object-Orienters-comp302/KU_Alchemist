package Domain;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundTwoController extends RoundOneController{

    /**
     * Sells a potion from the current player based on the passed identityType, if the potion has a positive sign, add 2 gold to the inventory of the current player, otherwise add 1 gold.
     * 
     * @param           Potion.identityType The type of the potion.
     * @return          The sign of the potion that was sold
     * @throws          IllegalArgumentException if the potion is not found.
     */
    public Potion.Signs sellPotion(Potion.IdentityTypes identityType) {
        Potion potion = Potion.deIdentify(identityType);
        Potion.Signs sign = Player.getCurrPlayer().getInventory().removePotion(potion);
        
        
        if(potion.getSign() == Potion.Signs.Positive){
            Player.getCurrPlayer().getInventory().setGold(Player.getCurrPlayer().getInventory().getGold()+2);
        }
        else {
            Player.getCurrPlayer().getInventory().setGold(Player.getCurrPlayer().getInventory().getGold()+1);
        }
        
        return sign;
    }
    
    public boolean publishTheory(Player currentPlayer, Ingredient.IngredientTypes selectedIngredient, Ingredient.AspectTrio alchemyMarker) {
        if (selectedIngredient != null && alchemyMarker != null && currentPlayer.getInventory().getGold() > 0) {
            // Check if the selected ingredient has an available alchemy marker and does not have a published theory
            if (!PublicationTrack.getInstance().isInPublicationTrack(selectedIngredient, alchemyMarker)) {
                // Assign the marker to the selected ingredient
                PublicationCard new_Theory = new PublicationCard(selectedIngredient, alchemyMarker,  currentPlayer); // Todo: The certainty point is a point that can take the values 1, 2, 3, expressing the player's confidence in the theory. It should be checked again after Phase 1
                // Mark the marker as used
                //PublicationTrack.getInstance().addPublicationCard(new_Theory); // already handled by default creation
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
