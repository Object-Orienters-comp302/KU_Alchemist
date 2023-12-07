package Domain;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundThreeController extends RoundTwoController{
    public boolean debunkTheory(Player currentPlayer, PublicationCard publicationCardToDebunk,
                                Aspect aspectTypeToDebunk) {
        if (publicationCardToDebunk != null && aspectTypeToDebunk != null) {
            // Check if the ingredient has a published theory
            if (PublicationTrack.getInstance().isPublished(publicationCardToDebunk)) {
                if (aspectTypeToDebunk.getColor() == Aspect.Colors.Red) {
                    if (aspectTypeToDebunk.isEqual(
                            publicationCardToDebunk.getIngredient().getAspects().getAspectRed())) {
                        currentPlayer.addReputation(-1);
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else if (aspectTypeToDebunk.getColor() == Aspect.Colors.Green) {
                    if (aspectTypeToDebunk.isEqual(
                            publicationCardToDebunk.getIngredient().getAspects().getAspectGreen())) {
                        currentPlayer.addReputation(-1);
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else if (aspectTypeToDebunk.getColor() == Aspect.Colors.Blue) {
                    if (aspectTypeToDebunk.isEqual(
                            publicationCardToDebunk.getIngredient().getAspects().getAspectBlue())) {
                        currentPlayer.addReputation(-1);
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else {
                    currentPlayer.addReputation(2);
                    publicationCardToDebunk.getOwner().addReputation(-1);
                    return true;
                }
                
                
            } else {
                // Ingredient doesn't have a published theory, debunking not allowed
                // TODO: Raise error
                return false;
            }
        }
        return false; // Debunking failed due to invalid inputs or null references
    }
    
    @Override
    public void TransmuteIngredient(Player player, Ingredient ingredient) {
        super.TransmuteIngredient(player, ingredient);
    }
    
    @Override
    public void Make_experiments(Player player, Potion potion, Boolean TestOnSelf) {
        super.Make_experiments(player, potion, TestOnSelf);
    }
    
    @Override
    public void BuyArtifacts(Player player, Artifact artifact) {
        super.BuyArtifacts(player, artifact);
    }
    
    @Override
    public Potion MakePotion(Ingredient.AspectTrio AspectTrio1, Ingredient.AspectTrio AspectTrio2) {
        return super.MakePotion(AspectTrio1, AspectTrio2);
    }
    
    @Override
    public Ingredient ForageForIngredient(Player player) {
        return super.ForageForIngredient(player);
    }
    
    @Override
    public boolean publishTheory(Player currentPlayer, Ingredient selectedIngredient, ArrayList<Aspect> alchemyMarker,
                                 Integer certainityPoint) {
        return super.publishTheory(currentPlayer, selectedIngredient, alchemyMarker, certainityPoint);
    }
    
    @Override
    public Potion removePotion(HashMap<Potion, Integer> Potions, Potion potion) {
        return super.removePotion(Potions, potion);
    }
    
    @Override
    public Potion sellPotion(Inventory inventory, Potion potion, Guarantee guarantee) {
        return super.sellPotion(inventory, potion, guarantee);
    }
    
    // All of the Functions above is false, and not usable, it is just for practice
    public ArrayList<Artifact> UseArtifactForOnce (Player currentPlayer, Artifact artifactCard){ // This function is not working
        ArrayList<Artifact> topThreeArray = new ArrayList<Artifact>();
        if(currentPlayer.getPlayerInventory().getArtifacts().containsKey(artifactCard)){
            topThreeArray = artifactCard.elixirOfInsight();
            return topThreeArray;
        }
        return topThreeArray; // Todo raise error
    }
    public ArrayList<Artifact> reArrange(ArrayList<Artifact> firstThreeCard){  // This function is not working
        ArrayList<Artifact> reArrangedfirstThreeCard = new ArrayList<Artifact>();
        reArrangedfirstThreeCard.add(firstThreeCard.get(1));
        reArrangedfirstThreeCard.add(firstThreeCard.get(2));
        reArrangedfirstThreeCard.add(firstThreeCard.get(0));
        return reArrangedfirstThreeCard;
    }
    public boolean UseArtifactEveryRound(PublicationCard pubCard1, PublicationCard pubCard2){ // This function is not working
        ArrayList<Aspect> aspect_1 = pubCard1.getAspects();
        ArrayList<Aspect> aspect_2 = pubCard2.getAspects();
        pubCard1.setAspects(aspect_2);
        pubCard2.setAspects(aspect_1);
        return true;
    }
}
