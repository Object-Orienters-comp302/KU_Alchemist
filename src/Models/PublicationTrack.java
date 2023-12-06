package Models;

import java.util.ArrayList;
import java.util.List;

public class PublicationTrack {
    private static PublicationTrack       single_instance;
    private final List<PublicationCard> publicationCards;
    
    private PublicationTrack() {
        publicationCards = new ArrayList<>();
        
        PublicationTrack.single_instance = this;
    }
    
    public static synchronized PublicationTrack getInstance () {
        if (single_instance == null) { single_instance = new PublicationTrack(); }
        
        return single_instance;
    }
    
    public List<PublicationCard> getPublicationCards() {
        return publicationCards;
    }
    
    public void addPublicationCard(PublicationCard publicationCard) {
        publicationCards.add(publicationCard);
    }
    
    public void removePublicationCard(PublicationCard publicationCard) {
        publicationCards.remove(publicationCard);
    }
    public boolean isInPublicationTrack(Ingredient ingredient, ArrayList<Aspect> aspects) {
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
        if (!isPublishedAspects && !isPublishedIngredient){
            return false;
        }
        return true; // PublicationCard found in the track
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
}