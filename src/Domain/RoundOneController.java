package Domain;

import Models.*;

import java.util.HashMap;

public class RoundOneController {
    
    protected RoundOneController() { }

    public void nextPlayer(){
        Player.nextPlayer();
    }
    public Ingredient ForageForIngredient (Player player) {
        if(player.getForageRight() >= 1){
            Deck deck = Deck.getInstance();
            Ingredient ingredient = deck.popIngredient();
            player.getInventory()
                    .addIngredient(ingredient, 1);
            player.setForageRight(player.getForageRight()-1);
            return ingredient;
        }
        else {
            return null;
        }
        
    }
    
    public void TransmuteIngredient(Player player, Ingredient.IngredientTypes ingredientType) {
        if (player.isInInventory(ingredientType)) {
            player.removeFromInventory(ingredientType);
            player.getInventory().setGold(player.getInventory().getGold() + 1);
        }
    }
    
    public void BuyArtifacts(Player player, Artifact artifact) {
        HashMap<Artifact, Integer> artifacts = player.getInventory().getArtifacts();
        if (player.getInventory().getGold() > 3) {
            
            artifacts.put(artifact, artifacts.get(artifact) + 1);
            player.getInventory().setGold(player.getInventory().getGold() - 3);
        }
    }
    
    public void Make_experiments(Player player, Potion potion,
                                 Boolean TestOnSelf) {//TODO Other cases will be implemented.
        if (TestOnSelf) {
            if (potion.getSign() == Potion.Signs.Negative) {//If negative get sickness
                player.setSicknessLevel(player.getSicknessLevel() + 1);
                if (player.getSicknessLevel() >= 3) {
                    player.haveSurgery();
                }
            }
        } else {// Testing on Student
            if (potion.getSign() == Potion.Signs.Negative) {//If negative lose 1 gold
                player.getInventory().setGold(player.getInventory().getGold() - 1);
            }
            
        }
    }
    
    public Potion MakePotion(Ingredient.AspectTrio AspectTrio1,
                             Ingredient.AspectTrio AspectTrio2) {//Takes 2 AspectTrios and outputs a Potion.
        if (CompareTwoAspects(AspectTrio1.getAspectBlue(), AspectTrio2.getAspectBlue())) {
            if (AspectTrio1.getAspectBlue()
                    .getPositivity() == Aspect.Positivities.Positive) {// If both of them are same we only need to check one.
                return new Potion(Potion.Colors.Blue, Potion.Signs.Positive);
            } else {
                return new Potion(Potion.Colors.Blue, Potion.Signs.Negative);
            }
        } else if (CompareTwoAspects(AspectTrio1.getAspectRed(), AspectTrio2.getAspectRed())) {
            if (AspectTrio1.getAspectRed().getPositivity() == Aspect.Positivities.Positive) {
                return new Potion(Potion.Colors.Red, Potion.Signs.Positive);
            } else {
                return new Potion(Potion.Colors.Red, Potion.Signs.Negative);
            }
            
        } else if (CompareTwoAspects(AspectTrio1.getAspectGreen(), AspectTrio2.getAspectGreen())) {
            if (AspectTrio1.getAspectGreen().getPositivity() == Aspect.Positivities.Positive) {
                return new Potion(Potion.Colors.Green, Potion.Signs.Positive);
            } else {
                return new Potion(Potion.Colors.Green, Potion.Signs.Negative);
            }
            
        } else {
            return new Potion(Potion.Colors.Colorless, Potion.Signs.Neutral);
        }
        
        
    }
    public void removeIngredient(Player player ,Ingredient ingredient){
        player.removeFromInventory(ingredient.getType());
    }
    
    private Boolean CompareTwoAspects(Aspect aspect1, Aspect aspect2) {
        return aspect1.getPositivity() == aspect2.getPositivity();
    }
    
    public boolean MagicMortar(Player current, Artifact artifact, Ingredient ingredient){
        if(current.getInventory().getArtifacts().containsKey(artifact)){
            if (artifact.getName().equals("Magic Mortar")){
                current.getInventory().getArtifacts().remove(artifact);
                current.getInventory().addIngredient(ingredient, 1);
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean PrintingPress(Player current, Artifact artifact){
        if(current.getInventory().getArtifacts().containsKey(artifact)){
            if(artifact.getName().equals("Printing Press")){
                current.getInventory().getArtifacts().remove(artifact);
                current.getInventory().addGold(1);
                return true;
            }
            return false;
        }
        return false;
    }
    
}
