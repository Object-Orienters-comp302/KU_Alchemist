package UI.Components.Potion;

import Models.Ingredient;
import Models.Player;
import UI.Components.CircleTransparentPanel;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IngredientButtonPopup extends JPanel {
    private int width, height, x, y;
    
    public IngredientButtonPopup(int x, int y, int width, int height, ImagePanel imgPanel, IngredientButton ingre) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setLayout(null);
        
        int current = 1;
        
        ///did not work when I put the block in another function
        
        IngredientPopupButton B0 =
                new IngredientPopupButton(width * 4 / 8, height * 4 / 8, width * 8 / 16, height * 8 / 16,
                                          AssetLoader.TriangleTable.QUESTION_MARK, imgPanel, ingre, true);
        add(B0);
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.FEATHER)) {
            CircleTransparentPanel T1 = new CircleTransparentPanel((width * 3 / 8) - ((width * 5 / 16) / 2),
                                                                   (height / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T1);
        }
        IngredientPopupButton B1 = new IngredientPopupButton(width * 3 / 8, height / 8, width * 5 / 16, height * 5 / 16,
                                                             AssetLoader.IngredientAssets.FEATHER, imgPanel, ingre,
                                                             !CheckIfInventory(AssetLoader.IngredientAssets.FEATHER));
        add(B1);
        
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.FEET)) {
            CircleTransparentPanel T2 = new CircleTransparentPanel((width / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 3 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T2);
        }
        IngredientPopupButton B2 = new IngredientPopupButton(width / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
                                                             AssetLoader.IngredientAssets.FEET, imgPanel, ingre,
                                                             !CheckIfInventory(AssetLoader.IngredientAssets.FEET));
        add(B2);
        
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.FLOWER)) {
            CircleTransparentPanel T3 = new CircleTransparentPanel((width / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 5 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T3);
        }
        IngredientPopupButton B3 = new IngredientPopupButton(width / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
                                                             AssetLoader.IngredientAssets.FLOWER, imgPanel, ingre,
                                                             !CheckIfInventory(AssetLoader.IngredientAssets.FLOWER));
        add(B3);
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.FROG)) {
            CircleTransparentPanel T4 = new CircleTransparentPanel((width * 3 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 7 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T4);
        }
        IngredientPopupButton B4 =
                new IngredientPopupButton(width * 3 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
                                          AssetLoader.IngredientAssets.FROG, imgPanel, ingre,
                                          !CheckIfInventory(AssetLoader.IngredientAssets.FROG));
        add(B4);
        
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.MANDRAKE)) {
            CircleTransparentPanel T5 = new CircleTransparentPanel((width * 5 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 7 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T5);
        }
        IngredientPopupButton B5 =
                new IngredientPopupButton(width * 5 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
                                          AssetLoader.IngredientAssets.MANDRAKE, imgPanel, ingre,
                                          !CheckIfInventory(AssetLoader.IngredientAssets.MANDRAKE));
        add(B5);
        
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.MUSHROOM)) {
            CircleTransparentPanel T6 = new CircleTransparentPanel((width * 7 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 5 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T6);
        }
        IngredientPopupButton B6 =
                new IngredientPopupButton(width * 7 / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
                                          AssetLoader.IngredientAssets.MUSHROOM, imgPanel, ingre,
                                          !CheckIfInventory(AssetLoader.IngredientAssets.MUSHROOM));
        add(B6);
        
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.WEED)) {
            CircleTransparentPanel T7 = new CircleTransparentPanel((width * 7 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 3 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T7);
        }
        IngredientPopupButton B7 =
                new IngredientPopupButton(width * 7 / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
                                          AssetLoader.IngredientAssets.WEED, imgPanel, ingre,
                                          !CheckIfInventory(AssetLoader.IngredientAssets.WEED));
        add(B7);
        
        
        if (CheckIfInventory(AssetLoader.IngredientAssets.SCORPION)) {
            CircleTransparentPanel T8 = new CircleTransparentPanel((width * 5 / 8) - ((width * 5 / 16) / 2),
                                                                   (height / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T8);
        }
        IngredientPopupButton B8 = new IngredientPopupButton(width * 5 / 8, height / 8, width * 5 / 16, height * 5 / 16,
                                                             AssetLoader.IngredientAssets.SCORPION, imgPanel, ingre,
                                                             !CheckIfInventory(AssetLoader.IngredientAssets.SCORPION));
        add(B8);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Container parent = IngredientButtonPopup.this.getParent();
                
                if (parent != null) {
                    
                    parent.remove(IngredientButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                    
                }
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                Container parent = IngredientButtonPopup.this.getParent();
                if (parent != null) {
                    Point mousePoint = e.getPoint();
                    
                    // Check if the mouse is still within the bounds of the parent component
                    if (IngredientButtonPopup.this.contains(mousePoint)) {
                        return;
                    }
                    parent.remove(IngredientButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                }
                
            }
        });
        
    }
    
    public static boolean CheckIfInventory(AssetLoader.AssetPath toCheck) {
        Ingredient.IngredientTypes ingredientType = switch (toCheck) {
            case AssetLoader.IngredientAssets.FEATHER -> Ingredient.IngredientTypes.Feather;
            case AssetLoader.IngredientAssets.FROG -> Ingredient.IngredientTypes.Toad;
            case AssetLoader.IngredientAssets.MANDRAKE -> Ingredient.IngredientTypes.Mandrake;
            case AssetLoader.IngredientAssets.WEED -> Ingredient.IngredientTypes.Plant;
            case AssetLoader.IngredientAssets.SCORPION -> Ingredient.IngredientTypes.Scorpion;
            case AssetLoader.IngredientAssets.FEET -> Ingredient.IngredientTypes.ChickenLeg;
            case AssetLoader.IngredientAssets.FLOWER -> Ingredient.IngredientTypes.Flower;
            case AssetLoader.IngredientAssets.MUSHROOM -> Ingredient.IngredientTypes.Mushroom;
            default -> throw new IllegalStateException("Unexpected value: " + toCheck);
        };
        
        return !Player.getCurrPlayer().getInventory().getIngredients().entrySet().stream()
                .anyMatch(entry -> entry.getKey().getType() == ingredientType && entry.getValue() > 0);
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        BookPanel login = new BookPanel(1);
        frame.getContentPane().add(login);
        frame.setVisible(true);
        */
        
    }
}
