package Domain;

import Models.Artifact;
import Models.Deck;
import Models.Ingredient;
import Models.Player;

public class RoundZeroController {
    private final Deck deck;
    
    public RoundZeroController() {
        this.deck = Deck.getInstance();
    }
    
    public void gameSetup() {
        
        //Creates 4 of each ingredient card in deck
        initializeIngredients(4);
        initializeArtifacts();
        
        this.deck.shuffleIngredients();
        this.deck.shuffleArtifact();
        
        for (Player player : Player.getPlayers()) {
            
            //Distributes starting gold
            gold_setup(player, 10);
            
            // Deal 2 cards to each player
            dealIngredientCards(player, 2);
        }
    }
    
    public void initializeIngredients(int quantity) {
        for (Ingredient.IngredientTypes type : Ingredient.IngredientTypes.values()) {
            deck.addIngredient(type, quantity);
        }
    }
    
    public void  initializeArtifacts(){
        Artifact artifact1 = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact1,1);
        
        Artifact artifact2 = new Artifact(Artifact.Name.Magic_Mortar, Artifact.AbilityType.MULTIPLE_TIMES_EFFECT_PER_ROUND);
        this.deck.addArtifactCard(artifact2,1);
        
        Artifact artifact3 = new Artifact(Artifact.Name.Printing_Press, Artifact.AbilityType.MULTIPLE_TIMES_EFFECT_PER_ROUND);
        this.deck.addArtifactCard(artifact3,1);
        
        Artifact artifact4 = new Artifact(Artifact.Name.Wisdom_Idol, Artifact.AbilityType.MULTIPLE_TIMES_EFFECT_PER_ROUND);
        this.deck.addArtifactCard(artifact4,1);
    }
    
    public void gold_setup(Player player, int gold) {
        player.getInventory().setGold(gold);
    }
    
    private void dealIngredientCards(Player player, int count) {
        for (int i = 0; i < count; i++) {
            Ingredient.IngredientTypes card = deck.popIngredient();
            player.getInventory().addIngredient(card, 1);
        }
    }
}
