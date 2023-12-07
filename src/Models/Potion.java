package Models;

public class Potion {//creating function is in the GameController for now
    final Colors Color;
    final Signs  Sign;
    final Identity Identity;
    
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
    
    public Identity getIdentity() {
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
    
    public enum Identity{
    	BLUENEGATIVE,
    	BLUEPOSITIVE,
    	REDNEGATIVE,
        REDPOSITIVE,
        GREENNEGATIVE,
        GREENPOSITIVE,
        NETURAL,
        UNKNOWN
    }
    
    private Identity Identify(Signs sign, Colors color) {
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
}
