package UI.Components.Publish;

import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;

public class BooksDisplayer extends JPanel {
    
    public BooksDisplayer() {
        setPreferredSize(new Dimension(1000, 500));
        setLayout(null);
        setBackground(Color.red);
        ImagePanel Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.PUBLISH));
        Background.setBounds(0, 0, 1000, 500);
        add(Background);
        Background.setLayout(null);
        BookPanel B0 = new BookPanel(AssetLoader.IngredientAssets.FEET);
        BookPanel B1 = new BookPanel(AssetLoader.IngredientAssets.FROG);
        BookPanel B2 = new BookPanel(AssetLoader.IngredientAssets.FEATHER);
        BookPanel B3 = new BookPanel(AssetLoader.IngredientAssets.WEED);
        BookPanel B4 = new BookPanel(AssetLoader.IngredientAssets.MANDRAKE);
        BookPanel B5 = new BookPanel(AssetLoader.IngredientAssets.MUSHROOM);
        BookPanel B6 = new BookPanel(AssetLoader.IngredientAssets.SCORPION);
        BookPanel B7 = new BookPanel(AssetLoader.IngredientAssets.FLOWER);
        
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
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.blue);
        BooksDisplayer bo = new BooksDisplayer();
        bo.setBounds(0, 0, 1500, 1500);
        frame.getContentPane().add(bo);
        
        
        frame.setVisible(true);
        
    }
    
    
}
