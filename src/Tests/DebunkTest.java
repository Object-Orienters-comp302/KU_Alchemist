
import Domain.GameController;
import Domain.RoundThreeController;
import Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DebunkTest {
    RoundThreeController roundThreeController = GameController.getInstance().getRoundThreeController();
    Player             testPlayer;
    Player             testPlayer_2;
    @BeforeEach
    public void init_player() {
        testPlayer = new Player("Test", null);
        testPlayer.getInventory().addGold(10);
        testPlayer_2 = new Player("Test2", null);
        testPlayer_2.getInventory().addGold(10);
        PublicationTrack.getInstance();
    }
    @Test
    public void testDebunkNullInputs() {
        
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Flower;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allNegative;
        Aspect testAspect = new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Green);
        PublicationCard publicationCard = new PublicationCard(testIngredient,testMarkers,testPlayer_2);
        
        
       
        assertFalse(roundThreeController.debunkTheory(testPlayer, null, null));
        assertFalse(roundThreeController.debunkTheory(testPlayer, publicationCard, null));
        assertFalse(roundThreeController.debunkTheory(testPlayer, null, testAspect));
    }
    
    @Test
    public void testDebunkTheoryWithNoPublicationCard() {
        
        Aspect testAspect = new Aspect(Aspect.Sizes.Big, Aspect.Positivities.Positive, Aspect.Colors.Green);
        
        assertFalse(roundThreeController.debunkTheory(testPlayer, null, testAspect));
    }
    
    @Test
    public void testDebunkTheoryWithNoAspectType() {
        Ingredient.AspectTrio true_one = Ingredient.getAspects(Ingredient.IngredientTypes.Flower);
        System.out.println(true_one);
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Flower;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.allNegative;
        PublicationCard publicationCard = new PublicationCard(testIngredient,testMarkers,testPlayer_2);
        
        
        
        assertFalse(roundThreeController.debunkTheory(testPlayer, publicationCard, null));
    }
    
    

    
    @Test
    public void testDebunkTheoryWithMatchingAspectRed() {
        Ingredient.AspectTrio true_one = Ingredient.getAspects(Ingredient.IngredientTypes.Flower);
        System.out.println(true_one);
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Flower;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeRed;
        PublicationCard publicationCard = new PublicationCard(testIngredient,testMarkers,testPlayer_2);
        Aspect testAspect = testMarkers.getAspectRed();
        System.out.println(testMarkers);
        
       
        
        assertFalse(roundThreeController.debunkTheory(testPlayer, publicationCard, testAspect));
    }
    
    @Test
    public void testDebunkTheoryWithMatchingAspectGreen() {
        Ingredient.AspectTrio true_one = Ingredient.getAspects(Ingredient.IngredientTypes.Plant);
        System.out.println(true_one);
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Plant;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeGreen;
        PublicationCard publicationCard = new PublicationCard(testIngredient,testMarkers,testPlayer_2);
        Aspect testAspect = testMarkers.getAspectRed();
        System.out.println(testMarkers);
        
        
        
        assertFalse(roundThreeController.debunkTheory(testPlayer, publicationCard, testAspect));
     
    }
    
    @Test
    public void testDebunkTheoryWithMatchingAspectBlue() {
        Ingredient.AspectTrio true_one = Ingredient.getAspects(Ingredient.IngredientTypes.ChickenLeg);
        System.out.println(true_one);
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.ChickenLeg;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeBlue;
        PublicationCard publicationCard = new PublicationCard(testIngredient,testMarkers,testPlayer_2);
        Aspect testAspect = testMarkers.getAspectRed();
        System.out.println(testMarkers);
        
        
        
        assertFalse(roundThreeController.debunkTheory(testPlayer, publicationCard, testAspect));
    }
    
    @Test
    public void testDebunkTheoryWithNotMatchingAspectBlue() {
        testPlayer_2.addReputation(1);
        Ingredient.AspectTrio true_one = Ingredient.getAspects(Ingredient.IngredientTypes.ChickenLeg);
        System.out.println(true_one);
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.ChickenLeg;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeBlue;
        PublicationCard publicationCard = new PublicationCard(testIngredient,testMarkers,testPlayer_2);
        Aspect testAspect = testMarkers.getAspectRed();
        System.out.println(testMarkers);
        boolean deneme = roundThreeController.debunkTheory(testPlayer, publicationCard, testAspect);
        System.out.println(testPlayer_2.getReputation());
        assertTrue(deneme);
        
    }
    
    @Test
    public void testDebunkTheoryWithWisdomIdol() {
        testPlayer_2.addReputation(1);
        int rep = testPlayer_2.getReputation();
        Ingredient.AspectTrio true_one = Ingredient.getAspects(Ingredient.IngredientTypes.Toad);
        System.out.println(true_one);
        Artifact wisdom = new Artifact(Artifact.Name.Wisdom_Idol, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        testPlayer_2.getInventory().addArtifactCard(wisdom);
        Ingredient.IngredientTypes testIngredient = Ingredient.IngredientTypes.Toad;
        Ingredient.AspectTrio testMarkers = Ingredient.AspectTrio.negativeBlue;
        PublicationCard publicationCard = new PublicationCard(testIngredient,testMarkers,testPlayer_2);
        Aspect testAspect = testMarkers.getAspectRed();
        System.out.println(testMarkers);
        boolean debunk = roundThreeController.debunkTheory(testPlayer, publicationCard, testAspect);
        
        System.out.println(debunk);
        System.out.println(rep);
        System.out.println(testPlayer_2.getReputation());
        if(debunk == true) {
            assertEquals(rep, testPlayer_2.getReputation());
        }
        else {
            assertFalse(debunk);
        }
        
    }
}
