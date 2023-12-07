package GUI_Components_Publish;

import GUI_Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;

public class BooksDisplayer extends JPanel {
    
    public BooksDisplayer() {
        setPreferredSize(new Dimension(1000, 500));
        setLayout(null);
        setBackground(Color.red);
        ImagePanel Background = new ImagePanel("./Images/backgrounds/publishBackground.png");
        Background.setBounds(0, 0, 1000, 500);
        add(Background);
        Background.setLayout(null);
        BookPanel B0 = new BookPanel(AssetLoader.IngredientAssets.Feet);
        BookPanel B1 = new BookPanel(AssetLoader.IngredientAssets.Frog);
        BookPanel B2 = new BookPanel(AssetLoader.IngredientAssets.Feather);
        BookPanel B3 = new BookPanel(AssetLoader.IngredientAssets.Weed);
        BookPanel B4 = new BookPanel(AssetLoader.IngredientAssets.Mandrake);
        BookPanel B5 = new BookPanel(AssetLoader.IngredientAssets.Mushroom);
        BookPanel B6 = new BookPanel(AssetLoader.IngredientAssets.Scorpion);
        BookPanel B7 = new BookPanel(AssetLoader.IngredientAssets.Flower);
        
        B0.setBounds(10, 5, 400, 200);
        B1.setBounds(335, 5, 400, 200);
        B2.setBounds(670, 5, 400, 200);
        B3.setBounds(10, 160, 400, 200);
        B4.setBounds(670, 160, 400, 200);
        B5.setBounds(10, 315, 400, 200);
        B6.setBounds(335, 315, 400, 200);
        B7.setBounds(670, 315, 400, 200);
        Background.add(B0);
        Background.add(B1);
        Background.add(B2);
        
        
        Background.add(B3);
        Background.add(B4);
        Background.add(B5);
        Background.add(B6);
        Background.add(B7);
        
    }
    
}
