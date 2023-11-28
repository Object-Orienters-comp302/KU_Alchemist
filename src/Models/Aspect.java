package Models;

public class Aspect {
    final Boolean isBig;
    final Boolean isPositive;
    final String Color;

    public Aspect(Boolean isBig, Boolean isPositive, String color) {
        this.isBig = isBig;
        this.isPositive = isPositive;
        Color = color;
    }

    public Boolean getBig() {
        return isBig;
    }

    public Boolean getPositive() {
        return isPositive;
    }

    public String getColor() {
        return Color;
    }
}
