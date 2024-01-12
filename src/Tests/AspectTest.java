import Domain.GameController;
import Domain.RoundOneController;
import Models.Aspect;
import Models.Ingredient;
import Models.Potion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AspectTest {
    RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
    
    @Test
    public void expectedNullPointerException() {
        List<Ingredient.AspectTrio> aspectTrios = new ArrayList<>();
        
        for (Ingredient.AspectTrio aspectTrio : Ingredient.AspectTrio.values()) {
            aspectTrios.add(aspectTrio);
        }
        System.out.println(aspectTrios);
        for (Ingredient.AspectTrio ass1 : aspectTrios) {
            for (Ingredient.AspectTrio ass2 : aspectTrios) {
                if (ass1.compareTo(ass2) < 0) {
                    // Avoid redundant combinations
                    Potion pot = roundOneController.MakePotion(ass1, ass2);
                    System.out.println("ASPECT1: " + ass1 + " ASPECT2: " + ass2 + " POTİON: " + pot.getIdentity());
                }
            }
        }
        
        
    }
    
    
}
