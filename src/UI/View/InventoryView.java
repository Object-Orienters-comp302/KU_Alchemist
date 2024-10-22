package UI.View;

import Domain.Event.Listener;
import Domain.Event.Type;
import Models.Ingredient;
import Models.Player;
import Models.Potion;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class InventoryView extends JPanel implements Listener {
    
    private static final long serialVersionUID = 1L;
    
    
    ImagePanel Background;
    
    JPanel Ingredient_panel;
    JPanel Potion_panel;
    
    ImagePanel feather;
    ImagePanel feet;
    ImagePanel flower;
    ImagePanel frog;
    ImagePanel mandrake;
    ImagePanel mushroom;
    ImagePanel scorpion;
    ImagePanel weed;
    
    ImagePanel greenPostive;
    ImagePanel redPostive;
    ImagePanel bluePostive;
    ImagePanel greenNegative;
    ImagePanel redNegative;
    ImagePanel blueNegative;
    ImagePanel neutral;
    
    JLabel title;
    
    JLabel feather_quantity;
    JLabel feet_quantity;
    JLabel flower_quantity;
    JLabel frog_quantity;
    JLabel mandrake_quantity;
    JLabel mushroom_quantity;
    JLabel scorpion_quantity;
    JLabel weed_quantity;
    
    JLabel greenPostive_quantity;
    JLabel redPostive_quantity;
    JLabel bluePostive_quantity;
    JLabel greenNegative_quantity;
    JLabel redNegative_quantity;
    JLabel blueNegative_quantity;
    JLabel neutral_quantity;
    
    /**
     * Create the panel.
     */
    
    public InventoryView() {
        
        for (Player player : Player.getPlayers()) {
            player.getInventory().addListener(this);
            player.addListener(this);
        }
        
        this.setSize(1000, 500);
        setLayout(null);
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.INVENTORY));
        Background.setForeground(SystemColor.desktop);
        Background.setLocation(0, 0);
        Background.setSize(1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        JPanel Ingredient_panel = new JPanel();
        Ingredient_panel.setOpaque(false);
        Ingredient_panel.setBounds(100, 70, 800, 100);
        Background.add(Ingredient_panel);
        Ingredient_panel.setLayout(new GridLayout(1, 8));
        
        JPanel Potion_panel = new JPanel();
        Potion_panel.setOpaque(false);
        Potion_panel.setBounds(100, 260, 800, 180);
        Background.add(Potion_panel);
        Potion_panel.setLayout(new GridLayout(1, 7));
        
        
        //Ingredient Images
        feather = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEATHER));
        Ingredient_panel.add(feather);
        
        feet = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEET));
        Ingredient_panel.add(feet);
        
        flower = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FLOWER));
        Ingredient_panel.add(flower);
        
        frog = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FROG));
        Ingredient_panel.add(frog);
        
        mandrake = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.MANDRAKE));
        Ingredient_panel.add(mandrake);
        
        mushroom = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.MUSHROOM));
        Ingredient_panel.add(mushroom);
        
        scorpion = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.SCORPION));
        Ingredient_panel.add(scorpion);
        
        weed = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.WEED));
        Ingredient_panel.add(weed);
        
        
        //potion images 
        greenPostive = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.GREEN_POSITIVE));
        Potion_panel.add(greenPostive);
        
        redPostive = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.RED_POSITIVE));
        Potion_panel.add(redPostive);
        
        bluePostive = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.BLUE_POSITIVE));
        Potion_panel.add(bluePostive);
        
        greenNegative = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.GREEN_NEGATIVE));
        Potion_panel.add(greenNegative);
        
        redNegative = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.RED_NEGATIVE));
        Potion_panel.add(redNegative);
        
        blueNegative = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.BLUE_NEGATIVE));
        Potion_panel.add(blueNegative);
        
        neutral = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.NEUTRAL));
        Potion_panel.add(neutral);
        
        
        JLabel title = new JLabel("INVENTORY");
        title.setForeground(SystemColor.desktop);
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setBounds(400, 10, 200, 50);
        Background.add(title);
        
        
        //Ingredient quantity Labels
        feather_quantity = new JLabel("0");
        feather_quantity.setForeground(new Color(255, 255, 255));
        feather_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        feather_quantity.setBounds(140, 160, 45, 50);
        Background.add(feather_quantity);
        
        feet_quantity = new JLabel("0");
        feet_quantity.setForeground(new Color(255, 255, 255));
        feet_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        feet_quantity.setBounds(240, 160, 45, 50);
        Background.add(feet_quantity);
        
        flower_quantity = new JLabel("0");
        flower_quantity.setForeground(new Color(255, 255, 255));
        flower_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        flower_quantity.setBounds(340, 160, 45, 50);
        Background.add(flower_quantity);
        
        frog_quantity = new JLabel("0");
        frog_quantity.setForeground(new Color(255, 255, 255));
        frog_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        frog_quantity.setBounds(440, 160, 45, 50);
        Background.add(frog_quantity);
        
        mandrake_quantity = new JLabel("0");
        mandrake_quantity.setForeground(new Color(255, 255, 255));
        mandrake_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        mandrake_quantity.setBounds(540, 160, 45, 50);
        Background.add(mandrake_quantity);
        
        mushroom_quantity = new JLabel("0");
        mushroom_quantity.setForeground(new Color(255, 255, 255));
        mushroom_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        mushroom_quantity.setBounds(640, 160, 45, 50);
        Background.add(mushroom_quantity);
        
        scorpion_quantity = new JLabel("0");
        scorpion_quantity.setForeground(new Color(255, 255, 255));
        scorpion_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        scorpion_quantity.setBounds(740, 160, 45, 50);
        Background.add(scorpion_quantity);
        
        weed_quantity = new JLabel("0");
        weed_quantity.setForeground(new Color(255, 255, 255));
        weed_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        weed_quantity.setBounds(840, 160, 45, 50);
        Background.add(weed_quantity);
        
        
        //Potion quantity Labels
        greenPostive_quantity = new JLabel("0");
        greenPostive_quantity.setForeground(new Color(255, 255, 255));
        greenPostive_quantity.setBackground(new Color(255, 255, 255));
        greenPostive_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        greenPostive_quantity.setBounds(150, 430, 45, 50);
        Background.add(greenPostive_quantity);
        
        redPostive_quantity = new JLabel("0");
        redPostive_quantity.setForeground(new Color(255, 255, 255));
        redPostive_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        redPostive_quantity.setBounds(265, 430, 45, 50);
        Background.add(redPostive_quantity);
        
        bluePostive_quantity = new JLabel("0");
        bluePostive_quantity.setForeground(new Color(255, 255, 255));
        bluePostive_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        bluePostive_quantity.setBounds(380, 430, 45, 50);
        Background.add(bluePostive_quantity);
        
        greenNegative_quantity = new JLabel("0");
        greenNegative_quantity.setForeground(new Color(255, 255, 255));
        greenNegative_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        greenNegative_quantity.setBounds(495, 430, 45, 50);
        Background.add(greenNegative_quantity);
        
        redNegative_quantity = new JLabel("0");
        redNegative_quantity.setForeground(new Color(255, 255, 255));
        redNegative_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        redNegative_quantity.setBounds(610, 430, 45, 50);
        Background.add(redNegative_quantity);
        
        blueNegative_quantity = new JLabel("0");
        blueNegative_quantity.setForeground(new Color(255, 255, 255));
        blueNegative_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        blueNegative_quantity.setBounds(725, 430, 45, 50);
        Background.add(blueNegative_quantity);
        
        neutral_quantity = new JLabel("0");
        neutral_quantity.setForeground(new Color(255, 255, 255));
        neutral_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        neutral_quantity.setBounds(840, 430, 45, 50);
        Background.add(neutral_quantity);
        
        
        this.IngredientsQuantity();
        this.PotionsQuantity();
        
        this.setVisible(true);
        
        
    }
    
    
    public void IngredientsQuantity() {
        
        HashMap<Ingredient.IngredientTypes, Integer> ingredients = Player.getCurrPlayer().getInventory().getIngredientHashMap();
        
        for (Ingredient.IngredientTypes ingredient : ingredients.keySet()) {
            
            switch (ingredient) {
                
                case Plant -> {
                    weed_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
                case Mandrake -> {
                    mandrake_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
                case Flower -> {
                    flower_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
                case Mushroom -> {
                    mushroom_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
                case ChickenLeg -> {
                    feet_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
                case Toad -> {
                    frog_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
                case Feather -> {
                    feather_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
                case Scorpion -> {
                    scorpion_quantity.setText(String.valueOf(ingredients.get(ingredient)));
                }
            }
        }
    }
    private void IngredientsQuantityReset(){
        feather_quantity.setText("0");
        feet_quantity.setText("0");
        flower_quantity.setText("0");
        frog_quantity.setText("0");
        mandrake_quantity.setText("0");
        mushroom_quantity.setText("0");
        scorpion_quantity.setText("0");
        weed_quantity.setText("0");
    }
    
    private void PotionsQuantityReset(){
        bluePostive_quantity.setText("0");
        redPostive_quantity.setText("0");
        greenPostive_quantity.setText("0");
        blueNegative_quantity.setText("0");
        redNegative_quantity.setText("0");
        greenNegative_quantity.setText("0");
        neutral_quantity.setText("0");
    }
    
    
    public void PotionsQuantity() {
        
        HashMap<Potion, Integer> potions = Player.getCurrPlayer().getInventory().getPotions();
        
        for (Potion potion : potions.keySet()) {
            
            Potion.Colors color = potion.getColor();
            Potion.Signs sign = potion.getSign();
            
            if (color == Potion.Colors.Blue && sign == Potion.Signs.Positive) {
                bluePostive_quantity.setText(String.valueOf(potions.get(potion)));
            } else if (color == Potion.Colors.Red && sign == Potion.Signs.Positive) {
                redPostive_quantity.setText(String.valueOf(potions.get(potion)));
            } else if (color == Potion.Colors.Green && sign == Potion.Signs.Positive) {
                greenPostive_quantity.setText(String.valueOf(potions.get(potion)));
            } else if (color == Potion.Colors.Blue && sign == Potion.Signs.Negative) {
                blueNegative_quantity.setText(String.valueOf(potions.get(potion)));
            } else if (color == Potion.Colors.Red && sign == Potion.Signs.Negative) {
                redNegative_quantity.setText(String.valueOf(potions.get(potion)));
            } else if (color == Potion.Colors.Green && sign == Potion.Signs.Negative) {
                greenNegative_quantity.setText(String.valueOf(potions.get(potion)));
            } else if (color == Potion.Colors.Colorless && sign == Potion.Signs.Neutral) {
                neutral_quantity.setText(String.valueOf(potions.get(potion)));
            }
        }
    }
    
    @Override
    public void onEvent(Type type) {
        if (type == Type.INGREDIENT) {
            IngredientsQuantityReset();
            IngredientsQuantity();
            this.revalidate();
            this.repaint();
        }
        if (type == Type.POTION) {
            PotionsQuantityReset();
            PotionsQuantity();
            this.revalidate();
            this.repaint();
        }
    }
}




