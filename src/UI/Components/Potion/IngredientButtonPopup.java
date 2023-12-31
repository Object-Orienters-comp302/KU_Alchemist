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
    private IngredientButton parentsPair;
    
    
    public IngredientButtonPopup(int x, int y, int width, int height, ImagePanel imgPanel, IngredientButton ingre) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setLayout(null);
        
        int buttonSizeW = width * 4 / 16;
        int buttonSizeH = height * 4 / 16;
        
        
        
        ///did not work when I put the block in another function
        
        parentsPair=ingre.getPair();
        if (parentsPair!=null){
            System.out.println(parentsPair.getCurrentIngredient());
        }
        
        IngredientPopupButton B0 =
                new IngredientPopupButton(width * 4 / 8, height * 4 / 8, buttonSizeW*3/2, buttonSizeW*3/2,
                                          AssetLoader.TriangleTable.QUESTION_MARK, imgPanel, ingre, true);
        add(B0);
        
        
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.FEATHER)) {
            CircleTransparentPanel T1 = new CircleTransparentPanel((width * 3 / 8) - (buttonSizeW / 2),
                                                                   (height*3 / 16) - (buttonSizeH / 2), buttonSizeW, buttonSizeH);
            add(T1);
        }
        IngredientPopupButton B1 = new IngredientPopupButton(width * 3 / 8, height*3 / 16, buttonSizeW, buttonSizeH,
                                                             AssetLoader.IngredientAssets.FEATHER, imgPanel, ingre,
                                                             !this.BlockCheck(AssetLoader.IngredientAssets.FEATHER));
        add(B1);
        
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.FEET)) {
            CircleTransparentPanel T2 = new CircleTransparentPanel((width*3 / 16) - (buttonSizeW / 2),
                                                                   (height * 3 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T2);
        }
        IngredientPopupButton B2 = new IngredientPopupButton(width*3 / 16, height * 3 / 8, buttonSizeW, buttonSizeH,
                                                             AssetLoader.IngredientAssets.FEET, imgPanel, ingre,
                                                             !this.BlockCheck(AssetLoader.IngredientAssets.FEET));
        add(B2);
        
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.FLOWER)) {
            CircleTransparentPanel T3 = new CircleTransparentPanel((width*3 / 16) - (buttonSizeW / 2),
                                                                   (height * 5 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T3);
        }
        IngredientPopupButton B3 = new IngredientPopupButton(width*3 / 16, height * 5 / 8, buttonSizeW, buttonSizeH,
                                                             AssetLoader.IngredientAssets.FLOWER, imgPanel, ingre,
                                                             !this.BlockCheck(AssetLoader.IngredientAssets.FLOWER));
        add(B3);
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.FROG)) {
            CircleTransparentPanel T4 = new CircleTransparentPanel((width * 3 / 8) - (buttonSizeW / 2),
                                                                   (height * 13 / 16) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T4);
        }
        IngredientPopupButton B4 =
                new IngredientPopupButton(width * 3 / 8, height * 13 / 16, buttonSizeW, buttonSizeH,
                                          AssetLoader.IngredientAssets.FROG, imgPanel, ingre,
                                          !this.BlockCheck(AssetLoader.IngredientAssets.FROG));
        add(B4);
        
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.MANDRAKE)) {
            CircleTransparentPanel T5 = new CircleTransparentPanel((width * 5 / 8) - (buttonSizeW / 2),
                                                                   (height * 13 / 16) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T5);
        }
        IngredientPopupButton B5 =
                new IngredientPopupButton(width * 5 / 8, height* 13 / 16, buttonSizeW, buttonSizeH,
                                          AssetLoader.IngredientAssets.MANDRAKE, imgPanel, ingre,
                                          !this.BlockCheck(AssetLoader.IngredientAssets.MANDRAKE));
        add(B5);
        
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.MUSHROOM)) {
            CircleTransparentPanel T6 = new CircleTransparentPanel((width * 13 / 16) - (buttonSizeW / 2),
                                                                   (height * 5 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T6);
        }
        IngredientPopupButton B6 =
                new IngredientPopupButton(width * 13 / 16, height * 5 / 8, buttonSizeW, buttonSizeH,
                                          AssetLoader.IngredientAssets.MUSHROOM, imgPanel, ingre,
                                          !this.BlockCheck(AssetLoader.IngredientAssets.MUSHROOM));
        add(B6);
        
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.WEED)) {
            CircleTransparentPanel T7 = new CircleTransparentPanel((width * 13 / 16) - (buttonSizeW / 2),
                                                                   (height * 3 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T7);
        }
        IngredientPopupButton B7 =
                new IngredientPopupButton(width * 13 / 16, height * 3 / 8, buttonSizeW, buttonSizeH,
                                          AssetLoader.IngredientAssets.WEED, imgPanel, ingre,
                                          !this.BlockCheck(AssetLoader.IngredientAssets.WEED));
        add(B7);
        
        
        if (this.BlockCheck(AssetLoader.IngredientAssets.SCORPION)) {
            CircleTransparentPanel T8 = new CircleTransparentPanel((width * 5 / 8) - (buttonSizeW / 2),
                                                                   (height * 3 / 16) - (buttonSizeH / 2), buttonSizeW, buttonSizeH);
            add(T8);
        }
        IngredientPopupButton B8 = new IngredientPopupButton(width * 5 / 8, height * 3 / 16, buttonSizeW, buttonSizeH,
                                                             AssetLoader.IngredientAssets.SCORPION, imgPanel, ingre,
                                                             !this.BlockCheck(AssetLoader.IngredientAssets.SCORPION));
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
        Ingredient.IngredientTypes ingredientType = Ingredient.getTypeFromPath(toCheck);
        
        return !Player.getCurrPlayer().getInventory().getIngredients().entrySet().stream()
                .anyMatch(entry -> entry.getKey().getType() == ingredientType && entry.getValue() > 0);
        
    }
    
    public boolean BlockCheck(AssetLoader.AssetPath path){
        if(CheckIfInventory(path) || (this.parentsPair!=null && this.parentsPair.getCurrentIngredient()==path)){
            return true;
        }
        return false;
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
