package Models;

import java.util.ArrayList;

public class PublicationCard {
    private final int               pointValue;
    private  ArrayList<Aspect> Aspects; //3 Aspects.
    private final Ingredient        Ingredient;
    
    private final Player Owner;
    
    public PublicationCard(Ingredient Ingredient, ArrayList<Aspect> aspects, int pointValue, Player owner) {
        this.Ingredient = Ingredient;
        Aspects         = aspects;
        this.pointValue = pointValue;
        this.Owner = owner;
    }
    
    public ArrayList<Aspect> getAspects() {
        return Aspects;
    }
    
    public int getPointValue()        { return pointValue; }
    
    public Ingredient getIngredient() { return Ingredient; }
    
    public Player getOwner() { return Owner; }
    
    public void setAspects(ArrayList<Aspect> aspects){ // Todo delete if there is a fault
        this.Aspects = aspects;
    }
}






