package Tests;

import static org.junit.Assert.*;

import Models.Artifact;
import Models.Ingredient;
import Models.Inventory;
import org.junit.*;



public class InventoryTest {
    private Inventory inventory;
    
    @Before
    public void setUp() {
        inventory = new Inventory();
    }
    
    @Test
    public void testInitialization() {
        assertNotNull("Ingredients map should be initialized", inventory.getIngredientHashMap());
        assertNotNull("Potions map should be initialized", inventory.getPotions());
        assertNotNull("Artifacts map should be initialized", inventory.getArtifacts());
        assertEquals("Gold should be initialized to 0", (Integer) 0, inventory.getGold());
    }
    
    @Test
    public void testAddAndRemoveIngredient() {
        inventory.addIngredient(Ingredient.IngredientTypes.Feather, 5);
        assertEquals("Ingredient count should be 5", 5, inventory.getIngredientCount(Ingredient.IngredientTypes.Feather));
        
        inventory.removeIngredient(Ingredient.IngredientTypes.Feather);
        assertFalse("Ingredient should be removed", inventory.isInInventory(Ingredient.IngredientTypes.Feather));
    }
    @Test
    public void testAddAndRemoveIngredient2() {
        inventory.addIngredient(Ingredient.IngredientTypes.Feather, 3);
        assertEquals("Ingredient count should be 5", 3, inventory.getIngredientCount(Ingredient.IngredientTypes.Feather));
        
        inventory.removeIngredient(Ingredient.IngredientTypes.Feather);
        assertFalse("Ingredient should be removed", inventory.isInInventory(Ingredient.IngredientTypes.Feather));
    }
    @Test
    public void testAddGold() {
        inventory.addGold(100);
        assertEquals("Gold count should be 100", (Integer)100, inventory.getGold());
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
