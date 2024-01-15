package UI.Components.SuperViews;

import Domain.GameController;
import Models.Deck;
import Models.Ingredient;
import Models.Player;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.GifPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.View.MenuView;
import Utils.AssetLoader;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class ArtifactTargetSelectorView extends JPanel {
    private static final Color                                        STEEL = Color.decode("#aaaaaa");
    private static final Color                                        GOLD  = Color.decode("#ffd700");
    private              ImagePanel                                   background, playerCard1, playerCard2, playerCard3;
    private JPanel card1, card2, card3, active;
    private ColorChangingPanel confirmButton;
    private Player    curr,player1,player2,player3;
    
    public ArtifactTargetSelectorView() {
        setBounds(0,0,1000,500);
        setLayout(null);
        
        ArrayList<Player> players = GameController.getInstance().getMenuController().getPlayers();
        curr=GameController.getInstance().getMenuController().getCurrentPlayer();
        int ind=1;
        for (Player pla:players){
            if (pla!=curr){
                setPlayer(ind,pla);
                ind++;
            }
        }
        
        background= new ImagePanel(AssetLoader.Backgrounds.INVENTORY);
        background.setBounds(0,0,1000,500);
        background.setLayout(null);
        add(background);
        
        confirmButton = new ColorChangingPanel(STEEL, GOLD, 30, ColorChangingPanel.RoundingStyle.BOTH);
        confirmButton.setBounds(400,375,200,100);
        background.add(confirmButton);
        confirmButton.setLayout(null);
        OutlinedLabel confirmLabel = new OutlinedLabel("CONFIRM", "#ddddd", "#ccccc", OutlinedLabel.Versions.MID_ORIENTED);
        confirmLabel.setBounds(0,0,200,100);
        confirmLabel.changeFontSize(35);
        confirmButton.add(confirmLabel);
        
        if (player1!=null) {
            card1 = new JPanel();
            card1.setBounds(100, 50, 200, 290);
            card1.setLayout(null);
            card1.setBackground(STEEL);
            background.add(card1);
            
            playerCard1 = new ImagePanel(player1.getToken().getImage());
            playerCard1.setBounds(5, 5, 190, 280);
            playerCard1.setLayout(null);
            card1.add(playerCard1);
        }
        if (player2!=null) {
            card2 = new JPanel();
            card2.setBounds(400, 50, 200, 290);
            card2.setLayout(null);
            card2.setBackground(STEEL);
            background.add(card2);
            
            playerCard2 = new ImagePanel(player2.getToken().getImage());
            playerCard2.setBounds(5, 5, 190, 280);
            playerCard2.setLayout(null);
            card2.add(playerCard2);
        }
        if (player3!=null) {
            card3 = new JPanel();
            card3.setBounds(700, 50, 200, 290);
            card3.setLayout(null);
            card3.setBackground(STEEL);
            background.add(card3);
            
            playerCard3 = new ImagePanel(player3.getToken().getImage());
            playerCard3.setBounds(5, 5, 190, 280);
            playerCard3.setLayout(null);
            card3.add(playerCard3);
        }
        addCardFunctions();
        
    }
    private ColorChangingPanel createConfirmButton() {
        ColorChangingPanel button = new ColorChangingPanel(STEEL, GOLD, 30, ColorChangingPanel.RoundingStyle.BOTH);
        button.setBounds(400, 375, 200, 100);
        button.setLayout(null);
        
        OutlinedLabel confirmLabel = new OutlinedLabel("CONFIRM", "#ddddd", "#ccccc", OutlinedLabel.Versions.MID_ORIENTED);
        confirmLabel.setBounds(0, 0, 200, 100);
        confirmLabel.changeFontSize(35);
        button.add(confirmLabel);
        
        return button;
    }
    
    private void addConfirmFunction(){
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            
            }
        });
    }
    private void liftBlockade(){
        MenuView menu = GameController.getInstance().getMenuController().getMenuView();
        menu.LiftBlockade();
        menu.reset();
    }
   
    private void setPlayer(int i,Player player) {
        if (i == 1) player1=player;
        if (i == 2) player2=player;
        if (i == 3) player3=player;
    }
    
    private int getPanelIndex(JPanel panel) {
        if (panel == card1) return 0;
        if (panel == card2) return 1;
        if (panel == card3) return 2;
        return -1; // Or handle this case appropriately
    }
    private void addCardFunctions(){
        if (player1!=null){
            playerCard1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cardFunction(playerCard1);
                }
            });
        }
        if (player2!=null){
            playerCard2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cardFunction(playerCard2);
                }
            });
        }
        if (player3!=null){
            playerCard3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cardFunction(playerCard3);
                }
            });
        }
    }
    private void cardFunction(JPanel pan){
        if (pan==active){
            disactivate(pan);
        }
        else {
            disactivate(active);
            activate(pan);
        }
    }
    private void disactivate(JPanel pan){
        pan.setBackground(STEEL);
        active=null;
    }
    private void activate(JPanel pan){
        pan.setBackground(GOLD);
        active=pan;
    }
    
    private ImagePanel getPlayerPanel(int index) {
        if (index == 1) return playerCard1;
        if (index == 2) return playerCard2;
        if (index == 3) return playerCard3;
        return null; // Or handle this case appropriately
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Elixir of Insight View");
            frame.setSize(1200, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            GameController.getInstance().getRoundZeroController().initializeIngredients(5);
            GameController.getInstance().getRoundThreeController().getDeck().shuffleIngredients();
            System.out.println(GameController.getInstance().getRoundThreeController().getDeck().getIngredients());
            
            ElixirOfInsightView elixirView = new ElixirOfInsightView();
            frame.add(elixirView);
            
            frame.setVisible(true);
        });
    }
    
}

