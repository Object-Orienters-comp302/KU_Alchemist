package Models;

import java.util.ArrayList;
import Models.Deck;
public class Artifact {
    private final String name;

    private final AbilityType abilityType; // Enum to represent the type of ability

    public Artifact(String name, AbilityType abilityType) {
        this.name = name;
        
        this.abilityType = abilityType;
    }

    public String getName() {
        return name;
    }

    

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public enum AbilityType {
        IMMEDIATE_ONE_TIME_EFFECT,
        MULTIPLE_TIMES_EFFECT_PER_ROUND
    }
    public ArrayList<Artifact> elixirOfInsight() {
        ArrayList<Artifact> firstThreeCard = new ArrayList<Artifact>();
        firstThreeCard.add(Deck.getInstance().getArtifacts().get(0));
        firstThreeCard.add(Deck.getInstance().getArtifacts().get(1));
        firstThreeCard.add(Deck.getInstance().getArtifacts().get(2));
        return firstThreeCard;
    }
   
}