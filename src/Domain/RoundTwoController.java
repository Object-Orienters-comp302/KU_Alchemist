package Domain;

import Models.Inventory;
import Models.Potion;

import java.util.HashMap;

public class RoundTwoController {
    
    public Potion sellPotion (Inventory inventory, Potion potion, Guarantee guarantee) {
        Potion removed_potion = removePotion(inventory.getPotions(), potion);
        
        if (removed_potion != null) {
            switch (guarantee) {
                case POSITIVE -> {
                    inventory.setGold(inventory.getGold() + 3);
                }
                case NEUTRAL -> {
                    inventory.setGold(inventory.getGold() + 2);
                }
                case NEGATIVE -> {
                    inventory.setGold(inventory.getGold() + 1);
                }
            }
            
            return removed_potion;
        }
        
        return null;
    }
    
    public Potion removePotion (HashMap<Potion, Integer> Potions, Potion potion) {
        
        if (Potions.isEmpty()) {
            return null;
        }
        
        int potion_num = Potions.get(potion);
        
        if (potion_num != 0) {
            Potions.put(potion, potion_num - 1);
            return potion;
            
        } else {
            return null;
        }
    }
    
    public enum Guarantee {
        POSITIVE,
        NEUTRAL,
        NEGATIVE,
    }
}
