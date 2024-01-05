package Tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Domain.GameController;
import Domain.RoundOneController;
import Domain.RoundZeroController;
import Models.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArtifactTest {
    RoundOneController  roundOneController = GameController.getInstance().getRoundOneController();
    RoundZeroController roundZeroController = GameController.getInstance().getRoundZeroController();
    @Test
    public void expectedNullPointerException() {
        assertThrows(NullPointerException.class, ()-> {
            roundOneController.MakePotion(null,null); // BB throws exception
        });
    }
    
    @Test
    void buyTest() {
        roundZeroController.gameSetup();
        Player player1 = new Player("p1",null);
        player1.getInventory().setGold(3);
        Player player2 = new Player("p2",null);
        player2.getInventory().setGold(2);
        Player player3 = new Player("p3",null);
        player3.getInventory().setGold(4);
        ArrayList<Artifact> deck=  Deck.getInstance().getArtifacts();
        System.out.println(deck);
        
        roundOneController.BuyArtifacts(player1);
        roundOneController.BuyArtifacts(player2);
        roundOneController.BuyArtifacts(player3);
        
        System.out.println(deck);
        System.out.println(player1.getInventory().getArtifacts());
        System.out.println(player2.getInventory().getArtifacts());
        System.out.println(player3.getInventory().getArtifacts());
        
        assertTrue(player1.getInventory().getArtifacts().size()>0);
        assertTrue(player2.getInventory().getArtifacts().size()==0);
        assertTrue(player3.getInventory().getArtifacts().size()>0);
        
        assertTrue(player1.getInventory().getGold()==0);
        assertTrue(player2.getInventory().getGold()==2);
        assertTrue(player3.getInventory().getGold()==1);
    }
    @Test
    void elixirOfInsightView() {
        roundZeroController.initializeIngredients(4);
        Artifact artifact = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
       
        // Perform the test
        HashMap<Ingredient, Integer> expectedView = new HashMap<>();
        Deck.getInstance().shuffleIngredients();
        ArrayList<Ingredient> deck=  Deck.getInstance().getIngredients();
        
        System.out.println(deck);
        expectedView.put(new Ingredient(Ingredient.IngredientTypes.Toad), 2);
        expectedView.put(new Ingredient(Ingredient.IngredientTypes.Mandrake), 0);
        expectedView.put(new Ingredient(Ingredient.IngredientTypes.Scorpion), 1);
        
        artifact.elixirOfInsightView(expectedView);
        System.out.println(deck);
        
        ArrayList<Ingredient> combinedList = new ArrayList<>();
        combinedList.add(deck.get(0));
        combinedList.add(deck.get(1));
        combinedList.add(deck.get(2));
        assertTrue(combinedList.containsAll(expectedView.keySet()));
        
        
    }
    
    
    @Test
    public void nullArtifact(){
        assertThrows(NullPointerException.class, ()-> {
            new Artifact(Artifact.Name.Elixir_of_Insight, null).getAbilityType(); // BB throws exception, this is for an if case that the potion hass null attribute.
        });
        assertThrows(NullPointerException.class, ()-> {
            new Artifact(null, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT).getName(); // BB throws exception, this is for an if case that the potion hass null attribute.
        });
    }
    
    
}
