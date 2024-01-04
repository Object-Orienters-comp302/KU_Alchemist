package Tests;

import Domain.GameController;
import Models.Player;
import Models.Inventory;
import Domain.GameController;
import Models.Ingredient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.*;

// Mete Yokuş: Make Potion
// Fırat Gümüş: Transmute funcs
// Hasan Görkem Orta:Buy Artifact
// Ali Mete Sevinçli: Publish\Debunk Theory


public class RoundOneControllerTest {
    

    
    @Test
    public void testTransmuteIngredient_RemoveIngredientAndAddGold() {
        
        // Create a test player with some ingredients in the inventory
        Player testPlayer = new Player("Test Player" , null);
        Ingredient plant1 = new Ingredient(Ingredient.IngredientTypes.Plant);
        testPlayer.getInventory().addIngredient(plant1 , 1); //Add Plant to the inventory
        
        GameController.getInstance().getRoundOneController().TransmuteIngredient(testPlayer, plant1.getType());
        
        assertFalse(testPlayer.isInInventory(Ingredient.IngredientTypes.Plant));
        assertEquals(1, testPlayer.getInventory().getGold());
    }

    
}
