package UI.View;

import Domain.GameController;
import Domain.MenuController;
import Models.Player;
import Models.Token;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.Player.PlayerDisplayer;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FinalScores extends JPanel {
    
    
    MenuController controller;
    String goldColor = "#FFD700";
    String silverColor = "#C0C0C0";
    String bronzeColor = "#CD7F32";
    HQImagePanel Background;
    public FinalScores(){
        
        controller = GameController.getInstance().getMenuController();
    
        this.setSize(1000, 500);
        this.setVisible(true);
        Background = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.PlainViewAssets.BACKGROUND));
        Background.setVisible(true);
        Background.setLayout(null);
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        
        createObjects();
        setLayout(null);
        
    }
    
    
    public void createObjects() {
        
        ArrayList<Player> playerList = controller.getPlayers();
        
        playerList.sort(Comparator.comparingInt(Player::getScore)
                                .thenComparingInt(player -> player.getInventory().getGold() % 3)
                                .reversed());
        
        for (int i = 0; i < playerList.size(); i++) {
            
            PlayerDisplayer displayer = new PlayerDisplayer(playerList.get(i));
            displayer.setBounds(320, (100 + 100*i), 240, 80);
            
            JLabel rank = new JLabel();
            rank.setText(i + 1 + ".");
            rank.setFont(new Font("Tahoma", Font.PLAIN,80 ));
            rank.setBounds(240, (95 + 100*i), 100, 80);
            
            JLabel score = new JLabel();
            score.setText(playerList.get(i).getScore() + "p");
            score.setFont(new Font("Tahoma", Font.PLAIN,80 ));
            score.setBounds(580, (95 + 100*i), 300, 80);
            
            if(i == 0){
                displayer.setBackground(Color.decode(goldColor));
                rank.setForeground(Color.decode(goldColor));
                score.setForeground(Color.decode(goldColor));
            }else if(i==1){
                displayer.setBackground(Color.decode(silverColor));
                rank.setForeground(Color.decode(silverColor));
                score.setForeground(Color.decode(silverColor));
            }else{
                displayer.setBackground(Color.decode(bronzeColor));
                rank.setForeground(Color.decode(bronzeColor));
                score.setForeground(Color.decode(bronzeColor));
            }
            
            Background.add(rank);
            Background.add(score);
            Background.add(displayer);
        }
        
    }
    

    private void calculateFinalScores(){
        GameController.getInstance().calculateFinalScores();
    }
    
    public static void main(String[] args) {
        
        Player player1 = new Player("player1",new Token("player1",AssetLoader.getAssetPath(AssetLoader.Avatars.RED)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.RED)));
        Player player2 = new Player("player2",new Token("player2",AssetLoader.getAssetPath(AssetLoader.Avatars.RED)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.RED)));
        Player player3 = new Player("player3",new Token("player3",AssetLoader.getAssetPath(AssetLoader.Avatars.RED)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.RED)));
        Player player4 = new Player("player4",new Token("player4",AssetLoader.getAssetPath(AssetLoader.Avatars.RED)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.RED)));
        
        player2.setScore(10);
        player1.setScore(8);
        player3.setScore(3);
        player4.setScore(14);
        
        
        
        JFrame frame = new JFrame();
        frame.setSize(1300, 800);
        frame.add(new FinalScores());
        frame.setVisible(true);
    }
}