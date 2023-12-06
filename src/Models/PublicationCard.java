package Models;

import java.util.ArrayList;

public class PublicationCard {
    private final int               pointValue;
    private  ArrayList<Aspect> Aspects; //3 Aspects.
    private final Ingredient        Ingredient;
    
    public PublicationCard(Ingredient Ingredient, ArrayList<Aspect> aspects, int pointValue) {
        this.Ingredient = Ingredient;
        Aspects         = aspects;
        this.pointValue = pointValue;
    }
    
    public ArrayList<Aspect> getAspects() {
        return Aspects;
    }
    
    public int getPointValue()        { return pointValue; }
    
    public Ingredient getIngredient() { return Ingredient; }
    
    public void setAspects(ArrayList<Aspect> aspects){ // Todo delete if there is a fault
        this.Aspects = aspects;
    }
}






