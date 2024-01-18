package Models;

import java.util.HashMap;

public class Artifact {
    private final Artifact.Name name;
    
    private final Artifact.AbilityType abilityType; // Enum to represent the type of ability
    private boolean used=false;
    
    @Deprecated
    public Artifact(Artifact.Name name, Artifact.AbilityType abilityType) {
        this.name = name;
        this.abilityType = abilityType;
    }
    @Deprecated
    public Artifact.Name getName() {
        return name;
    }
    public boolean isUsed(){
        return used;
    }
    public void gotUsed(){
        used=true;
    }
    public Artifact.AbilityType getAbilityType() {
        return abilityType;
    }
    
    /// The Integer is the order of the cards.
    public HashMap<Integer, Ingredient.IngredientTypes> elixirOfInsightView() {
        return Deck.getInstance().getFirstThree();
    }
    
    /// The Value is the Ingredient, and the key is the order to set it into the deck, must be 0, 1, 2.
    public void elixirOfInsightView(HashMap<Integer, Ingredient.IngredientTypes> to_set) {
        Deck.getInstance().setFirstThree(to_set);
    }
    
    
    public enum AbilityType {
        IMMEDIATE_ONE_TIME_EFFECT,
        MULTIPLE_TIMES_EFFECT_PER_ROUND
    }
    
    public enum Name {
        Elixir_of_Insight,
        Magic_Mortar,
        Printing_Press,
        Wisdom_Idol,
        Pistol_of_Sickness_Classic,
        Pistol_of_Sickness_Silver,
        Pistol_of_Sickness_Gold,
        Letter_of_DissContent_Blue,
        Letter_of_DissContent_Red,
        Inquisition_Accusation,
        Big_Black_Chicken,
        Magical_Boar,
        Mystic_Meerkat,
        Hunting_Phoenix,
        Chair_of_Alchemy,
        Syringe_Kit_Basic1,
        Syringe_Kit_Basic2,
        Elixir_of_Healing,
    }
}
