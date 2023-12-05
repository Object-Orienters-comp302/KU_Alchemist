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
    
    
}