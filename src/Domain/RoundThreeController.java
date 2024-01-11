package Domain;

import Models.*;

import java.util.HashMap;
import java.util.List;

public class RoundThreeController extends RoundTwoController{
    public boolean debunkTheory(Player currentPlayer, PublicationCard publicationCardToDebunk,
                                Aspect aspectTypeToDebunk) {
        boolean WisdomIdolFlag = false;
       
        if (publicationCardToDebunk != null && aspectTypeToDebunk != null) {
            // Check if the ingredient has a published theory
            if(isWisdomIdolAvailable(publicationCardToDebunk.getOwner())){
                WisdomIdolFlag = true;
            }
            if (PublicationTrack.getInstance().isPublished(publicationCardToDebunk)) {
                if (aspectTypeToDebunk.getColor() == Aspect.Colors.Red) {
                    
                    if (aspectTypeToDebunk.isEqual(
                            Ingredient.getAspects(publicationCardToDebunk.getIngredient()).getAspectRed())) {
                        currentPlayer.addReputation(-1);
                       
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else if (aspectTypeToDebunk.getColor() == Aspect.Colors.Green) {
                    if (aspectTypeToDebunk.isEqual(
                            Ingredient.getAspects(publicationCardToDebunk.getIngredient()).getAspectGreen())) {
                        currentPlayer.addReputation(-1);
                        
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else if (aspectTypeToDebunk.getColor() == Aspect.Colors.Blue) {
                    if (aspectTypeToDebunk.isEqual(
                            Ingredient.getAspects(publicationCardToDebunk.getIngredient()).getAspectBlue())) {
                        currentPlayer.addReputation(-1);
                       
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                }
                    currentPlayer.addReputation(2);
                    publicationCardToDebunk.getOwner().addReputation(-1);
                    if (WisdomIdolFlag == true){
                        publicationCardToDebunk.getOwner().addReputation(1);
                        useWisdomIdol(publicationCardToDebunk.getOwner());
                    }
                    return true;
                
                
                
            } else {
                // Ingredient doesn't have a published theory, debunking not allowed
                // TODO: Raise error
                return false;
            }
        }
        return false; // Debunking failed due to invalid inputs or null references
    }
    
    public Deck getDeck(){
        return Deck.getInstance();
    }
    public boolean useElixirOfInsight(Player currentPlayer, Artifact artifactCard){
        if (artifactCard != null && currentPlayer.getInventory().getArtifacts().contains(artifactCard)) {
            if (artifactCard.getAbilityType().equals(Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT)) {
                Deck.getInstance().getFirstThree();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean elixirRearrange(Ingredient ing1, Ingredient ing2, Ingredient ing3){
        HashMap<Integer, Ingredient> toSet = new HashMap<>();
        toSet.put(0,ing1);
        toSet.put(1,ing2);
        toSet.put(2,ing3);
        Deck.getInstance().setFirstThree(toSet);
        return true;
    }
    public List<PublicationCard> getPublicationCards(){
        return PublicationTrack.getInstance().getPublicationCards();
    }
    public boolean checkIfIngredientIsPublished(Ingredient.IngredientTypes type){
        for (PublicationCard card: getPublicationCards()){
            if (card.getIngredient()==type){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkIfAspectIsPublished(Ingredient.AspectTrio asp){
        for (PublicationCard card: getPublicationCards()){
            if (card.getAspects()==asp){
                return true;
            }
        }
        return false;
    }

}
