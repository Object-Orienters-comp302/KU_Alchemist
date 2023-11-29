package Domain;

import Models.Deck;
import Models.Player;

public class RoundOneController {

    public void ForageForIngredient(Player player) {
        Deck deck = Deck.getInstance();
        player.getPlayerInventory().addIngredient(deck.popIngredient(), 1);
    }

}
