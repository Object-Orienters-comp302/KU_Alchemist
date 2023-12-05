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
    
    public boolean isEqual (Aspect other){
        if(other.getColor() != this.getColor()){
            return false;
        }
        if(other.getPositivity() != this.getPositivity()){
            return false;
        }
        if(other.getSize() != this.getSize()){
            return false;
        }
        else {
            return true;
        }
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
