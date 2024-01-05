package Domain;

import Models.*;

public class RoundOneController {
    
    protected RoundOneController() { }


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
    
    public Artifact BuyArtifacts(Player player) {

        if (player.getInventory().getGold() >= 3) {
            Artifact artifact =Deck.getInstance().popArtifact();
            player.getInventory().addArtifactCard(artifact, 1);
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
        if(AspectTrio1 == null || AspectTrio2 == null){
            throw  new NullPointerException("Any AspectTrio can't be null");
        }
        if(AspectTrio1 == AspectTrio2){
            throw new RuntimeException("Two trios can't be same");
        }
        
        if (CompareTwoAspects(AspectTrio1.getAspectBlue(), AspectTrio2.getAspectBlue())) {
            if (CompareTwoAspectSizes(AspectTrio1.getAspectBlue(),AspectTrio2.getAspectBlue())) {// If both of them are same we only need to check one.
                return new Potion(Potion.Colors.Blue, changePositivityToSign(AspectTrio1.getAspectBlue().getPositivity()));
            }
        } else if (CompareTwoAspects(AspectTrio1.getAspectRed(), AspectTrio2.getAspectRed())) {
            if (CompareTwoAspectSizes(AspectTrio1.getAspectRed(),AspectTrio2.getAspectRed())) {
                return new Potion(Potion.Colors.Red,changePositivityToSign(AspectTrio1.getAspectRed().getPositivity()));
            }
            
        } else if (CompareTwoAspects(AspectTrio1.getAspectGreen(), AspectTrio2.getAspectGreen())) {
            if (CompareTwoAspectSizes(AspectTrio1.getAspectGreen(),AspectTrio2.getAspectGreen())) {
                return new Potion(Potion.Colors.Green, changePositivityToSign(AspectTrio1.getAspectGreen().getPositivity()));
            }
            
        }
        else {
            return new Potion(Potion.Colors.Colorless, Potion.Signs.Neutral);
        }
        
        return new Potion(Potion.Colors.Colorless, Potion.Signs.Neutral);
    }
    public Potion.Signs changePositivityToSign(Aspect.Positivities pos){
        switch (pos){
            case Positive -> { return Potion.Signs.Positive; }
            case Negative -> { return Potion.Signs.Negative; }
            case null, default -> throw new NullPointerException();
        }
    }
    public void removeIngredient(Player player ,Ingredient ingredient){
        player.removeFromInventory(ingredient.getType());
    }
    
    private Boolean CompareTwoAspects(Aspect aspect1, Aspect aspect2) {
        return aspect1.getPositivity() == aspect2.getPositivity();
    }
    private Boolean CompareTwoAspectSizes(Aspect aspect1, Aspect aspect2){
        return !(aspect1.getSize() == aspect2.getSize());
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
                current.getInventory().addGold(1);
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean WisdomIdol(Player current){
        if(current.getInventory().checkArtifactExists("Wisdom Idol")){
                current.getInventory().removeArtifact("Wisdom Idol");
                return true;
        }
        return false;
    }
    
}
