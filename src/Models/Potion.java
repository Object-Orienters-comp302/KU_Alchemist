package Models;

public class Potion {//creating function is in the GameController for now
    final String Color;
    final String Sign;

    public Potion(String color, String Sign) {
        Color = color;
        this.Sign = Sign;
    }

    public String getColor() {
        return Color;
    }

    public String getSign() {
        return Sign;
    }
}
