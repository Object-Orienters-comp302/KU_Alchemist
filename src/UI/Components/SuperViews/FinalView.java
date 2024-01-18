package UI.Components.SuperViews;

import Domain.GameController;
import Domain.MenuController;
import Models.Player;
import Models.Token;
import UI.Components.ImagePanels.GifPanel;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.Player.PlayerDisplayer;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class FinalView extends JPanel {
    
    
    MenuController controller;
    String goldColor = "#FFD700";
    String silverColor = "#C0C0C0";
    String bronzeColor = "#CD7F32";
    HQImagePanel Background;
    public FinalView(){
        
        controller = GameController.getInstance().getMenuController();
    
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setLayout(null);
        

        Background = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND));
        Background.setVisible(true);
        Background.setLayout(null);
        Background.setBounds(0, 0, 1280, 720);
        this.add(Background);
        
        GifPanel ConfettiGif = new GifPanel(0, 0, 1300, 1300, AssetLoader.Gifs.CONFETTI.getPath());
        ConfettiGif.setLayout(null);
        Background.add(ConfettiGif);
        
        calculateFinalScores();
        createObjects();
        
        
    }
    
    
    public void createObjects() {
        
        ArrayList<Player> playerList = controller.getPlayers();
        
        playerList.sort(Comparator.comparingInt(Player::getScore)
                                .thenComparingInt(player -> player.getInventory().getGold() % 3)
                                .reversed());
        
        for (int i = 0; i < playerList.size(); i++) {
            
            PlayerDisplayer displayer = new PlayerDisplayer(playerList.get(i));
            displayer.setBounds(420, (110 + 100*i), 240, 80);
            
            JLabel rank = new JLabel();
            rank.setText(i + 1 + ".");
            rank.setFont(new Font("Tahoma", Font.PLAIN,80 ));
            rank.setBounds(340, (105 + 100*i), 100, 80);
            
            JLabel score = new JLabel();
            score.setText(playerList.get(i).getScore() + "p");
            score.setFont(new Font("Tahoma", Font.PLAIN,80 ));
            score.setBounds(680, (105 + 100*i), 300, 80);
            
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
        Player player2 = new Player("player2",new Token("player2",AssetLoader.getAssetPath(AssetLoader.Avatars.BLUE)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.BLUE)));
        Player player3 = new Player("player3",new Token("player3",AssetLoader.getAssetPath(AssetLoader.Avatars.PURPLE)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.PURPLE)));
        Player player4 = new Player("player4",new Token("player4",AssetLoader.getAssetPath(AssetLoader.Avatars.YELLOW)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.YELLOW)));
        
        player1.setReputation(2);
        player2.setReputation(2);
        player3.setReputation(1);
        player4.setReputation(3);
        
        player1.getInventory().addGold(10);
        player2.getInventory().addGold(11);
        player3.getInventory().addGold(12);
        player4.getInventory().addGold(13);
        
        JFrame frame = new JFrame();
        frame.setSize(1290, 720);
        frame.add(new FinalView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
