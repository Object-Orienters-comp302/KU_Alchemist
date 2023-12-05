package Domain;

import Models.Inventory;
import Models.Potion;

public class RoundTwoController {
    
    public void sellPotion (Inventory inventory, Potion potion, Guarantee guarantee) throws Exception {
        removePotion(potion, inventory);
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
    }
    
    public void removePotion (Potion potion, Inventory inv) throws Exception {
        
        if (inv.getPotions()
                .isEmpty()) {
            throw new Exception("Inventory has no potions");
        }
        
        if (inv.getPotions()
                .get(potion) == null) {
            throw new Exception("Trying to remove potion that is not in inventory");
        }
        
        inv.removePotion(potion);
    }
    
    public enum Guarantee {
        POSITIVE,
        NEUTRAL,
        NEGATIVE,
    }
}
