package UI.Components.SuperViews;


import Domain.GameController;
import Domain.MenuController;
import Models.Player;
import Models.Token;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Player.PlayerDisplayer;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class WaitingRoomView extends JPanel {
    
    MenuController controller;
    String         goldColor = "#FFD700";
    HQImagePanel Background;
    ImagePanel selectStart;
    ImagePanel startText;
    
    public WaitingRoomView() {
        
        controller = GameController.getInstance().getMenuController();
        createObjects();
        setupObjects();
        addPlayers();
    }
    
    
    private void createObjects(){
        Background = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND));
        selectStart  = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
        startText = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.START_TEXT));
    }
    
    private void setupObjects(){
        
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setLayout(null);
        
        Background.setVisible(true);
        Background.setLayout(null);
        Background.setBounds(0, 0, 1280, 720);
        this.add(Background);
        
        selectStart.setBounds(800,400,250,100);
        Background.add(selectStart);
        selectStart.setLayout(null);
        
        startText.setLayout(null);
        startText.setBounds(75, 25, 100, 50);
        selectStart.add(startText);
        
    }
    public void addPlayers() {
        
        ArrayList<Player> playerList = controller.getPlayers();
        
        for (int i = 0; i < playerList.size(); i++) {
            
            PlayerDisplayer displayer = new PlayerDisplayer(playerList.get(i));
            displayer.setBounds(520, (110 + 100*i), 240, 80);
            
            JLabel rank = new JLabel();
            rank.setText(i + 1 + ".");
            rank.setFont(new Font("Tahoma", Font.PLAIN, 80 ));
            rank.setBounds(440, (105 + 100*i), 100, 80);
            rank.setForeground(Color.decode(goldColor));

            Background.add(rank);
            Background.add(displayer);
        }
    }
    
    public static void main(String[] args) {
        
        Player player1 = new Player("player1",new Token("player1", AssetLoader.getAssetPath(AssetLoader.Avatars.RED)
                , AssetLoader.getAssetPath(AssetLoader.Avatars.RED)));
        Player player2 = new Player("player2",new Token("player2",AssetLoader.getAssetPath(AssetLoader.Avatars.BLUE)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.BLUE)));
        Player player3 = new Player("player3",new Token("player3",AssetLoader.getAssetPath(AssetLoader.Avatars.PURPLE)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.PURPLE)));
        Player player4 = new Player("player4",new Token("player4",AssetLoader.getAssetPath(AssetLoader.Avatars.YELLOW)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.YELLOW)));
        
        JFrame frame = new JFrame();
        frame.setSize(1290, 720);
        frame.add(new WaitingRoomView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
