package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PublicationTrack implements Serializable {
    private static PublicationTrack      single_instance;
    private final  List<PublicationCard> publicationCards;
    
    private PublicationTrack() {
        publicationCards = new ArrayList<>();
        
        PublicationTrack.single_instance = this;
    }
    
    public static synchronized PublicationTrack getInstance() {
        if (single_instance == null) { single_instance = new PublicationTrack(); }
        
        return single_instance;
    }
    
    public void addPublicationCard(PublicationCard publicationCard) {
        publicationCards.add(publicationCard);
    }
    
    public void removePublicationCard(PublicationCard publicationCard) {
        publicationCards.remove(publicationCard);
    }
    
    public boolean isInPublicationTrack(Ingredient.IngredientTypes ingredient, Ingredient.AspectTrio aspects) {
        List<PublicationCard> publicationCards = getPublicationCards();
        boolean isPublishedIngredient = false; // True if the ingredient has a theory about itself
        boolean isPublishedAspects = false; // True if the aspect was used to publish an ingredient
        
        for (PublicationCard card : publicationCards) {
            if (card.getIngredient().equals(ingredient)) {
                isPublishedIngredient = true; // PublicationCard ingredient found in the track
            }
            if (card.getAspects().equals(aspects)) {
                isPublishedAspects = true;  // PublicationCard aspects found in the track
            }
        }
        return isPublishedAspects || isPublishedIngredient;// PublicationCard found in the track
    }
    
    public List<PublicationCard> getPublicationCards() {
        return publicationCards;
    }
    
    public boolean isPublished(PublicationCard publicationCard) {
        // Checks if the given pCard is published in publicationTrack
        List<PublicationCard> publicationCards = getPublicationCards();
        
        for (PublicationCard card : publicationCards) {
            if (card.equals(publicationCard)) {
                return true; // PublicationCard found in the track
            }
        }
        return false;
    }
    public boolean isPublished(Ingredient.IngredientTypes type) {
        // Checks if the given pCard is published in publicationTrack
        List<PublicationCard> publicationCards = getPublicationCards();
        
        for (PublicationCard card : publicationCards) {
            if (card.getIngredient()==type) {
                return true; // PublicationCard found in the track
            }
        }
        return false;
    }
    
    public PublicationCard getPublicationCardOf(Ingredient.IngredientTypes type){
        for (PublicationCard card : publicationCards) {
            if (card.getIngredient()==type) {
                return card;
            }
        }
        return null;
    }
}