package Domain;
import Models.*;
import Domain.RoundOneController;
import Domain.RoundTwoController;
import java.util.HashMap;
public class RoundThreeController {
    public boolean debunkTheory (Player currentPlayer, PublicationCard publicationCardToDebunk, Aspect aspectTypeToDebunk) {
        if (publicationCardToDebunk != null && aspectTypeToDebunk != null) {
            // Check if the ingredient has a published theory
            if (PublicationTrack.getInstance().isPublished(publicationCardToDebunk)) {
                if(aspectTypeToDebunk.getColor() == Aspect.Colors.Red){
                   if(aspectTypeToDebunk.isEqual(publicationCardToDebunk.getIngredient().getAspects().getAspectRed())){
                       return false; // aspect type is not debunked, because aspect is not false
                   }
                } else if (aspectTypeToDebunk.getColor() == Aspect.Colors.Green) {
                    if(aspectTypeToDebunk.isEqual(publicationCardToDebunk.getIngredient().getAspects().getAspectGreen())){
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                } else if (aspectTypeToDebunk.getColor() == Aspect.Colors.Blue) {
                    if(aspectTypeToDebunk.isEqual(publicationCardToDebunk.getIngredient().getAspects().getAspectBlue())){
                        return false; // aspect type is not debunked, because aspect is not false
                    }
                }
                else {
                    currentPlayer.addReputation(2);
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
}