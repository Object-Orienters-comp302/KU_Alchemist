package UI.View;

import Domain.GameController;
import Domain.MenuController;
import Models.Player;
import Models.Token;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.Player.PlayerDisplayer;
import Utils.AssetLoader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FinalScores extends JPanel {
    
    
    private MenuController controller;
    
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
        PlacePlayers();
        setLayout(null);
        
    }
    
    
    public void PlacePlayers() {
        ArrayList<Player> playerList = controller.getPlayers();
        System.out.println(playerList);
        
        playerList.sort(Comparator.comparingInt(Player::getScore)
                                .thenComparingInt(player -> player.getInventory().getGold() % 3)
                                .reversed());
        
        int playerCount = playerList.size();
        
        for (int i = 0; i < playerCount; i++) {
            PlayerDisplayer displayer = new PlayerDisplayer(playerList.get(i));
            
            
            displayer.setBounds(380, (100 + 100*i), 240, 80);
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
