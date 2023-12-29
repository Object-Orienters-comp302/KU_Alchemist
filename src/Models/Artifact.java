package Models;

import java.util.HashMap;

public class Artifact {
    private final Name name;
    
    private final AbilityType abilityType; // Enum to represent the type of ability
    
    public Artifact(Name name, AbilityType abilityType) {
        this.name = name;
        
        this.abilityType = abilityType;
    }
    
    public Name getName() {
        return name;
    }
    
    public AbilityType getAbilityType() {
        return abilityType;
    }
    
    /// The Integer is the order of the cards.
    public HashMap<Ingredient, Integer> elixirOfInsightView() {
        return Deck.getInstance().getFirstThree();
    }
    
    /// The Key is the Ingredient, and the value is the order to set it into the deck, must be 0, 1, 2.
    public void elixirOfInsightView(HashMap<Ingredient, Integer> to_set) {
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
        Wisdom_Idol
    }
}