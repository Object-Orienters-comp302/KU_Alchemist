package Models;

public class Aspect {
    final Sizes        size;
    final Positivities Positivity;
    final Colors       color;
    
    public Aspect (Sizes size, Positivities positivity, Colors color) {
        this.size  = size;
        Positivity = positivity;
        this.color = color;
    }
    
    public Sizes getSize () {
        return size;
    }
    
    public Positivities getPositivity () {
        return Positivity;
    }
    
    public Colors getColor () {
        return color;
    }
    
    public enum Sizes {
        Big,
        Small
    }
    
    public enum Positivities {
        Positive,
        Negative
    }
    
    public enum Colors {
        Green,
        Blue,
        Red
    }
}
