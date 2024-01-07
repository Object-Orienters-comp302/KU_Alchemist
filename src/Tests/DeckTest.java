// JUnit Imports, DO NOT USE ANY OTHER IMPORTS
// IF YOU NEED OTHER IMPORTS YOU ARE PROBABLY USING AN OLDER JUNIT VERSION
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import Models.Deck;
import Models.Ingredient;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Test class for Deck.
 * Provides unit tests for different functionalities of the Deck class.
 */
public class DeckTest {
    private Deck deck;
    
    /**
     * Sets up the test environment before each test.
     * Requires: None
     * Modifies: this.deck
     * Effects: Initializes a new Deck instance and clears it before each test.
     */
    @BeforeEach
    void setUp() {
        deck = Deck.getInstance();
        
        // Clear the deck for each test
        deck.clear();
    }
    
    /**
     * Tests the behavior of getFirstThree method when the deck is empty.
     * Requires: An empty deck instance.
     * Modifies: None
     * Effects: Asserts that the returned collection from getFirstThree is empty.
     */
    @Test
    void getFirstThreeWhenDeckIsEmpty() {
        assertTrue(deck.getFirstThree().isEmpty(), "The deck should be empty");
    }
    
    
    /**
     * Tests the getFirstThree method with less than three ingredients in the deck.
     * Requires: A deck instance with less than three ingredients.
     * Modifies: None
     * Effects: Asserts that the size of the returned collection is equal to the number of ingredients in the deck.
     */
    @Test
    void getFirstThreeWithLessThanThreeIngredients() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        assertEquals(1, deck.getFirstThree().size(), "The deck should have only one ingredient");
    }
    
    /**
     * Tests the getFirstThree method with exactly three ingredients in the deck.
     * Requires: A deck instance with exactly three different ingredients.
     * Modifies: None
     * Effects: Asserts that the size of the returned collection is exactly three.
     */
    @Test
    void getFirstThreeWithExactlyThreeIngredients() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        assertEquals(3, deck.getFirstThree().size(), "The deck should have three ingredients");
    }
    
    @Test
    void getFirstThreeWithExactlySameThreeIngredients() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        assertEquals(3, deck.getFirstThree().size(), "The deck should have three ingredients");
    }
    
    @Test
    void getFirstThreeWithMoreThanThreeIngredients() {
        for (Ingredient.IngredientTypes type : Ingredient.IngredientTypes.values()) {
            deck.addIngredient(new Ingredient(type), 1);
        }
        assertEquals(3, deck.getFirstThree().size(), "Only the first three ingredients should be returned");
    }
    
    @Test
    void getFirstThreeCorrectOrder() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        HashMap<Integer, Ingredient> firstThree = deck.getFirstThree();
        assertEquals(Ingredient.IngredientTypes.Plant, firstThree.get(0).getType(), "First ingredient should be Plant");
        assertEquals(Ingredient.IngredientTypes.Mandrake, firstThree.get(1).getType(),
                     "Second ingredient should be Mandrake");
        assertEquals(Ingredient.IngredientTypes.Flower, firstThree.get(2).getType(),
                     "Third ingredient should be Flower");
    }
    
    @Test
    void getFirstThreeWithDuplicateIngredients() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        HashMap<Integer, Ingredient> firstThree = deck.getFirstThree();
        assertTrue(firstThree.values().stream().allMatch(i -> i.getType() == Ingredient.IngredientTypes.Plant),
                   "All first three ingredients should be Plant");
    }
    
    @Test
    void getFirstThreeAfterShuffle() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        deck.shuffleIngredients();
        HashMap<Integer, Ingredient> firstThree = deck.getFirstThree();
        assertNotNull(firstThree, "First three ingredients should not be null after shuffle");
    }
    
    
    /*--------------------------------setFirstThree---------------------------------*/
    
    @Test
    void setFirstThreeInEmptyDeck() {
        HashMap<Integer, Ingredient> newFirstThree = new HashMap<>();
        Ingredient ingredient1 = new Ingredient(Ingredient.IngredientTypes.Plant);
        newFirstThree.put(0, ingredient1);
        deck.setFirstThree(newFirstThree);
        assertEquals(ingredient1, deck.getFirstThree().get(0), "The deck should contain Plant");
    }
    
    @Test
    void replaceExistingFirstThree() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        
        HashMap<Integer, Ingredient> newFirstThree = new HashMap<>();
        Ingredient newIngredient = new Ingredient(Ingredient.IngredientTypes.Mushroom);
        newFirstThree.put(0, newIngredient);
        deck.setFirstThree(newFirstThree);
        
        assertEquals(Ingredient.IngredientTypes.Mushroom, deck.getFirstThree().get(0).getType(),
                     "Plant should be replaced with Mushroom");
    }
    
    @Test
    void setFirstThreeAtSpecificIndex() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        
        HashMap<Integer, Ingredient> newFirstThree = new HashMap<>();
        Ingredient newIngredient = new Ingredient(Ingredient.IngredientTypes.Mushroom);
        newFirstThree.put(1, newIngredient);
        deck.setFirstThree(newFirstThree);
        
        assertEquals(Ingredient.IngredientTypes.Mushroom, deck.getFirstThree().get(1).getType(),
                     "Mandrake should be replaced with Mushroom");
    }
    
    @Test
    void ignoreInvalidPositions() {
        HashMap<Integer, Ingredient> newFirstThree = new HashMap<>();
        Ingredient ingredient = new Ingredient(Ingredient.IngredientTypes.Plant);
        newFirstThree.put(4, ingredient); // Invalid position
        deck.setFirstThree(newFirstThree);
        assertFalse(deck.getFirstThree().containsKey(4), "Invalid position should be ignored");
    }
    
    @Test
    void maintainOrderInFirstThree() {
        HashMap<Integer, Ingredient> newFirstThree = new HashMap<>();
        Ingredient ingredient1 = new Ingredient(Ingredient.IngredientTypes.Plant);
        Ingredient ingredient2 = new Ingredient(Ingredient.IngredientTypes.Mandrake);
        newFirstThree.put(0, ingredient1);
        newFirstThree.put(1, ingredient2);
        deck.setFirstThree(newFirstThree);
        
        assertEquals(Ingredient.IngredientTypes.Plant, deck.getFirstThree().get(0).getType(),
                     "First ingredient should be Plant");
        assertEquals(Ingredient.IngredientTypes.Mandrake, deck.getFirstThree().get(1).getType(),
                     "Second ingredient should be Mandrake");
    }
    
    
    @Test
    void setFirstThreeWithPartialUpdate() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        
        HashMap<Integer, Ingredient> newFirstThree = new HashMap<>();
        Ingredient newIngredient = new Ingredient(Ingredient.IngredientTypes.Mushroom);
        newFirstThree.put(1, newIngredient); // Replace only second ingredient
        deck.setFirstThree(newFirstThree);
        
        assertEquals(Ingredient.IngredientTypes.Mushroom, deck.getFirstThree().get(1).getType(),
                     "Second ingredient should be replaced with Mushroom");
    }
    
    @Test
    void setFirstThreeWithNoChanges() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        
        HashMap<Integer, Ingredient> newFirstThree = new HashMap<>();
        deck.setFirstThree(newFirstThree); // No changes
        assertEquals(3, deck.getFirstThree().size(), "The deck should still have three ingredients");
    }
    
    /*--------------------------------shuffleIngredients---------------------------------*/
    /**
     * Tests the behavior of shuffleIngredients method on a non-empty deck.
     * Requires: A non-empty deck instance.
     * Modifies: The order of ingredients in this.deck.
     * Effects: Asserts that the order of ingredients is changed after shuffling.
     */
    @Test
    void shuffleIngredientsNonEmptyDeck() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        
        ArrayList<Ingredient> ingredientsBeforeShuffle = new ArrayList<>(deck.getIngredients());
        deck.shuffleIngredients();
        ArrayList<Ingredient> ingredientsAfterShuffle = deck.getIngredients();
        
        assertNotEquals(ingredientsBeforeShuffle, ingredientsAfterShuffle,
                        "The order of ingredients should be changed after shuffle");
    }
    
    /**
     * Tests the shuffleIngredients method on an empty deck.
     * Requires: An empty deck instance.
     * Modifies: None
     * Effects: Asserts that shuffling an empty deck results in an empty deck.
     */
    @Test
    void shuffleEmptyDeck() {
        deck.shuffleIngredients();
        assertTrue(deck.getIngredients().isEmpty(), "Shuffling an empty deck should still result in an empty deck");
    }
    
    /**
     * Tests the shuffleIngredients method ensuring a different order of ingredients.
     * Requires: A deck instance with multiple ingredients.
     * Modifies: The order of ingredients in this.deck.
     * Effects: Asserts that the order of ingredients is different after shuffling.
     */
    @Test
    void shuffleResultsInDifferentOrder() {
        // This test might occasionally fail due to the random nature of shuffling
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        
        ArrayList<Ingredient> ingredientsBeforeShuffle = new ArrayList<>(deck.getIngredients());
        deck.shuffleIngredients();
        ArrayList<Ingredient> ingredientsAfterShuffle = deck.getIngredients();
        
        assertNotEquals(ingredientsBeforeShuffle, ingredientsAfterShuffle,
                        "The order of ingredients should be different after shuffle");
    }
    
    @Test
    void shuffleIngredientsAndCheckOrderChange() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        
        ArrayList<Ingredient> ingredientsBeforeShuffle = new ArrayList<>(deck.getIngredients());
        deck.shuffleIngredients();
        ArrayList<Ingredient> ingredientsAfterShuffle = deck.getIngredients();
        
        assertNotEquals(ingredientsBeforeShuffle, ingredientsAfterShuffle,
                        "Order of ingredients should change after shuffle");
    }
    
    @Test
    void shuffleIngredientsAndCheckSameElements() {
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Plant), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Mandrake), 1);
        deck.addIngredient(new Ingredient(Ingredient.IngredientTypes.Flower), 1);
        
        ArrayList<Ingredient> ingredientsBeforeShuffle = new ArrayList<>(deck.getIngredients());
        deck.shuffleIngredients();
        ArrayList<Ingredient> ingredientsAfterShuffle = deck.getIngredients();
        
        assertTrue(ingredientsBeforeShuffle.containsAll(ingredientsAfterShuffle) && ingredientsAfterShuffle.containsAll(
                ingredientsBeforeShuffle), "Elements should remain the same after shuffle");
    }
    
}
