package Domain;

import Models.*;

public class RoundOneController {
    
    protected RoundOneController() { }


    public Ingredient ForageForIngredient (Player player) {
        if(player.getForageRight() >= 1){
            Deck deck = Deck.getInstance();
            Ingredient ingredient = deck.popIngredient();
            player.getInventory()
                    .addIngredient(ingredient.getType(), 1);
            player.setForageRight(player.getForageRight()-1);
            return ingredient;
        }
        else {
            return null;
        }
        
    }
    
    public void TransmuteIngredient(Player player, Ingredient.IngredientTypes ingredientType) {
        if (player.getInventory().isInInventory(ingredientType)) {
            player.getInventory().removeIngredient(ingredientType);
            player.getInventory().setGold(player.getInventory().getGold() + 1);
        }
    }
    
    public Artifact BuyArtifacts(Player player) {
        if (player.getInventory().getGold() > 3) {
            Artifact artifact = Deck.getInstance().popArtifact();
            player.getInventory().addArtifactCard(artifact.getName(), 1);
            player.getInventory().setGold(player.getInventory().getGold() - 3);
            return artifact;
        }
        return null;
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
    public void removeIngredient(Player player , Ingredient.IngredientTypes ingredient){
        player.getInventory().removeIngredient(ingredient);
    }
    
    private Boolean CompareTwoAspects(Aspect aspect1, Aspect aspect2) {
        return aspect1.getPositivity() == aspect2.getPositivity();
    }
    
    public boolean MagicMortar(Player current, Artifact.Name artifactName, Ingredient.IngredientTypes ingredient){
        if(current.getInventory().getArtifacts().containsKey(artifactName)){
            if (artifactName.equals(Artifact.Name.Magic_Mortar)){
                current.getInventory().getArtifacts().remove(artifactName);
                current.getInventory().addIngredient(ingredient, 1);
                return true;
            }
        }
        return false;
    }
    
    public boolean PrintingPress(Player current, Artifact.Name artifactName){
        if(current.getInventory().getArtifacts().containsKey(artifactName)){
            if(artifactName.equals(Artifact.Name.Printing_Press)){
                current.getInventory().addGold(1);
                return true;
            }
        }
        return false;
    }
    public boolean WisdomIdol(Player current){
        if(current.getInventory().checkArtifactExists(Artifact.Name.Wisdom_Idol)){
                current.getInventory().removeArtifact(Artifact.Name.Wisdom_Idol);
                return true;
        }
        return false;
    }
    
}
