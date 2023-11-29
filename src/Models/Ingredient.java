package Models;

import java.util.ArrayList;

public class Ingredient {

    final IngredientTypes Type;

    final ArrayList<Aspect> Aspects; //3 Aspects.

    public Ingredient(IngredientTypes type, ArrayList<Aspect> aspects) {
        Type = type;
        Aspects = aspects;
    }


    public enum IngredientTypes{
        Plant,
        Mandrake,
        Flower,
        Mushroom,
        Toad,
        Feather,
        Scorpion
    }

    public ArrayList<Aspect> getAspects() {
        return Aspects;
    }
    public IngredientTypes getType() {
        return Type;
    }
}
