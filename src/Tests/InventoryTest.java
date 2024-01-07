import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import Models.Ingredient;
import Models.Inventory;



public class InventoryTest {
    private Inventory inventory;
    
    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }
    
    @Test
    public void testInitialization() {
        assertNotNull(inventory.getIngredientHashMap(), "Ingredients map should be initialized");
        assertNotNull(inventory.getPotions(), "Potions map should be initialized");
        assertNotNull(inventory.getArtifacts(),"Artifacts map should be initialized");
        assertEquals((Integer) 0, inventory.getGold(),"Gold should be initialized to 0");
    }
    
    @Test
    public void testAddAndRemoveIngredient() {
        inventory.addIngredient(Ingredient.IngredientTypes.Feather, 5);
        assertEquals(5, inventory.getIngredientCount(Ingredient.IngredientTypes.Feather), "Ingredient count should be 5");
        
        inventory.removeIngredient(Ingredient.IngredientTypes.Feather);
        assertFalse(inventory.isInInventory(Ingredient.IngredientTypes.Feather), "Ingredient should be removed");
    }
    @Test
    public void testAddAndRemoveIngredient2() {
        inventory.addIngredient(Ingredient.IngredientTypes.Feather, 3);
        assertEquals(3, inventory.getIngredientCount(Ingredient.IngredientTypes.Feather), "Ingredient count should be 3");
        
        inventory.removeIngredient(Ingredient.IngredientTypes.Feather);
        assertFalse(inventory.isInInventory(Ingredient.IngredientTypes.Feather), "Ingredient should be removed");
    }
    @Test
    public void testAddGold() {
        inventory.addGold(100);
        assertEquals((Integer)100, inventory.getGold(),"Gold count should be 100");
    }
//    @Test
//    public void testArtifactExistenceAndRemoval() {
//        Artifact artifact = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT); // Assuming constructor for Artifact
//        inventory.addArtifactCard(artifact, 1);
//
//        assertTrue("Artifact should exist", inventory.checkArtifactExists(Artifact.Name.Elixir_of_Insight));
//
//        inventory.removeArtifact("ArtifactName");
//        assertFalse("Artifact should be removed", inventory.checkArtifactExists(Artifact.Name.Elixir_of_Insight));
//    }
    
    
}
