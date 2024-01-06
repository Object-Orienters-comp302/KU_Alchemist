import Domain.GameController;
import Models.Player;
import Models.Inventory;
import Domain.GameController;
import Models.Ingredient;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.*;

// Mete Yokuş: Make Potion
// Fırat Gümüş: Transmute funcs
// Hasan Görkem Orta:Buy Artifact
// Ali Mete Sevinçli: Publish\Debunk Theory


public class RoundOneControllerTest {
    Player testPlayer;
    Ingredient.IngredientTypes plant1 = Ingredient.IngredientTypes.Plant;
    
    @BeforeEach
    public void init_classes(){
        // Create a test player with some ingredients in the inventory
        Player testPlayer = new Player("Test Player" , null);
    }
    

    
    @Test
    public void testTransmuteIngredient_RemoveIngredientAndAddGold() {
        
        
        testPlayer.getInventory().addIngredient(plant1 , 1); //Add Plant to the inventory
        
        GameController.getInstance().getRoundOneController().TransmuteIngredient(testPlayer, plant1);
        
        assertFalse(testPlayer.getInventory().isInInventory(Ingredient.IngredientTypes.Plant));
        assertEquals(1, testPlayer.getInventory().getGold());
    }
    
    @Test
    public void testTransmuteIngredient_EmptyInventory_NoChanges() {
        GameController.getInstance().getRoundOneController().TransmuteIngredient(testPlayer, plant1);
        
        assertFalse(testPlayer.getInventory().isInInventory(Ingredient.IngredientTypes.Plant));
        assertEquals(0, testPlayer.getInventory().getGold());
    }
    
    @Test
    public void testTransmuteIngredient_MultipleIngredientsOfType_RemoveOne() {
        testPlayer.getInventory().addIngredient(plant1 , 4); //Add 4 Plants to the inventory
        testPlayer.getInventory().setGold(7);
        
        GameController.getInstance().getRoundOneController().TransmuteIngredient(testPlayer, plant1);
        
        assertEquals(3, testPlayer.getInventory().getIngredientCount(plant1));
        assertEquals(8, testPlayer.getInventory().getGold());
    }
    
    @Test
    public void testTransmuteIngredient_NullPlayer_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            GameController.getInstance().getRoundOneController().TransmuteIngredient(null, null);
        });
    }
    
}
