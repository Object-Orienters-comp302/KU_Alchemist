package Models;

import java.util.ArrayList;
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
    
    public static ArrayList<Artifact> createArtifacts(){  //no looping because effects likely be different
        ArrayList<Artifact> list = new ArrayList<>();
        Artifact art1 = new Artifact(Name.Elixir_of_Insight,AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        Artifact art2 = new Artifact(Name.Magic_Mortar,AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        Artifact art3 = new Artifact(Name.Printing_Press,AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        Artifact art4 = new Artifact(Name.Wisdom_Idol,AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        list.add(art1);list.add(art2);list.add(art3);list.add(art4);
        return list;
    }
    
    @Override
    public String toString() {
        return this.getName().toString();
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