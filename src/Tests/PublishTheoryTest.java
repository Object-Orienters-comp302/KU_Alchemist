// JUnit Imports, DO NOT USE ANY OTHER IMPORTS
// IF YOU NEED OTHER IMPORTS YOU ARE PROBABLY USING AN OLDER JUNIT VERSION
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import Domain.GameController;
import Models.Player;
import Models.Ingredient;
import Domain.RoundTwoController;
import Models.PublicationTrack;


public class PublishTheoryTest {
    static RoundTwoController roundTwoController = GameController.getInstance().getRoundTwoController();
    static Player             testPlayer;
    @BeforeEach
    public void init_player() {
         testPlayer = new Player("Test", null);
         testPlayer.getInventory().addGold(10);
    }
    
    @Test
    public void testPublishTheorySuccess() {
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Flower;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allNegative;
        
        
        
        boolean isPublished = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        
        assertTrue(isPublished);
    }
    @Test
    public void testPublishTheoryNullInputs() {
        
        Ingredient.IngredientTypes testIngredient = null;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allPositive;
        
        
        boolean isPublished = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        
        assertFalse(isPublished);
    }
    @Test
    public void testPublishTheoryExistingPublication() {
        
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Scorpion;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeBlue;
        
        
        boolean isPublished_1 = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        boolean isPublished = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        
        assertFalse(isPublished);
    }
    
    @Test
    public void testPublishTheoryGoldAndReputation() {
        
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Mushroom;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeGreen;
        
        
        ;
        int initialReputation = testPlayer.getReputation();
        
        roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);

        assertEquals(9, testPlayer.getInventory().getGold());
        assertEquals(initialReputation + 1, testPlayer.getReputation());
    }
    @Test
    public void testPublishTheoryAddToTrack() {
       
        Ingredient.IngredientTypes testIngredient_1 = Ingredient.IngredientTypes.Feather;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeRed;
        
        
        int initialSize = PublicationTrack.getInstance().getPublicationCards().size();
        
        roundTwoController.publishTheory(testPlayer, testIngredient_1, testMarkers);
        assertEquals(initialSize + 1, PublicationTrack.getInstance().getPublicationCards().size());
    }
    @AfterAll
    static void ded() {
        roundTwoController = null; // Nullify the reference
        testPlayer = null;
    }
}
