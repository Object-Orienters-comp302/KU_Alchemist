package Domain;

import Models.*;

import java.util.HashMap;

public class RoundOneController {
    
    protected RoundOneController() { }


    public Ingredient.IngredientTypes ForageForIngredient (Player player) {
        if(player.getForageRight() >= 1){
            Deck deck = Deck.getInstance();
            Ingredient.IngredientTypes ingredient = deck.popIngredient();
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
        if (player.getInventory().isInInventory(ingredientType)) {
            player.getInventory().removeIngredient(ingredientType, 1);
            player.getInventory().setGold(player.getInventory().getGold() + 1);
        }
    }
    
    /**
     * Buys an artifact for a player if they have enough gold.
     *
     * @param player The player attempting to buy an artifact.
     * @return       The purchased artifact, or null if the player doesn't have enough gold or no artifacts are available.
     * @throws       IllegalArgumentException if the deck has no artifacts left.
     */
    public Artifact BuyArtifacts(Player player) {
        final int artifactCost = 3;
        
        if (player.getInventory().getGold() < artifactCost) {
            return null; // Not enough gold
        }
        
        Artifact artifact = Deck.getInstance().popArtifact();
        if (artifact == null) {
            throw new IllegalArgumentException("No Artifacts are left in the Deck!");
        }
        
        // Process the purchase
        player.getInventory().addArtifactCard(artifact);
        player.getInventory().setGold(player.getInventory().getGold() - artifactCost);
        
        return artifact;
    }
    
    
    
    public void Make_experiments(Player player, Potion potion,
                                 Boolean TestOnSelf) {//TODO Other cases will be implemented.
        if (TestOnSelf) {
            if (potion.getSign() == Potion.Signs.Negative) {//If negative get sickness
                player.setHealthLevel(player.getHealthLevel() - 1);
                /*
                if (player.getHealthLevel() <= -3) {
                    player.haveSurgery();
                }
                 */
            }
            if (potion.getSign()==Potion.Signs.Positive){
                player.setHealthLevel(player.getHealthLevel() + 1);
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
        } if (CompareTwoAspects(AspectTrio1.getAspectRed(), AspectTrio2.getAspectRed())) {
            if (CompareTwoAspectSizes(AspectTrio1.getAspectRed(),AspectTrio2.getAspectRed())) {
                return new Potion(Potion.Colors.Red,changePositivityToSign(AspectTrio1.getAspectRed().getPositivity()));
            }
            
        } if (CompareTwoAspects(AspectTrio1.getAspectGreen(), AspectTrio2.getAspectGreen())) {
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
    public void removeIngredient(Player player , Ingredient.IngredientTypes ingredient){
        player.getInventory().removeIngredient(ingredient, 1);
    }
    
    private Boolean CompareTwoAspects(Aspect aspect1, Aspect aspect2) {
        return aspect1.getPositivity() == aspect2.getPositivity();
    }
    private Boolean CompareTwoAspectSizes(Aspect aspect1, Aspect aspect2){
        return !(aspect1.getSize() == aspect2.getSize());
    }
    public Deck getDeck(){
        return Deck.getInstance();
    }
    
    //ARTIFACTS
    
    public void ElixirOfInsightAbility(HashMap<Integer, Ingredient.IngredientTypes> map){
        GameController.getInstance().getRoundOneController().getDeck().setFirstThree(map);
    }
    public void PistolOfSicknessAbility(Player target,int value){
        target.setHealthLevel(target.getHealthLevel()-value);
    }
    
    public boolean MagicMortar(Player current, Artifact.Name artifactName, Ingredient.IngredientTypes ingredient){
        if(current.getInventory().checkArtifactExists(artifactName)){
            if (artifactName.equals(Artifact.Name.Magic_Mortar)){
                current.getInventory().getArtifacts().remove(artifactName);
                current.getInventory().addIngredient(ingredient, 1);
                return true;
            }
        }
        return false;
    }
    
    public boolean PrintingPress(Player current, Artifact.Name artifactName){
        if(current.getInventory().checkArtifactExists(artifactName)){
            if(artifactName.equals(Artifact.Name.Printing_Press)){
                current.getInventory().addGold(1);
                return true;
            }
        }
        return false;
    }
    public boolean isWisdomIdolAvailable(Player current){
        return current.getInventory().checkArtifactExists(Artifact.Name.Wisdom_Idol);
    }
    
    public void useWisdomIdol(Player current){ //TODO: Fix this horrible naming
        current.getInventory().removeArtifact(Artifact.Name.Wisdom_Idol);
    }
    
}
