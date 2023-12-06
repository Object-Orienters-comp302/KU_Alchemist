package Domain;

import java.util.HashMap;

public class HelpController {
    
    HashMap<Components, String> helpTexts;
    
    protected HelpController() {
        
        helpTexts = new HashMap<>();
        
        helpTexts.put(Components.Potion,
                      "Potions are the primary objective of " + "the game. They are represented as cards with unique recipes and point values." + "To create a potion, you need to combine two ingredients.");
        
        helpTexts.put(Components.Artifact,
                      "Artifacts are special cards that grant players" + " unique abilities or effects throughout the game. There are various types of" + " artifacts, each with its own distinct ability");
        
        helpTexts.put(Components.Aspect,
                      "Aspects represent the properties or " + "characteristics of ingredients that players aim to uncover through deduction. " + "Throughout the game, players place alchemy markers on the Deduction" + " Board to form theories about these aspects.");
        
        helpTexts.put(Components.Ingredient,
                      "Ingredients are the core elements used in potion-making" + " and deduction within the game. ");
    }
    
    
    public String showHelpText(Components component) {
        
        return helpTexts.get(component);
    }
    
    
    public enum Components {
        Potion,
        Artifact,
        Aspect,
        Ingredient
    }
}
