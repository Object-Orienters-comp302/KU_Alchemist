package Domain;

import Models.Deck;
import Models.Ingredient;
import Models.Player;

import java.util.ArrayList;

public class RoundZeroController {
    private final Deck deck;
    ArrayList<Player> players;
    public RoundZeroController() {
        this.players = Player.getPlayers();
        this.deck = Deck.getInstance();
    }
    
    public void gameSetup() {
        
        //Creates 4 of each ingredient card in deck
        initializeIngredients(4);
        
        this.deck.shuffleIngredients();
        
        for(Player player : players) {
            
            //Distributes starting gold
            gold_setup(player, 10);
            
            // Deal 2 cards to each player
            dealIngredientCards(player, 2);
        }
    }
    
    public void gold_setup(Player player, int gold) {
        player.getInventory().setGold(gold);
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
