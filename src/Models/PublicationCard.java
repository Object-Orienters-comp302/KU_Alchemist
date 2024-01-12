package Models;

import java.util.ArrayList;
import java.util.HashMap;

public class PublicationCard {

    private       Models.Ingredient.AspectTrio Aspects; //3 Aspects.
    private final Ingredient.IngredientTypes                   Ingredient;
    
    private final Player Owner;
    private HashMap<Integer,Player> playersThatEndorsed;
    
    public PublicationCard(Ingredient.IngredientTypes Ingredient, Models.Ingredient.AspectTrio aspects, Player owner) {
        this.Ingredient = Ingredient;
        this.Aspects         = aspects;
        this.Owner = owner;
        this.playersThatEndorsed = new HashMap<>();
        playersThatEndorsed.put(1,null);playersThatEndorsed.put(2,null);playersThatEndorsed.put(3,null);
        PublicationTrack.getInstance().addPublicationCard(this);
    }
    
    public Models.Ingredient.AspectTrio getAspects() {
        return Aspects;
    }
    
   
    
    public Ingredient.IngredientTypes getIngredient() { return Ingredient; }
    
    public Player getOwner() { return Owner; }
    
    public void setAspects(Models.Ingredient.AspectTrio aspects){ // Todo delete if there is a fault
        this.Aspects = aspects;
    }
    
    public void addEndorser(int i,Player player){
        if (player==Owner){
            throw new RuntimeException("cannot endorse your own theory??");
        }
        playersThatEndorsed.put(i,player);
    }
    public HashMap<Integer,Player> getEndorsers(){
        return  playersThatEndorsed;
    }
    public boolean playerCanEndorse(Player player){
        if (Owner!=player && !playersThatEndorsed.values().contains(player)){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Ingredient: "+ getIngredient()+ " Claimed: " + getAspects() + " Real: "+ Models.Ingredient.getIngredientTypeToAspectTrioMap().get(getIngredient());
    }
}






