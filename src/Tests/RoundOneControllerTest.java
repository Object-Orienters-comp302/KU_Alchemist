// JUnit Imports, DO NOT USE ANY OTHER IMPORTS
// IF YOU NEED OTHER IMPORTS YOU ARE PROBABLY USING AN OLDER JUNIT VERSION
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import Domain.GameController;
import Models.Player;
import Models.Ingredient;

public class RoundOneControllerTest {
    static Player                     testPlayer;
    static Ingredient.IngredientTypes plant1 = Ingredient.IngredientTypes.Plant;
    
    
    @BeforeEach
    public void init_classes(){
        // Create a test player with some ingredients in the inventory
        testPlayer = new Player("Test Player" , null);
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
    
    @AfterAll
    static void ded() {
        testPlayer = null; // Nullify the reference
        plant1 = null;
    }
    
}
