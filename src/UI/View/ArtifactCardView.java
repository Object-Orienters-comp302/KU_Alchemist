package UI.View;

import Domain.Event.Listener;
import Domain.Event.Type;

import Models.Artifact;
import Models.Player;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class ArtifactCardView extends JPanel implements Listener {
    
    ImagePanel Background;
    JPanel Artifact_panel;
    
    //example images
    ImagePanel feather;
    ImagePanel feet;
    ImagePanel flower;
    ImagePanel frog;
    
    ArrayList<ArrayList<JLabel>> quantityLabels;
    
    public ArtifactCardView(){
        
        this.setSize(1000, 500);
        setLayout(null);
        
        CreateObjects();
        SetupObjects();
        createAndSetRow();
        ArtifactQuantity();
        
    }
    
    
    private void CreateObjects(){
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.INVENTORY));
        Artifact_panel = new JPanel();
        quantityLabels = new ArrayList<>();
        
        //example artifact images
        feather = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEATHER));
        feet = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FEET));
        flower = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FLOWER));
        frog = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.IngredientAssets.FROG));
        
        Artifact_panel.add(feather);
        Artifact_panel.add(feet);
        Artifact_panel.add(flower);
        Artifact_panel.add(frog);
        
    }
    
    private void createAndSetRow(){
        
        for(int i = 0; i < Player.getPlayers().size() ; i++){
            
            JLabel player_title =  new JLabel(Player.getPlayers().get(i).getID());
            player_title.setForeground(SystemColor.desktop);
            player_title.setFont(new Font("Tahoma", Font.BOLD, 30));
            player_title.setBounds(50, (190 + (i*80)), 200, 50);
            Background.add(player_title);
            
            JLabel artifact1_quantity = new JLabel("0");
            JLabel artifact2_quantity = new JLabel("0");
            JLabel artifact3_quantity = new JLabel("0");
            JLabel artifact4_quantity = new JLabel("0");
            
            artifact1_quantity.setForeground(new Color(255, 255, 255));
            artifact1_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
            artifact1_quantity.setBounds(250, (190 + (i*80)), 45, 50);
            Background.add(artifact1_quantity);
            
            artifact2_quantity.setForeground(new Color(255, 255, 255));
            artifact2_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
            artifact2_quantity.setBounds(400,  (190 + (i*80)), 45, 50);
            Background.add(artifact2_quantity);
            
            artifact3_quantity.setForeground(new Color(255, 255, 255));
            artifact3_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
            artifact3_quantity.setBounds(550,  (190 + (i*80)), 45, 50);
            Background.add(artifact3_quantity);
            
            artifact4_quantity.setForeground(new Color(255, 255, 255));
            artifact4_quantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
            artifact4_quantity.setBounds(700,  (190 + (i*80)), 45, 50);
            Background.add(artifact4_quantity);
            
            ArrayList<JLabel> p_quantity_Labels = new ArrayList<>();
            
            p_quantity_Labels.add(artifact1_quantity);
            p_quantity_Labels.add(artifact2_quantity);
            p_quantity_Labels.add(artifact3_quantity);
            p_quantity_Labels.add(artifact4_quantity);
            
            quantityLabels.add(p_quantity_Labels);
            
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
    }
    

    
    
    public void ArtifactQuantity () {
        
        for(int i = 0; i < Player.getPlayers().size() ; i++){
            
            HashMap<Artifact, Integer> artifacts = Player.getPlayers().get(i)
                    .getInventory().getArtifacts();
            
            ArrayList<JLabel> label_set = quantityLabels.get(i);
            
            for (Artifact artifact : artifacts.keySet()) {
                
                switch (artifact.getName()) {
                    
                    case Elixir_of_Insight -> {
                        label_set.get(0).setText(String.valueOf(artifacts.get(artifact)));
                    }
                    case Wisdom_Idol -> {
                        label_set.get(1).setText(String.valueOf(artifacts.get(artifact)));
                    }
                    case Printing_Press -> {
                        label_set.get(2).setText(String.valueOf(artifacts.get(artifact)));
                    }
                    case Magic_Mortar -> {
                        label_set.get(3).setText(String.valueOf(artifacts.get(artifact)));
                    }
                    
                }
            }
            
        }
    }
    
    
//    public static void main(String[] args) {
//
//
//        Player player1 = new Player("test1" , null);
//        Player player2 = new Player("test2" , null);
//        Player player3 = new Player("test3" , null);
//        Player player4 = new Player("test4" , null);
//
//        Artifact a = new Artifact(Artifact.Name.Wisdom_Idol, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
//
//        player1.getInventory().addArtifactCard(a, 2);
//        player2.getInventory().addArtifactCard(a, 4);
//
//
//        JFrame test = new JFrame();
//        test.setSize(1200,800);
//        ArtifactCardView test_panel = new ArtifactCardView();
//
//
//        test.setDefaultCloseOperation(test.EXIT_ON_CLOSE);
//        test.add(test_panel);
//        test.setVisible(true);
//    }
    
    @Override
    public void onEvent(Type type) {
        if (type == Type.ARTIFACT) {
            ArtifactQuantity();
            this.revalidate();
            this.repaint();
        }
        
    }
    
}


