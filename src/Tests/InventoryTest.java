// JUnit Imports, DO NOT USE ANY OTHER IMPORTS
// IF YOU NEED OTHER IMPORTS YOU ARE PROBABLY USING AN OLDER JUNIT VERSION
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import static org.junit.jupiter.api.Assertions.*;

import Models.Artifact;
import org.junit.jupiter.api.*;

import Models.Ingredient;
import Models.Inventory;



/**
 * Test class for Inventory.
 * Provides unit tests for different functionalities of the Inventory class.
 */
public class InventoryTest {
    private Inventory inventory;
    
    /**
     * Sets up the test environment before each test.
     * Requires: None
     * Modifies: this.inventory
     * Effects: Initializes a new Inventory instance before each test.
     */
    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }
    
    /**
     * Tests the initialization of the Inventory class.
     * Requires: None
     * Modifies: None
     * Effects: Asserts that the ingredientHashMap, potions, artifacts are initialized
     *          and gold is initialized to 0 in the Inventory class.
     *          Also checks the consistency of the Inventory's state post-initialization.
     */
    @Test
    public void testInitialization() {
        assertNotNull(inventory.getIngredientHashMap(), "Ingredients map should be initialized");
        assertNotNull(inventory.getPotions(), "Potions map should be initialized");
        assertNotNull(inventory.getArtifacts(),"Artifacts map should be initialized");
        assertEquals((Integer) 0, inventory.getGold(),"Gold should be initialized to 0");
        assertTrue(inventory.repOK());
    }
    
    /**
     * Tests the addition and removal of an ingredient in the Inventory.
     * Requires: Inventory instance to be initialized.
     * Modifies: this.inventory
     * Effects: Adds an ingredient to the inventory and asserts its count.
     *          Then removes the ingredient and asserts it is not in the inventory.
     *          Checks the consistency of the Inventory's state after each operation.
     */
    @Test
    public void testAddAndRemoveIngredient() {
        inventory.addIngredient(Ingredient.IngredientTypes.Feather, 5);
        assertEquals(5, inventory.getIngredientCount(Ingredient.IngredientTypes.Feather), "Ingredient count should be 5");
        
        inventory.removeIngredient(Ingredient.IngredientTypes.Feather);
        assertFalse(inventory.isInInventory(Ingredient.IngredientTypes.Feather), "Ingredient should be removed");
        assertTrue(inventory.repOK());
    }
    
    /**
     * Tests another scenario of adding and removing an ingredient in the Inventory.
     * Requires: Inventory instance to be initialized.
     * Modifies: this.inventory
     * Effects: Adds a different quantity of the same ingredient and asserts its count.
     *          Then removes the ingredient and asserts it is not in the inventory.
     *          Checks the consistency of the Inventory's state after each operation.
     */
    @Test
    public void testAddAndRemoveIngredient2() {
        inventory.addIngredient(Ingredient.IngredientTypes.Feather, 3);
        assertEquals(3, inventory.getIngredientCount(Ingredient.IngredientTypes.Feather), "Ingredient count should be 3");
        
        inventory.removeIngredient(Ingredient.IngredientTypes.Feather);
        assertFalse(inventory.isInInventory(Ingredient.IngredientTypes.Feather), "Ingredient should be removed");
        assertTrue(inventory.repOK());
    }
    
    /**
     * Tests the addition of gold to the Inventory.
     * Requires: Inventory instance to be initialized.
     * Modifies: this.inventory
     * Effects: Adds a specified amount of gold to the inventory and asserts the new gold count.
     *          Checks the consistency of the Inventory's state after the operation.
     */
    @Test
    public void testAddGold() {
        inventory.addGold(100);
        assertEquals((Integer)100, inventory.getGold(),"Gold count should be 100");
        assertTrue(inventory.repOK());
    }
    
    /**
     * Tests the existence and removal of an artifact in the Inventory.
     * Requires: Inventory instance to be initialized.
     * Modifies: this.inventory
     * Effects: Adds an artifact card to the inventory and asserts its existence.
     *          Then removes the artifact and asserts its non-existence.
     *          Checks the consistency of the Inventory's state after each operation.
     */
    @Test
    public void testArtifactExistenceAndRemoval() {
        Artifact artifact = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        inventory.addArtifactCard(artifact);
        
        assertTrue(inventory.checkArtifactExists(Artifact.Name.Elixir_of_Insight), "Artifact should exist");
        
        inventory.removeArtifact(Artifact.Name.Elixir_of_Insight);
        assertFalse(inventory.checkArtifactExists(Artifact.Name.Elixir_of_Insight), "Artifact should be removed");
        assertTrue(inventory.repOK());
    }
}
