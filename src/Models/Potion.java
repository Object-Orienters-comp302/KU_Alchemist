package Models;

public class Potion {//creating function is in the GameController for now
    final Colors Color;
    final Signs Sign;

    public Potion(Colors color, Signs Sign) {
        Color = color;
        this.Sign = Sign;
    }

    public Colors getColor() {
        return Color;
    }

    public Signs getSign() {
        return Sign;
    }

    public enum Signs {
        Positive,
        Neutral,
        Negative
    }
    public enum Colors {
        Green,
        Blue,
        Red
    }
}
