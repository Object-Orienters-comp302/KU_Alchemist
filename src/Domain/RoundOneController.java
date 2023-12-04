package Domain;

import Models.*;

import java.util.HashMap;

public class RoundOneController {

    protected RoundOneController() { }
    public void ForageForIngredient (Player player) {
        Deck deck = Deck.getInstance();
        player.getPlayerInventory()
                .addIngredient(deck.popIngredient(), 1);
    }
    
    public void TransmuteIngredient (Player player, Ingredient ingredient) {
        HashMap<Ingredient, Integer> ingredients = player.getPlayerInventory()
                .getIngredients();
        if (ingredients.get(ingredient) > 0) {
            
            ingredients.put(ingredient, ingredients.get(ingredient) - 1);
            player.getPlayerInventory()
                    .setGold(player.getPlayerInventory()
                                     .getGold() + 1);
        }
    }
    
    public void BuyArtifacts (Player player, Artifact artifact) {
        HashMap<Artifact, Integer> artifacts = player.getPlayerInventory()
                .getArtifacts();
        if (player.getPlayerInventory()
                .getGold() > 3) {
            
            artifacts.put(artifact, artifacts.get(artifact) + 1);
            player.getPlayerInventory()
                    .setGold(player.getPlayerInventory()
                                     .getGold() - 3);
        }
    }
    
    public void Make_experiments (Player player, Ingredient ingredient_1, Ingredient ingredient_2) {
    
    }
    private Potion CompareAspectTrios (Ingredient.AspectTrio AspectTrio1, Ingredient.AspectTrio AspectTrio2){//Takes 2 AspectTrios and outputs a Potion.
        if(CompareTwoAspects(AspectTrio1.getAspectBlue(), AspectTrio2.getAspectBlue())){
            if(AspectTrio1.getAspectBlue().getPositivity()== Aspect.Positivities.Positive){// If both of them are same we only need to check one.
                return new Potion(Potion.Colors.Blue, Potion.Signs.Positive);
            }
            else {
                return new Potion(Potion.Colors.Blue, Potion.Signs.Negative);
            }
        } else if(CompareTwoAspects(AspectTrio1.getAspectRed(), AspectTrio2.getAspectRed())){
            if(AspectTrio1.getAspectRed().getPositivity()== Aspect.Positivities.Positive){
                return new Potion(Potion.Colors.Red, Potion.Signs.Positive);
            }
            else {
                return new Potion(Potion.Colors.Red, Potion.Signs.Negative);
            }
            
        } else if(CompareTwoAspects(AspectTrio1.getAspectGreen(), AspectTrio2.getAspectGreen())){
            if(AspectTrio1.getAspectGreen().getPositivity()== Aspect.Positivities.Positive){
                return new Potion(Potion.Colors.Green, Potion.Signs.Positive);
            }
            else {
                return new Potion(Potion.Colors.Green, Potion.Signs.Negative);
            }
            
        } else{
            return new Potion(Potion.Colors.Colorless, Potion.Signs.Neutral);
        }
        
        
    }
    private Boolean CompareTwoAspects(Aspect aspect1, Aspect aspect2){
        return aspect1.getPositivity() == aspect2.getPositivity();
    }
    //TODO Add Make Experiment
    
}
