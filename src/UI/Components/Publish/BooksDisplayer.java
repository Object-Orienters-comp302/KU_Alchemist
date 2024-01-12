package UI.Components.Publish;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;

public class BooksDisplayer extends JPanel {
    BookPanel B0,B1,B2,B3,B4,B5,B6,B7;
    ImagePanel Background;
    public BooksDisplayer() {
        setPreferredSize(new Dimension(1000, 500));
        setLayout(null);
        setBackground(Color.red);
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.PUBLISH));
        Background.setBounds(0, 0, 1000, 500);
        add(Background);
        Background.setLayout(null);

        createBookPanels();
        configureBookPanels();
        
    }
    private void createBookPanels(){
        B0 = new BookPanel(AssetLoader.IngredientAssets.FEET);
        B1 = new BookPanel(AssetLoader.IngredientAssets.FROG);
        B2 = new BookPanel(AssetLoader.IngredientAssets.FEATHER);
        B3 = new BookPanel(AssetLoader.IngredientAssets.WEED);
        B4 = new BookPanel(AssetLoader.IngredientAssets.MANDRAKE);
        B5 = new BookPanel(AssetLoader.IngredientAssets.MUSHROOM);
        B6 = new BookPanel(AssetLoader.IngredientAssets.SCORPION);
        B7 = new BookPanel(AssetLoader.IngredientAssets.FLOWER);
    }

    private void configureBookPanels(){
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

    
    public void reset(){
        B0.reset();B1.reset();B2.reset();B3.reset();B4.reset();B5.reset();B6.reset();B7.reset();
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
