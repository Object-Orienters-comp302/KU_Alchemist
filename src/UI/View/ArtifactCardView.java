package UI.View;

import Models.Player;
import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ArtifactCardView extends JPanel {
    
    ImagePanel Background;
    JLabel feather_quantity;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JTable gameTable;
    ImagePanel feather;
    ImagePanel feet;
    ImagePanel flower;
    ImagePanel frog;
    
    
    ArrayList<JLabel> p1_quantityLabels;
    ArrayList<JLabel> p2_quantityLabels;
    public ArtifactCardView(){
        
        this.setSize(1000, 500);
        setLayout(null);

        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.INVENTORY));
        Background.setForeground(SystemColor.desktop);
        Background.setLocation(0, 0);
        Background.setSize(1000, 500);
        Background.setLayout(null);
        this.add(Background);
        
        
        
        
        JPanel Ingredient_panel = new JPanel();
        Ingredient_panel.setOpaque(false);
        Ingredient_panel.setBounds(200, 70, 600, 100);
        Background.add(Ingredient_panel);
        Ingredient_panel.setLayout(new GridLayout(1, 4));
        
        feather = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEATHER));
        Ingredient_panel.add(feather);
        
        feet = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEET));
        Ingredient_panel.add(feet);
        
        flower = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FLOWER));
        Ingredient_panel.add(flower);
        
        frog = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FROG));
        Ingredient_panel.add(frog);
        
        
        
        
        //Player titles
        JLabel player1_title = new JLabel("Player 1");
        player1_title.setForeground(SystemColor.desktop);
        player1_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player1_title.setBounds(50, 190, 200, 50);
        Background.add(player1_title);
        
        JLabel player2_title = new JLabel("Player 2");
        player2_title.setForeground(SystemColor.desktop);
        player2_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player2_title.setBounds(50, 270, 200, 50);
        Background.add(player2_title);
        
        JLabel player3_title = new JLabel("Player 3");
        player3_title.setForeground(SystemColor.desktop);
        player3_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player3_title.setBounds(50, 350, 200, 50);
        Background.add(player3_title);
        
        JLabel player4_title = new JLabel("Player 4");
        player4_title.setForeground(SystemColor.desktop);
        player4_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player4_title.setBounds(50, 430, 200, 50);
        Background.add(player4_title);
        
        
        
        
        //Player1 artifact quantity Labels
        JLabel p1_artifact1_quantity = new JLabel("0");
        p1_artifact1_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact1_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact1_quantity.setBounds(250, 190, 45, 50);
        Background.add(p1_artifact1_quantity);
        
        JLabel p1_artifact2_quantity = new JLabel("0");
        p1_artifact2_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact2_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact2_quantity.setBounds(400, 190, 45, 50);
        Background.add(p1_artifact2_quantity);
        
        JLabel p1_artifact3_quantity = new JLabel("0");
        p1_artifact3_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact3_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact3_quantity.setBounds(550, 190, 45, 50);
        Background.add(p1_artifact3_quantity);
        
        JLabel p1_artifact4_quantity = new JLabel("0");
        p1_artifact4_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact4_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact4_quantity.setBounds(700, 190, 45, 50);
        Background.add(p1_artifact4_quantity);
        
        p1_quantityLabels = new ArrayList<>();
        p1_quantityLabels.add(p1_artifact1_quantity);
        p1_quantityLabels.add(p1_artifact2_quantity);
        p1_quantityLabels.add(p1_artifact3_quantity);
        p1_quantityLabels.add(p1_artifact4_quantity);
        
        
        
        
        //Player2 artifact quantity Labels
        JLabel p2_artifact1_quantity = new JLabel("0");
        p2_artifact1_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact1_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact1_quantity.setBounds(250, 270, 45, 50);
        Background.add(p2_artifact1_quantity);
        
        JLabel p2_artifact2_quantity = new JLabel("0");
        p2_artifact2_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact2_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact2_quantity.setBounds(400, 270, 45, 50);
        Background.add(p2_artifact2_quantity);
        
        JLabel p2_artifact3_quantity = new JLabel("0");
        p2_artifact3_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact3_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact3_quantity.setBounds(550, 270, 45, 50);
        Background.add(p2_artifact3_quantity);
        
        JLabel p2_artifact4_quantity = new JLabel("0");
        p2_artifact4_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact4_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact4_quantity.setBounds(700, 270, 45, 50);
        Background.add(p2_artifact4_quantity);
        
        p2_quantityLabels = new ArrayList<>();
        p2_quantityLabels.add(p1_artifact1_quantity);
        p2_quantityLabels.add(p1_artifact2_quantity);
        p2_quantityLabels.add(p1_artifact3_quantity);
        p2_quantityLabels.add(p1_artifact4_quantity);
        
        
        
        
        
        
       
        
        
        
    }
    public static void main(String[] args) {
        
        JFrame test = new JFrame();
        test.setSize(1200,800);
        ArtifactCardView test_panel = new ArtifactCardView();
        test.setDefaultCloseOperation(test.EXIT_ON_CLOSE);
        test.add(test_panel);
        test.setVisible(true);
    }
}


