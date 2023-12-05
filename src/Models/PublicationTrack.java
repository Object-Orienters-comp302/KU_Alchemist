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
    public boolean searchInPublicationTrack(Ingredient ingredient, ArrayList<Aspect> aspects) {
        List<PublicationCard> publicationCards = getPublicationCards();
        int flag_ingredient = 0;
        int flag_aspects = 0;
        for (PublicationCard card : publicationCards) {
            if (card.getIngredient().equals(ingredient)) {
                flag_ingredient = 1; // PublicationCard ingredient found in the track
            }
            if (card.getAspects().equals(aspects)) {
                flag_aspects = 1;  // PublicationCard aspects found in the track
            }
        }
        if (flag_aspects == 0 && flag_ingredient == 0){
            return false;
        }
        return true; // PublicationCard found in the track
    }
    
}