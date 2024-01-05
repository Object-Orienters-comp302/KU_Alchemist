package Models;

import java.util.ArrayList;

public class PublicationCard {

    private       Models.Ingredient.AspectTrio Aspects; //3 Aspects.
    private final Ingredient                   Ingredient;
    
    private final Player Owner;
    
    public PublicationCard(Ingredient Ingredient, Models.Ingredient.AspectTrio aspects, Player owner) {
        this.Ingredient = Ingredient;
        this.Aspects         = aspects;
        this.Owner = owner;
    }
    
    public Models.Ingredient.AspectTrio getAspects() {
        return Aspects;
    }
    
   
    
    public Ingredient getIngredient() { return Ingredient; }
    
    public Player getOwner() { return Owner; }
    
    public void setAspects(Models.Ingredient.AspectTrio aspects){ // Todo delete if there is a fault
        this.Aspects = aspects;
    }
}






