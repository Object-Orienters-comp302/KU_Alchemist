package Tests;
import Domain.GameController;
import Domain.RoundOneController;
import Models.Aspect;
import Models.Player;
import Models.Ingredient;
import Domain.RoundTwoController;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import Models.PublicationTrack;
import org.junit.jupiter.api.*;


public class PublishTheoryTest {
    RoundTwoController roundTwoController = GameController.getInstance().getRoundTwoController();
    @Test
    public void testPublishTheorySuccess() {
        Player testPlayer = new Player("Test", null);
        Ingredient testIngredient = new Ingredient(Ingredient.IngredientTypes.Flower);
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allNegative;
        
        
        
        boolean isPublished = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        
        assertTrue(isPublished);
    }
    @Test
    public void testPublishTheoryNullInputs() {
        Player testPlayer = new Player("Test", null);
        Ingredient testIngredient = null;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allPositive;
        
        
        boolean isPublished = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        
        assertFalse(isPublished);
    }
    @Test
    public void testPublishTheoryExistingPublication() {
        Player testPlayer = new Player("Test", null);
        Ingredient testIngredient = new Ingredient(Ingredient.IngredientTypes.Flower);
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allNegative;
        
        
        boolean isPublished_1 = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        boolean isPublished = roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        
        assertFalse(isPublished);
    }
    
    @Test
    public void testPublishTheoryGoldAndReputation() {
        Player testPlayer = new Player("Test_1", null);
        Ingredient testIngredient = new Ingredient(Ingredient.IngredientTypes.Flower);
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allPositive;
        
        
        int initialGold = testPlayer.getInventory().getGold();
        int initialReputation = testPlayer.getReputation();
        testPlayer.getInventory().addGold(1);
        roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);

        assertEquals(initialGold, testPlayer.getInventory().getGold());
        assertEquals(initialReputation + 1, testPlayer.getReputation());
    }
    @Test
    public void testPublishTheoryAddToTrack() {
        Player testPlayer = new Player("Test", null);
        Ingredient testIngredient = new Ingredient(Ingredient.IngredientTypes.Feather);
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allPositive;
        
        
        int initialSize = PublicationTrack.getInstance().getPublicationCards().size();
        
        roundTwoController.publishTheory(testPlayer, testIngredient, testMarkers);
        
        assertEquals(initialSize + 1, PublicationTrack.getInstance().getPublicationCards().size());
    }
}
