package Models;

import Utils.AssetLoader;

import java.util.ArrayList;

public class Potion {//creating function is in the GameController for now
    final Colors Color;
    final        Signs    Sign;
    final IdentityTypes Identity;
    
    public Potion(Colors color, Signs sign) {
        Color     = color;
        Sign = sign;
        Identity=Identify(sign , color);
    }
    
    public Colors getColor() {
        return Color;
    }
    
    public Signs getSign() {
        return Sign;
    }
    
    public IdentityTypes getIdentity() {
    	return Identity;
    }
    
    public enum Signs {
        Positive,
        Neutral,
        Negative
    }
    
    public enum Colors {
        Colorless,
        Green,
        Blue,
        Red
    }
    
    public enum IdentityTypes{
    	BLUENEGATIVE,
    	BLUEPOSITIVE,
    	REDNEGATIVE,
        REDPOSITIVE,
        GREENNEGATIVE,
        GREENPOSITIVE,
        NETURAL,
        UNKNOWN
    }
    
    private IdentityTypes Identify(Signs sign, Colors color) {
    	switch (color) {
        case Colorless:
            return Identity.UNKNOWN;
        case Green:
            switch (sign) {
                case Positive:
                    return Identity.GREENPOSITIVE;
                case Neutral:
                    return Identity.NETURAL;
                case Negative:
                    return Identity.GREENNEGATIVE;
            }
        case Blue:
            switch (sign) {
                case Positive:
                    return Identity.BLUEPOSITIVE;
                case Neutral:
                    return Identity.NETURAL;
                case Negative:
                    return Identity.BLUENEGATIVE;
            }
        case Red:
            switch (sign) {
                case Positive:
                    return Identity.REDPOSITIVE;
                case Neutral:
                    return Identity.NETURAL;
                case Negative:
                    return Identity.REDNEGATIVE;
            }
    }
    return Identity.UNKNOWN;
    	
    }
    public static Potion deIdentify(IdentityTypes identity){
        switch (identity){
            case NETURAL:
                return new Potion(Colors.Colorless, Signs.Neutral);
            case REDNEGATIVE:
                return new Potion(Colors.Red,Signs.Negative);
            case BLUENEGATIVE:
                return new Potion(Colors.Blue, Signs.Negative);
            case GREENNEGATIVE:
                return new Potion(Colors.Green,Signs.Negative);
            case REDPOSITIVE:
                return new Potion(Colors.Red, Signs.Positive);
            case BLUEPOSITIVE:
                return new Potion(Colors.Blue, Signs.Positive);
            case GREENPOSITIVE:
                return new Potion(Colors.Green, Signs.Positive);
            case UNKNOWN:
                return new Potion(Colors.Colorless, Signs.Neutral);
        }
        
        return new Potion(Colors.Colorless, Signs.Neutral);
        
    }
    public static Potion.IdentityTypes getIdentityFromPath(AssetLoader.AssetPath path) {
        return switch (path) {
            case AssetLoader.Potions.RED_POSITIVE -> Potion.IdentityTypes.REDPOSITIVE;
            case AssetLoader.Potions.RED_NEGATIVE -> Potion.IdentityTypes.REDNEGATIVE;
            case AssetLoader.Potions.GREEN_POSITIVE -> Potion.IdentityTypes.GREENPOSITIVE;
            case AssetLoader.Potions.GREEN_NEGATIVE -> Potion.IdentityTypes.GREENNEGATIVE;
            case AssetLoader.Potions.BLUE_POSITIVE -> Potion.IdentityTypes.BLUEPOSITIVE;
            case AssetLoader.Potions.BLUE_NEGATIVE -> Potion.IdentityTypes.BLUENEGATIVE;
            case AssetLoader.Potions.NEUTRAL -> Potion.IdentityTypes.NETURAL;
            case AssetLoader.Potions.UNKNOWN -> Potion.IdentityTypes.UNKNOWN;
            default -> throw new IllegalStateException("Unexpected value: " + path);
        };
    }
    
    public static AssetLoader.AssetPath getPathFromIdentity(Potion.IdentityTypes type) {
        return switch (type) {
            case  Potion.IdentityTypes.REDPOSITIVE -> AssetLoader.Potions.RED_POSITIVE;
            case  Potion.IdentityTypes.REDNEGATIVE -> AssetLoader.Potions.RED_NEGATIVE ;
            case  Potion.IdentityTypes.GREENPOSITIVE ->AssetLoader.Potions.GREEN_POSITIVE ;
            case  Potion.IdentityTypes.GREENNEGATIVE -> AssetLoader.Potions.GREEN_NEGATIVE ;
            case  Potion.IdentityTypes.BLUEPOSITIVE -> AssetLoader.Potions.BLUE_POSITIVE ;
            case  Potion.IdentityTypes.BLUENEGATIVE -> AssetLoader.Potions.BLUE_NEGATIVE ;
            case  Potion.IdentityTypes.NETURAL -> AssetLoader.Potions.NEUTRAL ;
            case  Potion.IdentityTypes.UNKNOWN -> AssetLoader.Potions.UNKNOWN ;
            default -> throw new IllegalStateException("Unexpected type: " + type);
        };
    }
}
