package UI.View;

import Models.Player;
import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class ArtifactCardView extends JPanel {
    
    ImagePanel Background;
    JPanel Artifact_panel;
    JLabel player1_title;
    JLabel player2_title;
    JLabel player3_title;
    JLabel player4_title;
    
    JLabel p1_artifact1_quantity;
    JLabel p1_artifact2_quantity;
    JLabel p1_artifact3_quantity;
    JLabel p1_artifact4_quantity;
    JLabel p2_artifact1_quantity;
    JLabel p2_artifact2_quantity;
    JLabel p2_artifact3_quantity;
    JLabel p2_artifact4_quantity;
    JLabel p3_artifact1_quantity;
    JLabel p3_artifact2_quantity;
    JLabel p3_artifact3_quantity;
    JLabel p3_artifact4_quantity;
    
    JLabel p4_artifact1_quantity;
    JLabel p4_artifact2_quantity;
    JLabel p4_artifact3_quantity;
    JLabel p4_artifact4_quantity;
    
    
    //example images
    ImagePanel feather;
    ImagePanel feet;
    ImagePanel flower;
    ImagePanel frog;
    
    ArrayList<JLabel> p1_quantityLabels;
    ArrayList<JLabel> p2_quantityLabels;
    ArrayList<JLabel> p3_quantityLabels;
    ArrayList<JLabel> p4_quantityLabels;
    
    public ArtifactCardView(){
        
        this.setSize(1000, 500);
        setLayout(null);
        
        CreateObjects();
        SetupObjects();


        
    }
    
    
    private void CreateObjects(){
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.INVENTORY));
        Artifact_panel = new JPanel();
        
        //example artifact images
        feather = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEATHER));
        feet = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEET));
        flower = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FLOWER));
        frog = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FROG));
        
        Artifact_panel.add(feather);
        Artifact_panel.add(feet);
        Artifact_panel.add(flower);
        Artifact_panel.add(frog);
        
        player1_title = new JLabel("Player 1");
        player2_title = new JLabel("Player 2");
        
        p1_artifact1_quantity = new JLabel("0");
        p1_artifact2_quantity = new JLabel("0");
        p1_artifact3_quantity = new JLabel("0");
        p1_artifact4_quantity = new JLabel("0");
        p1_quantityLabels = new ArrayList<>();
        p1_quantityLabels.add(p1_artifact1_quantity);
        p1_quantityLabels.add(p1_artifact2_quantity);
        p1_quantityLabels.add(p1_artifact3_quantity);
        p1_quantityLabels.add(p1_artifact4_quantity);
        
        p2_artifact1_quantity = new JLabel("0");
        p2_artifact2_quantity = new JLabel("0");
        p2_artifact3_quantity = new JLabel("0");
        p2_artifact4_quantity = new JLabel("0");
        p2_quantityLabels = new ArrayList<>();
        p2_quantityLabels.add(p1_artifact1_quantity);
        p2_quantityLabels.add(p1_artifact2_quantity);
        p2_quantityLabels.add(p1_artifact3_quantity);
        p2_quantityLabels.add(p1_artifact4_quantity);
        
        if(Player.getPlayers().size() > 2){
            add3rdRow();
            if(Player.getPlayers().size() > 3){
                add4thRow();
            }
        }
        
    }
    
    private void SetupObjects(){
        
        Background.setForeground(SystemColor.desktop);
        Background.setLocation(0, 0);
        Background.setSize(1000, 500);
        Background.setLayout(null);
        this.add(Background);
        
        Artifact_panel.setOpaque(false);
        Artifact_panel.setBounds(200, 70, 600, 100);
        Background.add(Artifact_panel);
        Artifact_panel.setLayout(new GridLayout(1, 4));
        
        //Player titles
        player1_title.setForeground(SystemColor.desktop);
        player1_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player1_title.setBounds(50, 190, 200, 50);
        Background.add(player1_title);
        
        player2_title.setForeground(SystemColor.desktop);
        player2_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player2_title.setBounds(50, 270, 200, 50);
        Background.add(player2_title);
        
        //Player1 artifact quantity Labels
        p1_artifact1_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact1_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact1_quantity.setBounds(250, 190, 45, 50);
        Background.add(p1_artifact1_quantity);
        
        p1_artifact2_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact2_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact2_quantity.setBounds(400, 190, 45, 50);
        Background.add(p1_artifact2_quantity);
        
        p1_artifact3_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact3_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact3_quantity.setBounds(550, 190, 45, 50);
        Background.add(p1_artifact3_quantity);
        
        p1_artifact4_quantity.setForeground(new Color(255, 255, 255));
        p1_artifact4_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1_artifact4_quantity.setBounds(700, 190, 45, 50);
        Background.add(p1_artifact4_quantity);
        
        //Player2 artifact quantity Labels
        p2_artifact1_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact1_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact1_quantity.setBounds(250, 270, 45, 50);
        Background.add(p2_artifact1_quantity);
        
        p2_artifact2_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact2_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact2_quantity.setBounds(400, 270, 45, 50);
        Background.add(p2_artifact2_quantity);
        
        p2_artifact3_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact3_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact3_quantity.setBounds(550, 270, 45, 50);
        Background.add(p2_artifact3_quantity);
        
        p2_artifact4_quantity.setForeground(new Color(255, 255, 255));
        p2_artifact4_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p2_artifact4_quantity.setBounds(700, 270, 45, 50);
        Background.add(p2_artifact4_quantity);
    }
    
    private void add3rdRow(){
        
        player3_title = new JLabel("Player 3");
        player3_title.setForeground(SystemColor.desktop);
        player3_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player3_title.setBounds(50, 350, 200, 50);
        Background.add(player3_title);
        
        
        //Player2 artifact quantity Labels
        p3_artifact1_quantity = new JLabel("0");
        p3_artifact1_quantity.setForeground(new Color(255, 255, 255));
        p3_artifact1_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p3_artifact1_quantity.setBounds(250, 350, 45, 50);
        Background.add(p3_artifact1_quantity);
        
        p3_artifact2_quantity = new JLabel("0");
        p3_artifact2_quantity.setForeground(new Color(255, 255, 255));
        p3_artifact2_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p3_artifact2_quantity.setBounds(400, 350, 45, 50);
        Background.add(p3_artifact2_quantity);
        
        p3_artifact3_quantity = new JLabel("0");
        p3_artifact3_quantity.setForeground(new Color(255, 255, 255));
        p3_artifact3_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p3_artifact3_quantity.setBounds(550, 350, 45, 50);
        Background.add(p3_artifact3_quantity);
        
        p3_artifact4_quantity = new JLabel("0");
        p3_artifact4_quantity.setForeground(new Color(255, 255, 255));
        p3_artifact4_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p3_artifact4_quantity.setBounds(700, 350, 45, 50);
        Background.add(p3_artifact4_quantity);
        
        p3_quantityLabels = new ArrayList<>();
        p3_quantityLabels.add(p1_artifact1_quantity);
        p3_quantityLabels.add(p1_artifact2_quantity);
        p3_quantityLabels.add(p1_artifact3_quantity);
        p3_quantityLabels.add(p1_artifact4_quantity);
        
        
    }
    
    
    private void add4thRow(){
        
        player4_title = new JLabel("Player 4");
        player4_title.setForeground(SystemColor.desktop);
        player4_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        player4_title.setBounds(50, 430, 200, 50);
        Background.add(player4_title);
        
        //Player4 artifact quantity Labels
        p4_artifact1_quantity = new JLabel("0");
        p4_artifact1_quantity.setForeground(new Color(255, 255, 255));
        p4_artifact1_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p4_artifact1_quantity.setBounds(250, 430, 45, 50);
        Background.add(p4_artifact1_quantity);
        
        p4_artifact2_quantity = new JLabel("0");
        p4_artifact2_quantity.setForeground(new Color(255, 255, 255));
        p4_artifact2_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p4_artifact2_quantity.setBounds(400, 430, 45, 50);
        Background.add(p4_artifact2_quantity);
        
        p4_artifact3_quantity = new JLabel("0");
        p4_artifact3_quantity.setForeground(new Color(255, 255, 255));
        p4_artifact3_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p4_artifact3_quantity.setBounds(550, 430, 45, 50);
        Background.add(p4_artifact3_quantity);
        
        p4_artifact4_quantity = new JLabel("0");
        p4_artifact4_quantity.setForeground(new Color(255, 255, 255));
        p4_artifact4_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p4_artifact4_quantity.setBounds(700, 430, 45, 50);
        Background.add(p4_artifact4_quantity);
        
        p4_quantityLabels = new ArrayList<>();
        p4_quantityLabels.add(p1_artifact1_quantity);
        p4_quantityLabels.add(p1_artifact2_quantity);
        p4_quantityLabels.add(p1_artifact3_quantity);
        p4_quantityLabels.add(p1_artifact4_quantity);
        
    }
    
    
    public static void main(String[] args) {
        
       
        Player player1 = new Player("test1" , null);
        Player player2 = new Player("test2" , null);
        Player player3 = new Player("test3" , null);
        Player player4 = new Player("test4" , null);
        
        JFrame test = new JFrame();
        test.setSize(1200,800);
        ArtifactCardView test_panel = new ArtifactCardView();
        test.setDefaultCloseOperation(test.EXIT_ON_CLOSE);
        test.add(test_panel);
        test.setVisible(true);
    }
}


