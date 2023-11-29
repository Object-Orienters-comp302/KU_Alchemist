package Models;

import java.util.ArrayList;

public class Ingredient {
    final String Type;
    final ArrayList<Aspect> Aspects; //3 Aspects.

    public Ingredient(String type, ArrayList<Aspect> aspects) {
        Type = type;
        Aspects = aspects;
    }

    public String getType() {
        return Type;
    }


    public ArrayList<Aspect> getAspects() {
        return Aspects;
    }

}
