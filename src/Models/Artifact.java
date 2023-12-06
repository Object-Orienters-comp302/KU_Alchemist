package Models;

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
    
}