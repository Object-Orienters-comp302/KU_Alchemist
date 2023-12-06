package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class Ingredient {
    
    private static HashMap<IngredientTypes, AspectTrio> TypeToAspectTrioMap;
    final          IngredientTypes                      Type;
    
    public Ingredient(IngredientTypes type) {
        Type = type;
    }
    
    public AspectTrio getAspects() {
        return getTypeToAspectTrioMap().get(this.getType());
    }
    
    public static HashMap<IngredientTypes, AspectTrio> getTypeToAspectTrioMap() {
        if (Ingredient.TypeToAspectTrioMap == null) {
            initializeTypeToAspectTrioMap();
        }
        return TypeToAspectTrioMap;
        
    }
    
    public IngredientTypes getType() {
        return Type;
    }
    
    private static void initializeTypeToAspectTrioMap() {
        TypeToAspectTrioMap = new HashMap<>();
        
        IngredientTypes[] types = IngredientTypes.values();
        AspectTrio[] aspectTrios = AspectTrio.values();
        ArrayList<AspectTrio> availableAspectTrios = new ArrayList<>(Arrays.asList(aspectTrios));
        Random random = new Random();
        
        for (IngredientTypes type : types) {
            // Ensure there are available AspectTrios
            if (availableAspectTrios.isEmpty()) {
                throw new IllegalStateException("Not enough AspectTrios for one-to-one mapping.");
            }
            
            // Randomly select an AspectTrio and remove it from the available list
            int randomIndex = random.nextInt(availableAspectTrios.size());
            AspectTrio randomAspectTrio = availableAspectTrios.remove(randomIndex);
            
            // Map the IngredientType to the selected AspectTrio
            TypeToAspectTrioMap.put(type, randomAspectTrio);
        }
    }
    
    public enum IngredientTypes {
        Plant,
        Mandrake,
        Flower,
        Mushroom,
        ChickenLeg,
        Toad,
        Feather,
        Scorpion
    }
    
    public enum AspectTrio {
        //It is named by the big node trio has(these cases have only 1 big node),
        // except when they are all positive or negative in that case they are all big.
        allPositive(new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Blue),
                    new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Green),
                    new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Red)),
        allNegative(new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Blue),
                    new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Green),
                    new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Red)),
        negativeGreen(new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Blue),
                      new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Green),
                      new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Red)),
        positiveGreen(new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Blue),
                      new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Green),
                      new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Red)),
        positiveBlue(new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Blue),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Green),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Red)),
        negativeBlue(new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Blue),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Green),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Red)),
        positiveRed(new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Blue),
                    new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Green),
                    new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Red)),
        negativeRed(new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Blue),
                    new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Green),
                    new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Red));
        private final Aspect aspectBlue;
        private final Aspect aspectGreen;
        private final Aspect aspectRed;
        
        AspectTrio(Aspect aspectBlue, Aspect aspectGreen, Aspect aspectRed) {
            this.aspectBlue  = aspectBlue;
            this.aspectGreen = aspectGreen;
            this.aspectRed   = aspectRed;
        }
        
        public Aspect getAspectBlue() {
            return aspectBlue;
        }
        
        public Aspect getAspectGreen() {
            return aspectGreen;
        }
        
        public Aspect getAspectRed() {
            return aspectRed;
        }
    }
}
