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
        if(sign == null || color == null){
            throw new NullPointerException("Sign or color can't be null.");
        }
        return switch (color) {
            case Colorless -> IdentityTypes.NETURAL;
            case Green -> switch (sign) {
                case Positive -> IdentityTypes.GREENPOSITIVE;
                case Neutral -> IdentityTypes.NETURAL;
                case Negative -> IdentityTypes.GREENNEGATIVE;
            };
            case Blue -> switch (sign) {
                case Positive -> IdentityTypes.BLUEPOSITIVE;
                case Neutral -> IdentityTypes.NETURAL;
                case Negative -> IdentityTypes.BLUENEGATIVE;
            };
            case Red -> switch (sign) {
                case Positive -> IdentityTypes.REDPOSITIVE;
                case Neutral -> IdentityTypes.NETURAL;
                case Negative -> IdentityTypes.REDNEGATIVE;
            };
        };
        
    }
    public static Potion deIdentify(IdentityTypes identity){
        return switch (identity) {
            case NETURAL, UNKNOWN -> new Potion(Colors.Colorless, Signs.Neutral);
            case REDNEGATIVE -> new Potion(Colors.Red, Signs.Negative);
            case BLUENEGATIVE -> new Potion(Colors.Blue, Signs.Negative);
            case GREENNEGATIVE -> new Potion(Colors.Green, Signs.Negative);
            case REDPOSITIVE -> new Potion(Colors.Red, Signs.Positive);
            case BLUEPOSITIVE -> new Potion(Colors.Blue, Signs.Positive);
            case GREENPOSITIVE -> new Potion(Colors.Green, Signs.Positive);
        };
        
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
