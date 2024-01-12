package Domain;

import Models.*;

import java.util.HashMap;

public class RoundThreeController extends RoundTwoController{
    public boolean debunkTheory(Player currentPlayer, PublicationCard publicationCardToDebunk, Aspect.Colors aspectColorToDebunk) {
        System.out.println("Debunking theory...");
        boolean WisdomIdolFlag = false;
       
        if (publicationCardToDebunk != null && aspectColorToDebunk != null) {
            // Check if the ingredient has a published theory
            if(isWisdomIdolAvailable(publicationCardToDebunk.getOwner())){
                WisdomIdolFlag = true;
            }
            if (PublicationTrack.getInstance().isPublished(publicationCardToDebunk)) {
                if (aspectColorToDebunk == Aspect.Colors.Red) {
                    if (publicationCardToDebunk.getAspects().getAspectRed().isEqual(Ingredient.getAspects(publicationCardToDebunk.getIngredient()).getAspectRed())) {
                        currentPlayer.addReputation(-1);
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else if (aspectColorToDebunk == Aspect.Colors.Green) {
                    if (publicationCardToDebunk.getAspects().getAspectGreen().isEqual(Ingredient.getAspects(publicationCardToDebunk.getIngredient()).getAspectGreen())) {
                        currentPlayer.addReputation(-1);
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else if (aspectColorToDebunk == Aspect.Colors.Blue) {
                    if (publicationCardToDebunk.getAspects().getAspectBlue().isEqual(Ingredient.getAspects(publicationCardToDebunk.getIngredient()).getAspectBlue())) {
                        currentPlayer.addReputation(-1);
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                }
                    currentPlayer.addReputation(2);
                    publicationGotDebunked(publicationCardToDebunk);
                    if (WisdomIdolFlag == true){
                        publicationCardToDebunk.getOwner().addReputation(2); //changed from 1 to 2 since it felt weak
                        useWisdomIdol(publicationCardToDebunk.getOwner());
                    }
                System.out.println("A theory was debunked!");
                    return true;
            } else {
                // Ingredient doesn't have a published theory, debunking not allowed
                // TODO: Raise error
                return false;
            }
        }
        return false; // Debunking failed due to invalid inputs or null references
    }
    
    public void publicationGotDebunked(PublicationCard card){
        card.getOwner().addReputation(-4);
        HashMap<Integer, Player> map = card.getEndorsers();
        if (map.get(1)!=null){map.get(1).addReputation(-3);}
        if (map.get(2)!=null){map.get(2).addReputation(-2);}
        if (map.get(3)!=null){map.get(3).addReputation(-1);}
        PublicationTrack.getInstance().removePublicationCard(card);
    }
    //TODO: add function for when the publications turns out to be true (likely endgame controller)
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
    public boolean elixirRearrange(Ingredient.IngredientTypes ing1, Ingredient.IngredientTypes ing2, Ingredient.IngredientTypes ing3){
        HashMap<Integer, Ingredient.IngredientTypes> toSet = new HashMap<>();
        toSet.put(0,ing1);
        toSet.put(1,ing2);
        toSet.put(2,ing3);
        Deck.getInstance().setFirstThree(toSet);
        return true;
    }
    
    public boolean checkIfIngredientIsPublished(Ingredient.IngredientTypes type){
        for (PublicationCard card:PublicationTrack.getInstance().getPublicationCards()){
            if (card.getIngredient()==type){
                return true;
            }
        }
        return false;
    }
    

}
