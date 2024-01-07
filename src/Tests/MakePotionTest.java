// JUnit Imports, DO NOT USE ANY OTHER IMPORTS
// IF YOU NEED OTHER IMPORTS YOU ARE PROBABLY USING AN OLDER JUNIT VERSION
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import Domain.GameController;
import Domain.RoundOneController;
import Models.Ingredient;
import Models.Potion;

public class MakePotionTest {
    RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
    @Test
    public void expectedNullPointerException() {
        assertThrows(NullPointerException.class, ()-> {
            roundOneController.MakePotion(null,null); // BB throws exception
        });
    }
    
    @Test
    public void mustBeTrue(){
        Ingredient.AspectTrio trio1 = Ingredient.AspectTrio.allNegative;
        Ingredient.AspectTrio trio2 = Ingredient.AspectTrio.negativeGreen;
        Ingredient.AspectTrio trio3 = Ingredient.AspectTrio.allPositive;
        Ingredient.AspectTrio trio4 = Ingredient.AspectTrio.negativeRed;
        
        
        Potion potion1 = roundOneController.MakePotion(trio1, trio2);
        Potion potion2 = roundOneController.MakePotion(trio1, trio3);
        Potion potion3 = roundOneController.MakePotion(trio2, trio4);
        
        assertSame(new Potion(Potion.Colors.Blue, Potion.Signs.Negative).getIdentity(), potion1.getIdentity());
        assertSame(new Potion(Potion.Colors.Colorless, Potion.Signs.Neutral).getIdentity(), potion2.getIdentity());
        assertSame(new Potion(Potion.Colors.Green, Potion.Signs.Negative).getIdentity(), potion3.getIdentity());
    }
    @Test
    public void sameTrio(){
        Ingredient.AspectTrio trio1 = Ingredient.AspectTrio.allNegative;
        assertThrows(RuntimeException.class, ()-> {
            Potion potion1 = roundOneController.MakePotion(trio1, trio1);
        });
    }
    @Test
    public void nullPotion(){
        assertThrows(NullPointerException.class, ()-> {
            new Potion(Potion.Colors.Colorless,null).getIdentity(); // BB throws exception, this is for an if case that the potion hass null attribute.
        });
    }
    
    
}
