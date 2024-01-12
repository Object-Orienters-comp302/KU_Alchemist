// JUnit Imports, DO NOT USE ANY OTHER IMPORTS
// IF YOU NEED OTHER IMPORTS YOU ARE PROBABLY USING AN OLDER JUNIT VERSION
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import Models.Player;
import Domain.GameController;
import Domain.RoundOneController;
import Domain.RoundZeroController;
import Models.Artifact;
import Models.Deck;
import Models.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;


public class ArtifactTest {
    static RoundOneController  roundOneController  = GameController.getInstance().getRoundOneController();
    static RoundZeroController roundZeroController = GameController.getInstance().getRoundZeroController();
    
    
    
    @Test
    public void expectedNullPointerException() {
        assertThrows(NullPointerException.class, ()-> {
            roundOneController.MakePotion(null,null); // BB throws exception
        });
    }

    @Test
    void buyTest() {
        roundZeroController.gameSetup();
        Player playerWith3Gold = new Player("p3", null);
        playerWith3Gold.getInventory().setGold(3);
        Player playerWith2Gold = new Player("p2",null);
        playerWith2Gold.getInventory().setGold(2);
        Player playerWith4Gold = new Player("p4",null);
        playerWith4Gold.getInventory().setGold(4);
        
        ArrayList<Artifact> deck =  Deck.getInstance().getArtifacts();

        roundOneController.BuyArtifacts(playerWith3Gold); // -> 0 gold
        roundOneController.BuyArtifacts(playerWith2Gold); // -> Fail to buy -> 2 gold
        roundOneController.BuyArtifacts(playerWith4Gold); // -> 1 gold
        
        assertEquals(playerWith3Gold.getInventory().getArtifacts().size(), 1);
        assertEquals(playerWith2Gold.getInventory().getArtifacts().size(), 0);
        assertEquals(playerWith4Gold.getInventory().getArtifacts().size(), 1);
        
        assertEquals((int) playerWith3Gold.getInventory().getGold(), 0);
        assertEquals((int) playerWith2Gold.getInventory().getGold(), 2);
        assertEquals((int) playerWith4Gold.getInventory().getGold(), 1);
    }
    @Test
    void elixirOfInsightView() {
        roundZeroController.initializeIngredients(4);
        Artifact artifact = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);

        // Perform the test
        HashMap<Integer, Ingredient.IngredientTypes> expectedView = new HashMap<>();
        Deck.getInstance().shuffleIngredients();
        ArrayList<Ingredient.IngredientTypes> deck=  Deck.getInstance().getIngredients();

        System.out.println(deck);
        expectedView.put(0,Ingredient.IngredientTypes.Mandrake);
        expectedView.put(1,Ingredient.IngredientTypes.Scorpion);
        expectedView.put(2,Ingredient.IngredientTypes.Flower);

        artifact.elixirOfInsightView(expectedView);
        System.out.println(deck);

        ArrayList<Ingredient.IngredientTypes> combinedList = new ArrayList<>();
        combinedList.add(deck.get(0));
        combinedList.add(deck.get(1));
        combinedList.add(deck.get(2));
        assertEquals(combinedList.get(0),expectedView.get(0));
        assertEquals(combinedList.get(1),expectedView.get(1));
        assertEquals(combinedList.get(2),expectedView.get(2));



    }


//    @Test
//    public void nullArtifact(){
//        assertThrows(NullPointerException.class, ()-> {
//            new Artifact(Artifact.Name.Elixir_of_Insight, null).getAbilityType(); // BB throws exception, this is for an if case that the potion hass null attribute.
//        });
//        assertThrows(NullPointerException.class, ()-> {
//            new Artifact(null, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT).getName(); // BB throws exception, this is for an if case that the potion hass null attribute.
//        });
//    }
    @AfterAll
    static void ded() {
        roundOneController = null; // Nullify the reference
        roundZeroController = null;
    }


}