package Domain;

import Models.Deck;
import Models.Ingredient;
import Models.Player;

public class RoundZeroController {
    private final Deck deck;
    
    public RoundZeroController() {
        this.deck = Deck.getInstance();
    }
    
    public void gameSetup(Player player1, Player player2) {
        //Distributes starting gold
        gold_setup(player1, player2, 10);
        
        //Creates 4 of each ingredient card
        initializeIngredients(4);
        
        // Deal 2 cards to each player
        dealIngredientCards(player1, 2);
        dealIngredientCards(player2, 2);
    }
    
    public void gold_setup(Player player1, Player player2, int gold) {
        player1.getInventory().setGold(gold);
        player2.getInventory().setGold(gold);
    }
    
    public void initializeIngredients(int quantity) {
        for (Ingredient.IngredientTypes type : Ingredient.IngredientTypes.values()) {
            deck.addIngredient(new Ingredient(type), quantity);
        }
    }
    
    private void dealIngredientCards(Player player, int count) {
        for (int i = 0; i < count; i++) {
            Ingredient card = deck.popIngredient();
            player.getInventory().addIngredient(card, 1);
        }
    }
    
}
