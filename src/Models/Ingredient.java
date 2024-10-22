package Models;

import Utils.AssetLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class Ingredient implements Serializable {
    
    private static HashMap<IngredientTypes, AspectTrio> ingredientTypeToAspectTrioMap;
    final          IngredientTypes                      Type;
    
    @Deprecated
    public Ingredient(IngredientTypes type) {
        Type = type;
    }
    
    @Deprecated
    public AspectTrio getAspects() {
        return getIngredientTypeToAspectTrioMap().get(this.getType());
    }
    
    public static HashMap<IngredientTypes, AspectTrio> getIngredientTypeToAspectTrioMap() {
        if (Ingredient.ingredientTypeToAspectTrioMap == null) {
            initializeTypeToAspectTrioMap();
        }
        return ingredientTypeToAspectTrioMap;
    }
    public static AspectTrio getAspects(IngredientTypes type){
        return Ingredient.getIngredientTypeToAspectTrioMap().get(type);
    }
    @Deprecated
    public boolean equals(Ingredient ingr) {
        return (this.getType() == ingr.getType());
    }
    
    @Deprecated
    public IngredientTypes getType() {
        return Type;
    }
    
    private static void initializeTypeToAspectTrioMap() {
        ingredientTypeToAspectTrioMap = new HashMap<>();
        
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
            ingredientTypeToAspectTrioMap.put(type, randomAspectTrio);
        }
    }
    
    public enum IngredientTypes {
        Plant("Plant"),
        Mandrake("Mandrake"),
        Flower("Flower"),
        Mushroom("Mushroom"),
        ChickenLeg("Chicken Leg"),
        Toad("Toad"),
        Feather("Feather"),
        Scorpion("Scorpion");
        private final String TypeString;
        
        IngredientTypes(String typeString) {
            
            this.TypeString = typeString;
        }
        
        public String getTypeString() {
            return TypeString;
        }
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
                      new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Green),
                      new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Red)),
        positiveBlue(new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Blue),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Green),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Red)),
        negativeBlue(new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Negative, Aspect.Colors.Blue),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Green),
                     new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Red)),
        positiveRed(new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Negative, Aspect.Colors.Blue),
                    new Aspect(Aspect.Sizes.Small, Aspect.Positivities.Positive, Aspect.Colors.Green),
                    new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Red)),
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
    
    @Override
    public String toString() {
        return this.getType().toString() ;
    }

    // Move Path Related functions to Controllers
    
    public static Ingredient.IngredientTypes getTypeFromPath(AssetLoader.AssetPath path) {
        return switch (path) {
            case AssetLoader.IngredientAssets.FEATHER -> Ingredient.IngredientTypes.Feather;
            case AssetLoader.IngredientAssets.FROG -> Ingredient.IngredientTypes.Toad;
            case AssetLoader.IngredientAssets.MANDRAKE -> Ingredient.IngredientTypes.Mandrake;
            case AssetLoader.IngredientAssets.WEED -> Ingredient.IngredientTypes.Plant;
            case AssetLoader.IngredientAssets.SCORPION -> Ingredient.IngredientTypes.Scorpion;
            case AssetLoader.IngredientAssets.FEET -> Ingredient.IngredientTypes.ChickenLeg;
            case AssetLoader.IngredientAssets.FLOWER -> Ingredient.IngredientTypes.Flower;
            case AssetLoader.IngredientAssets.MUSHROOM -> Ingredient.IngredientTypes.Mushroom;
            default -> throw new IllegalStateException("Unexpected value: " + path);
        };
    }
    
    public static AssetLoader.AssetPath getPathFromType(Ingredient.IngredientTypes type) {
        return switch (type) {
            case  Ingredient.IngredientTypes.Feather -> AssetLoader.IngredientAssets.FEATHER;
            case  Ingredient.IngredientTypes.Toad -> AssetLoader.IngredientAssets.FROG ;
            case  Ingredient.IngredientTypes.Mandrake ->AssetLoader.IngredientAssets.MANDRAKE ;
            case  Ingredient.IngredientTypes.Plant -> AssetLoader.IngredientAssets.WEED ;
            case  Ingredient.IngredientTypes.Scorpion -> AssetLoader.IngredientAssets.SCORPION ;
            case  Ingredient.IngredientTypes.ChickenLeg -> AssetLoader.IngredientAssets.FEET ;
            case  Ingredient.IngredientTypes.Flower -> AssetLoader.IngredientAssets.FLOWER ;
            case  Ingredient.IngredientTypes.Mushroom -> AssetLoader.IngredientAssets.MUSHROOM ;
            default -> throw new IllegalStateException("Unexpected type: " + type);
        };
    }
    
    public static Ingredient.AspectTrio getTrioFromPath(AssetLoader.AssetPath path) {
        return switch (path) {
            case AssetLoader.Book.ALL_POSITIVE -> AspectTrio.allPositive;
            case AssetLoader.Book.ALL_NEGATIVE -> AspectTrio.allNegative;
            case AssetLoader.Book.NEGATIVE_GREEN -> AspectTrio.negativeGreen;
            case AssetLoader.Book.POSITIVE_RED -> AspectTrio.positiveRed;
            case AssetLoader.Book.NEGATIVE_BLUE -> AspectTrio.negativeBlue;
            case AssetLoader.Book.NEGATIVE_RED -> AspectTrio.negativeRed;
            case AssetLoader.Book.POSITIVE_GREEN -> AspectTrio.positiveGreen;
            case AssetLoader.Book.POSITIVE_BLUE -> AspectTrio.positiveBlue;
            default -> throw new IllegalStateException("Unexpected value: " + path);
        };
    }
    
    public static AssetLoader.AssetPath getPathFromTrio(Ingredient.AspectTrio trio) {
        return switch (trio) {
            case AspectTrio.allPositive -> AssetLoader.Book.ALL_POSITIVE  ;
            case AspectTrio.allNegative -> AssetLoader.Book.ALL_NEGATIVE  ;
            case AspectTrio.negativeGreen -> AssetLoader.Book.NEGATIVE_GREEN ;
            case AspectTrio.positiveRed -> AssetLoader.Book.POSITIVE_RED  ;
            case  AspectTrio.negativeBlue -> AssetLoader.Book.NEGATIVE_BLUE ;
            case AspectTrio.negativeRed -> AssetLoader.Book.NEGATIVE_RED ;
            case AspectTrio.positiveGreen -> AssetLoader.Book.POSITIVE_GREEN  ;
            case AspectTrio.positiveBlue -> AssetLoader.Book.POSITIVE_BLUE ;
            default -> throw new IllegalStateException("Unexpected value: " + trio);
        };
    }
}
