package Domain;
import Models.Ingredient;
import Models.Potion;
import Models.Inventory;


import java.util.HashMap;
import java.util.Map;

public class RoundTwoController {



    public Potion sellPotion(Inventory inventory, Potion potion, int guarantee_num){
        //guarantee = 3 positive , 2 neutral or positive, 1 negative

        Potion removed_potion = removePotion(inventory.getPotions(), potion);

        if(removed_potion != null) {
            if (guarantee_num == 3) {
                inventory.setGold(inventory.getGold() + 3);
            } else if (guarantee_num == 2) {
                inventory.setGold(inventory.getGold() + 2);
            } else {
                inventory.setGold(inventory.getGold() + 1);
            }

            return removed_potion;
        }

        return null;
    }

    public Potion removePotion(HashMap<Potion, Integer> Potions, Potion r_potion) {

        if (Potions.isEmpty()) {return null;}

        int potion_num = Potions.get(r_potion);

        if (potion_num!=0){

            Potions.put(r_potion,potion_num-1);
            return r_potion;

        }else{
            return null;
        }
    }
}
